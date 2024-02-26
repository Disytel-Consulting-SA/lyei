-- 20240208-18:15 se agregan columnas para validar certificado AFIP en servicios externos
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','validatecrt','varchar(1)'));
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','testcrtstatus','varchar(1)'));
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','productioncrtstatus','varchar(1)'));
-- 20240222-16:56 se agregan columnas para guardar el TA en los servicios externos
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','homota','bytea'));
update ad_system set dummy = (SELECT addcolumnifnotexists('c_externalservice','prodta','bytea'));

