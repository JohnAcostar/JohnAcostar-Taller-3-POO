package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;


public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas
{
    protected final int COSTO_POR_KM_NATURAL = 800;
    protected final int COSTO_POR_KM_CORPORATIVO = 900;

    protected final double DESCUENTO_PEQ = 0.05;
    protected final double DESCUENTO_MEDIANAS = 0.10;
    protected final double DESCUENTO_GRANDES = 0.20;

    public CalculadoraTarifasTemporadaBaja()
    {
        super();
    }

    @Override
    public int calcularCostoBase(Vuelo vuelo, Cliente cliente)
    {
        Ruta ruta = vuelo.getRuta();
        int distancia = calcularDistanciaVuelo(ruta);

        if (cliente instanceof ClienteNatural)
        {
            return COSTO_POR_KM_NATURAL * distancia;
        }
        else
        {
            return COSTO_POR_KM_CORPORATIVO * distancia;
        }
    }

    @Override
    public double calcularPorcentajeDescuento(Cliente cliente)
    {
        if (cliente instanceof ClienteCorporativo)
        {
            ClienteCorporativo corp = (ClienteCorporativo) cliente;

            if (corp.getTamanoEmpresa() == ClienteCorporativo.PEQUENA)
            {
                return DESCUENTO_PEQ;
            }
            else if (corp.getTamanoEmpresa() == ClienteCorporativo.MEDIANA)
            {
                return DESCUENTO_MEDIANAS;
            }
            else if (corp.getTamanoEmpresa() == ClienteCorporativo.GRANDE)
            {
                return DESCUENTO_GRANDES;
            }
        }

        // Clientes naturales no tienen descuento en temporada baja
        return 0;
    }
}