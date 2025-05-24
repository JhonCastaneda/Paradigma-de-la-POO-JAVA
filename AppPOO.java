import java.util.Scanner;

class Persona {
    protected String nombre;
    protected int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return "Sin especificar";
    }

    public String getInfo() {
        return "Nombre: " + nombre + ", Género: " + getGenero();
    }
}

class Hombre extends Persona {
    public Hombre(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String getGenero() {
        return "Masculino";
    }

    @Override
    public String getInfo() {
        return "HOMBRE - " + super.getInfo();
    }
}

class Mujer extends Persona {
    public Mujer(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public String getGenero() {
        return "Femenino";
    }

    @Override
    public String getInfo() {
        return "MUJER - " + super.getInfo();
    }
}

public class AppPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona[] personas = new Persona[5];
        int totalEdad = 0;
        int countHombres = 0;
        int countMujeres = 0;

        for (int i = 0; i < personas.length; i++) {
            System.out.println("Ingrese el nombre de la persona #" + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la edad de " + nombre + ": ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el género (Masculino/Femenino): ");
            String genero = scanner.nextLine().trim().toLowerCase();

            if (genero.equals("masculino")) {
                personas[i] = new Hombre(nombre, edad);
                countHombres++;
            } else if (genero.equals("femenino")) {
                personas[i] = new Mujer(nombre, edad);
                countMujeres++;
            } else {
                System.out.println("Género no válido. Se asignará como Hombre por defecto.");
                personas[i] = new Hombre(nombre, edad);
                countHombres++;
            }

            totalEdad += edad;
        }

        System.out.println("\n--- Información de las personas capturadas ---");
        for (Persona p : personas) {
            System.out.println(p.getInfo());
        }

        double promedioEdad = (double) totalEdad / personas.length;
        System.out.println("\nPromedio de edad: " + promedioEdad);
        System.out.println("Cantidad de personas de género masculino: " + countHombres);
        System.out.println("Cantidad de personas de género femenino: " + countMujeres);
    }
}
