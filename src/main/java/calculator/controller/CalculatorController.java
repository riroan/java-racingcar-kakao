package calculator.controller;

import calculator.Calculator;
import calculator.Delimiter;
import calculator.Splitter;
import calculator.Validator;
import calculator.view.CalculatorView;

import java.util.*;

public class CalculatorController {
    private Calculator calculator;
    private CalculatorView calculatorView;

    public CalculatorController() {
        calculator = new Calculator();
        calculatorView = new CalculatorView();
    }

    public void start() {
        Delimiter delimiter = new Delimiter();
        Validator validator = new Validator(delimiter);
        Splitter splitter = new Splitter(delimiter);

        String expression = calculatorView.getExpression();

        expression = delimiter.customExpression(expression);
        validator.validate(expression);

        List<Integer> numberList = splitter.split(expression);
        int result = calculator.calculate(numberList);

        calculatorView.printResult(result);
    }
}
