package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.IUserService;
import kodlama.io.rentACar.business.concretes.responses.GetAllUsersResponse;
import lombok.AllArgsConstructor;

@RestController 
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
	private IUserService userService;
	
	@GetMapping("/getall")
	public List<GetAllUsersResponse> getAll(){
		return userService.getAll();
	}

}
