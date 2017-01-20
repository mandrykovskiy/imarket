package ua.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.ProductCountry;
import ua.form.filter.CountryFilterForm;
import ua.implementation.specification.CountryFilterAdapter;
import ua.repository.ProductCountryRepository;
import ua.servise.ProductCountrySevise;

@Service
@Transactional
public class ProductCountryImpl implements ProductCountrySevise {
	@Autowired
	private ProductCountryRepository productCountryRepository;

	@Override
	public void save(ProductCountry productCountry) {
		productCountryRepository.save(productCountry);
	}

	@Override
	public ProductCountry findByName(String name) {
		return productCountryRepository.findByName(name);
	}

	@Override
	public void delete(String name) {
		productCountryRepository.delete(name);
	}

	@Override
	public List<ProductCountry> findAll() {
		return productCountryRepository.findAll();
	}

	@Override
	public void delete(int id) {
		productCountryRepository.delete(id);
	}
	
	@Override
	public List<ProductCountry> findWithProducts() {
		return productCountryRepository.findWithProducts();
	}

	@Override
	public ProductCountry findOne(int id) {
		return productCountryRepository.findOne(id);
	}
	
	@Override
	public Page<ProductCountry> findAll(Pageable pageable) {
		return productCountryRepository.findAll(pageable);
	}

	@Override
	public Page<ProductCountry> findAll(Pageable pageable, CountryFilterForm form) {
		return productCountryRepository.findAll(new CountryFilterAdapter(form), pageable);
	}

}
