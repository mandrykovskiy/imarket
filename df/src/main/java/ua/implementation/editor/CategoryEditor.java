package ua.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.ProductCategory;
import ua.servise.ProductCategoryService;

public class CategoryEditor extends PropertyEditorSupport{
	
	private final ProductCategoryService productCategoryService;

	public CategoryEditor(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ProductCategory productCategory = productCategoryService.findOne(Integer.valueOf(text));
		setValue(productCategory);
	}

}
