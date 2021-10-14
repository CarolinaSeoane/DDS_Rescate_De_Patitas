INSERT INTO ubicacion (direccion, latitud, longitud) VALUES
    ('CalleFalsa, Springfield', 123, 456),
    ('Av SiempreViva, Springfield', 742, 742),
    ('Av Va, Springfield', 741, 442),
    ('Av Viva, Springfield', 767, 246),
    ('Springfield', 666, 942);

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

INSERT INTO organizacion (calidad, pixeles_alto, pixeles_ancho, id_ubicacion) VALUES
    ('png', 500, 500, (SELECT id FROM ubicacion WHERE direccion='CalleFalsa, Springfield')),
    ('png', 450, 450, (SELECT id FROM ubicacion WHERE direccion='Av SiempreViva, Springfield')),
    ('png', 600, 700, (SELECT id FROM ubicacion WHERE direccion='Av Va, Springfield')),
    ('png', 500, 1000, (SELECT id FROM ubicacion WHERE direccion='Av Viva, Springfield'));

INSERT INTO pregunta (pregunta, id_organizacion) VALUES
	('¿Tiene mascotas actualmente en su hogar?', NULL),
	('¿Es la primera vez que adopta?', 1),
	('¿Tiene chicos en su hogar?', 1),
	('¿El animal que va a adoptar es para usted o para un tercero?', 2),
	('¿Ha pensado qué hará con el animal en vacaciones?', 3),
	('En caso de mudanza ¿qué haría con el animal?', NULL),
	('¿Tiene los recursos para cubrir sus necesidades?', NULL),
	('¿Tiene alergias?', 2),
	('¿Su familia está de acuerdo con la adopción?', NULL),
	('¿Tiene el espacio físico adecuado y seguro para el perro o gato?', 2);

INSERT INTO persona (rol, domicilio, fecha_de_nacimiento, nro_documento, tipo_documento, id_contacto_propio) VALUES
    ('Duenio', 'Calle123', CURRENT_DATE, 43025544, 'DNI', NULL),
    ('Rescatista', 'Nazca 5487', CURRENT_DATE, 44445544, 'DNI', NULL),
    ('Duenio', 'Campana 3455', CURRENT_DATE, 44445889, 'DNI', NULL),
    ('Rescatista', 'Libertador 741', CURRENT_DATE, 44443324, 'DNI', NULL),
    ('Rescatista', 'Corrientes 456', CURRENT_DATE, 44446664, 'DNI', NULL),
    ('Duenio', 'Gaona 4452', CURRENT_DATE, 22346664, 'DNI', NULL);

INSERT INTO contacto (apellido,	email, formas_notificacion, nombre,	telefono, id_persona) VALUES
    ('Diaz', 'mauroD@yahoo.com', 'WPP', 'Mauro', '1566547546', 1),
    ('Diaz', 'martuu@gmail.com', 'WPP, SMS', 'Martina', '1544447546', 1),
    ('Diaz', 'jessi@gmail.com', 'MAIL', 'Jessica', '45125447', 1),
    ('Bianco', 'Bianco007@yahoo.com', 'WPP, SMS, MAIL', 'Fernando', '1566777546', 2),
    ('Sola', 'sol@yahoo.com', 'EMAIL', 'Sol', '1787547546', 3),
    ('Sola', 'vicSola@gmail.com', 'EMAIL, SMS', 'Victoria', '1566547546', 3),
    ('Sola', 'Manu54@yahoo.com', 'WPP', 'Manuel', '1565667546', 3),
    ('Sola', 'SylSolaa@yahoo.com', 'WPP', 'Sylvina', '45067546', 3),
    ('Gabo', 'gabRuth@yahoo.com', 'SMS', 'Ruth', '45032104', 4),
    ('Paulin', 'GabiPaul@gmail.com', 'WPP, SMS, EMAIL', 'Gabriel', '1566511146', 5),
    ('Marian', 'elsiMarian@yahoo.com', 'EMAIL', 'Elsa', '45024450', 6),
    ('Marian', 'micaaMarian@yahoo.com', 'WPP', 'Micaela', '45027546', 6);

UPDATE persona SET id_contacto_propio = 1 WHERE id = 1;
UPDATE persona SET id_contacto_propio = 4 WHERE id = 2;
UPDATE persona SET id_contacto_propio = 5 WHERE id = 3;
UPDATE persona SET id_contacto_propio = 9 WHERE id = 4;
UPDATE persona SET id_contacto_propio = 10 WHERE id = 5;
UPDATE persona SET id_contacto_propio = 11 WHERE id = 6;

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

INSERT INTO mascota (apodo, descripcion, edad, id_qr, nombre, sexo, tipo, id_persona_duenia, id_organizacion) VALUES
    ('Benny', 'Gato amistoso que se lleva bien con todos y le encanta jugar, correr y disfrutar del aire libre.', 3, 'asdfgh456', 'Benito', 'MACHO', 'GATO', 1, 1),
    ('Mora', 'Perrita Border Collie joven, muy buena y compañera con las personas.', 2, '45erty987', 'Mora', 'HEMBRA', 'PERRO', 1, 2),
    ('Oscar', 'Perro mayor. Ya no es muy jugueton pero es un perro bueno y tranquilo.', 7, 'a7d78e5f2', 'Oscar', 'MACHO', 'PERRO', 3, 3),
    ('Dexter', 'Gato bastante travieso. Le gusta jugar con peluches pero no se lleva bien con otras mascotas.', 4, 'dht43rg45', 'Dexter', 'MACHO', 'GATO', 6, 3),
    ('Elton', 'Es un gato bastante grande que disfruta de estar con gente. Solamente come comida para gatos adultos.', 10, '34dfgsd47', 'Elton', 'MACHO', 'GATO', 6, 2),
    ('Luna', 'Gatita de buen comportamiento aunque muy solitaria. No suele salir al patio.', 1, '367d45der', 'Luna', 'HEMBRA', 'GATO', 3, 3),
    ('Wilson', 'Perro joven. Amistoso con otros perros pero no se lleva bien con los gatos.', 4, 'i7f8h8u5f', 'Wilson', 'MACHO', 'PERRO', 1, 1);

INSERT INTO usuario (tipo_usuario, password, usuario, id_organizacion, id_persona_duenia) VALUES
    ('StandardUser', 'Carlos077**', 'mauroDiaz', NULL, 1),
    ('StandardUser', 'MiPassword123_', 'sol_Sola', NULL, 3),
    ('StandardUser', '*ChiChiLo456', 'elsaMarian', NULL, 6),
    ('Administrador', 'Messi+1000', 'martinMatos', 1, NULL),
    ('Administrador', 'fjdsafjds486**A', 'MilagrosRoldan', 2, NULL),
    ('Administrador', '4524Aa**', 'JuanaTidan', 3, NULL),
    ('Administrador', 'avengers123ABC#', 'SofiVal', 4, NULL);

INSERT INTO publicacion_dar_en_adopcion (id_mascota, id_organizacion) VALUES
    (1, 1),
    (2, 1),
    (4, 1),
    (7, 1),
    (2, 1);