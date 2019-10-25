--20191024-095900 Nuevos campos para MiPyME en configuracion, y registro en la factura
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','cbuemisor','varchar(100)'));
update ad_system set dummy = (SELECT addcolumnifnotexists('C_LYEIElectronicInvoiceConfig','aliasemisor','varchar(100)'));