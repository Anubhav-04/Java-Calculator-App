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