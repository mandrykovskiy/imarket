package ua.servise;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.ProductCategory;
import ua.form.filter.CategoryFilterForm;

public interface ProductCategoryService {
	
	void save(ProductCategory productCategory);

	ProductCategory findByName(String name);

	void delete(String name);
	
	List<ProductCategory> findAll();
	
	Page<ProductCategory> findAll(Pageable pageable);

	void delete(int id);
	
	List<ProductCategory> findWithProducts();
	
	ProductCategory findOne(int id);
	
	Page<ProductCategory> findAll(Pageable pageable, CategoryFilterForm form);
}
