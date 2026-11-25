package org.isil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorFlota gestor = new GestorFlota();

        Vehiculo v1 = new Auto("V-101", "Toyota", "Corolla", 2024, 120.0, 4, true);
        Vehiculo v2 = new Camioneta("V-102", "Mitsubishi", "L200", 2023, 160.0, 1000.0, true);
        Vehiculo v3 = new Auto("V-103", "Hyundai", "Accent", 2022, 95.0, 4, false);
        Vehiculo v4 = new Camioneta("V-104", "Nissan", "Frontier", 2025, 175.0, 1500.0, false);
        Vehiculo vDuplicado = new Auto("v-101", "Toyota", "Corolla Duplicado", 2024, 120.0, 4, true);

        System.out.println("=== 1. REGISTRO Y CONTROL DE DUPLICADOS (HashSet) ===");
        registrarYMostrar(gestor, v1);
        registrarYMostrar(gestor, v2);
        registrarYMostrar(gestor, v3);
        registrarYMostrar(gestor, v4);
        registrarYMostrar(gestor, vDuplicado);
        System.out.println("Total registrados: " + gestor.totalVehiculos());

        System.out.println("\n=== 2. RECORRIDO CON FOR-EACH ===");
        gestor.listarConForEach();

        System.out.println("\n=== 3. INSPECCIÓN CON ITERATOR ===");
        gestor.listarConIterator();

        System.out.println("\n=== 4. BÚSQUEDA POR CÓDIGO ('V-102') ===");
        Vehiculo encontrado = gestor.buscarPorCodigo("V-102");
        System.out.println(encontrado != null ? "Encontrado: " + encontrado : "No encontrado.");

        System.out.println("\n=== 5. ORDENAMIENTO POR TARIFA DIARIA (MENOR A MAYOR) ===");
        List<Vehiculo> porTarifa = gestor.ordenarPorTarifaDiariaAsc();
        for (Vehiculo v : porTarifa) {
            System.out.println("  - " + v);
        }

        System.out.println("\n=== 6. ORDENAMIENTO POR AÑO (MÁS RECIENTE A MÁS ANTIGUO) ===");
        List<Vehiculo> porAnio = gestor.ordenarPorAnioDesc();
        for (Vehiculo v : porAnio) {
            System.out.println("  - " + v);
        }

        System.out.println("\n=== 7. ELIMINACIÓN CON iterator().remove() Y removeIf() ===");
        boolean eliminado = gestor.eliminarPorCodigo("V-103");
        System.out.println("Eliminar por código 'V-103' (iterator().remove()): "
                + (eliminado ? "eliminado" : "no encontrado"));
        int eliminados = gestor.eliminarPorMarca("Mitsubishi");
        System.out.println("Eliminar marca 'Mitsubishi' (removeIf()): "
                + eliminados + " vehículo(s) eliminado(s)");
        System.out.println("Total restante: " + gestor.totalVehiculos());
        System.out.println("Listado final:");
        gestor.listarConForEach();

        boolean reRegistrado = gestor.registrarVehiculo(v3);
        System.out.println("Re-registro de 'V-103' tras la eliminación: "
                + (reRegistrado ? "OK" : "rechazado por duplicado"));
        System.out.println("Total final: " + gestor.totalVehiculos());
    }

    private static void registrarYMostrar(GestorFlota gestor, Vehiculo vehiculo) {
        if (gestor.registrarVehiculo(vehiculo)) {
            System.out.println("Registrado: " + vehiculo.getCodigo());
        } else {
            System.out.println("Duplicado omitido: " + vehiculo.getCodigo());
        }
    }
}
