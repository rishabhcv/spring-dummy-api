# Spring Boot based REST API
Created using [Spring Initializr](http://start.spring.io/). Dependencies :
1. Web (For Spring Web Dependecies - Rest, Spring MVC)             
2. Dev-Tools (For Live-reload feature)        
3. JPA (For persistence)       
4. H2 (In memory Database)      
 

# TroubleShooting
1. [Post request persisting null values](https://stackoverflow.com/questions/38935912/requestbody-is-getting-null-values)
2. __com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.esp.entity.Players` (no Creators, like default construct, exist): cannot deserialize from Object value (no delegate- or property-based Creator)__ : A default no-argument constructor is required to deserialize (map) the RequestBody from JSON to Object's fields. The contructor can have any access modifier, even private. If you're creating parameterized constructor for your Entity classes, don't forget to add a default no-argument constructor as well.

<!-- 3.
4.
5. -->
