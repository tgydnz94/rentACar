package kodlama.io.rentACar.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Delegate;

import java.util.List;
import kodlama.io.rentACar.business.abstracts.IBrandService;
import kodlama.io.rentACar.business.concretes.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.DeleteBrandRequest;
import kodlama.io.rentACar.business.concretes.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.concretes.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;

@RestController 
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private IBrandService brandService;
	
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
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
