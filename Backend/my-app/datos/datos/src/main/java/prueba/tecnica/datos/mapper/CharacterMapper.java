package prueba.tecnica.datos.mapper;

import prueba.tecnica.datos.model.Character;
import prueba.tecnica.datos.model.dto.CharacterDTO;
import prueba.tecnica.datos.model.dto.CharacterDetailDTO;

public class CharacterMapper {

    public static CharacterDTO toCharacterDTO(Character character, String firstEpisodeName) {
        return CharacterDTO.builder()
                .id(character.getID())
                .name(character.getName())
                .status(character.getStatus())
                .species(character.getSpecies())
                .location(LocationMapper.toLocationDTO(character.getLocation()))
                .firstEpisode(firstEpisodeName)
                .image(character.getImage())
                .build();
    }

    public static CharacterDetailDTO toCharacterDetailDTO(Character character, String firstEpisodeName) {
        return CharacterDetailDTO.builder()
                .id(character.getID())
                .name(character.getName())
                .status(character.getStatus())
                .species(character.getSpecies())
                .type(character.getType())
                .origin(LocationMapper.toLocationDTO(character.getOrigin()))
                .location(LocationMapper.toLocationDTO(character.getLocation()))
                .gender(character.getGender())
                .firstEpisode(firstEpisodeName)
                .image(character.getImage())
                .build();
    }
}
