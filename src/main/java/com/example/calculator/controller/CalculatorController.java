package com.example.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.dto.CalculationRequest;
import com.example.calculator.dto.CalculationResponse;
import com.example.calculator.service.CalculatorService;

@RestController
public class CalculatorController {

	/*
	 * 사용법1:
	 * 
	 * @Autowired CalculatorService calculatorService;
	 */

	// 사용법2: 생성자 사용(객체obj)
	CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@PostMapping("/calculator")
	public CalculationResponse calculator(@RequestBody CalculationRequest request) {
		String result = calculatorService.calculator(request.getNum1(), request.getNum2(), request.getOperation());
		return new CalculationResponse(request.getNum1(), request.getNum2(), request.getOperation(), result);
	}

	@GetMapping("/add")
	public String add(@RequestParam double num1, @RequestParam double num2) {
		return calculatorService.add(num1, num2);
	}

	@GetMapping("/add2")
	public CalculationResponse add2(@RequestParam double num1, @RequestParam double num2) {
		String result = calculatorService.add(num1, num2);
		return new CalculationResponse(num1, num2, "ADD", result);
	}

	@GetMapping("/subtract")
	public String subtract(@RequestParam double num1, @RequestParam double num2) {
		return calculatorService.subtract(num1, num2);
	}

	@GetMapping("/subtract2")
	public CalculationResponse subtract2(@RequestParam double num1, @RequestParam double num2) {
		String result = calculatorService.subtract(num1, num2);
		return new CalculationResponse(num1, num2, "SUBTRACT", result);
	}

	@GetMapping("/multiply")
	public String multiply(@RequestParam double num1, @RequestParam double num2) {
		return CalculatorService.multiply(num1, num2);
	}

	@GetMapping("/multiply2")
	public CalculationResponse multiply2(@RequestParam double num1, @RequestParam double num2) {
		String result = CalculatorService.multiply(num1, num2);
		return new CalculationResponse(num1, num2, "MULTIPLY", result);
	}

	@GetMapping("/divide")
	public String divide(@RequestParam double num1, @RequestParam double num2) {
		return CalculatorService.divide(num1, num2);
	}

	@GetMapping("/divide2")
	public CalculationResponse divide2(@RequestParam double num1, @RequestParam double num2) {
	    if (num2 == 0)
	        throw new ArithmeticException("0으로 나눌 수 없음");
	    String result = CalculatorService.divide(num1, num2);
	    return new CalculationResponse(num1, num2, "DIVIDE", result);
	}

}
