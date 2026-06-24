 servicio-autenticacion: Controla el acceso de usuarios (hecho sean: sin fallas al crear la base de datos y mostrar los datos ingresados) ✅
👤 pasajero_service: Gestiona los datos de turistas (hecho tomas: falta hacer testing)✅
🚗 vehiculo-service: Controla permisos de autos (hecho sean: falta hacer el testing)✅
👶 menores-service: Valida permisos de niños (hecho tomas : falta testeo, se hizo el testeo y se voi que funciono en el testeo sin lanzar errores al prender)✅
🍎 sag-service: Revisa alimentos y mascotas (hecho tomas : falta hacer testing)✅
👮 pdi-service: Controla entrada y salida (hecho por carlos: en la prueba del testeo da error al pedir cierta informacion y al ingresar cierta informacion en el get tambien da error la solicion que tuvo que hacerce fue borrar la autorizacion)✅
🇦🇷 integracion-service: Conecta con aduana argentina 
📊 reportes-service: Crea archivos PDF y Excel ✅
⏱️ flujo-service: Mide tiempos de espera ✅
❓ ayuda-service: Muestra guías al usuario (hecho Carlos : falta testeo)✅
gateaway: (hecho por el tomas: se le ingresaron los respectivos microservicios ya creados y funcionando)✅
eureka server:(hecho por sean, se configuro para que este listo para que los microservicios se enuentren automaticamente sin ingresar ip manualmente al gateaway)✅
(configurar todos los microservicios con eureka client y crear el microservico del api gateaway en donde van todos los microservicios conectados incluido el eureka server sol se le agrega el nombre del microservicio junto con el port, el url y terminar los 5 microservicios que faltan el eureka, gateaway son solo conectores no sirven agregar el docker en los microservicios y en algunos agregar el swagger)

Gateway-service         = 8080
Autentificacion-service = 8090
vehiculo-service        = 8091
pasajero-service        = 8092
Ayuda-service           = 8093
Menores-service         = 8094
Pdi-service             = 8095 
SAG-service             = 8096
Eureka-service          = 8761
