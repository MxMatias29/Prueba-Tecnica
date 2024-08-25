package prueba.tecnica.datos.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class CharacterDTO {
    private long id;
    private String name;
    private String status;
    private String species;
    private LocationDTO location;
    private String firstEpisode;
    private String image;
}
