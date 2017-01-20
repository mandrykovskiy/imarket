package ua.servise.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.ProductCountry;
import ua.servise.ProductCountrySevise;

public class ProductCountryValidator implements Validator {
	
	private final ProductCountrySevise productCountrySevise;

	public ProductCountryValidator(ProductCountrySevise productCountrySevise) {
		this.productCountrySevise = productCountrySevise;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductCountry.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductCountry form = (ProductCountry) target;
		if (form.getId() == 0)
			if (productCountrySevise.findByName(form.getName()) != null) {
				errors.rejectValue("name", "", "ProductCountry already exists");
			}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can`t be empty");
	}
}
