package grafos;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GrafoMatriz grafo = new GrafoMatriz();
        Scanner scan = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("----- Menú del Grafo -----");
            System.out.println("1. Ingresar vértices");
            System.out.println("2. Conectar vértices");
            System.out.println("3. Verificar si un vértice es adyacente con otro");
            System.out.println("4. Buscar todas las adyacencias de un vértice");
            System.out.println("5. Salir");
            System.out.println("--------------------------");
            System.out.print("Ingrese su opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    if (grafo.numVerts < GrafoMatriz.MaxVerts) {
                        System.out.print("Ingrese el nombre del vértice a agregar: ");
                        String nombreVertice = scan.next();
                        grafo.nuevoVertice(nombreVertice);
                        System.out.println("Vértice agregado correctamente.");
                    } else {
                        System.out.println("El número máximo de vértices (20) ha sido alcanzado.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del primer vértice: ");
                    String nombreVertice1 = scan.next();
                    System.out.print("Ingrese el nombre del segundo vértice: ");
                    String nombreVertice2 = scan.next();
                    try {
                        grafo.nuevoArco(nombreVertice1, nombreVertice2);
                        System.out.println("Arista agregada entre " + nombreVertice1 + " y " + nombreVertice2);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del primer vértice: ");
                    String v1 = scan.next();
                    System.out.print("Ingrese el nombre del segundo vértice: ");
                    String v2 = scan.next();
                    try {
                        boolean sonAdyacentes = grafo.adyacente(v1, v2);
                        System.out.println("¿Son adyacentes? " + sonAdyacentes);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el nombre del vértice: ");
                    String vertice = scan.next();
                    try {
                        int indiceVertice = grafo.numVertice(vertice);
                        List<Vertice> verticesAdyacentes = grafo.verticesAdyacentes(indiceVertice);
                        System.out.println("Vértices adyacentes a " + vertice + ": " + verticesAdyacentes);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 5 && grafo.numVerts < GrafoMatriz.MaxVerts);

        scan.close();
    }
}