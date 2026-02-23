package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente
{
    public static final String NATURAL = "natural";

    private String nombre;

    public ClienteNatural(String nombre) 
    {
        super(nombre);
        this.nombre = nombre;
    }

    @Override
    public String getTipoCliente() 
    {
        return NATURAL;
    }
}