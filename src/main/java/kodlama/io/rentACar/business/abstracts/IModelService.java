package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.concretes.requests.CreateModelRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllModelsResponse;

public interface IModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
	
}
