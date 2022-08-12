# java-modules
Usage examples of modules in Java version > 8

Modules
Java 9 modules enhance the platform as follows:

  -Strong encapsulation. Encapsulation is honored during compilation and execution, even in the face of reflection attempts.
  -Reliable configuration. The runtime checks the availability of dependencies before launching the application.
  -Creation of images that packages the application with a custom-made Java platform. This implies:
        -Lower memory and disk requirements (useful for microservices and small devices)
        -Greater security, because the code involved is less.
        -Improved optimization (dead-code elimination, constant folding, compression, etc.).
   -Decoupled services without classpath scanning (interface implementations are explicitly indicated).
   -Fast type loading. The system knows where each package is without having to scan the classpath.
   -Preserves the borders established by architecture.

Strong encapsulation has other benefits, such as the ability to test a module in isolation, avoid code decay by introducing accidental dependencies, and dependency reduction when multiple teams work in parallel.

A module in Java is an artifact that can contain code, resources, and metadata. The metadata describes dependencies with other modules, and regulates access to the module's packages.

Example of a module file 
  // open allows reflection throughout the module
  open module com.example
  {
      // export a package so that other modules can access their public packages
      exports com.apple;
  
      // indicates a dependency on the com.orange module
      requires com.orange;
  
      // indicates a dependency on com.banana. the 'static' makes the dependency
      // be required during compilation but optional during execution
      requires static com.banana;
  
      // indicates a dependency to the com.berry module and its dependencies
      requires transitive com.berry;
  
      // enable reflection in the com.pear module
      opens com.pear;
  
      // allow reflection in the com.lemon package but only from the com.mango module
      opens com.lemon to com.mango;
  
      // expose the type MyImplementation that implements the service MyService
      provides com.service.MyService with com.consumer.MyImplementation
  
      // use the service com.service.MyService
      uses com.service.MyService
  }
