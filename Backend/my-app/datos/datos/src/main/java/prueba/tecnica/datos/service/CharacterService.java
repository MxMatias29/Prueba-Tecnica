package prueba.tecnica.datos.service;

import prueba.tecnica.datos.model.dto.CharacterDTO;
import prueba.tecnica.datos.model.dto.CharacterDetailDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> getAllCharacters(int page);

    CharacterDetailDTO getCharacterById(int id);

    List<CharacterDTO> searchCharacterByName(String name);
}
