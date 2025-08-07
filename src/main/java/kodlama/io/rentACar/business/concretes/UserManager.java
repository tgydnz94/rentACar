package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.IUserService;
import kodlama.io.rentACar.business.concretes.responses.GetAllUsersResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.IUserRepository;
import kodlama.io.rentACar.entities.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements IUserService {
	private IUserRepository userRepository;
	private ModelMapperService modelMapperService;
	
@Override
	
	public List<GetAllUsersResponse> getAll() {

		List<User> users = userRepository.findAll();
		List<GetAllUsersResponse> usersResponse = users.stream()
				.map(user-> this.modelMapperService.forResponse()
						.map(user, GetAllUsersResponse.class))
				.collect(Collectors.toList());
		return usersResponse;
	}


}
