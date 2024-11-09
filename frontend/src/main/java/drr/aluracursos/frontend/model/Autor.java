package drr.aluracursos.frontend.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Autor {
    private Integer id;
    private String nombre;
    private Integer anoNacimiento;
    private Integer anoFallecimiento;
    private String titulos;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(Integer anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public Integer getAnoFallecimiento() {
        return anoFallecimiento;
    }

    public void setAnoFallecimiento(Integer anoFallecimiento) {
        this.anoFallecimiento = anoFallecimiento;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
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
