package kodlama.io.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.IBrandService;
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
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brandRepository.getAll();
	}

}
