package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

/**
 * Esta clase abstracta define e implementa los aspectos que son comunes
 * para todos los tipos de clientes de la Aerolínea.
 * Cada cliente tiene una lista de tiquetes usados y sin usar.
 */
public abstract class Cliente
{
    private List<Tiquete> tiquetesSinUsar;
    private List<Tiquete> tiquetesUsados;

    /**
     * Inicializa las listas de tiquetes del cliente.
     */
    public Cliente()
    {
        tiquetesSinUsar = new ArrayList<>();
        tiquetesUsados = new ArrayList<>();
    }

    /**
     * Retorna el identificador del cliente.
     */
    public abstract String getIdentificador();

    /**
     * Retorna el tipo del cliente.
     */
    public abstract String getTipoCliente();

    /**
     * Agrega un nuevo tiquete a la lista de tiquetes sin usar.
     */
    public void agregarTiquete(Tiquete tiquete)
    {
        tiquetesSinUsar.add(tiquete);
    }

    /**
     * Calcula el valor total de los tiquetes del cliente.
     */
    public int calcularValorTotalTiquetes()
    {
        int total = 0;

        for (Tiquete t : tiquetesSinUsar)
        {
            total += t.getTarifa();
        }

        for (Tiquete t : tiquetesUsados)
        {
            total += t.getTarifa();
        }

        return total;
    }

    /**
     * Marca como usados los tiquetes correspondientes al vuelo dado.
     */
    public void usarTiquetes(Vuelo vuelo)
    {
        Iterator<Tiquete> iterator = tiquetesSinUsar.iterator();

        while (iterator.hasNext())
        {
            Tiquete t = iterator.next();

            if (t.getVuelo().equals(vuelo))
            {
                tiquetesUsados.add(t);
                iterator.remove();
            }
        }
    }
}