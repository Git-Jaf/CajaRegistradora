package Controlador;

import Objetos.Arroz;
import Objetos.Carne;
import Objetos.Papa;
import Objetos.Productos;
import Storage.MockData;
import Vistas.Vista;
import java.util.List;

public class Registradora {
    private MockData mockData;
    public Registradora(){
        mockData = new MockData();
    }
    
    //Inicia el proceso de la registradora
    public void registrar(){
        int opcion;
        do {
            Vista.mostrarCabecera();
            Vista.mostrarMenuPrincipal();
            Vista.mostrarObtenerOpcion();
            opcion = Vista.obtenerOpcion();
            
            switch (opcion) {
                case 1:
                    compraVista();
                    break;
                case 2:
                    ventaVista();
                    break;
                case 3:
                    mostrarStock();
                    break;
                case 4:
                    mostrarCompras();
                    break;
                case 5:
                    mostrarVentas();
                    break;
                case 6:
                    Vista.salir();
                    System.exit(0);
                    break;
                default:
                    Vista.opcionNoValida();
                    break;
            }
        } while (opcion >= 1 & opcion <= 6);
    }
    
    //Muestra las opciones de compra
    private void compraVista(){
        Vista.mostrarCabeceraCompra();
        int opcion;
        do {            
            Vista.mostrarObtenerOpcion();
            opcion = Vista.obtenerOpcion();
            if (opcion >= 1 && opcion <= 3) {
                comprarProducto(opcion);
            } else if(opcion == 4) {
                Vista.salirModulo("Compras");
                return;
            } else {
                Vista.opcionNoValida();
            }
        } while (opcion < 1 || opcion > 4);
    }
    
    //Registra en el mockData el producto comprado
    private void comprarProducto(int opcion){
        Productos productos = null;
        switch (opcion) {
            case 1:
                productos = new Papa("Amarilla");
                break;
            case 2:
                productos = new Arroz("Rompe Olla");
                break;
            case 3:
                productos = new Carne("Lomo de res");
                break;
            default:
                Vista.opcionNoValida();
                break;
        }
        
        Vista.mostrarObtenerCantidad();
        int cantidad = Vista.obtenerCantidad();
        Vista.mostrarObtenerPrecio();
        double precio = Vista.obtenerPrecio();
        productos.setCantidad(cantidad);
        productos.setPrecio(precio);
        
        mockData.comprar(productos);
    }
    
    public void mostrarStock(){
        Vista.mostrarCabeceraStock();
        Vista.mostrarStockItems(mockData.obtenerTodos());
        Vista.elijaCualquierTecla();
        Vista.obtenerOpcion();
    }
    
    //Muestra las opciones de venta
    private void ventaVista(){
        Vista.mostrarCabeceraVenta();
        int opcion;
        do {            
            Vista.mostrarObtenerOpcion();
            opcion = Vista.obtenerOpcion();
            if (opcion >= 1 && opcion <= 3) {
                venderProducto(opcion);
            } else if(opcion == 4) {
                    Vista.salirModulo("Ventas");
                return;
            } else {
                Vista.opcionNoValida();
            }
        } while (opcion < 1 || opcion > 4);
    }
    
    //Registra en el mockData el producto vendido
    private void venderProducto(int opcion) {
        Productos productos = null;
        if (opcion < 1 || opcion > 3) {
            Vista.opcionNoValida();
            return;
        }

        productos = mockData.obtenerIndice(opcion - 1);
        Vista.mostrarObtenerCantidad();
        int cantidad = Vista.obtenerCantidad();
        if (productos.getCantidad() < cantidad) {
           Vista.cantidadNoValida();
           return;
        } 
        productos.setCantidad(cantidad);
        mockData.vender(productos);
    }
    
    private void mostrarCompras(){
        List<Productos> listado = mockData.obtenerCompras();
        Vista.mostrarCabeceraListadoCompras();
        Vista.mostrarCompras(listado);
        Vista.elijaCualquierTecla();
        Vista.obtenerOpcion();
    }

    private void mostrarVentas() {
        List<Productos> listado = mockData.obtenerVentas();
        Vista.mostrarCabeceraListadoVentas();
        Vista.mostrarVentas(listado);
        Vista.elijaCualquierTecla();
        Vista.obtenerOpcion();
    }
}
