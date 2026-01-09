-- Insertar Estaciones
INSERT INTO estacion (capacidad, coordenada, nombre, numero) VALUES (20, '37.377,-5.987', 'Plaza de España', 1);
INSERT INTO estacion (capacidad, coordenada, nombre, numero) VALUES (15, '37.382,-6.002', 'Altozano', 2);
INSERT INTO estacion (capacidad, coordenada, nombre, numero) VALUES (10, '37.389,-5.984', 'La Campana', 3);

-- Insertar Usuarios (nombre, num_tarjeta, pin, saldo)
INSERT INTO usuario (nombre, num_tarjeta, pin, saldo) VALUES ('Juan Pérez', 111222, 1234, 50.0);
INSERT INTO usuario (nombre, num_tarjeta, pin, saldo) VALUES ('Ana García', 333444, 4321, 25.50);
INSERT INTO usuario (nombre, num_tarjeta, pin, saldo) VALUES ('Carlos Ruiz', 555666, 9999, 5.0);

-- Insertar Bicicletas (estado: 0=LIBRE, 1=OCUPADA, 2=ROTA)
INSERT INTO bicicleta (marca, modelo, estado, estacion_id) VALUES ('Decathlon', 'Rockrider', 0, 1);
INSERT INTO bicicleta (marca, modelo, estado, estacion_id) VALUES ('Btwin', 'Elops', 0, 1);
INSERT INTO bicicleta (marca, modelo, estado, estacion_id) VALUES ('Orbea', 'MX', 2, 2);
INSERT INTO bicicleta (marca, modelo, estado, estacion_id) VALUES ('Xiaomi', 'Himo', 0, 2);
INSERT INTO bicicleta (marca, modelo, estado, estacion_id) VALUES ('Trek', 'Marlin', 0, 3);

-- Insertar Usos (coste, fecha_inicio, fecha_final, bicicleta_id, estacion_id, usuario_id)
INSERT INTO uso (coste, fecha_inicio, fecha_final, bicicleta_id, estacion_id, usuario_id) VALUES (2.5, '2023-10-01T10:00:00', '2023-10-01T12:30:00', 1, 1, 1);
INSERT INTO uso (coste, fecha_inicio, fecha_final, bicicleta_id, estacion_id, usuario_id) VALUES (1.0, '2023-10-02T09:00:00', '2023-10-02T09:45:00', 2, 1, 2);
INSERT INTO uso (coste, fecha_inicio, fecha_final, bicicleta_id, estacion_id, usuario_id) VALUES (0.0, '2023-10-03T18:00:00', NULL, 4, 2, 1);