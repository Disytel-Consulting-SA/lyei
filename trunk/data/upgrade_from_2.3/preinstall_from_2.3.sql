--20220713-0956 En caso de que la factura contenga servicios, se debe informar a AFIP el periodo del servicio
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','lyeiperiodfrom','timestamp without time zone'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','lyeiperiodto','timestamp without time zone'));

