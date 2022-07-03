package Veterinaria;

public class Cliente {
    private int id;
    private String nombre;
    public Cliente(int id , String nombre){
        this.nombre=nombre;
        this.id=id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente() {}

    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
