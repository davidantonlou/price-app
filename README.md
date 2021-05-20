## Execution
````
$> mvn clean package
$> mvn spring-boot:run
````

## Endpoints

Documentation: http://localhost:8080/swagger-ui.html

* GET http://localhost:8080/api/v1/prices
* GET http://localhost:8080/api/v1/price?brandId=X&inputDate=YYYY-MM-dd 00:00:00&productId=X