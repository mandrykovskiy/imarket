package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>, 
JpaSpecificationExecutor<ProductCategory>{
	
	ProductCategory findByName(String name);
	
	default void delete(String name){
		delete(findByName(name));
	}
	
	@Query("SELECT DISTINCT c FROM ProductCategory c LEFT JOIN FETCH c.products")
	List<ProductCategory> findWithProducts();
	
	@Modifying
	@Query("DELETE FROM ProductCategory c WHERE c.name=:name")
	void deleteByName(@Param("name") String name);
}
