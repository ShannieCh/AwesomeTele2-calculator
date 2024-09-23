package Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    // Add two numbers
    @GetMapping("/add")
    public Calculation add(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.executeOperation(num1, num2, Operation.ADD);
    }

    // Subtract two numbers
    @GetMapping("/subtract")
    public Calculation subtract(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.executeOperation(num1, num2, Operation.SUBTRACT);
    }

    // Multiply two numbers
    @GetMapping("/multiply")
    public Calculation multiply(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.executeOperation(num1, num2, Operation.MULTIPLY);
    }

    // Divide two numbers
    @GetMapping("/divide")
    public Calculation divide(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.executeOperation(num1, num2, Operation.DIVIDE);
    }

    // Get all previous calculations
    @GetMapping("/allPreviousCalculations")
    public List<Calculation> fetchAllCalculations() {
        return calculatorService.fetchCalculationHistory();
    }
}
