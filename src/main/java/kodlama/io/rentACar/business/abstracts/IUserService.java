package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.concretes.responses.GetAllUsersResponse;

public interface IUserService {
	List<GetAllUsersResponse> getAll();

}
