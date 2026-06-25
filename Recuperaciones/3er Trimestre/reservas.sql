-- Crear la tabla
CREATE TABLE reservas (
    id               INT            NOT NULL AUTO_INCREMENT,
    tipo_reserva     CHAR(1)        NOT NULL,
    nombre_cliente   VARCHAR(100)   NOT NULL,
    dni              VARCHAR(9)     NOT NULL,
    precio_noche     DECIMAL(6,2)   NOT NULL,
    fecha_entrada    DATE           NOT NULL,
    num_noches       INT            NOT NULL,
    tipo_habitacion  CHAR(1)        NULL,
    pension          VARCHAR(2)     NULL,
    PRIMARY KEY (id)
);

INSERT INTO reservas (tipo_reserva, nombre_cliente, dni, precio_noche, fecha_entrada, num_noches, tipo_habitacion, pension) VALUES
('E', 'Ana García López',         '12345678A', 75.00,  '2026-06-01', 3, 'I', NULL),
('E', 'Carlos Martínez Ruiz',     '23456789B', 95.50,  '2026-06-05', 5, 'D', NULL),
('E', 'Lucía Fernández Mora',     '34567890C', 220.00, '2026-06-10', 2, 'S', NULL),
('E', 'Pedro Sánchez Gil',        '45678901D', 75.00,  '2026-06-12', 1, 'I', NULL),
('E', 'María López Jiménez',      '56789012E', 95.50,  '2026-06-15', 7, 'D', NULL),
('E', 'Javier Romero Castro',     '67890123F', 220.00, '2026-06-20', 4, 'S', NULL),
('E', 'Elena Torres Vega',        '78901234G', 75.00,  '2026-07-01', 2, 'I', NULL),
('E', 'Antonio Díaz Herrera',     '89012345H', 95.50,  '2026-07-08', 6, 'D', NULL),
('P', 'Isabel Navarro Blanco',    '90123456J', 130.00, '2026-06-03', 4, NULL, 'MP'),
('P', 'Francisco Molina Reyes',   '01234567K', 160.00, '2026-06-08', 7, NULL, 'PC'),
('P', 'Carmen Ortega Fuentes',    '11223344L', 130.00, '2026-06-14', 3, NULL, 'MP'),
('P', 'Alejandro Serrano Pinto',  '22334455M', 160.00, '2026-06-22', 5, NULL, 'PC'),
('P', 'Sofía Muñoz Delgado',      '33445566N', 130.00, '2026-07-03', 2, NULL, 'MP'),
('P', 'Roberto Iglesias Cano',    '44556677P', 160.00, '2026-07-10', 8, NULL, 'PC'),
('P', 'Patricia Vargas Leal',     '55667788Q', 130.00, '2026-07-15', 3, NULL, 'MP');
