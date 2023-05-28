
package examen_3da_evaluación_apple_pie_2;

/*
INTEGRANTES:
ANGEL EDUARDO ARIZPE CARRILLO
IRAM ARREDONDO RAMÍREZ
DAVID ALBERTO MARTÍNEZ ESPINOZA
LUIS CARLOS MEZA LÓPEZ
*/

public class EXAMEN_3DA_EVALUACIÓN_APPLE_PIE_2 {

    
    public static void main(String[] args) {
        //Se crea un objeto "inventario" para poder hacer uso de los métodos de la clase Inventario
        Inventario inventario = new Inventario();
        
        Producto p1 = new Producto(1, "Avena", 20, 4);
        inventario.addProduct(p1);
        
        Producto p2 = new Producto(2, "Leche", 30, 5);
        inventario.addProduct(p2);
        
        Producto p3 = new Producto(3, "Huevos", 60, 7);
        inventario.addProduct(p3);
        
        Producto p4 = new Producto(4, "Pan", 40, 8);
        inventario.addProduct(p4);
        
        Producto p5 = new Producto(5, "Atún", 10, 12);
        inventario.addProduct(p5);
        
        Producto p6 = new Producto(6, "Jamón", 80, 15);
        inventario.addProduct(p6);
        
        Producto p7 = new Producto(7, "Limón", 5, 20);
        inventario.addProduct(p7);
        
        Producto p8 = new Producto(8, "Sabritas", 35, 9);
        inventario.addProduct(p8);
        
        Producto p9 = new Producto(9, "Sodas", 45, 13);
        inventario.addProduct(p9);
        
        Producto p10 = new Producto(10, "Tortillas", 15, 17);
        inventario.addProduct(p10);
        
        //Producto p11 = new Producto(11, "Tortillas Maiz", 23, 4);
        //inventario.addProduct(p11);
        
        //REMOVER UN PRODUCTO
        //inventario.removeProduct(7);
        //inventario.removeProduct(20);
        
        //BUSCAR UN PRODUCTO
        //inventario.searchProduct(3);
        
        //MOSTAR INVENTARIO
        inventario.displayInventory();
        
        //GUARDAR EN UN ARCHIVO DE TEXTO (.txt)
        //Ubicación --> C:\\Archivos\\
        //inventario.safeToFile("ProductosA");
        
        //LEER UN ARCHIVO DE TEXTO (.txt)
        //Ubicación --> C:\\Archivos\\
        //inventario.loadFromFile("ProductosA");
    }
    
}
