package drr.aluracursos.backend.webclient;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, TypeReference<T> tipo);
}
