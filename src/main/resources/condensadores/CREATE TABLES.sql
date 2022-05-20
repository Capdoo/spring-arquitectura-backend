create schema bioclimatica;
use bioclimatica;
create table condensadores(
	zona integer primary key,
    U_muro decimal(5,2),
    Rsi_muro decimal(5,2),
    Te_muro integer,
    U_techo decimal(5,2),
    Rsi_techo decimal(5,2),
    Te_techo integer,
    U_piso decimal(5,2),
    Rsi_piso decimal(5,2),
    Te_piso integer,
    HR integer
);

create table edificacion_ti(
	tipo varchar(100) primary key,
    Ti decimal(5,1)
);