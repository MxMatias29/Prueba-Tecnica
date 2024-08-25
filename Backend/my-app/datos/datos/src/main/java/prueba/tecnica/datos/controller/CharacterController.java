package prueba.tecnica.datos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import prueba.tecnica.datos.model.dto.CharacterDTO;
import prueba.tecnica.datos.model.dto.CharacterDetailDTO;
import prueba.tecnica.datos.service.CharacterService;
import prueba.tecnica.datos.service.implementation.ExcelService;

import java.io.ByteArrayInputStream;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private ExcelService excelService;

    @GetMapping("/")
    public ResponseEntity<List<CharacterDTO>> getAllCharacters(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

        List<CharacterDTO> characters = characterService.getAllCharacters(page);

        if (characters.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(characters);
    }

    @GetMapping("{id}")
    public ResponseEntity<CharacterDetailDTO> getCharacterById(@PathVariable("id") int id) {

        CharacterDetailDTO character = characterService.getCharacterById(id);

        if (character == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(character);
    }

    @GetMapping("/export/excel")
    public ResponseEntity<byte[]> exportToExcel(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        try {
            List<CharacterDTO> characters = characterService.getAllCharacters(page);

            ByteArrayInputStream bais = excelService.generateExcel(characters);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "characters.xlsx");

            return new ResponseEntity<>(bais.readAllBytes(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
