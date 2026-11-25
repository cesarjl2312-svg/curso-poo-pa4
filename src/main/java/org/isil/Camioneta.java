package org.isil;

public class Camioneta extends Vehiculo {
    private double capacidadCargaKg;
    private boolean traccion4x4;

    public Camioneta(String codigo, String marca, String modelo, int anioFabricacion,
                     double tarifaBase, double capacidadCargaKg, boolean traccion4x4) {
        super(codigo, marca, modelo, anioFabricacion, tarifaBase);
        this.capacidadCargaKg = capacidadCargaKg;
        this.traccion4x4 = traccion4x4;
    }

    public double getCapacidadCargaKg() {
        return capacidadCargaKg;
    }

    public boolean isTraccion4x4() {
        return traccion4x4;
    }

    @Override
    public double calcularTarifaDiaria() {
        double recargoCarga = (capacidadCargaKg / 500.0) * 12.0;
        double recargo4x4 = traccion4x4 ? 25.0 : 0.0;
        return getTarifaBase() + recargoCarga + recargo4x4;
    }

    @Override
    public String realizarInspeccion() {
        return "Inspección Camioneta [" + getCodigo() + "]: suspensión, carga ("
                + capacidadCargaKg + " kg) y tracción " + (traccion4x4 ? "4x4" : "4x2") + " -> OK";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Carga: %.0f kg | 4x4: %s",
                capacidadCargaKg, traccion4x4 ? "Sí" : "No");
    }
}