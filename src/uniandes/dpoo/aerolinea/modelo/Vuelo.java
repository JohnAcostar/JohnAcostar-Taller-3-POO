package uniandes.dpoo.aerolinea.modelo;

public class Vuelo 
{
    private Ruta ruta;
    private String fecha;

    public Vuelo(Ruta ruta, String fecha) 
    {
        this.ruta = ruta;
        this.fecha = fecha;
    }

    public Ruta getRuta() 
    {
        return ruta;
    }

    public String getFecha() 
    {
        return fecha;
    }
}