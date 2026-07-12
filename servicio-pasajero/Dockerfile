servicio-pasajero:
    build: ./servicio-pasajero
    container_name: servicio-pasajero
    ports:
      - "8095:8095"
    environment:
      - SERVER_PORT=8095
      - DB_HOST=auth-db
      - DB_PASSWORD=root_secure_pass # <-- Aquí le pasas la contraseña real que usa tu contenedor MySQL
      - EUREKA_HOST=servidor-eureka
    depends_on:
      auth-db:
        condition: service_healthy
      servidor-eureka:
        condition: service_started
    networks:
      - aduana-network