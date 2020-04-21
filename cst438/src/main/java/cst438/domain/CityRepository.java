package cst438.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findAllByOrderByNameAsc();
	
	@Query("SELECT a FROM city a WHERE a.countryCode=?1 ORDER BY a.name ASC")
	List<City> findAllByOrderByNameAsc(String countryCode);
}