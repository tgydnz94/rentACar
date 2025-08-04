package kodlama.io.rentACar.business.concretes.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBrandRequest {
	private int id;
	private String name;

}
