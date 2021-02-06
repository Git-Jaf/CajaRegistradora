package Objetos;

public abstract class Productos implements Cloneable{
    private String nombre;
    private int cantidad;
    private double precio;

    public Productos() {}

    public Productos(String n) {
        this.nombre = n;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            System.out.println("No puede asignar cantidad negativa");
            return;
        }
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            System.out.println("No puede asignar un precio negativo");
            return;
        }
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos: " + "\nNombre: " + nombre + "\nCantidad: " + cantidad + "\nPrecio: " + precio;
    }
    
    public Productos clone() throws CloneNotSupportedException {
        return (Productos) super.clone();
    }
}
