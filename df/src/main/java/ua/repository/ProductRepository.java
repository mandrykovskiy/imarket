package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Product;
import ua.entity.ProductCategory;
import ua.entity.ProductCountry;
import ua.entity.ProductCreator;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT r FROM Product "
			+ "r LEFT JOIN FETCH r.productCountry "
			+ " LEFT JOIN FETCH r.productCategory "
			+ " LEFT JOIN FETCH r.productCreator "
			+ "WHERE r.id=:id")
	
	Product findOneProductCountryInited(@Param("id")int id);
	
	Product findByName(String name);
	
//	@Query("SELECT r FROM Product "
//			+ "r LEFT JOIN FETCH r.productCountry "
//			+ " LEFT JOIN FETCH r.productCategory "
//			+ " LEFT JOIN FETCH r.productCreator "
//			)
//	List<Product> findAll();
	
	@Modifying
	@Query("UPDATE Product r SET r.productCountry = :productCountry WHERE r.name = :name")
	void changeProductCountry(@Param("name")String name, @Param("productCountry")ProductCountry  productCountry);
	
	@Modifying
	@Query("UPDATE Product r SET r.productCategory = :productCategory WHERE r.name = :name")
	void changeProductCategory(@Param("name")String name, @Param("productCategory")ProductCategory  productCategory);
	
	@Modifying
	@Query("UPDATE Product r SET r.productCreator = :productCreator WHERE r.name = :name")
	void changeProductCreator(@Param("name")String name, @Param("productCreator")ProductCreator  productCreator);

	
	
}
