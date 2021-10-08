INSERT INTO ubicacion (direccion, latitud, longitud) VALUES
    ('CalleFalsa, Springfield', 123, 456),
    ('Av SiempreViva, Springfield', 742, 742),
    ('Av Va, Springfield', 741, 442),
    ('Av Viva, Springfield', 767, 246),
    ('Av Siempre, Springfield', 666, 942);

INSERT INTO caracteristica (caracteristica) VALUES
    ('amigable'),
	('manso'),
	('companiero'),
	('jugueton'),
	('tranquilo'),
	('arisco'),
	('travieso');

INSERT INTO comodidad (comodidad) VALUES
    ('patio'),
    ('balcon'),
    ('terraza'),
	('campo');

INSERT INTO pregunta (pregunta, id_organizacion) VALUES
	('¿Tenés mascotas actualmente en tu hogar?', NULL),
	('¿Es la primera vez que adoptas?', NULL),
	('¿Tenés chicos en tu hogar?', NULL);

INSERT INTO organizacion (calidad, pixeles_alto, pixeles_ancho, id_ubicacion) VALUES
    ('png', 500, 500, (SELECT id FROM ubicacion WHERE direccion='CalleFalsa, Springfield')),
    ('png', 450, 450, (SELECT id FROM ubicacion WHERE direccion='Av Siempre, Springfield')),
    ('png', 600, 700, (SELECT id FROM ubicacion WHERE direccion='Av Va, Springfield')),
    ('png', 500, 1000, (SELECT id FROM ubicacion WHERE direccion='Av Viva, Springfield'));

INSERT INTO persona (rol, domicilio, fecha_de_nacimiento, nro_documento, tipo_documento, id_contacto_propio) VALUES
    ('Duenio', NULL, CURRENT_DATE, 43025544, 'DNI', NULL),
    ('Rescatista', NULL, CURRENT_DATE, 44445544, 'DNI', NULL);

INSERT INTO preferencias (edad_max, edad_min, sexo, tipo_mascota) VALUES
    (5, 3, 'MACHO', 'GATO'),
    (10, 4, 'HEMBRA', 'GATO'),
    (6, 3, 'HEMBRA', 'PERRO'),
    (8, 2, 'MACHO', 'PERRO');

INSERT INTO publicacion_interesado (email, id_preferencias) VALUES
    ('hola@gmail.com', 1),
    ('chau@gmail.com', 2),
    ('perro@gmail.com', 3),
    ('gato@gmail.com', 4);