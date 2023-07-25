To run the Current Account API, follow these steps:

1- Ensure you have Java (JDK 17) installed on your machine, or change the version in the pom.xml file
2- Clone the project from the GitHub repository: 
3- Navigate to the project's root directory.
4- Build the project using Maven: mvn clean install.
5- Run the application: mvn spring-boot:run.
6- The API will be accessible at http://localhost:8080
7- The in-memory database :devdb will be accessible at http://localhost:8080/h2-console/. the access credentials are admin/admin
8- To run the tests: mvn test


###########"###API Documentation#######################################

The API is documented using Swagger, which provides an interactive interface to explore the available endpoints and their specifications.

Swagger API Documentation URL: http://localhost:8080/swagger-ui/index.html#/

Using the Swagger documentation, you can:

1- View all available endpoints, their request parameters, and response formats.
2- Test API endpoints directly from the documentation interface.
3- Obtain detailed information about the data models used in the API.
