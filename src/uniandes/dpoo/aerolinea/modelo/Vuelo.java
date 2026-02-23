package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo 
{
    private Ruta ruta;
    private String fecha;
    private Avion avion;
    private Map<String, Tiquete> tiquetes;

    public Vuelo(Ruta ruta, String fecha, Avion avion) 
    {
        this.ruta = ruta;
        this.fecha = fecha;
        this.avion = avion;
        this.tiquetes = new HashMap<>();
    }

    public Ruta getRuta() 
    {
        return ruta;
    }

    public String getFecha() 
    {
        return fecha;
    }

    public Avion getAvion()
    {
        return avion;
    }

    public Collection<Tiquete> getTiquetes()
    {
        return tiquetes.values();
    }

    public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad)
            throws VueloSobrevendidoException
    {
        int capacidad = avion.getCapacidad();
        int vendidos = tiquetes.size();

        if (vendidos + cantidad > capacidad)
        {
            
        }

        int total = 0;

        for (int i = 0; i < cantidad; i++)
        {
            int precio = calculadora.calcularTarifa(this, cliente);

            String codigo = fecha + "-" + (tiquetes.size() + 1);

            Tiquete tiquete = new Tiquete(codigo, this, cliente, precio);

            tiquetes.put(tiquete.getCodigo(), tiquete);
            total += precio;
        }

        return total;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Vuelo otro = (Vuelo) obj;

        return ruta.equals(otro.ruta) && fecha.equals(otro.fecha);
    }
}