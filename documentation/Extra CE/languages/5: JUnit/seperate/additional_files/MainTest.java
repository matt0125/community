import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MainTest {
    
    private static Calculator calculator = new Calculator();
    @Test
    void addition() {
        assertEquals(4, calculator.add(3, 1));
    }

    @Test
    void addition2() {
        assertEquals(5, calculator.add(3, 2));
    }

    @Test
    void addition3() {
        assertEquals(2, calculator.add(1, 1));
    }
}