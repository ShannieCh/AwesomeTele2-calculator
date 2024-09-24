package Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        return calculatorService.addTwoNumbers(num1, num2);
    }

    // Subtract two numbers
    @GetMapping("/subtract")
    public Calculation subtract(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.subtractTwoNumbers(num1, num2);
    }

    // Multiply two numbers
    @GetMapping("/multiply")
    public Calculation multiply(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.multiplyTwoNumbers(num1, num2);
    }

    // Divide two numbers
    @GetMapping("/divide")
    public Calculation divide(@RequestParam double num1, @RequestParam double num2) {
        return calculatorService.divideTwoNumbers(num1, num2);
    }

    // Get all previous calculations
    @GetMapping("/allPreviousCalculations")
    public List<Calculation> fetchAllCalculations() {
        return calculatorService.fetchCalculationHistory();
    }

    // Exception handler for division by zero or other invalid arguments
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
