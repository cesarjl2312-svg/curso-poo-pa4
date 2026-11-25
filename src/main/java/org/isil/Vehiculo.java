package org.isil;

import java.util.Objects;

public abstract class Vehiculo implements Inspeccionable {
    private String codigo;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private double tarifaBase;

    public Vehiculo(String codigo, String marca, String modelo, int anioFabricacion, double tarifaBase) {
        this.codigo = codigo.trim().toUpperCase();
        this.marca = marca.trim();
        this.modelo = modelo.trim();
        this.anioFabricacion = anioFabricacion;
        this.tarifaBase = tarifaBase;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public abstract double calcularTarifaDiaria();

    protected String resumenBase() {
        return String.format("[%s] %s %s (%d) | Base: S/ %.2f | Diaria: S/ %.2f",
                codigo, marca, modelo, anioFabricacion, tarifaBase, calcularTarifaDiaria());
    }

    @Override
    public String toString() {
        return resumenBase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo)) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(codigo, vehiculo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}