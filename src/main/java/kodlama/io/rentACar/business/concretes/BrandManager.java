package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.IBrandService;
import kodlama.io.rentACar.business.concretes.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.DeleteBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.concretes.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.IBrandRepository;
import kodlama.io.rentACar.entities.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements IBrandService {
	private IBrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	
	public List<GetAllBrandsResponse> getAll() {
//		List<Brand> brands = brandRepository.findAll();
//		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//		for (Brand brand : brands)
//		{
//			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			
//			brandsResponse.add(responseItem);
//			
//		}
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand-> this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return brandsResponse;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
//		Brand brand = new Brand();
//		brand.setName(createBrandRequest.getName());
		
		this.brandBusinessRules
		.checkIfBrandNameExists(createBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest()
				.map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
		
	}





	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
//		Brand brand = new Brand();
//		brand.setId(deleteBrandRequest.getId());
		
		Brand brand = this.modelMapperService.forRequest()
				.map(deleteBrandRequest, Brand.class);
		
		this.brandRepository.deleteById(brand.getId());
		
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
//		Brand brand = brandRepository.getReferenceById(updateBrandRequest.getId());
//		brand.setName(updateBrandRequest.getName());
		
		Brand brand = this.modelMapperService.forRequest()
				.map(updateBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	}


	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse response = this.modelMapperService.forResponse()
				.map(brand, GetByIdBrandResponse.class);
		return response;
	}

}
