public abstract class CalculadoraTarifas {

    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double descuento = calcularPorcentajeDescuento(cliente);
        int valorConDescuento = (int) (costoBase * (1 - descuento));
        return calcularValorImpuestos(valorConDescuento);
    }

    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    protected int calcularValorImpuestos(int costoBase) {
        return (int) (costoBase * (1 + IMPUESTO));
    }
}