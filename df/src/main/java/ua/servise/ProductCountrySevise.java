package ua.servise;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.ProductCountry;
import ua.form.filter.CountryFilterForm;

public interface ProductCountrySevise {

	void save(ProductCountry productCountry);

	ProductCountry findByName(String name);

	void delete(String name);

	List<ProductCountry> findAll();

	Page<ProductCountry> findAll(Pageable pageable);

	void delete(int id);

	List<ProductCountry> findWithProducts();

	ProductCountry findOne(int id);

	Page<ProductCountry> findAll(Pageable pageable, CountryFilterForm form);

}
