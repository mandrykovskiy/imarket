package ua.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.ProductCategory;
import ua.form.filter.CategoryFilterForm;
import ua.implementation.specification.CategoryFilterAdapter;
import ua.repository.ProductCategoryRepository;
import ua.servise.ProductCategoryService;
@Service
@Transactional
public class ProductCategoryImpl implements ProductCategoryService{
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public void save(ProductCategory productCategory) {
		productCategoryRepository.save(productCategory);
	}

	@Override
	public ProductCategory findByName(String name) {
		return productCategoryRepository.findByName(name);
	}

	@Override
	public void delete(String name) {
		productCategoryRepository.delete(name);
	}

	@Override
	public List<ProductCategory> findAll() {
		return productCategoryRepository.findAll();
	}

	@Override
	public void delete(int id) {
		productCategoryRepository.delete(id);
	}
	
	@Override
	public List<ProductCategory> findWithProducts() {
		return productCategoryRepository.findWithProducts();
	}

	@Override
	public ProductCategory findOne(int id) {
		return productCategoryRepository.findOne(id);
	}
	
	@Override
	public Page<ProductCategory> findAll(Pageable pageable) {
		return productCategoryRepository.findAll(pageable);
	}

	@Override
	public Page<ProductCategory> findAll(Pageable pageable, CategoryFilterForm form) {
		return productCategoryRepository.findAll(new CategoryFilterAdapter(form), pageable);
	}

}
