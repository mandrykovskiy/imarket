package ua.servise;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.ProductCreator;
import ua.form.filter.CreatorFilterForm;

public interface ProductCreatorService {
	
	void save(ProductCreator productCreator);

	ProductCreator findByName(String name);

	void delete(String name);
	
	List<ProductCreator> findAll();

	Page<ProductCreator> findAll(Pageable pageable);

	void delete(int id);

	List<ProductCreator> findWithProducts();

	ProductCreator findOne(int id);

	Page<ProductCreator> findAll(Pageable pageable, CreatorFilterForm form);
}
