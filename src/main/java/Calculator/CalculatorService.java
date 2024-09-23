package Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    private final CalculationRepository calculationRepository;

    @Autowired
    public CalculatorService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    // Perform the specified arithmetic operation
    public Calculation executeOperation(double firstNumber, double secondNumber, Operation operation) {
        double result;

        switch (operation) {
            case ADD:
                result = firstNumber + secondNumber;
                break;
            case SUBTRACT:
                result = firstNumber - secondNumber;
                break;
            case MULTIPLY:
                result = firstNumber * secondNumber;
                break;
            case DIVIDE:
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed");
                }
                result = firstNumber / secondNumber;
                break;
            default:
                throw new UnsupportedOperationException("Unsupported operation: " + operation);
        }

        // Create a Calculation object to store the operation
        Calculation calculation = new Calculation(firstNumber, secondNumber, operation, result);
        recordCalculation(calculation);

        return calculation;
    }

    // Save the calculation to the repository
    private void recordCalculation(Calculation calculation) {
        calculationRepository.save(calculation);
        calculationRepository.flush(); // Ensure it's written to the database immediately
    }

    // Retrieve the history of calculations
    public List<Calculation> fetchCalculationHistory() {
        return calculationRepository.findAll();
    }
}
