package ua.servise;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Product;
import ua.form.ProductForm;
import ua.form.filter.ProductFilterForm;

public interface ProductService {

	List<Product> findAll();

	void delete(int id);
	
	void save(ProductForm form);

	ProductForm findForForm(int id);
	
	Product findByName(String name);
	
	Page<Product> findAll(ProductFilterForm form, Pageable pageable);
}
