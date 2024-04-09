Simple SpringBoot application using PostgreSQL as a database with three different services.
1. Job Service: Lets you add job openings to a related company.
2. Company Service: Lets you add a company for which you can add several job openings.
3. Review Service: Lets you add reviews for different companies.

The service is built using Maven and requires Java 17 to run.

The project uses Docker containers to run instances of pgadmin and postgresql. You can check the container config in docker-compose.yaml file. Both these containers use docker network concept to interact with each other.

Clone it to your local and set the application.properties file as per your database requirements.

All the functionalities are exposed with the help of @RestController annotation.

Move to the controllers section to view the APIs and start enjoying a mini version of LinkedIn ^^
