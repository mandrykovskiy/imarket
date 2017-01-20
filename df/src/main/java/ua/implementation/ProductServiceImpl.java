package ua.implementation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Product;
import ua.form.ProductForm;
import ua.form.filter.ProductFilterForm;
import ua.repository.ProductCategoryRepository;
import ua.repository.ProductCountryRepository;
import ua.repository.ProductCreatorRepository;
import ua.repository.ProductRepository;
import ua.servise.FileWriter;
import ua.servise.FileWriter.Folder;
import ua.servise.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCountryRepository productCountryRepository;
	
	@Autowired
	private ProductCreatorRepository productCreatorRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	

	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void delete(int id) {
		productRepository.delete(id);
	}

	@Override
	public void save(ProductForm form) {
		Product product = new Product();
		product.setProductCountry(form.getProductCountry());
		product.setProductCategory(form.getProductCategory());
		product.setProductCreator(form.getProductCreator());
		product.setName(form.getName());
		product.setId(form.getId());
		product.setPath(form.getPath());
		product.setVersion(form.getVersion());
		productRepository.saveAndFlush(product);
		String extension = fileWriter.write(Folder.PRODUCT, form.getFile(), product.getId());
		if(extension!=null){
			product.setVersion(form.getVersion()+1);
			product.setPath(extension);
			productRepository.save(product);
		}
	}

	@Override
	public ProductForm findForForm(int id) {
		Product product = productRepository.findOneProductCountryInited(id);
		ProductForm form = new ProductForm();
		form.setId(product.getId());
		form.setName(product.getName());
		form.setPath(product.getPath());
		form.setVersion(product.getVersion());
		form.setProductCountry(product.getProductCountry());
		form.setName(product.getName());
		return form;
	}

	@Override
	public Product findByName(String name) {
		return productRepository.findByName(name);
		
	}

	@Override
	public Page<Product> findAll(ProductFilterForm form, Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
}
