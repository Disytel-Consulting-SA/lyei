-- 20240208-18:15 se agregan columnas para validar certificado AFIP en servicios externos
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','validatecrt','varchar(1)'));
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','testcrtstatus','varchar(1)'));
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','productioncrtstatus','varchar(1)'));
-- 20240222-16:56 se agregan columnas para guardar el TA en los servicios externos
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','homota','bytea'));
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','prodta','bytea'));

--20250212-13:45
update ad_system set dummy = (SELECT addcolumnifnotexists('c_categoria_iva','ivareceptorid','numeric(10,0)'));

update c_categoria_iva set ivareceptorid=5 where coalesce(ivareceptorid,0)=0;
update c_categoria_iva set ivareceptorid=1 where codigo in (2, 0, 9);
update c_categoria_iva set ivareceptorid=4 where codigo in (4, 15);
update c_categoria_iva set ivareceptorid=2 where codigo in (5, 10);
update c_categoria_iva set ivareceptorid=6 where codigo in (3, 6, 8);

--20250318-11:35
update ad_system set dummy = (SELECT addcolumnifnotexists('c_invoice','iscancelamismamoneda','character'));
--20220725-0904 Seteo propertie para deploy en prod 
INSERT INTO libertya.ad_preference (ad_preference_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, ad_window_id, ad_user_id, "attribute", value)
VALUES(nextval('seq_ad_preference'), 1010016, 0, 'Y', current_timestamp, 100, current_timestamp, 100, NULL, NULL, 'LYEIVersion4.0', 'N');