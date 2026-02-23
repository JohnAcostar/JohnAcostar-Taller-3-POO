package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    private String codigoRuta;
    private Aeropuerto origen;
    private Aeropuerto destino;
    private String horaSalida;
    private String horaLlegada;
    private int duracionMinutos;

    public Ruta(String codigoRuta, Aeropuerto origen, Aeropuerto destino, 
                String horaSalida, String horaLlegada)
    {
        this.codigoRuta = codigoRuta;
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.duracionMinutos = calcularDuracion();
    }

    private int calcularDuracion()
    {
        int minutosSalida = getHoras(horaSalida) * 60 + getMinutos(horaSalida);
        int minutosLlegada = getHoras(horaLlegada) * 60 + getMinutos(horaLlegada);

        int duracion = minutosLlegada - minutosSalida;

        // Si llega al día siguiente
        if (duracion < 0)
        {
            duracion += 24 * 60;
        }

        return duracion;
    }

    public String getCodigoRuta()
    {
        return codigoRuta;
    }

    public Aeropuerto getOrigen()
    {
        return origen;
    }

    public Aeropuerto getDestino()
    {
        return destino;
    }

    public String getHoraSalida()
    {
        return horaSalida;
    }

    public String getHoraLlegada()
    {
        return horaLlegada;
    }

    public int getDuracionMinutos()
    {
        return duracionMinutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * Por ejemplo, para la cadena '715' retorna 15.
     */
    public static int getMinutos(String horaCompleta)
    {
        int minutos = Integer.parseInt(horaCompleta) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * Por ejemplo, para la cadena '715' retorna 7.
     */
    public static int getHoras(String horaCompleta)
    {
        int horas = Integer.parseInt(horaCompleta) / 100;
        return horas;
    }

}
