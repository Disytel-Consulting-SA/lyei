--20210319-1202 Nuevos campos para validacion registracion factura electronica
update ad_system set dummy = (SELECT addcolumnifnotexists('C_Invoice','LYEIManageElectronicInvoiceProcess','character(1)'));
