package prueba.tecnica.datos.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LocationDTO {
    private String name;
    private String url;
}
