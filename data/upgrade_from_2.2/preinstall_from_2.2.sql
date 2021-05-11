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