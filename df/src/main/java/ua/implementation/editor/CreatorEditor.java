package ua.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.ProductCreator;
import ua.servise.ProductCreatorService;

public class CreatorEditor extends PropertyEditorSupport{
	private final ProductCreatorService productCreatorService;

	public CreatorEditor(ProductCreatorService productCreatorService) {
		this.productCreatorService = productCreatorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ProductCreator productCreator = productCreatorService.findOne(Integer.valueOf(text));
		setValue(productCreator);
	}
}
