package com.RMI;

public class Main
{
    /*
    // RMI stands for Remote Method Invocation
    - API
     -- provides a mechanism to create distributed application
     -- RMI allows an object to invoke methods on an object running in another JVM

     -RMI provides remote communication between the applications using two objects stub and skeleton
     /Stub
     -- stub is an object
     -- acts as a gateway for the client side
     -- All the outgoing requests are routed through it
     -- resides at the client side and represents the remote object
     -- When the caller invokes method on the stub object , does the following tasks
        * initiates a connection with remote Virtual Machine (JVM),
        * writes and transmits (marshals) the parameters to the remote Virtual Machine (JVM),
        * waits for the result
        * reads (unmarshals) the return value or exception,
        * finally, returns the value to the caller


    / Skeleton
    -- skeleton is an object
    -- acts as a gateway for the server side object
    -- All the incoming requests are routed through it
    -- When the skeleton receives the incoming request, it does the following tasks
        * reads the parameter for the remote method
        * invokes the method on the actual remote object
        * writes and transmits (marshals) the result to the caller



    // requirements for the distributed applications
    * application need to locate the remote method
    * need to provide the communication with the remote objects
    * application need to load the class definitions for the objects

    ///  steps to write the RMI program.

    -- Create the remote interface
    -- Provide the implementation of the remote interface
    -- Compile the implementation class and create the stub and skeleton objects using the rmic tool
    -- Start the registry service by (rmi Registry)  tool
    -- Create and start the remote application
    -- Create and start the client application


     */
}
