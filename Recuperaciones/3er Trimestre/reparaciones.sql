CREATE TABLE reparaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_reparacion CHAR(1) NOT NULL,
    nombre_cliente VARCHAR(100) NOT NULL,
    dni VARCHAR(9) NOT NULL,
    precio_base DOUBLE NOT NULL,
    fecha_entrada DATE NOT NULL,
    horas_trabajo INT NOT NULL,
    tipo_averia CHAR(1),
    limpieza_interna CHAR(1)
);

INSERT INTO reparaciones
(tipo_reparacion, nombre_cliente, dni, precio_base, fecha_entrada, horas_trabajo, tipo_averia, limpieza_interna)
VALUES
('M', 'Laura Gómez', '12345678A', 50, '2026-06-10', 2, 'P', NULL),
('M', 'Carlos Ruiz', '87654321B', 35, '2026-06-11', 1, 'B', NULL),
('O', 'Marta Pérez', '11223344C', 80, '2026-06-12', 3, NULL, 'S'),
('O', 'Sergio López', '99887766D', 60, '2026-06-13', 2, NULL, 'N');
