package ua.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.ProductCreator;
import ua.form.filter.CreatorFilterForm;
import ua.implementation.specification.CreatorFilterAdapter;
import ua.repository.ProductCreatorRepository;
import ua.servise.ProductCreatorService;

@Service
@Transactional
public class ProductCreatorImpl implements ProductCreatorService {
	@Autowired
	private ProductCreatorRepository productCreatorRepository;

	@Override
	public void save(ProductCreator productCreator) {
		productCreatorRepository.save(productCreator);
	}

	@Override
	public ProductCreator findByName(String name) {
		return productCreatorRepository.findByName(name);
	}

	@Override
	public void delete(String name) {
		productCreatorRepository.delete(name);
	}

	@Override
	public List<ProductCreator> findAll() {
		return productCreatorRepository.findAll();
	}

	@Override
	public void delete(int id) {
		productCreatorRepository.delete(id);
	}

	@Override
	public List<ProductCreator> findWithProducts() {
		return productCreatorRepository.findWithProducts();
	}

	@Override
	public ProductCreator findOne(int id) {
		return productCreatorRepository.findOne(id);
	}

	@Override
	public Page<ProductCreator> findAll(Pageable pageable) {
		return productCreatorRepository.findAll(pageable);
	}

	@Override
	public Page<ProductCreator> findAll(Pageable pageable, CreatorFilterForm form) {
		return productCreatorRepository.findAll(new CreatorFilterAdapter(form), pageable);
	}

}
