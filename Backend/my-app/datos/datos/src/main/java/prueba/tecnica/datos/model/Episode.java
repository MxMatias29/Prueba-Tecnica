package prueba.tecnica.datos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Episode {
    private long id;
    private String name;

    @JsonProperty("id")
    public long getID() {
        return id;
    }

    @JsonProperty("id")
    public void setID(long value) {
        this.id = value;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String value) {
        this.name = value;
    }
}
