# Spring Boot based REST API
Created using [Spring Initializr](http://start.spring.io/). Dependencies :
1. Web (For Spring Web Dependecies - Rest, Spring MVC)             
2. Dev-Tools (For Live-reload feature)        
3. JPA (For persistence)       
4. H2 (In memory Database)      
 
## Introduction

1. @GetMapping(path = "/players/{id}")  & @PathVariable                                  
2. @RequestBody                                    
3. Exception class with @ResponseStatus(HttpStatus.NOT_FOUND) -- class level, method level             
4. URI location = ServletUriComponentsBuilder                         
		.fromCurrentRequest()                 
		.path("/{id}")                        
		.buildAndExpand(player.getId())                  
		.toUri();                               
		return ResponseEntity.created(location).build();                    
  5. spring.jackson.serialization.INDENT_OUTPUT=true
  6. @ControllerAdvice
  7. generic Exception Handling using @ExceptionHandler and ResponseEntityExceptionHandler class [Read More](https://dzone.com/articles/global-exception-handling-with-controlleradvice)                        
  ```java
  @ExceptionHandler(PlayerNotFoundException.class)
	public final ResponseEntity<Object> handleAllNotFoundExceptions(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);
	}
  ```
  8. Added Validation using javax validation API's Annotations : @Valid, @Size, @NotNull, @Min,    etc. Added a handler method in Generic response handler: 
  ```java
  @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse expResp = new ExceptionResponse(ex.getMessage(), request.getDescription(false), new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.BAD_REQUEST);
	}
  ```      


## TroubleShooting 
1. [Post request persisting null values](https://stackoverflow.com/questions/38935912/requestbody-is-getting-null-values)
2. __com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.esp.entity.Players` (no Creators, like default construct, exist): cannot deserialize from Object value (no delegate- or property-based Creator)__ : A default no-argument constructor is required to deserialize (map) the RequestBody from JSON to Object's fields. The contructor can have any access modifier, even private. If you're creating parameterized constructor for your Entity classes, don't forget to add a default no-argument constructor as well.        

## Awesome Articles to Read
1. [Jackson annotations guide](https://www.baeldung.com/jackson-annotations)        
2. [21 Best Practices for designing and launching a RESTful API](https://www.snyxius.com/21-best-practices-designing-launching-restful-api/)          
3. [Microsoft Microservices Architecture Style](https://docs.microsoft.com/en-us/azure/architecture/guide/architecture-styles/microservices)      
4. [Microsoft API Design and Best Practices](https://docs.microsoft.com/en-us/azure/architecture/best-practices/api-design)
5. [SmartBear Understanding Microservice Architecture](https://smartbear.com/learn/api-design/what-are-microservices/)
