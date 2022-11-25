--20220713-0956 En caso de que la factura contenga servicios, se debe informar a AFIP el periodo del servicio
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','lyeiperiodfrom','timestamp without time zone'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','lyeiperiodto','timestamp without time zone'));

--20221028-1355 Se agregan pos y com necesarios para el proceso de ddjj afip
-- lyeicom representa el puerto utilizado por la impresora fiscal invocado por la herramienta getaudar
-- lyeipos referencia el pos asociado al controlador fiscal
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Controlador_Fiscal','lyeipos','integer'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Controlador_Fiscal','lyeicom','integer'));


-- 20221111-1918 Tabla nueva para DDJJ Presentadas
create table C_LYEIDDJJPresentada(
--columnas obligatorias de libertya
C_LYEIDDJJPresentada_ID integer NOT NULL PRIMARY KEY,
ad_client_id integer NOT NULL,
ad_org_id integer NOT NULL,
isactive character(1) NOT NULL DEFAULT 'Y'::bpchar,
created timestamp without time zone NOT NULL DEFAULT ('now'::text)::timestamp(6) with time zone,
createdby integer NOT NULL,
updated timestamp without time zone NOT NULL DEFAULT ('now'::text)::timestamp(6) with time zone,
updatedby integer NOT NULL,
--asociacion con la impresora fiscal correspondiente
c_controlador_fiscal_id integer,
-- posConfig utilizada para la operacion
c_lyeielectronicposconfig_id int,
-- Usuario que ejecutó el proceso
ad_user_id integer,
-- data de ddjj presentadas
-- Fecha y hora de presentación
fyh_presentacion timestamp,
-- Nombre del archivo (85 caracteres aprox)
filename varchar(256),
-- Número de transacción (si se presentó OK)
trx_number varchar(20),
-- rango de fechas para las cuales se realiza la presentacion
datefrom date,
dateto date,
-- Mensaje de error (si falló)
error_msg varchar
);

