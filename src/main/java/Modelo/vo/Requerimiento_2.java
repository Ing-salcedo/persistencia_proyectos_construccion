package Modelo.vo;

public class Requerimiento_2 {
    public String Nombre;
    public String Primer_Apellido;
    public String Ciudad_Residencia;
    public String Cargo;
    public String Salario;

    public Requerimiento_2(String cargo) {
        Cargo = cargo;
    }
    public Requerimiento_2() {
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }
    public void setPrimer_Apellido(String primer_Apellido) {
        Primer_Apellido = primer_Apellido;
    }
    public String getCiudad_Residencia() {
        return Ciudad_Residencia;
    }
    public void setCiudad_Residencia(String ciudad_Residencia) {
        Ciudad_Residencia = ciudad_Residencia;
    }
    public String getCargo() {
        return Cargo;
    }
    public void setCargo(String cargo) {
        Cargo = cargo;
    }
    public String getSalario() {
        return Salario;
    }
    public void setSalario(String salario) {
        Salario = salario;
    }
}
