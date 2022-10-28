--20220713-0956 En caso de que la factura contenga servicios, se debe informar a AFIP el periodo del servicio
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','lyeiperiodfrom','timestamp without time zone'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','lyeiperiodto','timestamp without time zone'));

--20221028-1355 Se agregan pos y com necesarios para el proceso de ddjj afip
-- lyeicom representa el puerto utilizado por la impresora fiscal invocado por la herramienta getaudar
-- lyeipos referencia el pos asociado al controlador fiscal
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Controlador_Fiscal','lyeipos','integer'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Controlador_Fiscal','lyeicom','integer'));

