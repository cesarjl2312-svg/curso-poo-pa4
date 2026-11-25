# Acuerdos de trabajo — Equipo PA4 (Programación Orientada a Objetos, 30626)

**Evaluación:** PA4 — sesiones 11 a 13 del sílabo.
**Integrantes:** Angel Fernando Reyes Moreno, César Augusto Maguiña Robles.
**Fecha de acuerdo:** 2026-11-24.

## 1. Distribución de responsabilidades

| Integrante | Responsabilidad principal | Entregables |
|---|---|---|
| César Augusto Maguiña Robles | Diseño del dominio y de la jerarquía OO. Implementación de `Inspeccionable`, `Vehiculo`, `Auto`, `Camioneta` y `GestorFlota` (registro con `HashSet`, recorridos, búsquedas y ordenamientos). | Clases del paquete `org.isil`, commit inicial del proyecto. |
| Angel Fernando Reyes Moreno | Operaciones de eliminación (`iterator().remove()` y `removeIf()`), aplicación `Main` e integración de la solución. Documentación del diseño en el README, acuerdos de trabajo, evidencias de compilación y ejecución, y control de versiones. | `Main.java`, métodos de eliminación en `GestorFlota`, `README.md`, `docs/`, evidencias en `docs/evidencias/`. |

La división busca equilibro: César aportó la base del dominio y la colección; Angel la aplicación demostrativa, las operaciones restantes, la documentación y la verificación.

## 2. Reglas de trabajo acordadas

1. **Lenguaje y entorno:** Java 17+, proyecto Maven gestionado desde IntelliJ IDEA. El `pom.xml` fija `maven.compiler.source` y `target` en 17 para que compile en cualquier equipo del grupo.
2. **Paquete único `org.isil`:** todas las clases viven en el mismo paquete para simplificar la ejecución y la revisión del docente.
3. **Convenciones de código:**
   - Atributos siempre `private` (encapsulamiento); sin setters para los campos que identifican al objeto (`codigo`).
   - Un método público por operación del dominio; nombres en español coherentes con el enunciado.
   - Los métodos de colección no modifican la flota salvo los de registro y eliminación, y lo indican en su documentación (`Javadoc` en los métodos de eliminación).
4. **Criterio de aceptación antes de integrar:** el proyecto debe compilar con `javac -Xlint:all` sin errores ni advertencias y `Main` debe ejecutarse de principio a fin con código de salida 0. Toda integración debe acompañarse de la salida real como evidencia.
5. **Sin dependencias externas:** solo la biblioteca estándar de Java (`java.util.*`), porque el sílabo cubre hasta la sesión 13 y no incluye frameworks.
6. **Control de versiones:** un repositorio en GitHub por equipo; cada integrante sube sus aportes con su propia cuenta. Los mensajes de commit describen el cambio y su relación con la rúbrica (`PA4: ...`).
7. **Documentación:** el `README.md` incluye descripción, integrantes con su distribución de trabajo, instrucciones de ejecución, diseño adoptado y enlace al video; la documentación se actualiza en el mismo commit que el código que describe.
8. **Video:** se graba con cámaras encendidas de todos los integrantes; cada uno explica la parte que implementó y justifica las decisiones técnicas. El enlace se coloca en el README antes de la entrega.

## 3. Reparto del sustento oral (video)

| Integrante | Parte de la exposición |
|---|---|
| César Augusto Maguiña Robles | Jerarquía de clases, clase abstracta `Vehiculo`, interfaz `Inspeccionable`, sobrescritura de `calcularTarifaDiaria()` y `realizarInspeccion()`, y uso de `HashSet` con `equals()`/`hashCode()`. |
| Angel Fernando Reyes Moreno | Colección de objetos y operaciones: recorridos con `for-each` e `iterator()`, búsquedas, ordenamientos con `Comparator`, eliminación con `iterator().remove()` y `removeIf()`, y verificación de la ejecución. |

## 4. Pruebas acordadas

Además de la ejecución de `Main`, el equipo verifica manualmente los siguientes casos antes de cada entrega:

- Registro de un código duplicado con distinta capitalización (`v-101` vs `V-101`): debe omitirse.
- Búsqueda de un código inexistente: debe retornar `null` sin errores.
- Eliminación de un vehículo y re-registro del mismo código: debe permitirlo.
- Ordenamientos: los dos listados deben mostrarse consistentes con las tarifas calculadas y los años.

## 5. Repositorio

- GitHub: `cesarjl2312-svg/curso-poo-pa4` (rama `main`).
- Ambos integrantes tienen acceso de escritura al repositorio.
