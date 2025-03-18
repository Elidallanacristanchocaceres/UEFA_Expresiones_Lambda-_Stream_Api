package com.manejoequipos.repository;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manejoequipos.domain.Liga;

public class leerJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Liga leerJson(String ruta) throws IOException {
        return objectMapper.readValue(new File(ruta), Liga.class);
    }
}