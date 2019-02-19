package com.springBootModel.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springBootModel.model.Product;

public class ProductValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "field.required");

		Product product = (Product) target;
		if (product.getPages() == null || product.getPages() <= 0) {
			errors.rejectValue("pages", "field.required");
		}
	}

}
