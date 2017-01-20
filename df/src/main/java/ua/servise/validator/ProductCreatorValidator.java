package ua.servise.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.ProductCreator;
import ua.servise.ProductCreatorService;

public class ProductCreatorValidator implements Validator{

	private final ProductCreatorService productCreatorService;

	public ProductCreatorValidator(ProductCreatorService productCreatorService) {
		this.productCreatorService = productCreatorService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductCreator.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductCreator form = (ProductCreator) target;
		if (form.getId() == 0)
			if (productCreatorService.findByName(form.getName()) != null) {
				errors.rejectValue("name", "", "ProductCreator already exists");
			}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can`t be empty");
	}
}
