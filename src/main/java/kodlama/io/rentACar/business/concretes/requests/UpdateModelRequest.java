package kodlama.io.rentACar.business.concretes.requests;

import kodlama.io.rentACar.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
	private int id;
	private String name;
	private int brandId;

}
