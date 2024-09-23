package Calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CalculatorServiceTest {

    @Mock
    private CalculationRepository calculationRepository;

    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Set up mock objects before each test
    }

    @Test
    public void testAdd() {
        // Test addition
        Calculation calculation = calculatorService.executeOperation(5, 3, Operation.ADD);
        assertEquals(8, calculation.getResult()); // Check if the result is correct
        verify(calculationRepository).save(any(Calculation.class)); // Make sure we saved the calculation
    }

    @Test
    public void testSubtract() {
        // Test subtraction
        Calculation calculation = calculatorService.executeOperation(5, 3, Operation.SUBTRACT);
        assertEquals(2, calculation.getResult());
        verify(calculationRepository).save(any(Calculation.class));
    }

    @Test
    public void testMultiply() {
        // Test multiplication
        Calculation calculation = calculatorService.executeOperation(5, 3, Operation.MULTIPLY);
        assertEquals(15, calculation.getResult());
        verify(calculationRepository).save(any(Calculation.class));
    }

    @Test
    public void testDivide() {
        // Test division
        Calculation calculation = calculatorService.executeOperation(6, 3, Operation.DIVIDE);
        assertEquals(2, calculation.getResult());
        verify(calculationRepository).save(any(Calculation.class));
    }

    @Test
    public void testDivideByZero() {
        // Test dividing by zero
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.executeOperation(5, 0, Operation.DIVIDE);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    public void testGetCalculations() {
        // Purpose: This test ensures that calculatorService.fetchCalculationHistory()
        // interacts with the repository by calling calculationRepository.findAll() at least once.

        // Call the method to fetch the calculation history
        calculatorService.fetchCalculationHistory();

        // Verify that the repository's findAll method was called at least once
        verify(calculationRepository, atLeastOnce()).findAll();
    }

}
