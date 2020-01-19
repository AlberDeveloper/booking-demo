# booking-demo

## Proyecto de prueba para Guest Incoming.

### Pre-requisitos
- Sistema Operativo: Linux (se creado y testeado en una máquina con un Ubuntu)

- Antes de empezar debemos tener instalado:
    - docker
    - maven
    - git
    
    
### Descargar el proyecto git
- Dentro del directorio donde queramos guardar el proyecto ejecutaremos:  
``git clone https://bitbucket.org/alber_developer/booking-demo.git``

### Compilar y levantar los servicios con Docker
- Entramos al directorio  
``cd booking-demo``
- Limpiar e instalar
``mvn clean && mvn install``  
- Creamos el .jar del proyecto  
``./mvnw package && java -jar ./target/bookingdemo-0.0.1.jar``
- Construimos la imagen Docker  
``docker build -t bookingdemo-docker .``
- Creamos la imagen de la BD con la carga de datos inicial  
``docker run -d -p 3001:3001 --name=bookingdemo-database --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_USER=user" --env="MYSQL_PASSWORD=user123"  --env="MYSQL_DATABASE=booking_demo" mysql``  
``docker exec -i bookingdemo-database mysql -uroot -proot booking_demo < dump-booking_demo.sql``
- Levantamos los servicios  
``docker-compose up``

### Ejecutar funcionalidades con el navegador
- Las url para los diferentes servicios son:
    - Disponibilidad: http://localhost:8080/booking-demo/getAvailability
    - Reservar: http://localhost:8080/booking-demo/booking
    - Cancelar una reserva: http://localhost:8080/booking-demo/cancel-booking
    
#### Comprobar disponibilidad
Para comprobar la disponibilidad, podremos buscar por código de ciudad o de hotel. Los códigos son los siguientes:

**Ciudades:**

|  Código | Ciudad    |
|---------|-----------|
| 001     | Barcelona |
| 002     | París     |
| 003     | Roma      | 


**Hoteles:**

|  Código | Hotel                  |
|---------|------------------------|
| CIBAL   | CheckIn Balmes         |
| CIRAM   | CheckIn Ramblas        |
| CITIV   | CheckIn Tivoli         |
| CITEL   | CheckIn Torre Eiffel   |
| CICES   | CheckIn Champs Elysees |
| CICOL   | CheckIn Coliseo        |
| CIVAT   | CheckIn Vaticano       |
| CITRI   | CheckIn Trieste        |

En nuestro cliente de peticiones (navegador web o clientes tipo "Postman"),hacer la llamada para consultar la disponibilidad de habitaciones en una ciudad o en un hotel. El código de ciudad u hotel se lo enviaremos a traves del parámetro *code*. Por ejemplo:  
http://localhost:8080/booking-demo/getAvailability?code=CITEL

Nos buscará disponibilidad en el hotel "CheckIn Torre Eiffel". O bien:  
http://localhost:8080/booking-demo/getAvailability?code=002

Nos buscará disponibilidad en todos los hoteles de Francia.

Esta petición nos devolverá un json con toda la información requerida, para realizar una reserva, guardaremos el *bookingCode*.


#### Realizar una reserva
Para realizar una reserva, haremos la petición a la siguiente URL con el *bookingCode* deseado:    
http://localhost:8080/booking-demo/booking?bookingCode=*{bookingCode}*    

Si la petición es correcta, nos devolverá un localizador *locator* de la reserva realizada, por si queremos cancelar la reserva a posteriori.
    
#### Cancelar una reserva
Para cancelar una reserva, haremos la petición a la siguiente URL con el *locator* deseado:  
http://localhost:8080/booking-demo/cancel-booking?locatorCode=*{locator}*    

Si la petición es correcta, cancelará nuestra reserva.    
    
    
    
    
    
    
    
    
    
    
    
    