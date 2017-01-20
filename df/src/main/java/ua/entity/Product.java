package ua.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(indexes={@Index(columnList="name"),@Index(columnList="price")})
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String name;
	double price;
	private int version;
	private String path;
	
	@ManyToMany
	@JoinTable(name="MyOrder_Product",joinColumns=
	@JoinColumn(name="product_id"), inverseJoinColumns=
	@JoinColumn(name="myOrder_id"))
	
	private List<MyOrder> myOrders; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductCategory productCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductCreator productCreator;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ProductCountry productCountry;
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<MyOrder> getMyOrders() {
		return myOrders;
	}
	public void setMyOrders(List<MyOrder> myOrders) {
		this.myOrders = myOrders;
	}
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
	public ProductCountry getProductCountry() {
		return productCountry;
	}
	public void setProductCountry(ProductCountry productCountry) {
		this.productCountry = productCountry;
	}
	
	
	
	
	
}
