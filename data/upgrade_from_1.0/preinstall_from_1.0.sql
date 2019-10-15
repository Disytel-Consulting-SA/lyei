--20171020-0926 Nueva columna para especificar el ambiente de trabajo actual
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicPOSConfig','currentenvironment','character(1) NOT NULL DEFAULT ''H''::bpchar'));

--20171020-0926 Nueva columna para asignar a todos los POS el ambiente de trabajo actual
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','setenvironment','character(1)'));

--20171023-0956 Columnas para especificar si se modificó la configuracion
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','cuitChanged','character(1) NOT NULL DEFAULT ''N''::bpchar'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','nameChanged','character(1) NOT NULL DEFAULT ''N''::bpchar'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','applicantChanged','character(1) NOT NULL DEFAULT ''N''::bpchar'));

--20171023-1921 Cada TPV almacenara su TA.xml en el registro de configuracion de TPV correspondiente
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicPOSConfig','homota','bytea'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicPOSConfig','prodta','bytea'));

--20171023-1950 Soporte para el caso en que ya se gestionaron previamente los CRTs, con lo cual se debe cargar el key
--				Tambien debe ser posible eliminar el key si se desea rejecutar el proceso
 update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','rsakey','bytea'));
 update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','cleankey','character(1)'));
 update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','rsacsr','bytea'));
 update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','cleancsr','character(1)'));
 update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','configtype','character(1) NOT NULL DEFAULT ''C''::bpchar'));

--20171025-1519 Clase encargada de gestionar la registracion de FE
insert into ad_preference values((select nextval('seq_ad_preference')), 0, 0, 'Y', now(), 0, now(), 0, null, null, 'WSFE_PROVIDER_CLASS', 'org.libertya.locale.ar.electronicInvoice.utils.LYEIWSFE', null, null);
--20171026-1236 Clase encargada de gestionar la registracion de FEX
insert into ad_preference values((select nextval('seq_ad_preference')), 0, 0, 'Y', now(), 0, now(), 0, null, null, 'WSFEX_PROVIDER_CLASS', 'org.libertya.locale.ar.electronicInvoice.utils.LYEIWSFEX', null, null); 

--20171027-1109 Especificar tipo de servicio del punto de venta, por ejemplo 
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicPOSConfig','posservice','character(1) NOT NULL DEFAULT ''N''::bpchar'));

--20171031-1013 Log de actividad
CREATE TABLE C_LYEIElectronicInvoiceLog (
  C_LYEIElectronicInvoiceLog_ID INTEGER NOT NULL,
  ad_client_id INTEGER NOT NULL,
  ad_org_id INTEGER NOT NULL,
  isactive CHARACTER(1) NOT NULL DEFAULT 'Y'::bpchar,
  created TIMESTAMP WITHOUT TIME zone NOT NULL DEFAULT ('now'::text)::TIMESTAMP(6) WITH TIME zone,
  createdby INTEGER NOT NULL,
  updated TIMESTAMP WITHOUT TIME zone NOT NULL DEFAULT ('now'::text)::TIMESTAMP(6) WITH TIME zone,
  updatedby INTEGER NOT NULL,
  c_invoice_id INTEGER NULL,
  C_LYEIElectronicInvoiceConfig_ID INTEGER NULL,
  C_LYEIElectronicPOSConfig_ID INTEGER NULL,
  activity text,
  CONSTRAINT C_LYEIElectronicInvoiceLog_Key PRIMARY KEY (C_LYEIElectronicInvoiceLog_ID)
);

--20171031-1354 Los campos cae, vtocae y caeerror no se encuentran activos por defecto
update ad_field set isactive = 'Y' where ad_componentobjectuid in ('CORE-AD_Field-1014249', 'CORE-AD_Field-1014251', 'CORE-AD_Field-1014253');
