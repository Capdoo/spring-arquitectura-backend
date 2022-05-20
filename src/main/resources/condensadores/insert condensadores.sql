use sql10493413;
insert into	edificacion_ti()
values
	('Bibliotecas, archivos' ,16.5),
	('Cantinas' ,18.0),
	('Cines y teatro' ,20.0),
    ('Cocinas' ,20.0),
    ('Escuela (aula)' ,20.0),
    ('Escuela (gimnasio)' ,16.5),
    ('Escuela (piscinas de aprendizaje cubierta)' ,24.0),
    ('Grandes almacenes' ,20.0),
    ('Hospital (Salas de hospitalizacion)' ,21.0),
    ('Hospital (Salas de reconocimiento y de tratamiento)' ,24.0),
    ('Locales de trabajo' ,19.0),
    ('Oficinas' ,20.0),
    ('Restaurantes' ,20.0),
    ('Salas de actos' ,20.0),
    ('Salas de exposiciones' ,16.5),
    ('Salas de juntas' ,18.0),
    ('Tiendas' ,20.0),
    ('Vivienda' ,18.0)
    ;

insert into	condensadores(zona, u_muro, rsi_muro, te_muro,
								u_techo, rsi_techo, te_techo,
								u_piso, rsi_piso, te_piso,
                                hr)
values
	(1, 2.36, 0.11, 18, 2.21, 0.17, 18, 2.63, 0.17, 18, 80),
    (2, 3.20, 0.11, 24, 2.20, 0.17, 24, 2.63, 0.17, 24, 70),
    (3, 2.36, 0.11, 20, 2.21, 0.17, 20, 2.63, 0.17, 20, 50),
    (4, 2.36, 0.11, 12, 2.21, 0.09, 12, 2.63, 0.09, 12, 50),
    (5, 1.85, 0.11, 6,  1.00, 0.09, 6,  3.26, 0.09, 6,  50),
    (6, 1.75, 0.11, 0,  1.00, 0.09, 0,  3.26, 0.09, 0,  50),
    (7, 2.36, 0.11, 26, 2.20, 0.17, 26, 2.63, 0.17, 26, 70),
    (8, 3.60, 0.11, 22, 2.20, 0.17, 22, 2.63, 0.17, 22, 70),
    (9, 3.60, 0.11, 27, 2.20, 0.17, 27, 2.63, 0.17, 27, 70);
