package Calculator;

import javax.persistence.*;

@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double firstNumber;
    private double secondNumber;

    @Enumerated(EnumType.STRING)
    private Operation operation;
    private double result;

    // Default constructor
    public Calculation() {
    }

    // Constructor for creating a Calculation
    public Calculation(double firstNumber, double secondNumber, Operation operation, double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operation = operation;
        this.result = result;
    }

    // Getters
    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public Operation getOperation() {
        return operation;
    }

    public double getResult() {
        return result;
    }

    // Setters
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
