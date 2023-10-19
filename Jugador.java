import java.io.FileWriter;
import java.io.IOException; //importar librerias
import java.util.Scanner;

public class Jugador { // crear clase jugador
    private String nombre;
    private String pais;
    private String posicion;
    private int errores;
    private int aces;
    private int servicios;

    public Jugador() { // crear constructor

    }

    public String getNombre() { // hacer los gets
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getErrores() {
        return errores;
    }

    public int getAces() {
        return aces;
    }

    public int getServicios() {
        return servicios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public void setAces(int aces) {
        this.aces = aces;
    }

    public void setServicios(int servicios) {
        this.servicios = servicios;
    }

    public void guardarJugador() { // metodo para guardar la jugador (este se sgregó porque no estaba incluido en
                                   // el analisis de clases)
        String archivo = "bd.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del jugador:");
        setNombre(scanner.nextLine());

        System.out.println("Ingrese el país del jugador:");
        setPais(scanner.nextLine());

        System.out.println("Ingrese la posición del jugador:");
        setPosicion(scanner.nextLine());

        System.out.println("Ingrese la cantidad de errores del jugador:");
        setErrores(scanner.nextInt());

        System.out.println("Ingrese la cantidad de aces del jugador:");
        setAces(scanner.nextInt());

        System.out.println("Ingrese la cantidad de servicios del jugador:");
        setServicios(scanner.nextInt());

        try { // hacer un try catch para guardar los datos
            FileWriter insertar = new FileWriter(archivo, true);
            insertar.append(getNombre());
            insertar.append(",");
            insertar.append(getPais());
            insertar.append(",");
            insertar.append(getPosicion());
            insertar.append(",");
            insertar.append(String.valueOf(getErrores()));
            insertar.append(",");
            insertar.append(String.valueOf(getAces()));
            insertar.append(",");
            insertar.append(String.valueOf(getServicios()));
            insertar.append("\n");
            insertar.flush();
            insertar.close();
            System.out.println("Datos del jugador guardados en el archivo CSV exitosamente.");
        } catch (IOException e) {
            System.err.println("Error, no se guardaron los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Jugador jugador = new Jugador();
        jugador.guardarJugador();
    }
}
