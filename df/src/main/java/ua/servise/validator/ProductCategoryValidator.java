package ua.servise.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.ProductCategory;
import ua.servise.ProductCategoryService;

public class ProductCategoryValidator implements Validator  {
	
	private final ProductCategoryService productCategoryService;

	public ProductCategoryValidator(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductCategory.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductCategory form = (ProductCategory) target;
		if (form.getId() == 0)
			if (productCategoryService.findByName(form.getName()) != null) {
				errors.rejectValue("name", "", "ProductCategory already exists");
			}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "",
				"Can`t be empty");
	}
}
