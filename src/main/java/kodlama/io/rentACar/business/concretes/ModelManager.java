package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.IModelService;
import kodlama.io.rentACar.business.concretes.requests.CreateModelRequest;
import kodlama.io.rentACar.business.concretes.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.IModelRepository;
import kodlama.io.rentACar.entities.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {
	private IModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model-> this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest()
				.map(createModelRequest, Model.class);
		
		this.modelRepository.save(model);
		
	}

}
