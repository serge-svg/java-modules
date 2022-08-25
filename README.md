# Java Modules
Usage examples of modules in Java version > 8

Modules
Java 9 modules enhance the platform as follows:

* Strong encapsulation. Encapsulation is honored during compilation and execution, even in the face of reflection attempts.
* Reliable configuration. The runtime checks the availability of dependencies before launching the application.
* Creation of images that packages the application with a custom-made Java platform. This implies:
  * Lower memory and disk requirements (useful for microservices and small devices)
  * Greater security, because the code involved is less.
  * Improved optimization (dead-code elimination, constant folding, compression, etc.).
  * Decoupled services without classpath scanning (interface implementations are explicitly indicated).
  * Fast type loading. The system knows where each package is without having to scan the classpath.
  * Preserves the borders established by architecture.

Strong encapsulation has other benefits, such as the ability to test a module in isolation, avoid code decay by introducing accidental dependencies, and dependency reduction when multiple teams work in parallel.

A module in Java is an artifact that can contain code, resources, and metadata. The metadata describes dependencies with other modules, and regulates access to the module's packages.

Example of a module file 
>// nombre del módulo. open permite la reflexión en todo el módulo  
    **open module com.ejemplo**  
  {  
  // exporta un paquete para que otros módulos accedan a sus paquetes públicos  
     **exports com.apple;**  
  // indica una dependencia con el módulo com.orange  
     **requires com.orange;**  
  // indica una dependencia con com.banana. el 'static' hace que la dependencia   
  // sea obligatoria durante compilación pero opcional durante ejecución  
     **requires static com.banana;**  
  // indica una dependencia al módulo com.berry y sus dependencias  
     **requires transitive com.berry;**    
  // permite reflexión en el módulo com.pear  
     **opens com.pear;**  
  // permite reflexión en el paquete com.lemon pero solo desde el módulo com.mango  
     **opens com.lemon to com.mango;**  
  // expone el tipo MyImplementation que implementa el servicio MyService  
     **provides com.service.MyService with com.consumer.MyImplementation;**  
  // usa el servicio com.service.MyService  
     **uses com.service.MyService;**  
}

More info
https://www.adictosaltrabajo.com/2017/10/30/modularidad-en-java-9-12/