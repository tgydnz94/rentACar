package kodlama.io.rentACar.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.dataAccess.abstracts.IBrandRepository;
import kodlama.io.rentACar.entities.Brand;

@Repository 
public class InMemoryBrandRepository implements IBrandRepository {
	List<Brand> brands;
	


	public InMemoryBrandRepository() {
		brands = new ArrayList<Brand>();
		brands.add(new Brand("BMW", 1));
		brands.add(new Brand("Mercedes", 2));
		brands.add(new Brand("Audi", 3));
	}



	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brands;
	}

}
