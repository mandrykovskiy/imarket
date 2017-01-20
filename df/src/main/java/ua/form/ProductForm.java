package ua.form;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.ProductCategory;
import ua.entity.ProductCountry;
import ua.entity.ProductCreator;

public class ProductForm {
	
	private int id;
	
	private String Name;
	private String path;
	
	private MultipartFile file;
	
	private int version;
	
	private String price;
	
	private ProductCountry productCountry;
	private ProductCategory productCategory;
	private ProductCreator productCreator;

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public ProductCreator getProductCreator() {
		return productCreator;
	}

	public void setProductCreator(ProductCreator productCreator) {
		this.productCreator = productCreator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public ProductCountry getProductCountry() {
		return productCountry;
	}

	public void setProductCountry(ProductCountry productCountry) {
		this.productCountry = productCountry;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
}
