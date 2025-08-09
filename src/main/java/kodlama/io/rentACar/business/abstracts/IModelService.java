package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.concretes.requests.CreateModelRequest;
import kodlama.io.rentACar.business.concretes.requests.DeleteModelRequest;
import kodlama.io.rentACar.business.concretes.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.concretes.responses.GetByIdModelResponse;

public interface IModelService {
	List<GetAllModelsResponse> getAll();
	GetByIdModelResponse getById(int id);
	void add(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest updateModelRequest);
	void delete(DeleteModelRequest deleteModelRequest);
	
}
