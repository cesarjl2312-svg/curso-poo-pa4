package org.isil;

public class Auto extends Vehiculo {
    private int numPuertas;
    private boolean esHibrido;

    public Auto(String codigo, String marca, String modelo, int anioFabricacion,
                double tarifaBase, int numPuertas, boolean esHibrido) {
        super(codigo, marca, modelo, anioFabricacion, tarifaBase);
        this.numPuertas = numPuertas;
        this.esHibrido = esHibrido;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public boolean isEsHibrido() {
        return esHibrido;
    }

    @Override
    public double calcularTarifaDiaria() {
        double recargoHibrido = esHibrido ? 15.0 : 0.0;
        return getTarifaBase() + recargoHibrido;
    }

    @Override
    public String realizarInspeccion() {
        return "Inspección Auto [" + getCodigo() + "]: frenos, luces, neumáticos y motor "
                + (esHibrido ? "híbrido -> OK" : "gasolina -> OK");
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Puertas: %d | Híbrido: %s",
                numPuertas, esHibrido ? "Sí" : "No");
    }
}