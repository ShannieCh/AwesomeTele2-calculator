package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CalculatorServiceTest {

    @Mock
    private CalculationRepository calculationRepository;

    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test case for addition
    @Test
    public void testAdd() {
        Calculation calculation = calculatorService.addTwoNumbers(7, 2);
        assertEquals(9, calculation.getResult());
        verify(calculationRepository).save(any(Calculation.class));
    }

    // Test case for subtraction
    @Test
    public void testSubtract() {
        Calculation calculation = calculatorService.subtractTwoNumbers(7, 2);
        assertEquals(5, calculation.getResult());
        verify(calculationRepository).save(any(Calculation.class));
    }

    // Test case for multiplication
    @Test
    public void testMultiply() {
        Calculation calculation = calculatorService.multiplyTwoNumbers(7, 2);
        assertEquals(14, calculation.getResult());
        verify(calculationRepository).save(any(Calculation.class));
    }

    // Test case for division
    @Test
    public void testDivide() {
        Calculation calculation = calculatorService.divideTwoNumbers(8, 4);
        assertEquals(2, calculation.getResult());
        verify(calculationRepository).save(any(Calculation.class));
    }

    // Test case for division by zero
    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divideTwoNumbers(7, 0);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
