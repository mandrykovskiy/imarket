package ua.implementation.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.ProductCountry;
import ua.servise.ProductCountrySevise;

public class CountryEditor extends PropertyEditorSupport{
	
	private final ProductCountrySevise productCountrySevise;

	public CountryEditor(ProductCountrySevise productCountrySevise) {
		this.productCountrySevise = productCountrySevise;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ProductCountry productCountry = productCountrySevise.findOne(Integer.valueOf(text));
		setValue(productCountry);
	}
}
