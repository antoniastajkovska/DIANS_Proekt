We made two separate Spring Boot applications (dataconversion-microservice and gallery-microservice), each responsible for its own domain. The dataconversion-microservice handles data conversion from XML to JSON and writes the result to a JSON file, while the gallery-microservice handles the retrieval of JSON data from dataconversion-microservice and further processing.

These services are loosely coupled, meaning they can function independently. The gallery-microservice doesn't need to know how the JSON data is generated; it simply consumes it from the dataconversion-microservice endpoint.

We’re using HTTP to communicate between the two services. The gallery-microservice makes an HTTP GET request to the /data endpoint of the dataconversion-microservice to fetch the JSON data.
