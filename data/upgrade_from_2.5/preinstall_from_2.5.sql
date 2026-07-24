--20260702-1249 Preinstall LYEI 2.6

--20260724-0900 Alerta por vencimiento certificados RECE

--Cambiar ad_client.modelvalidationclasses del tipo de varchar(255) a text para evitar limitaciones en la longitud de las clases definidas.  No definir un limite de 255 en metadatos.
--Estas ampliaciones tambien se realizaron a nivel CORE, pero se incluyen aqui en caso de estar usando una version previa de CORE.
ALTER TABLE ad_client ALTER COLUMN modelvalidationclasses TYPE text;
update ad_column set fieldlength = -1 where ad_componentobjectuid = 'CORE-AD_Column-13058';

-- Se incluye nuevo validator 
update ad_client set modelvalidationclasses = modelvalidationclasses || ';org.libertya.locale.ar.electronicInvoice.utils.LYEICRTAboutToExpireValidator' where ad_client_id = 1010016;

-- Nueva preferencia para definir con cuantos dias de anticipacion comienzan los warnings
INSERT INTO ad_preference
(ad_preference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_window_id, ad_user_id, "attribute", value, ad_componentobjectuid, ad_componentversion_id)
VALUES
((select nextval('seq_ad_preference')), 1010016, 0, 'Y', now(), 0, now(), 0, NULL, NULL, 'LYEI_RECE_WARNING_WINDOW_DAYS', '15', NULL, NULL);

