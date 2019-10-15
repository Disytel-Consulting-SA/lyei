--20160304-1043 Creacion de tabla de configuracion de FE y configuracion de POS
CREATE TABLE C_LYEIElectronicInvoiceConfig (
  C_LYEIElectronicInvoiceConfig_ID INTEGER NOT NULL,
  ad_client_id INTEGER NOT NULL,
  ad_org_id INTEGER NOT NULL,
  isactive CHARACTER(1) NOT NULL DEFAULT 'Y'::bpchar,
  created TIMESTAMP WITHOUT TIME zone NOT NULL DEFAULT ('now'::text)::TIMESTAMP(6) WITH TIME zone,
  createdby INTEGER NOT NULL,
  updated TIMESTAMP WITHOUT TIME zone NOT NULL DEFAULT ('now'::text)::TIMESTAMP(6) WITH TIME zone,
  updatedby INTEGER NOT NULL,
  name varchar(100) NOT NULL,
  cuit varchar(20) NOT NULL,
  applicant varchar(100) NOT NULL,
  electronicInvoiceBaseDir varchar(255),
  confirmConfiguration char(1),
  editConfiguration char(1),
  createElectronicPOS char(1),
  CONSTRAINT C_LYEIElectronicInvoiceConfig_Key PRIMARY KEY (C_LYEIElectronicInvoiceConfig_ID)
);

CREATE TABLE C_LYEIElectronicPOSConfig (
  C_LYEIElectronicPOSConfig_ID INTEGER NOT NULL,
  ad_client_id INTEGER NOT NULL,
  ad_org_id INTEGER NOT NULL,
  isactive CHARACTER(1) NOT NULL DEFAULT 'Y'::bpchar,
  created TIMESTAMP WITHOUT TIME zone NOT NULL DEFAULT ('now'::text)::TIMESTAMP(6) WITH TIME zone,
  createdby INTEGER NOT NULL,
  updated TIMESTAMP WITHOUT TIME zone NOT NULL DEFAULT ('now'::text)::TIMESTAMP(6) WITH TIME zone,
  updatedby INTEGER NOT NULL,
  C_LYEIElectronicInvoiceConfig_ID INTEGER NOT NULL,
  pos integer NOT NULL,
  productionCRT bytea,
  productionCRTstatus char(1),
  testCRT bytea,
  testCRTstatus char(1),
  validateCRT char(1),
  CONSTRAINT C_LYEIElectronicPOSConfig_Key PRIMARY KEY (C_LYEIElectronicPOSConfig_ID)
);

ALTER TABLE C_LYEIElectronicInvoiceConfig ADD COLUMN processed character(1) NOT NULL DEFAULT 'N'::bpchar;

ALTER TABLE C_LYEIElectronicPOSConfig 
ADD CONSTRAINT C_LYEIElectronicPOSConfig_EIConfig 
FOREIGN KEY (C_LYEIElectronicInvoiceConfig_ID)
REFERENCES C_LYEIElectronicInvoiceConfig (C_LYEIElectronicInvoiceConfig_ID) MATCH SIMPLE
ON UPDATE NO ACTION ON DELETE NO ACTION;
