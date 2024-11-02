package drr.aluracursos.backend.webclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConvierteDatos implements IConvierteDatos{
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, TypeReference<T> tipo){
        try{
            return mapper.readValue(json, tipo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    /*@Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try{
            return mapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }*/
}
