package Storage;

import Objetos.Arroz;
import Objetos.Carne;
import Objetos.Papa;
import Objetos.Productos;
import java.util.ArrayList;
import java.util.List;

public class MockData {
    private Productos[] productos;
    private List<Productos> compras;
    private List<Productos> ventas;
    
    public MockData(){
        productos = new Productos[3];
        Productos papa = new Papa("Amarilla");
        Productos arroz = new Arroz("Rompe Olla");
        Productos carne = new Carne("Lomo de res");
        
        productos[0] = papa;
        productos[1] = arroz;        
        productos[2] = carne;  
        
        compras = new ArrayList<>();
        ventas = new ArrayList<>();
    }
    
    public Productos obtenerIndice(int i){
        if (i < 0 || i > 2) {
            System.out.println("Indice no válido");
            return null;
        }
        Productos resultado = null;
        try {
            resultado = productos[i].clone();
        } catch (CloneNotSupportedException cnse) {
            System.out.println(cnse);
        }
        return resultado;
    }

    public Productos[] obtenerTodos() {
        Productos[] resultado = new Productos[3];
        try {
            resultado[0] = productos[0].clone();
            resultado[1] = productos[1].clone();
            resultado[2] = productos[2].clone();
        } catch (CloneNotSupportedException cnse) {
            System.out.println(cnse);
        }
        return resultado;
    }
    
    public void comprar(Productos producto){
        Productos temporal;
        switch(producto.getClass().getSimpleName()){
            case "Papa":
                temporal = productos[0];
                break;
            case "Arroz":
                temporal = productos[1];
                break;
            case "Carne":
                temporal = productos[2];
                break;
            default:
                System.out.println("No válido");
                return;
        }
        
        //Se suma la cantidad actual con la cantidad adquirida
        temporal.setCantidad(temporal.getCantidad() + producto.getCantidad());
        temporal.setPrecio(producto.getPrecio());
        compras.add(producto);
    }
    
    public void vender(Productos producto){
        Productos temporal;
        switch(producto.getClass().getSimpleName()){
            case "Papa":
                temporal = productos[0];
                break;
            case "Arroz":
                temporal = productos[1];
                break;
            case "Carne":
                temporal = productos[2];
                break;
            default:
                System.out.println("No válido");
                return;
        }
        
        temporal.setCantidad(temporal.getCantidad() - producto.getCantidad());
        //Se le agrega un 25% de sobrecosto de venta
        producto.setPrecio(temporal.getPrecio() * 1.25);
        ventas.add(producto);
    }
    
    public List<Productos> obtenerCompras(){
        return compras;
    }
    
    public List<Productos> obtenerVentas(){
        return ventas;
    }
}
