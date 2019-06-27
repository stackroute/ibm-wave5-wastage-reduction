package com.stackroute.routingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.stackroute.routingService.repository")
public class Neo4jServiceApplication {

	public static void main(String []args) {

		SpringApplication.run(Neo4jServiceApplication.class, args);
	}

}
