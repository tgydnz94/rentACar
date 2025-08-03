package kodlama.io.rentACar.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.rentACar.entities.Brand;
import java.util.List;
import kodlama.io.rentACar.business.abstracts.IBrandService;

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
	public List<Brand> getAll(){
		return brandService.getAll();
	}

}
