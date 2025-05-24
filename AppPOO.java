import java.util.ArrayList;
import java.util.Scanner;

class Persona {
    // a) Propiedades privadas
    private String nombre;
    private String apellido;
    private String genero;
    private int edad;

    // Constructor
    public Persona(String nombre, String apellido, String genero, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
    }

    // Métodos getters para acceder a los atributos necesarios
    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }
}

public class AppPOO {
    static ArrayList<Persona> personas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        capturarPersonas();
        mostrarNombreYGenero();
        System.out.println("Promedio de edades: " + calcularPromedioEdad());
        System.out.println("Cantidad de personas con género Masculino: " + contarGenero("Masculino"));
        System.out.println("Cantidad de personas con género Femenino: " + contarGenero("Femenino"));
    }

    // b) Método para capturar 5 personas por teclado
    public static void capturarPersonas() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese los datos de la persona #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Género (Masculino/Femenino): ");
            String genero = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            personas.add(new Persona(nombre, apellido, genero, edad));
        }
    }

    // b) Método para mostrar nombre y género
    public static void mostrarNombreYGenero() {
        System.out.println("\n--- Nombre y Género de las personas ---");
        for (Persona p : personas) {
            System.out.println("Nombre: " + p.getNombre() + " | Género: " + p.getGenero());
        }
    }

    // c) Promedio de edad
    public static double calcularPromedioEdad() {
        int suma = 0;
        for (Persona p : personas) {
            suma += p.getEdad();
        }
        return (double) suma / personas.size();
    }

    // d) Contar personas por género
    public static int contarGenero(String generoBuscado) {
        int contador = 0;
        for (Persona p : personas) {
            if (p.getGenero().equalsIgnoreCase(generoBuscado)) {
                contador++;
            }
        }
        return contador;
    }
}
