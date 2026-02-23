package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;

public abstract class CalculadoraTarifas
{
    /**
     * El porcentaje que corresponde al impuesto sobre el costo base
     */
    public static final double IMPUESTO = 0.19; // 19% típico en Colombia

    public CalculadoraTarifas()
    {
        // Constructor vacío
    }

    /**
     * Calcula la tarifa total de un vuelo para un cliente.
     */
    public int calcularTarifa(Vuelo vuelo, Cliente cliente)
    {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);

        int valorConDescuento = (int) (costoBase * (1 - descuento));

        return calcularValorImpuestos(valorConDescuento);
    }

    /**
     * Este método calcula cuál debe ser el costo base.
     */
    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    /**
     * Calcula el porcentaje de descuento.
     */
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    /**
     * Calcula la distancia aproximada en kilómetros para una ruta.
     */
    protected int calcularDistanciaVuelo(Ruta ruta)
    {
        Aeropuerto origen = ruta.getOrigen();
        Aeropuerto destino = ruta.getDestino();

        return Aeropuerto.calcularDistancia(origen, destino);
    }

    /**
     * Calcula el valor de los impuestos.
     */
    protected int calcularValorImpuestos(int costoBase)
    {
        return (int) (costoBase * (1 + IMPUESTO));
    }
}