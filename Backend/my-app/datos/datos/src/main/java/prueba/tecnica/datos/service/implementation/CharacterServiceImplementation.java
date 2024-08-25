package prueba.tecnica.datos.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.tecnica.datos.client.RickAndMortyClient;
import prueba.tecnica.datos.mapper.CharacterMapperService;
import prueba.tecnica.datos.model.CharacterResponse;
import prueba.tecnica.datos.model.dto.CharacterDTO;
import prueba.tecnica.datos.model.dto.CharacterDetailDTO;
import prueba.tecnica.datos.service.CharacterService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImplementation implements CharacterService {

    @Autowired
    private RickAndMortyClient rickAndMortyClient;

    @Autowired
    private CharacterMapperService characterMapperService;

    @Override
    public List<CharacterDTO> getAllCharacters(int page) {
        CharacterResponse response = rickAndMortyClient.getAllCharacters(page);
        return response.getAllCharacters().parallelStream()
                .map(characterMapperService::mapCharacterToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CharacterDetailDTO getCharacterById(int id) {
        return characterMapperService.mapCharacterToDetailDTO(rickAndMortyClient.getCharacterById(id));
    }

}
