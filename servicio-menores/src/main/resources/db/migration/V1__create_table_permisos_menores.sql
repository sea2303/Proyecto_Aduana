CREATE TABLE permisos_menores (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  nombre VARCHAR(100) NOT NULL,
                                  apellidos VARCHAR(100) NOT NULL,
                                  numero_documento VARCHAR(20) NOT NULL UNIQUE,
                                  edad BIGINT NOT NULL,
                                  permiso_vigente BOOLEAN NOT NULL,
                                  estado_control VARCHAR(50) NOT NULL
);