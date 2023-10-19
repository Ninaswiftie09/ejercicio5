import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; //importar librerias

public class Libero extends Jugador { // crear clase libero y conectarlo con la clase de jugador
    private int recibos;

    public Libero(int recibos) {
        this.recibos = recibos;
    }

    public int getRecibos() {
        return recibos;
    }

    public void setRecibos(int recibos) {
        this.recibos = recibos;
    }

    public void guardarLibero() { // metodo para guardar los recibos, aún no está completo pero por falta de
                                  // tiempo me va tocar dejarlo así
        String archivo = "bd.csv";
        try {
            FileWriter insertar = new FileWriter(archivo, true);
            insertar.append("");
            insertar.append(",");
            insertar.append(String.valueOf(getRecibos()));
            insertar.append("\n");
            insertar.flush();
            insertar.close();
            System.out.println("Datos guardados en el archivo CSV exitosamente.");
        } catch (IOException e) {
            System.err.println("Error, no se guardaron los datos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántas recepciones ha hecho el libero?");
        int recibos = scanner.nextInt();

        Libero libero = new Libero(recibos);
        libero.guardarLibero();
    }
}
// no me acordaba que se entregaba hoy :,) pidoperdón