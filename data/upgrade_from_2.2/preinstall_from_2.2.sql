--20210319-1202 Nuevos campos para validacion registracion factura electronica
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','LYEIManageElectronicInvoiceProcess','character(1)'));

--20210405-1056 CAEA: Nuevas columnas en C_Invoice para validar si el documento fue informado y el detalle
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','LYEICAEAInformed','character(1)'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','LYEICAEAInformedDetail','varchar'));

--20210405-1108 CAEA: Nueva tabla para pedidos de CAEA
CREATE TABLE C_LYEICAEARequest
(
  C_LYEICAEARequest_ID integer NOT NULL,
  ad_client_id integer NOT NULL,
  ad_org_id integer NOT NULL,
  isactive character(1) NOT NULL DEFAULT 'Y'::bpchar,
  created timestamp without time zone NOT NULL DEFAULT ('now'::text)::timestamp(6) with time zone,
  createdby integer NOT NULL,
  updated timestamp without time zone NOT NULL DEFAULT ('now'::text)::timestamp(6) with time zone,
  updatedby integer NOT NULL,
  periodo int,
  orden int,
  caea varchar(14), 
  fechadesde date,
  fechahasta date,
  fechatopeinforme date, 
  observaciones varchar,
  CONSTRAINT C_LYEICAEARequest_Key PRIMARY KEY (C_LYEICAEARequest_ID)
);

--20210405-1108 CAEA: Nueva tabla CAEA solicitados pero no utilizados
CREATE TABLE C_LYEICAEANotUsed
(
  C_LYEICAEANotUsed_ID integer NOT NULL,
  ad_client_id integer NOT NULL,
  ad_org_id integer NOT NULL,
  isactive character(1) NOT NULL DEFAULT 'Y'::bpchar,
  created timestamp without time zone NOT NULL DEFAULT ('now'::text)::timestamp(6) with time zone,
  createdby integer NOT NULL,
  updated timestamp without time zone NOT NULL DEFAULT ('now'::text)::timestamp(6) with time zone,
  updatedby integer NOT NULL,
  C_LYEICAEARequest_ID integer NOT NULL, 	-- CAEA solicitado no usado
  C_LYEIElectronicPOSConfig_ID integer,		-- PtoVta donde no fue usado (o NULL si no fue usado en ninguno)
  status character(1),
  detail varchar,
  CONSTRAINT C_LYEICAEANotUsed_Key PRIMARY KEY (C_LYEICAEANotUsed_ID)
);

--20210405-1108 CAEA: Nueva columna para tipo de solicitud de CAE (CAE o CAEA)
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicPOSConfig','CAEMethod','character(1)'));

--20210407-1154 CAEA: Nuevas columnas para indicar si el ambiente es homo o prod
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEICAEARequest','environment','character(1)'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEICAEANotUsed','environment','character(1)'));

--20210510-0932 CAEA: Nueva columna para secuencias CAEA (Prod / Homo)
update ad_system set dummy = (SELECT addcolumnifnotexists('AD_Sequence','lyeicurrentnextcaeaprod','numeric(18,0)'));
update ad_system set dummy = (SELECT addcolumnifnotexists('AD_Sequence','lyeicurrentnextcaeahomo','numeric(18,0)'));

--20210517-0838 CAEA: Nueva columna para unidad de referencia minorista (dato a enviar: UnidadesMtx)
update ad_system set dummy = (SELECT addcolumnifnotexists('M_Product','lyeiunidadesmtx','int'));

--20210517-0925 CAEA: Nueva columna para codigo de unidad de consumo minorista (dato a enviar: CodigoMtx)
update ad_system set dummy = (SELECT addcolumnifnotexists('M_Product','lyeicodigomtx','varchar'));

--20210603-1004 CAEA: TYPE PARA REPORTE DE DOCUMENTOS PENDIENTES A INFORMAR
--DROP TYPE if exists v_caea_pending_documents_type;
CREATE TYPE v_caea_pending_documents_type AS (
	ad_client_id integer, 
	ad_org_id integer, 
	ambiente character,
	periodo integer,
	orden integer,
	c_doctype_id integer, 
	c_invoice_id integer, 
	documentno varchar,
	ptovta integer,
	dateinvoiced date, 
	grandtotal numeric(20,2), 
	c_bpartner_id integer, 
	lyeicaeainformed character, 
	lyeicaeainformeddetail varchar
);

--20210603-1004 CAEA: FUNCTION PARA REPORTE DE DOCUMENTOS PENDIENTES A INFORMAR
-- DROP FUNCTION v_caea_pending_documents(clientID integer, orgID integer, periodo integer, orden integer, ptovta integer, ambiente character)
CREATE OR REPLACE FUNCTION v_caea_pending_documents(clientID integer, orgID integer, periodo integer, orden integer, ptovta integer, ambiente character)
RETURNS SETOF v_caea_pending_documents_type AS
$BODY$
DECLARE
consulta varchar;
periodquery varchar;
ordenquery varchar;
adocument v_caea_pending_documents_type;
BEGIN
periodquery = '(select (date_part(''year'', dateinvoiced)::varchar || lpad(date_part(''month'', dateinvoiced)::varchar, 2, ''0''))::int) as periodo, ';
ordenquery = '(select case when date_part(''day'', dateinvoiced) <= 15 then 1 else 2 end) as orden, ';

-- Comprobantes pendientes de informar
consulta = ' SELECT ad_client_id, ad_org_id, ''' || ambiente || ''',' || periodquery || ordenquery || ' c_doctype_id, c_invoice_id, documentno, puntodeventa as ptovta, dateinvoiced::date, grandtotal, c_bpartner_id, lyeicaeainformed, lyeicaeainformeddetail '||
	   ' FROM C_Invoice i ' ||
	   ' WHERE lyeicaeainformed IN (''P'', ''R'') ' ||
	   ' AND cae IN (	select caea ' ||
	   ' 	 		from c_lyeicaearequest ' ||
	   ' 			where (1=1) ';

-- Periodo?
if (periodo is not null and periodo>0) then
consulta = consulta ||
	   '			and periodo = ' || periodo;
end if;

-- Orden?
if (orden is not null and orden>0) then
consulta = consulta ||
	   ' 			and orden = ' || orden;
end if;

consulta = consulta ||
	   '			and ad_client_id = ' || clientID ||	   
	   '	 		and environment = ''' || ambiente || ''') ' ||
	   ' AND ad_client_id = ' || clientID;

-- Organizacion?
if (orgID is not null and orgID > 0) THEN
consulta = consulta || 
	   ' AND ad_org_id = ' || orgID;
end if;

-- PtoVta?
if (ptovta is not null and ptovta > 0) THEN
consulta = consulta || 
	   ' AND puntodeventa = ' || ptovta;
end if;

consulta = consulta || ' ORDER BY c_doctype_id, documentno ASC ';

--raise notice '%', consulta;
FOR adocument IN EXECUTE consulta LOOP
	return next adocument;
END LOOP;

END
$BODY$
 LANGUAGE plpgsql VOLATILE;

--20210603-1004 CAEA: TABLA PARA REPORTE DE DOCUMENTOS PENDIENTES A INFORMAR
CREATE TABLE t_caea_pending_documents (
	created timestamp,
	ad_pinstance_id integer,
	ad_client_id integer, 
	ad_org_id integer, 
	ambiente character,
	periodo integer,
	orden integer,
	c_doctype_id integer, 
	c_invoice_id integer, 
	documentno varchar,
	ptovta integer,
	dateinvoiced date, 
	grandtotal numeric(20,2), 
	c_bpartner_id integer, 
	lyeicaeainformed character, 
	lyeicaeainformeddetail varchar
);

--20210604-0930 CAEA: TYPE PARA REPORTE DE CAEA SIN UTILIZAR PENDIENTES A INFORMAR
--DROP TYPE if exists v_caea_not_used_type;
CREATE TYPE v_caea_not_used_type AS (
	ad_client_id integer,
	ad_org_id integer,
	ambiente character,
	caea varchar,
	periodo integer,
	orden integer,
	ptovta integer,
	status character,
	detail varchar
);

--20210604-0930 CAEA: FUNCTION PARA REPORTE DE CAEA SIN UTILIZAR PENDIENTES A INFORMAR
-- DROP FUNCTION v_caea_not_used(clientID integer, orgID integer, periodo integer, orden integer, ptovta integer, ambiente character)
CREATE OR REPLACE FUNCTION v_caea_not_used(clientID integer, orgID integer, periodo integer, orden integer, ptovta integer, ambiente character)
RETURNS SETOF v_caea_not_used_type AS
$BODY$
DECLARE
consulta varchar;
countquery varchar;
adocument v_caea_not_used_type;
BEGIN
-- Cantidad de comprobantes CAEA emitidos para el ptovta dado que coincidan con el caea evaluado
countquery = '(select count(1) from c_invoice where puntodeventa = pc.pos AND CAE = cr.caea AND lyeicaeainformed is not null) as comp_emitidos, ';

-- CAEA sin usar por punto de venta 
consulta =
' SELECT foo.ad_client_id, foo.ad_org_id, foo.environment as ambiente, foo.caea, foo.periodo, foo.orden, foo.pos as ptovta, foo.status, foo.detail ' ||
' FROM ( ' ||
	-- CAEA para informar o informados con error, y numero de comprobantes emitidos en cada caso
'	select cr.ad_client_id, cr.ad_org_id, cr.environment, cr.caea, cr.periodo, cr.orden, pc.pos, ' || countquery || ' cnu.status, cnu.detail ' ||
'	FROM c_lyeicaearequest cr ' ||
'	LEFT JOIN C_LYEIElectronicPOSConfig pc ON pc.caemethod = ''A''  ' || -- Necesitamos conocer todos los puntos de venta de tipo CAEA
'	LEFT JOIN C_LYEICAEANotUsed cnu ON cr.c_lyeicaearequest_id = cnu.c_lyeicaearequest_id and pc.C_LYEIElectronicPOSConfig_id = cnu.C_LYEIElectronicPOSConfig_id ' ||
'	WHERE cr.ad_client_id = ' || clientID;

if (orgID is not null and orgID > 0) then
consulta = consulta ||
'	and cr.ad_org_id = ' || orgID;
end if;

consulta = consulta ||
'	and cr.environment = ''' || ambiente || '''' ||
'	and cr.periodo = ' || periodo;

if (orden is not null and orden>0) then
consulta = consulta ||
'	and cr.orden =  ' || orden;
end if;

if (ptovta is not null and ptovta>0) then
consulta = consulta ||
'	and pc.pos = ' || ptovta;
end if;

consulta = consulta ||
'	and (C_LYEICAEANotUsed_id is null or cnu.C_LYEICAEANotUsed_id not in ( ' ||
		-- Ya notificados y aprobados 
'		SELECT C_LYEICAEANotUsed_id ' ||
'		FROM C_LYEICAEANotUsed ' ||
'		WHERE environment = ''' || ambiente || '''' ||
'		AND status = ''A'' ' ||
'	)) ' ||
' ) as foo ' ||
' WHERE comp_emitidos = 0 ' ||
' ORDER BY periodo asc, orden asc ';


raise notice '%', consulta;
FOR adocument IN EXECUTE consulta LOOP
	return next adocument;
END LOOP;

END
$BODY$
 LANGUAGE plpgsql VOLATILE;

--20210604-0930 CAEA: TABLE PARA REPORTE DE CAEA SIN UTILIZAR PENDIENTES A INFORMAR
-- drop table T_caea_not_used 
CREATE TABLE T_caea_not_used (
	created timestamp,
	ad_pinstance_id integer,
	ad_client_id integer,
	ad_org_id integer,
	ambiente character,
	caea varchar,
	periodo integer,
	orden integer,
	ptovta integer,
	status character,
	detail varchar
);

--20210610-1031 CAEA: Nueva columna para tipo validacion de secuencias
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicPOSConfig','CAEACheckSequences','character(1)'));