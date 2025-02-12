--20250212-13:45
update ad_system set dummy = (SELECT addcolumnifnotexists('c_categoria_iva','ivareceptorid','numeric(10,0)'));

update c_categoria_iva set ivareceptorid=5 where coalesce(ivareceptorid,0)=0;
update c_categoria_iva set ivareceptorid=1 where codigo in (2, 0, 9);
update c_categoria_iva set ivareceptorid=4 where codigo in (4, 15);
update c_categoria_iva set ivareceptorid=2 where codigo in (5, 10);
update c_categoria_iva set ivareceptorid=6 where codigo in (3, 6, 8);
