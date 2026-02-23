package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
    public static final String CORPORATIVO = "corporativo";

    public static final int PEQUENA = 1;
    public static final int MEDIANA = 2;
    public static final int GRANDE  = 3;

    private String nombreEmpresa;
    private int tamanoEmpresa;

    public ClienteCorporativo(String nombreEmpresa, int tamano)
    {
        super(); // Cliente() inicializa listas de tiquetes
        this.nombreEmpresa = nombreEmpresa;
        this.tamanoEmpresa = tamano;
    }

    @Override
    public String getIdentificador()
    {
        return nombreEmpresa;
    }

    @Override
    public String getTipoCliente()
    {
        return CORPORATIVO;
    }

    public String getNombreEmpresa()
    {
        return nombreEmpresa;
    }

    public int getTamanoEmpresa()
    {
        return tamanoEmpresa;
    }

    public static ClienteCorporativo cargarDesdeJSON(JSONObject cliente)
    {
        String nombreEmpresa = cliente.getString("nombreEmpresa");
        int tam = cliente.getInt("tamanoEmpresa");
        return new ClienteCorporativo(nombreEmpresa, tam);
    }

    public JSONObject salvarEnJSON()
    {
        JSONObject jobject = new JSONObject();
        jobject.put("tipoCliente", CORPORATIVO);   // 👈 clave correcta
        jobject.put("nombreEmpresa", this.nombreEmpresa);
        jobject.put("tamanoEmpresa", this.tamanoEmpresa);
        return jobject;
    }
}