package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.Brand;

public interface IBrandRepository extends JpaRepository<Brand,Integer> {
	boolean existsByName(String name); //spring jpa keywords

}
