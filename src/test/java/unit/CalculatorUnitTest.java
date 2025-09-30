package unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import com.app.calculator.Application;



public class CalculatorUnitTest {
    @Test
    void additionTest() {
        // System.out.println("Addition Testing Started");
        assertEquals(4, Application.add(2,2));
    }
    @Test
    void subtractionTest() {
        // System.out.println("Subtraction Testing Started");
        assertEquals(5, Application.sub(7,2));
    }
    @Test
    void multiplyTest() {
        // System.out.println("Multiplication Testing Started");
        assertEquals(14, Application.mul(7,2));
    }
     @Test
    void testDivValidDivision() {
        // System.out.println("Valid Division Testing Started");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Application.div(10, 2);

        assertTrue(outContent.toString().contains("5"));
    }

    @Test
    void testDivByZero() {
        // System.out.println("Inalid Division Testing Started");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Application.div(10, 0);

        assertTrue(outContent.toString().toLowerCase().contains("arithmeticexception"));
    }
}
