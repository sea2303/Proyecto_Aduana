CREATE TABLE vehiculos (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           patente VARCHAR(50),
                           marca VARCHAR(100),
                           modelo VARCHAR(100),
                           propietario_rut VARCHAR(50),
                           tiene_permiso_argentina BOOLEAN NOT NULL
);