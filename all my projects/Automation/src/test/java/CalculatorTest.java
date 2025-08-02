import org.junit.jupiter.api.Test;
import org.example.Calculator;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 5);
        assertEquals(10, result);
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.subtract(20, 10));
    }

    @Test
    void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(20, calculator.multiply(4, 5));
        assertEquals(0, calculator.multiply(0, 10));
        assertEquals(-15, calculator.multiply(-3, 5));
    }

    @Test
    void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.divide(20, 4));
        assertEquals(-3, calculator.divide(-15, 5));
    }

    @Test
    void testDivideByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}