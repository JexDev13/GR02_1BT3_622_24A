package web;

public class Reseva {
    private String cedula;
    private String num_habitacion;
    private String dia_entra;
    private String dia_sale;
    private String persona;

    public Reseva(String cedula, String num_habitacion, String dia_entra, String dia_sale, String persona) {
        this.cedula = cedula;
        this.num_habitacion = num_habitacion;
        this.dia_entra = dia_entra;
        this.dia_sale = dia_sale;
        this.persona = persona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNum_habitacion() {
        return num_habitacion;
    }

    public void setNum_habitacion(String num_habitacion) {
        this.num_habitacion = num_habitacion;
    }

    public String getDia_entra() {
        return dia_entra;
    }

    public void setDia_entra(String dia_entra) {
        this.dia_entra = dia_entra;
    }

    public String getDia_sale() {
        return dia_sale;
    }

    public void setDia_sale(String dia_sale) {
        this.dia_sale = dia_sale;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }


}
