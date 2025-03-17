package com.manejoequipos;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class leerJson {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Liga leerJson(String ruta) throws IOException {
        return objectMapper.readValue(new File(ruta), Liga.class);
    }
}