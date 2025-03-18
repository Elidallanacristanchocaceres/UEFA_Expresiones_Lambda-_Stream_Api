package com.manejoequipos.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Liga {
    @JsonProperty("equipos")
    private List<equipos> equipos; 

    public List<equipos> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<equipos> equipos) {
        this.equipos = equipos;
    }
}