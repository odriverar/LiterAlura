package drr.aluracursos.frontend.webclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos {
    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T convertirDatos(String json, TypeReference<T> tipo){
        try {
            return mapper.readValue(json, tipo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("No se puede convertir el JSON a datos, favor de coordinar con el Administrador de Aplicaciones. \nError: " + e);
        }
    }
}
