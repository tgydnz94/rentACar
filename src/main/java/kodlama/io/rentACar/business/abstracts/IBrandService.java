package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.concretes.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.DeleteBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllBrandsResponse;

public interface IBrandService {
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);

}
