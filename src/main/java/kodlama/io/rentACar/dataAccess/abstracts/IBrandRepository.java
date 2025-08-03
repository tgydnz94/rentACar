package kodlama.io.rentACar.dataAccess.abstracts;

import java.util.List;

import kodlama.io.rentACar.entities.Brand;

public interface IBrandRepository {
	List<Brand> getAll();

}
