package prueba.tecnica.datos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterResponse {
    @JsonProperty("results")

    private List<Character> characters;

    public List<Character> getAllCharacters() { return characters; }

}
