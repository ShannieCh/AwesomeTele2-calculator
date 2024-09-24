package Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
public class CalculatorService {

    private final CalculationRepository calculationRepository;

    @Autowired
    public CalculatorService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public Calculation addTwoNumbers(double num1, double num2) {
        double result = num1 + num2;
        Calculation calculation = new Calculation(num1, num2, Operation.ADD, result);
        recordCalculation(calculation);
        return calculation;
    }

    public Calculation subtractTwoNumbers(double num1, double num2) {
        double result = num1 - num2;
        Calculation calculation = new Calculation(num1, num2, Operation.SUBTRACT, result);
        recordCalculation(calculation);
        return calculation;
    }

    public Calculation multiplyTwoNumbers(double num1, double num2) {
        double result = num1 * num2;
        Calculation calculation = new Calculation(num1, num2, Operation.MULTIPLY, result);
        recordCalculation(calculation);
        return calculation;
    }

    public Calculation divideTwoNumbers(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        double result = num1 / num2;
        Calculation calculation = new Calculation(num1, num2, Operation.DIVIDE, result);
        recordCalculation(calculation);
        return calculation;
    }

    // Save the calculation to the repository
    private void recordCalculation(Calculation calculation) {
        calculationRepository.save(calculation);
        calculationRepository.flush();
    }

    // Retrieve the history of calculations
    public List<Calculation> fetchCalculationHistory() {
        return calculationRepository.findAll();
    }

}

