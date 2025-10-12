# Build and Run the application ---------
1. Run the below command

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=9100"

```

2. go to --> 'http://localhost:9100/index.html'

# Test the application ---------

```bash

mvn test

```

3. To run the Selenium integration testing 

```bash

python3 src/test/java/integration/CalculatorIntegrationTest.py

```

4. To run sonar-scanner

```bash
sonar-scanner -Dsonar.projectBaseDir="$(pwd)" -Dsonar.host.url=http://localhost:9000 -Dsonar.token= secrets from sonarqube
```