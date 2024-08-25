package prueba.tecnica.datos.mapper;

import prueba.tecnica.datos.model.Location;
import prueba.tecnica.datos.model.dto.LocationDTO;

public class LocationMapper {

    public static LocationDTO toLocationDTO(Location location) {
        return LocationDTO.builder()
                .name(location.getName())
                .url(location.getURL())
                .build();
    }
}
