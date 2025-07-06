
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problema6_EjectuorSimuladorConflictosBelicos {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Datos predefinidos para simulación
        String[] nacionesDesarrolladas = {"Estados Unidos", "China", "Alemania", "Japón", "Reino Unido", "Francia", "Corea del Sur", "Canadá"};
        String[] nacionesEnDesarrollo = {"Brasil", "India", "México", "Argentina", "Sudáfrica", "Indonesia", "Tailandia", "Colombia"};

        String[] posiblesAliados = {"OTAN", "Unión Europea", "BRICS", "G7", "Mercosur", "ASEAN", "Liga Árabe", "Unión Africana"};

        ArrayList<Nacion> naciones = new ArrayList<>();
        ArrayList<ReporteConflicto> reportes = new ArrayList<>();

        System.out.println("=== SIMULADOR DE CONFLICTOS BÉLICOS MUNDIALES 2025 ===");
        System.out.println("Desarrollado para la ONU");
        System.out.print("Ingrese el nombre de la simulación: ");
        String nombreSimulacion = sc.nextLine();

        System.out.print("Ingrese el período de simulación (ej: 2025-Q1): ");
        String periodoSimulacion = sc.nextLine();

        String continuar = "S";
        int idReporte = 1;
        int totalConflictos = 0;

        do {
            System.out.println("\n--- REGISTRAR NACIONES PARA SIMULACIÓN ---");
            System.out.println("Período: " + periodoSimulacion);

            ArrayList<Nacion> nacionesPeriodo = new ArrayList<>();
            String continuarNaciones = "S";

            do {
                System.out.println("\nSeleccione el tipo de nación:");
                System.out.println("1. Nación Desarrollada (Alta tecnología militar)");
                System.out.println("2. Nación en Vías de Desarrollo (Recursos limitados)");
                System.out.print("Opción: ");

                int tipoNacion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                if (tipoNacion < 1 || tipoNacion > 2) {
                    System.out.println("Tipo inválido. Intente nuevamente.");
                    continue;
                }

                String nombre = "";
                String[] nombresArray = {};

                switch (tipoNacion) {
                    case 1 -> {
                        nombresArray = nacionesDesarrolladas;
                        nombre = nombresArray[random.nextInt(nombresArray.length)];
                    }
                    case 2 -> {
                        nombresArray = nacionesEnDesarrollo;
                        nombre = nombresArray[random.nextInt(nombresArray.length)];
                    }
                }

                String idNacion = "NAC" + String.format("%03d", random.nextInt(999) + 1);
                long habitantes = (long) (10_000_000 + (random.nextDouble() * 1_000_000_000)); // 10M - 1B habitantes
                double recursosEconomicos = 100_000_000 + (random.nextDouble() * 50_000_000_000L); // 100M - 50B USD
                int poderMilitar = random.nextInt(100) + 1; // 1-100

                System.out.println("Nación: " + nombre);
                System.out.println("ID: " + idNacion);
                System.out.println("Habitantes: " + String.format("%,d", habitantes));
                System.out.println("Recursos económicos: $" + String.format("%.0f", recursosEconomicos));
                System.out.println("Poder militar inicial: " + poderMilitar);

                // Crear nación según el tipo
                Nacion nacionCreada = null;

                switch (tipoNacion) {
                    case 1 -> { // Nación Desarrollada
                        boolean tecnologiaAvanzada = random.nextBoolean();
                        int nivelTecnologia = random.nextInt(50) + 50; // 50-100
                        int presupuestoDefensa = random.nextInt(30) + 20; // 20-50% del PIB

                        NacionDesarrollada nacionDev = new NacionDesarrollada(
                                idNacion, nombre, habitantes, recursosEconomicos, poderMilitar,
                                tecnologiaAvanzada, nivelTecnologia, presupuestoDefensa);

                        // Asignar aliados
                        int numAliados = random.nextInt(4) + 1; // 1-4 aliados
                        for (int i = 0; i < numAliados; i++) {
                            String aliado = posiblesAliados[random.nextInt(posiblesAliados.length)];
                            nacionDev.agregarAliado(aliado);
                        }

                        nacionDev.calcularImpacto();
                        nacionCreada = nacionDev;

                        System.out.println("Nación Desarrollada creada:");
                        System.out.println("- Tecnología avanzada: " + (tecnologiaAvanzada ? "Sí" : "No"));
                        System.out.println("- Nivel tecnológico: " + nivelTecnologia + "/100");
                        System.out.println("- Presupuesto defensa: " + presupuestoDefensa + "%");
                        System.out.println("- Poder militar ajustado: " + nacionDev.poderMilitar);
                    }
                    case 2 -> { // Nación en Vías de Desarrollo
                        double recursosLimitados = recursosEconomicos * 0.3; // 30% de recursos disponibles
                        int infraestructura = random.nextInt(60) + 20; // 20-80
                        double deudaExterna = recursosEconomicos * 0.5; // 50% de deuda

                        NacionEnDesarrollo nacionEnDes = new NacionEnDesarrollo(
                                idNacion, nombre, habitantes, recursosEconomicos, poderMilitar,
                                recursosLimitados, infraestructura, deudaExterna);

                        // Asignar menos aliados
                        int numAliados = random.nextInt(3) + 1; // 1-3 aliados
                        for (int i = 0; i < numAliados; i++) {
                            String aliado = posiblesAliados[random.nextInt(posiblesAliados.length)];
                            nacionEnDes.agregarAliado(aliado);
                        }

                        nacionEnDes.calcularImpacto();
                        nacionCreada = nacionEnDes;

                        System.out.println("Nación en Vías de Desarrollo creada:");
                        System.out.println("- Recursos limitados: $" + String.format("%.0f", recursosLimitados));
                        System.out.println("- Infraestructura: " + infraestructura + "/100");
                        System.out.println("- Deuda externa: $" + String.format("%.0f", deudaExterna));
                        System.out.println("- Poder militar ajustado: " + nacionEnDes.poderMilitar);
                    }
                }

                if (nacionCreada != null) {
                    nacionesPeriodo.add(nacionCreada);

                    System.out.println("Estado de conflicto: " + nacionCreada.estadoConflicto);
                    System.out.println("Aliados:");
                    for (String aliado : nacionCreada.aliados) {
                        System.out.println("  - " + aliado);
                    }
                }

                System.out.println("\n¿Desea registrar otra nación? (S/N)");
                continuarNaciones = sc.nextLine().toUpperCase();

            } while (continuarNaciones.equals("S"));

            // Simular conflictos entre naciones
            if (nacionesPeriodo.size() >= 2) {
                System.out.println("\n=== SIMULACIÓN DE CONFLICTOS ===");
                System.out.print("¿Cuántos conflictos desea simular? (máximo "
                        + (nacionesPeriodo.size() * (nacionesPeriodo.size() - 1) / 2) + "): ");
                int numConflictos = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < numConflictos && i < nacionesPeriodo.size() * 2; i++) {
                    // Seleccionar dos naciones aleatoriamente
                    Nacion nacion1 = nacionesPeriodo.get(random.nextInt(nacionesPeriodo.size()));
                    Nacion nacion2;
                    do {
                        nacion2 = nacionesPeriodo.get(random.nextInt(nacionesPeriodo.size()));
                    } while (nacion1 == nacion2);

                    System.out.println("\n--- CONFLICTO " + (i + 1) + " ---");
                    System.out.println("Declaración de conflicto entre:");
                    System.out.println("X " + nacion1.nombre + " (Poder: " + nacion1.poderMilitar + ")");
                    System.out.println("X " + nacion2.nombre + " (Poder: " + nacion2.poderMilitar + ")");

                    int poder1 = nacion1.poderMilitar;
                    int poder2 = nacion2.poderMilitar;

                    System.out.println("Calculando consecuencias del conflicto...");

                    if (poder1 > poder2) {
                        // Nación 1 gana
                        int diferencia = poder1 - poder2;
                        double reduccionPoblacion = 0.05 * diferencia;

                        nacion2.habitantes -= (long) (nacion2.habitantes * reduccionPoblacion / 100);
                        nacion2.recursosEconomicos -= nacion2.recursosEconomicos * 0.10; // 10% de reducción
                        nacion2.estadoConflicto = "Derrotada";
                        nacion1.estadoConflicto = "Victoriosa";

                        System.out.println("Victoria de " + nacion1.nombre);
                        System.out.println(nacion2.nombre + " perdió " + String.format("%.1f", reduccionPoblacion) + "% de población");
                        System.out.println(nacion2.nombre + " perdió 10% de recursos económicos");

                    } else if (poder2 > poder1) {
                        // Nación 2 gana
                        int diferencia = poder2 - poder1;
                        double reduccionPoblacion = 0.05 * diferencia;

                        nacion1.habitantes -= (long) (nacion1.habitantes * reduccionPoblacion / 100);
                        nacion1.recursosEconomicos -= nacion1.recursosEconomicos * 0.10; // 10% de reducción
                        nacion1.estadoConflicto = "Derrotada";
                        nacion2.estadoConflicto = "Victoriosa";

                        System.out.println("Victoria de " + nacion2.nombre);
                        System.out.println(nacion1.nombre + " perdió " + String.format("%.1f", reduccionPoblacion) + "% de población");
                        System.out.println(nacion1.nombre + " perdió 10% de recursos económicos");

                    } else {
                        // Empate
                        nacion1.recursosEconomicos -= nacion1.recursosEconomicos * 0.05; // 5% de reducción
                        nacion2.recursosEconomicos -= nacion2.recursosEconomicos * 0.05; // 5% de reducción
                        nacion1.estadoConflicto = "En conflicto";
                        nacion2.estadoConflicto = "En conflicto";

                        System.out.println("Empate entre " + nacion1.nombre + " y " + nacion2.nombre);
                        System.out.println("Ambas naciones perdieron 5% de recursos económicos");
                    }

                    System.out.println("Estado post-conflicto:");
                    System.out.println("  " + nacion1.nombre + ": " + nacion1.estadoConflicto);
                    System.out.println("  " + nacion2.nombre + ": " + nacion2.estadoConflicto);
                }

                totalConflictos++;
            }

            ReporteConflicto reporte = new ReporteConflicto(idReporte, periodoSimulacion, nombreSimulacion, new ArrayList<>(nacionesPeriodo), totalConflictos);
            reportes.add(reporte);

            // Añadir naciones a la lista general
            naciones.addAll(nacionesPeriodo);

            System.out.println("\n=== REPORTE DE CONFLICTOS GENERADO ===");
            System.out.println(reporte);

            System.out.println("\n=== ESTADO ACTUAL DE NACIONES ===");
            for (Nacion nacion : nacionesPeriodo) {
                System.out.println(nacion);
            }

            System.out.println("\n¿Desea ejecutar otro período de simulación? (S/N)");
            continuar = sc.nextLine().toUpperCase();

            if (continuar.equals("S")) {
                System.out.print("Ingrese el nuevo período: ");
                periodoSimulacion = sc.nextLine();
            }

            idReporte++;

        } while (continuar.equals("S"));

        System.out.println("\n" + "=".repeat(60));
        System.out.println("    REPORTE FINAL - SIMULADOR ONU 2025");
        System.out.println("=".repeat(60));
        System.out.println("Simulación: " + nombreSimulacion);
        System.out.println("Períodos simulados: " + reportes.size());
        System.out.println("Total de naciones: " + naciones.size());
        System.out.println("Total de conflictos simulados: " + totalConflictos);

        long nacionesDesarrolladass = 0;
        long nacionesEnDesarrolloo = 0;
        for (Nacion nacion : naciones) {
            if (nacion instanceof NacionDesarrollada) {
                nacionesDesarrolladass++;
            } else if (nacion instanceof NacionEnDesarrollo) {
                nacionesEnDesarrolloo++;
            }
        }

        System.out.println("\n=== DISTRIBUCIÓN POR TIPO ===");
        System.out.println("Naciones Desarrolladas: " + nacionesDesarrolladas);
        System.out.println("Naciones en Vías de Desarrollo: " + nacionesEnDesarrollo);

        // Estadísticas de conflictos
        long nacionesEnConflicto = 0;
        for (Nacion nacion : naciones) {
            if (nacion.estadoConflicto.equals("En conflicto")) {
                nacionesEnConflicto++;
            }
        }
        System.out.println("\n=== ESTADO DE CONFLICTOS ===");
        System.out.println("Naciones en conflicto: " + nacionesEnConflicto);
        System.out.println("Naciones en paz: " + (naciones.size() - nacionesEnConflicto));

        // Nación más poderosa
        Nacion nacionMasPoderosa = null;
        int mayorPoder = 0;
        for (Nacion nacion : naciones) {
            if (nacion.poderMilitar > mayorPoder) {
                mayorPoder = nacion.poderMilitar;
                nacionMasPoderosa = nacion;
            }
        }

        if (nacionMasPoderosa != null) {
            System.out.println("\n=== NACIÓN MÁS PODEROSA ===");
            System.out.println(nacionMasPoderosa.nombre + " (Poder: " + nacionMasPoderosa.poderMilitar + ")");
        }

        System.out.println("\n=== HISTORIAL DE SIMULACIONES ===");
        for (ReporteConflicto reporte : reportes) {
            System.out.println("Reporte " + reporte.id + " - " + reporte.periodo
                    + " (" + reporte.naciones.size() + " naciones, "
                    + reporte.conflictosSimulados + " conflictos)");
        }

    }

}

abstract class Nacion {

    public String id;
    public String nombre;
    public long habitantes;
    public double recursosEconomicos;
    public int poderMilitar;
    public String estadoConflicto;
    public ArrayList<String> aliados;

    public Nacion(String id, String nombre, long habitantes, double recursosEconomicos, int poderMilitar) {
        this.id = id;
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.recursosEconomicos = recursosEconomicos;
        this.poderMilitar = Math.min(Math.max(poderMilitar, 1), 100); // Restricción 1-100
        this.estadoConflicto = "En paz";
        this.aliados = new ArrayList<>();
    }

    public abstract void calcularImpacto();

    public void agregarAliado(String aliado) {
        if (!aliados.contains(aliado)) {
            aliados.add(aliado);
        }
    }

    public void aplicarBonusAliados() {
        if (!aliados.isEmpty()) {
            int bonusAliados = aliados.size() * 2; // 2 puntos por aliado
            this.poderMilitar = Math.min(this.poderMilitar + bonusAliados, 100);
        }
    }

    @Override
    public String toString() {
        return "Nacion{" + "id=" + id + ", nombre=" + nombre
                + ", habitantes=" + String.format("%,d", habitantes)
                + ", recursos=$" + String.format("%.0f", recursosEconomicos)
                + ", poderMilitar=" + poderMilitar
                + ", estado=" + estadoConflicto
                + ", aliados=" + aliados.size() + '}';
    }
}

class NacionDesarrollada extends Nacion {

    public boolean tecnologiaAvanzada;
    public int nivelTecnologia;
    public int presupuestoDefensa;

    public NacionDesarrollada(String id, String nombre, long habitantes, double recursosEconomicos,
            int poderMilitar, boolean tecnologiaAvanzada, int nivelTecnologia,
            int presupuestoDefensa) {
        super(id, nombre, habitantes, recursosEconomicos, poderMilitar);
        this.tecnologiaAvanzada = tecnologiaAvanzada;
        this.nivelTecnologia = nivelTecnologia;
        this.presupuestoDefensa = presupuestoDefensa;
    }

    @Override
    public void calcularImpacto() {
        // Bono por tecnología avanzada
        if (tecnologiaAvanzada) {
            int bonoTecnologia = (int) (nivelTecnologia * 0.3); // 30% del nivel tecnológico
            this.poderMilitar = Math.min(this.poderMilitar + bonoTecnologia, 100);
        }

        // Bono por presupuesto de defensa
        if (presupuestoDefensa > 40) {
            int bonoPresupuesto = (presupuestoDefensa - 40) / 2; // Bono extra si >40%
            this.poderMilitar = Math.min(this.poderMilitar + bonoPresupuesto, 100);
        }

        // Aplicar bonus por aliados
        aplicarBonusAliados();
    }

    @Override
    public String toString() {
        return "NacionDesarrollada{" + "id=" + id + ", nombre=" + nombre
                + ", habitantes=" + String.format("%,d", habitantes)
                + ", recursos=$" + String.format("%.0f", recursosEconomicos)
                + ", poderMilitar=" + poderMilitar
                + ", tecnologiaAvanzada=" + tecnologiaAvanzada
                + ", nivelTecnologia=" + nivelTecnologia
                + ", presupuestoDefensa=" + presupuestoDefensa + "%"
                + ", estado=" + estadoConflicto
                + ", aliados=" + aliados.size() + '}';
    }
}

class NacionEnDesarrollo extends Nacion {

    public double recursosLimitados;
    public int infraestructura;
    public double deudaExterna;

    public NacionEnDesarrollo(String id, String nombre, long habitantes, double recursosEconomicos,
            int poderMilitar, double recursosLimitados, int infraestructura,
            double deudaExterna) {
        super(id, nombre, habitantes, recursosEconomicos, poderMilitar);
        this.recursosLimitados = recursosLimitados;
        this.infraestructura = infraestructura;
        this.deudaExterna = deudaExterna;
    }

    @Override
    public void calcularImpacto() {
        // Reducción por recursos limitados
        double factorRecursos = recursosLimitados / recursosEconomicos;
        int reduccionRecursos = (int) ((1 - factorRecursos) * 20); // Máximo 20 puntos de reducción

        // Reducción por infraestructura deficiente
        int reduccionInfraestructura = (100 - infraestructura) / 5; // Reducción basada en infraestructura

        // Reducción por deuda externa
        double ratioDeuda = deudaExterna / recursosEconomicos;
        int reduccionDeuda = (int) (ratioDeuda * 10); // Máximo 10 puntos por deuda

        // Aplicar reducciones
        this.poderMilitar = Math.max(this.poderMilitar - reduccionRecursos
                - reduccionInfraestructura - reduccionDeuda, 1);

        // Aplicar bonus por aliados (menor impacto)
        if (!aliados.isEmpty()) {
            int bonusAliados = aliados.size(); // 1 punto por aliado
            this.poderMilitar = Math.min(this.poderMilitar + bonusAliados, 100);
        }
    }

    @Override
    public String toString() {
        return "NacionEnDesarrollo{" + "id=" + id + ", nombre=" + nombre
                + ", habitantes=" + String.format("%,d", habitantes)
                + ", recursos=$" + String.format("%.0f", recursosEconomicos)
                + ", poderMilitar=" + poderMilitar
                + ", recursosLimitados=$" + String.format("%.0f", recursosLimitados)
                + ", infraestructura=" + infraestructura + "/100"
                + ", deudaExterna=$" + String.format("%.0f", deudaExterna)
                + ", estado=" + estadoConflicto
                + ", aliados=" + aliados.size() + '}';
    }
}

class ReporteConflicto {

    public int id;
    public String periodo;
    public String nombreSimulacion;
    public ArrayList<Nacion> naciones;
    public int conflictosSimulados;
    public long poblacionTotal;
    public double recursosTotal;

    public ReporteConflicto(int id, String periodo, String nombreSimulacion,
            ArrayList<Nacion> naciones, int conflictosSimulados) {
        this.id = id;
        this.periodo = periodo;
        this.nombreSimulacion = nombreSimulacion;
        this.naciones = new ArrayList<>(naciones);
        this.conflictosSimulados = conflictosSimulados;
        this.calcularTotales();
    }

    public void calcularTotales() {
        this.poblacionTotal = 0;
        this.recursosTotal = 0;
        for (Nacion nacion : naciones) {
            this.poblacionTotal += nacion.habitantes;
            this.recursosTotal += nacion.recursosEconomicos;
        }
    }

    @Override
    public String toString() {
        return "ReporteConflicto{" + "id=" + id + ", periodo=" + periodo
                + ", simulacion=" + nombreSimulacion + ", naciones=" + naciones.size()
                + ", conflictos=" + conflictosSimulados
                + ", poblacionTotal=" + String.format("%,d", poblacionTotal)
                + ", recursosTotal=$" + String.format("%.0f", recursosTotal) + '}';
    }
}
