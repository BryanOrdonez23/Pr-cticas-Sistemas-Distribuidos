//package Algoritmo;

/**
 *
 * @author UserPc
 */
public class Proceso {

    private String nombre;
    private int tiempo;

    public Proceso(String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void Imprimir() {
        System.out.println(this.getNombre() + ": " + this.getTiempo());
    }
    
    
    public void Aumento(int a){
        this.setTiempo(getTiempo()+a);
    }

}
