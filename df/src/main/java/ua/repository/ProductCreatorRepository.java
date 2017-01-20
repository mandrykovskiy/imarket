package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.ProductCreator;

public interface ProductCreatorRepository extends JpaRepository<ProductCreator, Integer>, 
JpaSpecificationExecutor<ProductCreator>{
	ProductCreator findByName(String name);
	
	default void delete(String name){
		delete(findByName(name));
	}
	
	@Query("SELECT DISTINCT c FROM ProductCreator c LEFT JOIN FETCH c.products")
	List<ProductCreator> findWithProducts();
	
	@Modifying
	@Query("DELETE FROM ProductCreator c WHERE c.name=:name")
	void deleteByName(@Param("name") String name);
}
