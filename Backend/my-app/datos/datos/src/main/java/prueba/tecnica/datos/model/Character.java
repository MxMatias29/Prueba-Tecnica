package prueba.tecnica.datos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Characters {
    private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private String url;
}
