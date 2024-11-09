package drr.aluracursos.frontend.principal;

import drr.aluracursos.frontend.model.Autor;
import drr.aluracursos.frontend.model.Idioma;
import drr.aluracursos.frontend.model.Libro;
import drr.aluracursos.frontend.service.PrincipalService;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);

    private final PrincipalService principalService = new PrincipalService();

    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    --------------------*   LiterAlura   *--------------------
                    ********************- MENU PRINCIPAL -********************
                    1.- Buscar libro por título
                    2.- Listar libros registrados
                    3.- Listar autores registrados
                    4.- Listar autores vivos en un determinado año
                    5.- Listar libros por idioma
                   \s
                   \s
                    0.- Salir
                    **********************************************************\s
                   \s""";
            System.out.println(menu);
            System.out.print("Seleccione una opcion: ");
            String input = teclado.nextLine();
            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        buscarLibrosPorTitulo();
                        break;
                    case 2:
                        listarLibrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivosAUnAnio();
                        break;
                    case 5:
                        listarIdiomasSubMenu();
                        break;
                    case 0:
                        System.out.println("Gracias, vuelva pronto...!");
                        break;
                    default:
                        System.out.println("Opcion invalida!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.print("La opción elejida no es correcta, favor de verificar.");
            }
        }
    }

    private void mensajeFinal(){
        try{
            System.out.println("Presiona ENTER para continuar...");
            System.in.read();
        } catch (IOException | InputMismatchException e) {
            throw new RuntimeException("Error,favor de comunicarse con el administrador de sistema.");
        }
    }

    private void buscarLibrosPorTitulo() {
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++ LIBROS REGISTRADOS +++++++++++++++++++++++++++++++++++");
        System.out.print("Escribe el titulo del libro: ");
        try{
            var titulo = teclado.nextLine();
            List<Libro> libros = principalService.buscarLibrosPorTitulo(titulo);
            if (!libros.isEmpty()) {
                System.out.println("Cantidad de libros encontrados: " + libros.size());
                libros.forEach(libro -> System.out.println(libro.toString()));
                System.out.println("Cantidad de libros encontrados: " + libros.size());
            } else {
                System.out.println("El titulo no existe");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        mensajeFinal();
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = principalService.buscarLibrosRegistrados();
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++ LIBROS REGISTRADOS +++++++++++++++++++++++++++++++++++");
        if(!libros.isEmpty()){
            System.out.println("Cantidad de libros registrados: " + libros.size());
            libros.forEach(libro -> System.out.println(libro.toString()));
            System.out.println("Cantidad de libros registrados: " + libros.size());
        } else {
            System.out.println("No hay libros registrados");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        mensajeFinal();
    }

    private void listarAutoresRegistrados() {
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++ AUTORES REGISTRADOS +++++++++++++++++++++++++++++++++++");
        List<Autor> autores = principalService.listarAutoresRegistrados();
        if (!autores.isEmpty()) {
            System.out.println("Cantidad de autores registrados: " + autores.size());
            autores.forEach(autor -> System.out.println(autor.toString()));
            System.out.println("Cantidad de autores registrados: " + autores.size());
        } else {
            System.out.println("No hay autores registrados");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        mensajeFinal();
    }

    private void listarAutoresVivosAUnAnio() {
        System.out.println();
        System.out.println("+++++++++++++++++++++++++++++++++++ AUTORES VIVOS A UN AÑO +++++++++++++++++++++++++++++++++++");
        System.out.print("Ingrese el año vivo de autor(es) que desea buscar: ");
        String input = teclado.nextLine();
        try {
            Integer anioVivo = Integer.parseInt(input);
            List<Autor> autoresVivos = principalService.buscarAutoresVivos(anioVivo);
            if (!autoresVivos.isEmpty()) {
                System.out.println("Cantidad de autores registrados: " + autoresVivos.size());
                autoresVivos.forEach(autor -> System.out.println(autor.toString()));
                System.out.println("Cantidad de autores registrados: " + autoresVivos.size());
            } else {
                System.out.println("No hay autores vivos para el año buscado");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error, se esperaba un valor nuemrico, favor de verificar.");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        mensajeFinal();
    }

    private void listarIdiomasSubMenu() {
        List<Idioma> idiomas = principalService.listarIdiomas();
        var opcionIdioma = -1;
        System.out.println("++++++++++++++++++++++++++++++ LIBROS POR IDIOMAS ++++++++++++++++++++++++++++++");
        if(idiomas.isEmpty()){
            System.out.println("No hay libros registrados");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            mensajeFinal();
            return;
        }
        while (opcionIdioma != 0) {
            System.out.println("****************************** IDIOMAS ******************************");
            idiomas.forEach(idioma -> System.out.println(idioma.toString()));
            System.out.println("[0] Volver al menu principal");
            System.out.println("**********************************************************************");

            System.out.print("Seleccione una opcion: ");
            String input = teclado.nextLine();
            try {
                opcionIdioma = Integer.parseInt(input);

                Integer opcElegida = opcionIdioma;

                if (opcElegida == 0) {
                    return;
                } else {
                    Idioma idioma = idiomas.stream().filter(i -> i.getId() == opcElegida).findFirst().orElse(null);

                    if (idioma == null) {
                        System.out.println("Valor ingresado es incorrecto, favor de verificar.");
                        continue;
                    }

                    List<Libro> libros = principalService.buscarLibrosPorIdioma(idioma);
                    System.out.println("Cantidad de libros encontrados: " + libros.size());
                    libros.forEach(libro -> System.out.println(libro.toString()));
                    System.out.println("Cantidad de libros encontrados: " + libros.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Valor ingresado es incorrecto, por favor verifique.");
            }
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        mensajeFinal();
    }


}
