package uniandes.dpoo.aerolinea.modelo.cliente;

/**
 * Clase abstracta que representa un cliente de la aerolínea.
 */
public abstract class Cliente 
{
    private String identificador;

    public Cliente(String identificador) 
    {
        this.identificador = identificador;
    }

    /**
     * Retorna el identificador único del cliente.
     */
    public String getIdentificador() 
    {
        return identificador;
    }

    /**
     * Retorna el tipo de cliente (natural, corporativo, etc.)
     */
    public abstract String getTipoCliente();
}