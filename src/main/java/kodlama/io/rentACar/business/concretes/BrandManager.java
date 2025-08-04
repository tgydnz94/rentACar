package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.IBrandService;
import kodlama.io.rentACar.business.concretes.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.DeleteBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.IBrandRepository;
import kodlama.io.rentACar.entities.Brand;

@Service
public class BrandManager implements IBrandService {
	private IBrandRepository brandRepository;
	
	@Autowired
	public BrandManager(IBrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}


	@Override
	
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		for (Brand brand : brands)
		{
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			
			brandsResponse.add(responseItem);
			
		}
		return brandsResponse;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		
		this.brandRepository.save(brand);
		
	}





	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		Brand brand = new Brand();
		brand.setId(deleteBrandRequest.getId());
		
		this.brandRepository.deleteById(brand.getId());
		
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = brandRepository.getReferenceById(updateBrandRequest.getId());
		brand.setName(updateBrandRequest.getName());
		
		
		this.brandRepository.save(brand);
	}

}
