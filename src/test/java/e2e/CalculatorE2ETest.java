package e2e;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.app.calculator.Application;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorE2ETest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void testAdd() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl() + "/add?a=7&b=3", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Sum: 10");
    }

    @Test
    public void testSub() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl() + "/sub?a=7&b=3", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Difference: 4");
    }

    @Test
    public void testMul() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl() + "/mul?a=7&b=3", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Product: 21");
    }

    @Test
    public void testDiv() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl() + "/div?a=7&b=3", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Quotient: 2");
    }

    @Test
    public void testDivByZero() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl() + "/div?a=7&b=0", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Error: Division by zero not allowed.");
    }
}
