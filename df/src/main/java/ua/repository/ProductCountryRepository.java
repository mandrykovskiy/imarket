package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.ProductCountry;

public interface ProductCountryRepository extends JpaRepository<ProductCountry, Integer>, 
JpaSpecificationExecutor<ProductCountry>{
	
	ProductCountry findByName(String name);
	
	default void delete(String name){
		delete(findByName(name));
	}
	
	@Query("SELECT DISTINCT c FROM ProductCountry c LEFT JOIN FETCH c.products")
	List<ProductCountry> findWithProducts();
		
	@Modifying
	@Query("DELETE FROM ProductCountry c WHERE c.name=:name")
	void deleteByName(@Param("name") String name);
}
