import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problema4_EjectuorMonitoreoClimatico {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);


        String[] ubicacionesCosta = {"Guayaquil", "Machala", "Esmeraldas", "Manta", "Portoviejo", "Salinas", "Babahoyo"};
        String[] ubicacionesSierra = {"Quito", "Cuenca", "Ambato", "Riobamba", "Loja", "Ibarra", "Latacunga"};
        String[] ubicacionesOriente = {"Puyo", "Macas", "Tena", "Coca", "Zamora", "Sucúa", "Shushufindi"};

        ArrayList<Dispositivo> dispositivos = new ArrayList<>();
        ArrayList<ReporteAmbiental> reportes = new ArrayList<>();
        
        System.out.println("=== SISTEMA DE MONITOREO CLIMÁTICO ECUADOR ===");
        System.out.print("Ingrese el nombre de la red de monitoreo: ");
        String nombreRed = sc.nextLine();
        
        System.out.print("Ingrese el período de monitoreo (ej: Enero 2024): ");
        String periodoMonitoreo = sc.nextLine();
        
        String continuar = "S";
        int idReporte = 1;
        
        do {
            System.out.println("\n--- REGISTRAR DISPOSITIVOS DE MONITOREO ---");
            System.out.println("Período: " + periodoMonitoreo);
            
            ArrayList<Dispositivo> dispositivosReporte = new ArrayList<>();
            String continuarDispositivos = "S";
            
            do {
                System.out.println("\nSeleccione la región para instalar dispositivo:");
                System.out.println("1. Costa");
                System.out.println("2. Sierra");
                System.out.println("3. Oriente");
                System.out.print("Opción: ");
                
                int tipoRegion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                
                if (tipoRegion < 1 || tipoRegion > 3) {
                    System.out.println("Región inválida. Intente nuevamente.");
                    continue;
                }
                
                // Generar datos aleatorios del dispositivo
                String ubicacion = "";
                String[] ubicacionesArray = {};
                
                switch (tipoRegion) {
                    case 1 -> {
                        ubicacionesArray = ubicacionesCosta;
                        ubicacion = ubicacionesArray[random.nextInt(ubicacionesArray.length)];
                    }
                    case 2 -> {
                        ubicacionesArray = ubicacionesSierra;
                        ubicacion = ubicacionesArray[random.nextInt(ubicacionesArray.length)];
                    }
                    case 3 -> {
                        ubicacionesArray = ubicacionesOriente;
                        ubicacion = ubicacionesArray[random.nextInt(ubicacionesArray.length)];
                    }
                }
                
                String idDispositivo = "DEV" + String.format("%03d", random.nextInt(999) + 1);
                
                System.out.println("Ubicación seleccionada: " + ubicacion);
                System.out.println("ID del dispositivo: " + idDispositivo);
                
                // Crear dispositivo según la región
                Dispositivo dispositivoCreado = null;
                
                switch (tipoRegion) {
                    case 1 -> { // Costa
                        double temperatura = 22.0 + (random.nextDouble() * 13.0); // 22-35°C
                        double precipitacion = random.nextDouble() * 300.0; // 0-300mm
                        double humedad = 60.0 + (random.nextDouble() * 35.0); // 60-95%
                        double salinidad = random.nextDouble() * 5.0; // 0-5 ppt
                        
                        DispositivoCosta deviceCosta = new DispositivoCosta(idDispositivo, ubicacion, temperatura, precipitacion, humedad, salinidad);
                        deviceCosta.procesarDatos();
                        deviceCosta.detectarRiesgos();
                        dispositivoCreado = deviceCosta;
                        
                        System.out.println("Dispositivo Costa instalado:");
                        System.out.println("- Temperatura: " + String.format("%.1f", temperatura) + "°C");
                        System.out.println("- Precipitación: " + String.format("%.1f", precipitacion) + "mm");
                        System.out.println("- Humedad: " + String.format("%.1f", humedad) + "%");
                        System.out.println("- Salinidad: " + String.format("%.2f", salinidad) + " ppt");
                    }
                    case 2 -> { // Sierra
                        double temperatura = 5.0 + (random.nextDouble() * 20.0); // 5-25°C
                        double precipitacion = random.nextDouble() * 200.0; // 0-200mm
                        double altitud = 2000.0 + (random.nextDouble() * 2500.0); // 2000-4500m
                        double estabilidadSuelo = random.nextDouble() * 10.0; // 0-10 (índice)
                        
                        DispositivoSierra deviceSierra = new DispositivoSierra(idDispositivo, ubicacion, temperatura, precipitacion, altitud, estabilidadSuelo);
                        deviceSierra.procesarDatos();
                        deviceSierra.detectarRiesgos();
                        dispositivoCreado = deviceSierra;
                        
                        System.out.println("Dispositivo Sierra instalado:");
                        System.out.println("- Temperatura: " + String.format("%.1f", temperatura) + "°C");
                        System.out.println("- Precipitación: " + String.format("%.1f", precipitacion) + "mm");
                        System.out.println("- Altitud: " + String.format("%.0f", altitud) + "m");
                        System.out.println("- Estabilidad del suelo: " + String.format("%.1f", estabilidadSuelo) + "/10");
                    }
                    case 3 -> { // Oriente
                        double temperatura = 20.0 + (random.nextDouble() * 12.0); // 20-32°C
                        double precipitacion = 100.0 + (random.nextDouble() * 400.0); // 100-500mm
                        double humedad = 70.0 + (random.nextDouble() * 25.0); // 70-95%
                        double calidadAire = random.nextDouble() * 100.0; // 0-100 ICA
                        double biodiversidad = random.nextDouble() * 10.0; // 0-10 índice
                        
                        DispositivoOriente deviceOriente = new DispositivoOriente(idDispositivo, ubicacion, temperatura, precipitacion, humedad, calidadAire, biodiversidad);
                        deviceOriente.procesarDatos();
                        deviceOriente.detectarRiesgos();
                        dispositivoCreado = deviceOriente;
                        
                        System.out.println("Dispositivo Oriente instalado:");
                        System.out.println("- Temperatura: " + String.format("%.1f", temperatura) + "°C");
                        System.out.println("- Precipitación: " + String.format("%.1f", precipitacion) + "mm");
                        System.out.println("- Humedad: " + String.format("%.1f", humedad) + "%");
                        System.out.println("- Calidad del aire: " + String.format("%.1f", calidadAire) + " ICA");
                        System.out.println("- Biodiversidad: " + String.format("%.1f", biodiversidad) + "/10");
                    }
                }
                
                if (dispositivoCreado != null) {
                    dispositivosReporte.add(dispositivoCreado);
                    System.out.println("Riesgos detectados: " + dispositivoCreado.riesgosDetectados.size());
                    for (String riesgo : dispositivoCreado.riesgosDetectados) {
                        System.out.println("  " + riesgo);
                    }
                }
                
                System.out.println("\n¿Desea instalar otro dispositivo en este período? (S/N)");
                continuarDispositivos = sc.nextLine().toUpperCase();
                
            } while (continuarDispositivos.equals("S"));
            
            // Crear reporte ambiental
            ReporteAmbiental reporte = new ReporteAmbiental(idReporte, periodoMonitoreo, nombreRed, dispositivosReporte);
            reportes.add(reporte);
            
            // Añadir dispositivos a la lista general
            dispositivos.addAll(dispositivosReporte);
            
            System.out.println("\n=== REPORTE AMBIENTAL GENERADO ===");
            System.out.println(reporte);
            
            System.out.println("\n=== DISPOSITIVOS INSTALADOS ===");
            for (Dispositivo dispositivo : dispositivosReporte) {
                System.out.println(dispositivo);
            }
            
            // Análisis de riesgos críticos
            ArrayList<String> riesgosCriticos = reporte.obtenerRiesgosCriticos();
            if (!riesgosCriticos.isEmpty()) {
                System.out.println("\n RIESGOS CRÍTICOS DETECTADOS:");
                for (String riesgo : riesgosCriticos) {
                    System.out.println("- " + riesgo);
                }
            }
            
            System.out.println("\n¿Desea registrar otro período de monitoreo? (S/N)");
            continuar = sc.nextLine().toUpperCase();
            
            if (continuar.equals("S")) {
                System.out.print("Ingrese el nuevo período de monitoreo: ");
                periodoMonitoreo = sc.nextLine();
            }
            
            idReporte++;
            
        } while (continuar.equals("S"));
        
        System.out.println("\n=== RESUMEN FINAL DEL SISTEMA ===");
        System.out.println("Red de monitoreo: " + nombreRed);
        System.out.println("Períodos monitoreados: " + reportes.size());
        System.out.println("Total de dispositivos instalados: " + dispositivos.size());
        
        // Estadísticas por región
        long dispositivosCosta = dispositivos.stream().filter(d -> d instanceof DispositivoCosta).count();
        long dispositivosSierra = dispositivos.stream().filter(d -> d instanceof DispositivoSierra).count();
        long dispositivosOriente = dispositivos.stream().filter(d -> d instanceof DispositivoOriente).count();
        
        System.out.println("\n=== DISTRIBUCIÓN POR REGIÓN ===");
        System.out.println("Costa: " + dispositivosCosta + " dispositivos");
        System.out.println("Sierra: " + dispositivosSierra + " dispositivos");
        System.out.println("Oriente: " + dispositivosOriente + " dispositivos");
        
        System.out.println("\n=== HISTORIAL DE REPORTES ===");
        for (ReporteAmbiental reporte : reportes) {
            System.out.println("Reporte " + reporte.id + " - " + reporte.periodo + " (" + reporte.dispositivos.size() + " dispositivos)");
        }
        
        sc.close();
    }
}

abstract class Dispositivo {
    protected String id;
    protected String ubicacion;
    protected double temperatura;
    protected double precipitacion;
    protected String estado;
    protected ArrayList<String> riesgosDetectados;
    
    public Dispositivo(String id, String ubicacion, double temperatura, double precipitacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.temperatura = temperatura;
        this.precipitacion = precipitacion;
        this.estado = "Activo";
        this.riesgosDetectados = new ArrayList<>();
    }
    
    public abstract void procesarDatos();
    public abstract void detectarRiesgos();
    
    @Override
    public String toString() {
        return "Dispositivo{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + '}';
    }
}

class DispositivoCosta extends Dispositivo {
    private double humedad;
    private double salinidad;
    
    public DispositivoCosta(String id, String ubicacion, double temperatura, double precipitacion, double humedad, double salinidad) {
        super(id, ubicacion, temperatura, precipitacion);
        this.humedad = humedad;
        this.salinidad = salinidad;
    }
    
    @Override
    public void procesarDatos() {
        // Protocolo específico para la costa
        if (temperatura > 32) {
            estado = "Temperatura Alta";
        } else if (humedad > 90) {
            estado = "Humedad Crítica";
        } else {
            estado = "Normal";
        }
    }
    
    @Override
    public void detectarRiesgos() {
        riesgosDetectados.clear();
        
        // Riesgos específicos de la costa
        if (temperatura > 33) {
            riesgosDetectados.add("Ola de calor extrema");
        }
        if (precipitacion > 250) {
            riesgosDetectados.add("Riesgo de inundación costera");
        }
        if (humedad > 90) {
            riesgosDetectados.add("Condiciones de alta humedad");
        }
        if (salinidad > 4.0) {
            riesgosDetectados.add("Salinización del suelo");
        }
        if (precipitacion < 20) {
            riesgosDetectados.add("Sequía costera");
        }
    }
    
    @Override
    public String toString() {
        return "DispositivoCosta{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, humedad=" + String.format("%.1f", humedad) + "%, salinidad=" + String.format("%.2f", salinidad) + "ppt, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + '}';
    }
}

class DispositivoSierra extends Dispositivo {
    private double altitud;
    private double estabilidadSuelo;
    
    public DispositivoSierra(String id, String ubicacion, double temperatura, double precipitacion, double altitud, double estabilidadSuelo) {
        super(id, ubicacion, temperatura, precipitacion);
        this.altitud = altitud;
        this.estabilidadSuelo = estabilidadSuelo;
    }
    
    @Override
    public void procesarDatos() {
        // Protocolo específico para la sierra
        if (temperatura < 8) {
            estado = "Temperatura Baja";
        } else if (estabilidadSuelo < 3) {
            estado = "Suelo Inestable";
        } else {
            estado = "Normal";
        }
    }
    
    @Override
    public void detectarRiesgos() {
        riesgosDetectados.clear();
        
        // Riesgos específicos de la sierra
        if (temperatura < 5) {
            riesgosDetectados.add("Riesgo de heladas");
        }
        if (precipitacion > 150 && estabilidadSuelo < 4) {
            riesgosDetectados.add("Alto riesgo de deslizamiento");
        }
        if (estabilidadSuelo < 2) {
            riesgosDetectados.add("Terreno muy inestable");
        }
        if (altitud > 4000 && temperatura < 10) {
            riesgosDetectados.add("Condiciones de páramo extremas");
        }
        if (precipitacion < 30) {
            riesgosDetectados.add("Sequía en zona montañosa");
        }
    }
    
    @Override
    public String toString() {
        return "DispositivoSierra{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, altitud=" + String.format("%.0f", altitud) + "m, estabilidadSuelo=" + String.format("%.1f", estabilidadSuelo) + "/10, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + '}';
    }
}

class DispositivoOriente extends Dispositivo {
    private double humedad;
    private double calidadAire;
    private double biodiversidad;
    
    public DispositivoOriente(String id, String ubicacion, double temperatura, double precipitacion, double humedad, double calidadAire, double biodiversidad) {
        super(id, ubicacion, temperatura, precipitacion);
        this.humedad = humedad;
        this.calidadAire = calidadAire;
        this.biodiversidad = biodiversidad;
    }
    
    @Override
    public void procesarDatos() {
        // Protocolo específico para el oriente
        if (calidadAire > 80) {
            estado = "Aire Contaminado";
        } else if (biodiversidad < 3) {
            estado = "Biodiversidad Baja";
        } else {
            estado = "Normal";
        }
    }
    
    @Override
    public void detectarRiesgos() {
        riesgosDetectados.clear();
        
        // Riesgos específicos del oriente
        if (calidadAire > 75) {
            riesgosDetectados.add("Contaminación del aire");
        }
        if (precipitacion > 400) {
            riesgosDetectados.add("Riesgo de inundación amazónica");
        }
        if (biodiversidad < 2) {
            riesgosDetectados.add("Pérdida crítica de biodiversidad");
        }
        if (humedad < 75) {
            riesgosDetectados.add("Sequía en selva tropical");
        }
        if (temperatura > 30 && humedad > 90) {
            riesgosDetectados.add("Estrés térmico tropical");
        }
    }
    
    @Override
    public String toString() {
        return "DispositivoOriente{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, humedad=" + String.format("%.1f", humedad) + "%, calidadAire=" + String.format("%.1f", calidadAire) + "ICA, biodiversidad=" + String.format("%.1f", biodiversidad) + "/10, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + '}';
    }
}

class ReporteAmbiental {
    public int id;
    public String periodo;
    public String redMonitoreo;
    public ArrayList<Dispositivo> dispositivos;
    public int totalRiesgos;
    
    public ReporteAmbiental(int id, String periodo, String redMonitoreo, ArrayList<Dispositivo> dispositivos) {
        this.id = id;
        this.periodo = periodo;
        this.redMonitoreo = redMonitoreo;
        this.dispositivos = new ArrayList<>(dispositivos);
        this.calcularTotalRiesgos();
    }
    
    private void calcularTotalRiesgos() {
        this.totalRiesgos = 0;
        for (Dispositivo dispositivo : dispositivos) {
            this.totalRiesgos += dispositivo.riesgosDetectados.size();
        }
    }
    
    public ArrayList<String> obtenerRiesgosCriticos() {
        ArrayList<String> riesgosCriticos = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivos) {
            for (String riesgo : dispositivo.riesgosDetectados) {
                if (riesgo.contains("extrema") || riesgo.contains("crítica") || riesgo.contains("Alto riesgo") || riesgo.contains("muy inestable")) {
                    riesgosCriticos.add(dispositivo.ubicacion + ": " + riesgo);
                }
            }
        }
        return riesgosCriticos;
    }
    
    @Override
    public String toString() {
        return "ReporteAmbiental{" + "id=" + id + ", periodo=" + periodo + ", redMonitoreo=" + redMonitoreo + ", dispositivos=" + dispositivos.size() + ", totalRiesgos=" + totalRiesgos + '}';
    }
}