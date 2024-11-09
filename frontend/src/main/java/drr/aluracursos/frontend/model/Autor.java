package drr.aluracursos.frontend.model;

public class Autor {
    private final Integer id;
    private final String nombre;
    private final Integer anoNacimiento;
    private final Integer anoFallecimiento;
    private final String titulos;

    public Autor(Integer id, String nombre, Integer anoNacimiento, Integer anoFallecimiento, String titulos) {
        this.id = id;
        this.nombre = nombre;
        this.anoNacimiento = anoNacimiento;
        this.anoFallecimiento = anoFallecimiento;
        this.titulos = titulos;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAnoNacimiento() {
        return anoNacimiento;
    }

    public Integer getAnoFallecimiento() {
        return anoFallecimiento;
    }

    public String getTitulos() {
        return titulos;
    }

    @Override
    public String toString() {
        return "------------------------------------------ Autor " + getId() + " ------------------------------------------" +
               "\n Nombre: " + getNombre() +
               "\n Año Nacimiento: " + getAnoNacimiento() +
               "\n Año Fallecimiento: " + getAnoFallecimiento() +
               "\n Titulos: " + getTitulos() +
               "\n---------------------------------------------------------------------------------------------";
    }
}
