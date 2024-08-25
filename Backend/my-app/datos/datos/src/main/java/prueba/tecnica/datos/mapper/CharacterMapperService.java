package prueba.tecnica.datos.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.tecnica.datos.client.RickAndMortyClient;
import prueba.tecnica.datos.model.Character;
import prueba.tecnica.datos.model.Episode;
import prueba.tecnica.datos.model.dto.CharacterDTO;
import prueba.tecnica.datos.model.dto.CharacterDetailDTO;

@Service
public class CharacterMapper {

    @Autowired
    private RickAndMortyClient rickAndMortyClient;

    private CharacterDTO mapCharacterToDTO(Character character) {
        String firstEpisodeUrl = character.getEpisode()[0];
        int episodeId = Integer.parseInt(firstEpisodeUrl.split("/")[5]);
        Episode firstEpisode = rickAndMortyClient.getEpisodeById(episodeId);

        return CharacterDTO.builder()
                .id(character.getID())
                .name(character.getName())
                .status(character.getStatus())
                .species(character.getSpecies())
                .location(mapLocationToDTO(character.getLocation()))
                .firstEpisode(firstEpisode.getName())
                .image(character.getImage())
                .build();
    }

    private CharacterDetailDTO mapCharacterToDetailDTO(Character character) {

        String firstEpisodeUrl = character.getEpisode()[0];
        int episodeId = Integer.parseInt(firstEpisodeUrl.split("/")[5]);
        Episode firstEpisode = rickAndMortyClient.getEpisodeById(episodeId);

        return CharacterDetailDTO.builder()
                .id(character.getID())
                .name(character.getName())
                .status(character.getStatus())
                .species(character.getSpecies())
                .type(character.getType())
                .origin(mapLocationToDTO(character.getOrigin()))
                .location(mapLocationToDTO(character.getLocation()))
                .gender(character.getGender())
                .firstEpisode(firstEpisode.getName())
                .image(character.getImage())
                .build();
    }
}
