package kodlama.io.rentACar.business.concretes.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
	@NotBlank
	@NotBlank
	@Size(min=2, max=30)
	private String name;
	@NotBlank
	@NotBlank
	private int brandId;

}
