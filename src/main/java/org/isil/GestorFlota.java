package org.isil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GestorFlota {
    private final List<Vehiculo> flota = new ArrayList<>();
    private final Set<Vehiculo> codigosRegistrados = new HashSet<>();

    public boolean registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            return false;
        }
        if (!codigosRegistrados.add(vehiculo)) {
            return false;
        }
        flota.add(vehiculo);
        return true;
    }

    public void listarConForEach() {
        if (flota.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        for (Vehiculo v : flota) {
            System.out.println("  - " + v);
        }
    }

    public void listarConIterator() {
        Iterator<Vehiculo> it = flota.iterator();
        while (it.hasNext()) {
            Vehiculo v = it.next();
            System.out.println("  - " + v.realizarInspeccion());
        }
    }

    public Vehiculo buscarPorCodigo(String codigo) {
        if (codigo == null) return null;
        String buscado = codigo.trim().toUpperCase();
        for (Vehiculo v : flota) {
            if (v.getCodigo().equalsIgnoreCase(buscado)) {
                return v;
            }
        }
        return null;
    }

    public List<Vehiculo> buscarPorMarca(String marca) {
        List<Vehiculo> encontrados = new ArrayList<>();
        if (marca == null) return encontrados;
        String buscada = marca.trim().toLowerCase();
        for (Vehiculo v : flota) {
            if (v.getMarca().toLowerCase().contains(buscada)) {
                encontrados.add(v);
            }
        }
        return encontrados;
    }

    public List<Vehiculo> ordenarPorTarifaDiariaAsc() {
        List<Vehiculo> ordenada = new ArrayList<>(flota);
        ordenada.sort(Comparator.comparingDouble(Vehiculo::calcularTarifaDiaria));
        return ordenada;
    }

    public List<Vehiculo> ordenarPorAnioDesc() {
        List<Vehiculo> ordenada = new ArrayList<>(flota);
        ordenada.sort(Comparator.comparingInt(Vehiculo::getAnioFabricacion).reversed());
        return ordenada;
    }

    /**
     * Elimina el vehículo con el código indicado usando iterator() y remove().
     * También se retira del HashSet de códigos registrados para que el código
     * pueda volver a registrarse después.
     */
    public boolean eliminarPorCodigo(String codigo) {
        if (codigo == null) {
            return false;
        }
        String buscado = codigo.trim().toUpperCase();
        Iterator<Vehiculo> it = flota.iterator();
        while (it.hasNext()) {
            Vehiculo v = it.next();
            if (v.getCodigo().equals(buscado)) {
                it.remove();
                codigosRegistrados.remove(v);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina todos los vehículos de la marca indicada usando removeIf().
     * Retorna la cantidad de vehículos eliminados.
     */
    public int eliminarPorMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            return 0;
        }
        String buscada = marca.trim();
        List<Vehiculo> aEliminar = new ArrayList<>();
        for (Vehiculo v : flota) {
            if (v.getMarca().equalsIgnoreCase(buscada)) {
                aEliminar.add(v);
            }
        }
        codigosRegistrados.removeAll(aEliminar);
        flota.removeIf(v -> v.getMarca().equalsIgnoreCase(buscada));
        return aEliminar.size();
    }

    public int totalVehiculos() {
        return flota.size();
    }
}
