-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS Hotel;

-- Usar la base de datos recién creada
USE Hotel;

-- Crear la tabla clientes
CREATE TABLE IF NOT EXISTS clientes (
    cedula INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS habitaciones (
    numero_habitacion INT UNIQUE,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2),
    capacidad INT,
    categoria VARCHAR(255),
    PRIMARY KEY (numero_habitacion)
);

-- Crear la tabla reserva
CREATE TABLE IF NOT EXISTS reserva (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    cedula_cliente INT,
    numero_habitacion INT,
    dia_entrada DATE,
    dia_salida DATE,
    cantidad_personas INT,
    FOREIGN KEY (cedula_cliente) REFERENCES clientes(cedula),
    FOREIGN KEY (numero_habitacion) REFERENCES habitaciones(numero_habitacion)
);

INSERT INTO clientes (cedula, nombre, apellidos) 
VALUES (1722465026, 'Juan', 'Pérez');

-- Insertar habitación con temática de la calle Broadway
INSERT INTO habitaciones (numero_habitacion, nombre, precio, capacidad, categoria) 
VALUES (101, 'Broadway Suite', 150.00, 2, 'individual');

-- Insertar habitación con temática de la calle Wall Street
INSERT INTO habitaciones (numero_habitacion, nombre, precio, capacidad, categoria) 
VALUES (102, 'Wall Street Loft', 200.00, 3, 'doble');
-- Insertar habitación con temática de la calle Fifth Avenue
INSERT INTO habitaciones (numero_habitacion, nombre, precio, capacidad, categoria) 
VALUES (103, 'Fifth Avenue Penthouse', 300.00, 4, 'suite');

INSERT INTO reserva (cedula_cliente, numero_habitacion, dia_entrada, dia_salida, cantidad_personas) 
VALUES (123456789, 101, '2024-05-01', '2024-05-05', 2);

INSERT INTO reserva (cedula_cliente, numero_habitacion, dia_entrada, dia_salida, cantidad_personas) 
VALUES (1722465026, 102, '2024-04-28', '2024-04-30', 2);



select * from clientes;
select * from reserva;
select * from habitaciones;