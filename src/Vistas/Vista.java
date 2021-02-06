package Vistas;

import Objetos.Productos;
import java.util.List;
import java.util.Scanner;

public class Vista {
    public static void mostrarCabecera(){
        System.out.println("\t\t*************************************");
        System.out.println("\t\t* BIENVENIDO A LA CAJA REGISTRADORA *");
        System.out.println("\t\t*************************************");
    }
    
    public static void mostrarMenuPrincipal() {
        System.out.println("\t\t 1. Comprar"); 
        System.out.println("\t\t 2. Vender");
        System.out.println("\t\t 3. Inventario");
        System.out.println("\t\t 4. Compras");
        System.out.println("\t\t 5. Ventas");
        System.out.println("\t\t 6. Salir");
    }
    
    public static void mostrarObtenerOpcion(){
        System.out.println("\t\t*************************************");
        System.out.print("\t\tDigite una opción: ");
    }
    
    public static void mostrarObtenerCantidad(){
        System.out.print("\t\tDigite la Cantidad en Kg.: ");
    }

    public static void mostrarObtenerPrecio() {
        System.out.print("\t\tDigite el Precio en S/.: ");
    }
    
    public static int obtenerOpcion(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    public static int obtenerCantidad() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static double obtenerPrecio() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
    
    public static void mostrarCabeceraCompra() {
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*          MENÚ DE COMPRAS          *");
        System.out.println("\t\t*************************************");
        mostrarItemsMenu();
    }
    
    public static void mostrarCabeceraVenta() {
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*         MENÚ  DE  VENTAS          *");
        System.out.println("\t\t*************************************");
        mostrarItemsMenu();
    }
    
    public static void mostrarCabeceraStock() {
        System.out.println("\t\t****************************************************");
        System.out.println("\t\t*               I N V E N T A R I O                *");
        System.out.println("\t\t****************************************************");
        mostrarCabeceraItem();
    }
    
    public static void mostrarCabeceraItem(){
        System.out.println("\t\t------------------------------------------------------------------------------");
        System.out.println("\t\t* PRODUCTO\t| CANTIDAD\t| P. UNITARIO\t\t\t| P. TOTAL\t*");
        System.out.println("\t\t------------------------------------------------------------------------------");
    }
    
    public static void mostrarCabeceraListadoCompras() {
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*          C O M P R A S            *");
        System.out.println("\t\t*************************************");
        mostrarCabeceraItem();
    }
    
    public static void mostrarCabeceraListadoVentas() {
        System.out.println("\t\t*************************************");
        System.out.println("\t\t*           V E N T A S             *");
        System.out.println("\t\t*************************************");
        mostrarCabeceraItem();
    }
    
    public static void mostrarItemsMenu(){
        System.out.println("\t\t1. Papa");
        System.out.println("\t\t2. Arroz");
        System.out.println("\t\t3. Carne");
        System.out.println("\t\t4. <- Volver");
    }
    
    public static void salir(){
        System.out.println("\t\tSaliendo del sistema, hasta pronto!");
    }
    
    public static void opcionNoValida(){
        System.out.println("\t\tOpción no válida");
    }
    
    public static void salirModulo(String name) {
        System.out.println("\t\tSaliendo del módulo..." + name);
    }

    public static void mostrarStockItems(Productos[] productos) {
        for (Productos p : productos) {
            System.out.println("\t\t* "+p.getNombre()+"\t| "+p.getCantidad()+"\t\t| "+"S/. "+p.getPrecio()+"\t\t\t| "+"S/. "+p.getCantidad()*p.getPrecio()+"\t*");
        }
    }
    
    public static void elijaCualquierTecla() {
        System.out.print("\t\tDigite cualquier número para continuar... ");
    }

    public static void cantidadNoValida() {
        System.out.print("\t\tLa cantidad en kilogramos no es válida");
    }
    
    public static void mostrarCompras(List<Productos> listado) {
        for (Productos p : listado) {
             System.out.println("\t\t* "+p.getNombre()+"\t| "+p.getCantidad()+"\t\t| "+"S/. "+p.getPrecio()+"\t\t\t| "+"S/. "+p.getCantidad()*p.getPrecio()+"\t*");
        }
    }

    public static void mostrarVentas(List<Productos> listado) {
        for (Productos p : listado) {
             System.out.println("\t\t* "+p.getNombre()+"\t| "+p.getCantidad()+"\t\t| "+"S/. "+p.getPrecio()+"\t\t\t| "+"S/. "+p.getCantidad()*p.getPrecio()*1.25+"\t*");
        }
    }
}
