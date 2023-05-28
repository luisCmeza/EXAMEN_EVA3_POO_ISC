package examen_3da_evaluación_apple_pie_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inventario {

    private Producto[] productos = new Producto[10];//Limite de objetos que se pueden crear en el arreglo productos (x<=10)
    private int cantidad = 0;//Cantidad de objetos "reales" creados

    //AGREGA PRODUCTOS AL SISTEMA
    void addProduct(Producto producto) {
        if (cantidad < 10) {
            productos[cantidad] = producto;//Guarda en la posición cantidad el objeto producto creado en el main
            cantidad++;
        } else {
            System.out.println("Cantidad de productos máxima alcanzada");
            System.out.println("");
        }
    }

    //ELIMINA UN PRODUCTO EN FUNCIÓN A SU ID
    void removeProduct(int productId) {
        boolean found = false;
        for (int i = 0; i < productos.length; i++) {
            //Verificar que exista algún producto con el id señalado
            for (int j = 0; j < cantidad; j++) {
                if (productos[j] != null && productos[j].getId() == productId) {
                    found = true;
                }
            }
            //Eliminación del objeto de la posición según el id
            if (productos[i] != null && productos[i].getId() == productId) {
                productos[i] = null;
                for (int j = 1; j < cantidad; j++) {
                    if (productos[i] == null && i < cantidad - 1) {
                        productos[i] = productos[i + 1];
                        i++;
                        productos[i] = null;
                    } else {
                        break;
                    }
                }
            }
            //Mensaje de error en caso de que no exista un objeto con el id señalado
            if (found != true) {
                System.out.println("El producto con el id '" + productId + "' a eliminar no fue encontrado");
                System.out.println("");
                break;
            }
        }
    }

    //BUSCA UN PRODUCTO POR SU ID Y DEVUELVE EL OBJETO PRODUCTO SI LO ENCUENTRA
    String searchProduct(int productId) {
        boolean found = false;
        String answer = "";
        //Verificación de que exista un objeto con el id señalado
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < cantidad; j++) {
                if (productos[j] != null && productos[j].getId() == productId) {
                    found = true;
                }
            }
            //Imprime el objeto buscado según Id
            if (productos[i] != null && productos[i].getId() == productId) {
                System.out.println("ID: " + productos[i].getId());
                System.out.println("Nombre: " + productos[i].getNombre());
                System.out.println("Precio: " + productos[i].getPrecio());
                System.out.println("Cantidad: " + productos[i].getCantidad());
                System.out.println("");
            }
            //Mensaje de error en caso de que no exista el id señalado
            if (found != true) {
                System.out.println("El producto buscado con el id '" + productId + "' no fue encontrado");
                break;
            }
        }
        return answer;
    }

    //MUESTRA EL INVENTARIO ACTUAL CON TODOS LOS PRODUCTOS Y SUS DETALLES
    void displayInventory() {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                System.out.println("ID: " + productos[i].getId());
                System.out.println("Nombre: " + productos[i].getNombre());
                System.out.println("Precio: " + productos[i].getPrecio());
                System.out.println("Cantidad: " + productos[i].getCantidad());
                System.out.println("");
            } else {
                break;
            }
        }
    }

    //GUARDA TODO EL INVENTARIO EN UN SOLO ARCHIVO DE TEXTO CON EL NOMBRE DE ARCHIVO DADO
    void safeToFile(String filename) {
        String ruta = "C:\\Archivos\\";
        try {
            writeUsingBufferedWriter(ruta + filename + ".txt", "");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    //CARGA EL CONTENIDO DEL INVENTARIO DESDE UN ARCHIVO DE TEXTO CON EL NOMBRE DE ARCHIVO DADO
    void loadFromFile(String filename) {
        final String RUTA = "C:\\Archivos\\" + filename + ".txt";
        try {
            readingUsingBufferedReader(RUTA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //MÉTODO DEL BUFFEREDWRITER
    public void writeUsingBufferedWriter(String ruta, String datos) throws IOException {
        File file = new File(ruta);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < 10; i++) {
            if (productos[i] != null) {
                bufWriter.write("ID: " + productos[i].getId() + " \n");
                bufWriter.write("Nombre: " + productos[i].getNombre() + " \n");
                bufWriter.write("Precio: " + productos[i].getPrecio() + " \n");
                bufWriter.write("Cantidad: " + productos[i].getCantidad() + " \n");
                bufWriter.write("\n");
            }
        }
        bufWriter.close();
        fileWriter.close();
    }
    //MÉTODO DEL BUFFEREDREADER
    public static void readingUsingBufferedReader(String ruta) throws IOException {
        System.out.println("");
        File file = new File(ruta);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufReader = new BufferedReader(inputStreamReader);
        String linea;
        while ((linea = bufReader.readLine()) != null) {
            System.out.println(linea);
        }
        bufReader.close();
    }
}
