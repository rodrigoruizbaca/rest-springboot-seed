# rest-springboot-seed
SprinBoot rest example.


Seed project for sprong boot rest app.

USAGE:
Needs to have installed maven.

1. Run mvn install
2. Run java -jar lib/SpringBootRestSeed-0.0.1-SNAPSHOT-spring-boot.jar

In postman or a browser run

http://localhost:8080/rate/convert/USD?amount=52

This call will convert an amount of USD dolars to mexican pesos

You can change the base to other currencies by changing the path variable USD in the example by EUR:

http://localhost:8080/rate/convert/EUR?amount=52

This call will convert an amount of euros to mexican pesos


The enpoint is internally calling another rates endpoints:

http://fixer.io/