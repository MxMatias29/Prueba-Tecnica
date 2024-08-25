package prueba.tecnica.datos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import prueba.tecnica.datos.model.Character;
import prueba.tecnica.datos.model.CharacterResponse;
import prueba.tecnica.datos.model.Episode;


@FeignClient(name = "rickAndMortyClient", url = "${rickandmorty.api.url}")
public interface RickAndMortyClient {

    @GetMapping("character/")
    CharacterResponse getAllCharacters(@RequestParam(value = "page", required = false) int page);

    @GetMapping(value = "character/{id}")
    Character getCharacterById(@PathVariable("id") int id);

    @GetMapping("/episode/{id}")
    Episode getEpisodeById(@PathVariable("id") int id);
}
