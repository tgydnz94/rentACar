package kodlama.io.rentACar.business.concretes.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class GetByIdModelResponse {
	private int id;
	private String name;

}
