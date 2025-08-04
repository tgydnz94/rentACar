package kodlama.io.rentACar.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.rentACar.entities.Brand;
import lombok.Delegate;

import java.util.List;
import kodlama.io.rentACar.business.abstracts.IBrandService;
import kodlama.io.rentACar.business.concretes.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.DeleteBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllBrandsResponse;

@RestController 
@RequestMapping("/api/brands")
public class BrandsController {
	private IBrandService brandService;
	
	@Autowired
	public BrandsController(IBrandService brandService) {
		super();
		this.brandService = brandService;
	}
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateBrandRequest brandRequest) {
		this.brandService.add(brandRequest);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody() DeleteBrandRequest deleteBrandRequest)
	{
		this.brandService.delete(deleteBrandRequest);
	}

}
