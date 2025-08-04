package kodlama.io.rentACar.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.rentACar.entities.Brand;
import java.util.List;
import kodlama.io.rentACar.business.abstracts.IBrandService;
import kodlama.io.rentACar.business.concretes.requests.CreateBrandRequest;
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

}
