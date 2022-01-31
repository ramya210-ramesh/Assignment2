package com.te.SpringAssement.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.SpringAssement.exception.ProductException;

@ControllerAdvice
public class ProductExceptionController {
	@ExceptionHandler(ProductException.class)
	public String handleExcep(HttpServletRequest request, ProductException exception) {
		request.setAttribute("errMsg", exception.getMessage());
		return "loginform";

	}

}
