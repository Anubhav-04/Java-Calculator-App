package integration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.app.calculator.Application;  

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class CalculatorControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(get("/add").param("a", "7").param("b", "3"))
            .andExpect(status().isOk())
            .andExpect(content().string("Sum: 10"));
    }

    @Test
    public void testSub() throws Exception {
        mockMvc.perform(get("/sub").param("a", "7").param("b", "3"))
            .andExpect(status().isOk())
            .andExpect(content().string("Difference: 4"));
    }

    @Test
    public void testMul() throws Exception {
        mockMvc.perform(get("/mul").param("a", "7").param("b", "3"))
            .andExpect(status().isOk())
            .andExpect(content().string("Product: 21"));
    }

    @Test
    public void testDiv() throws Exception {
        mockMvc.perform(get("/div").param("a", "7").param("b", "3"))
            .andExpect(status().isOk())
            .andExpect(content().string("Quotient: 2"));
    }

    @Test
    public void testDivByZero() throws Exception {
        mockMvc.perform(get("/div").param("a", "7").param("b", "0"))
            .andExpect(status().isOk())
            .andExpect(content().string("Error: Division by zero not allowed."));
    }
}
