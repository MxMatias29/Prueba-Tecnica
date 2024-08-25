package prueba.tecnica.datos.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.tecnica.datos.client.RickAndMortyClient;
import prueba.tecnica.datos.model.Character;
import prueba.tecnica.datos.model.Episode;
import prueba.tecnica.datos.model.dto.CharacterDTO;
import prueba.tecnica.datos.model.dto.CharacterDetailDTO;

@Service
public class CharacterMapperService {

    @Autowired
    private RickAndMortyClient rickAndMortyClient;

    public CharacterDTO mapCharacterToDTO(Character character) {
        String firstEpisodeUrl = character.getEpisode()[0];
        int episodeId = Integer.parseInt(firstEpisodeUrl.split("/")[5]);
        Episode firstEpisode = rickAndMortyClient.getEpisodeById(episodeId);
        return CharacterMapper.toCharacterDTO(character, firstEpisode.getName());
    }

    public CharacterDetailDTO mapCharacterToDetailDTO(Character character) {
        String firstEpisodeUrl = character.getEpisode()[0];
        int episodeId = Integer.parseInt(firstEpisodeUrl.split("/")[5]);
        Episode firstEpisode = rickAndMortyClient.getEpisodeById(episodeId);
        return CharacterMapper.toCharacterDetailDTO(character, firstEpisode.getName());
    }
}
