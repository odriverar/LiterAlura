package drr.aluracursos.backend.webclient;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
