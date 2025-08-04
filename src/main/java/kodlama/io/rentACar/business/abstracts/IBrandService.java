package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.concretes.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllBrandsResponse;

public interface IBrandService {
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);

}
