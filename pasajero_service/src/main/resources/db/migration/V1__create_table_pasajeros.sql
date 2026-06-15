CREATE TABLE pasajeros (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(255),
                           apellido VARCHAR(255),
                           numero_documento VARCHAR(255),
                           tipo_documento VARCHAR(255),
                           nacionalidad VARCHAR(255),
                           estado_control VARCHAR(255),
                           cantidad_bultos INT
);