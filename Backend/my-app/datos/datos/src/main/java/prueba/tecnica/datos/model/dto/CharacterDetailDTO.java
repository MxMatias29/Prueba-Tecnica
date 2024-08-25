package prueba.tecnica.datos.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import prueba.tecnica.datos.model.Location;

@Builder
@Getter
@Setter
public class CharacterDetailDTO {
    private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private LocationDTO origin;
    private LocationDTO location;
    private String image;
    private String firstEpisode;
}
