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
                sc.nextLine(); 
                
                if (tipoRegion < 1 || tipoRegion > 3) {
                    System.out.println("Región inválida. Intente nuevamente.");
                    continue;
                }
                

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
                

                Dispositivo dispositivoCreado = null;
                
                switch (tipoRegion) {
                    case 1 -> {
                        double temperatura = 22.0 + (random.nextDouble() * 13.0); 
                        double precipitacion = random.nextDouble() * 300.0; 
                        double humedad = 60.0 + (random.nextDouble() * 35.0);
                        double salinidad = random.nextDouble() * 5.0; 
                        
                        DispositivoCosta deviceCosta = new DispositivoCosta(idDispositivo, ubicacion, temperatura, precipitacion, humedad, salinidad);
                        deviceCosta.procesarDatos();
                        deviceCosta.detectarRiesgos();
                        dispositivoCreado = deviceCosta;
                        System.out.println(dispositivoCreado);
                    }
                    case 2 -> { 
                        double temperatura = 5.0 + (random.nextDouble() * 20.0); 
                        double precipitacion = random.nextDouble() * 200.0; 
                        double altitud = 2000.0 + (random.nextDouble() * 2500.0); 
                        double estabilidadSuelo = random.nextDouble() * 10.0; 
                        
                        DispositivoSierra deviceSierra = new DispositivoSierra(idDispositivo, ubicacion, temperatura, precipitacion, altitud, estabilidadSuelo);
                        deviceSierra.procesarDatos();
                        deviceSierra.detectarRiesgos();
                        dispositivoCreado = deviceSierra;
                        
                        System.out.println(dispositivoCreado);
                    }
                    case 3 -> {
                        double temperatura = 20.0 + (random.nextDouble() * 12.0);
                        double precipitacion = 100.0 + (random.nextDouble() * 400.0); 
                        double humedad = 70.0 + (random.nextDouble() * 25.0); 
                        double calidadAire = random.nextDouble() * 100.0; 
                        double biodiversidad = random.nextDouble() * 10.0;
                        
                        DispositivoOriente deviceOriente = new DispositivoOriente(idDispositivo, ubicacion, temperatura, precipitacion, humedad, calidadAire, biodiversidad);
                        deviceOriente.procesarDatos();
                        deviceOriente.detectarRiesgos();
                        dispositivoCreado = deviceOriente;
                        
                        System.out.println(dispositivoCreado);
                    }
                }
                
                if (dispositivoCreado != null) {
                    dispositivosReporte.add(dispositivoCreado);
                    System.out.println("Riesgos detectados: " + dispositivoCreado.numeroRiesgos);
                    for (String riesgo : dispositivoCreado.riesgosDetectados) {
                        System.out.println(riesgo);
                    }
                }
                
                System.out.println("\n¿Desea instalar otro dispositivo en este período? (S/N)");
                continuarDispositivos = sc.nextLine().toUpperCase();
                
            } while (continuarDispositivos.equals("S"));

            ReporteAmbiental reporte = new ReporteAmbiental(idReporte, periodoMonitoreo, nombreRed, dispositivosReporte);
            reporte.calcularTotalRiesgos();
            reportes.add(reporte);
            

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
        
        int dispositivosCosta = 0;
        int dispositivosSierra = 0;
        int dispositivosOriente = 0;

        for (Dispositivo d : dispositivos) {
            if (d instanceof DispositivoCosta) {
                dispositivosCosta++;
            } else if (d instanceof DispositivoSierra) {
                dispositivosSierra++;
            } else if (d instanceof DispositivoOriente) {
                dispositivosOriente++;
            }
        }
        
        System.out.println("\n=== DISTRIBUCIÓN POR REGIÓN ===");
        System.out.println("Costa: " + dispositivosCosta + " dispositivos");
        System.out.println("Sierra: " + dispositivosSierra + " dispositivos");
        System.out.println("Oriente: " + dispositivosOriente + " dispositivos");
        
        System.out.println("\n=== HISTORIAL DE REPORTES ===");
        for (ReporteAmbiental reporte : reportes) {
            System.out.println("Reporte " + reporte.id + " - " + reporte.periodo + " (" + reporte.dispositivos.size() + " dispositivos)");
        }
        
    }
}

abstract class Dispositivo {
    public String id;
    public String ubicacion;
    public double temperatura;
    public double precipitacion;
    public String estado;
    public ArrayList<String> riesgosDetectados = new ArrayList<>();
    public int numeroRiesgos;
    
    
    public Dispositivo(String id, String ubicacion, double temperatura, double precipitacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.temperatura = temperatura;
        this.precipitacion = precipitacion;
        this.estado = "Activo";
    }
    
    public abstract void procesarDatos();
    public abstract void detectarRiesgos();
    
    @Override
    public String toString() {
        return "Dispositivo{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + "} ";
    }
}

class DispositivoCosta extends Dispositivo {
    public double humedad;
    public double salinidad;
    
    public DispositivoCosta(String id, String ubicacion, double temperatura, double precipitacion, double humedad, double salinidad) {
        super(id, ubicacion, temperatura, precipitacion);
        this.humedad = humedad;
        this.salinidad = salinidad;
    }
    
    @Override
    public void procesarDatos() {

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
      

        if (temperatura > 33) {
            riesgosDetectados.add("Ola de calor extrema");
            super.numeroRiesgos++;
        }
        if (precipitacion > 250) {
            riesgosDetectados.add("Riesgo de inundación costera");
            super.numeroRiesgos++;
        }
        if (humedad > 90) {
            riesgosDetectados.add("Condiciones de alta humedad");
            super.numeroRiesgos++;
        }
        if (salinidad > 4.0) {
            riesgosDetectados.add("Salinización del suelo");
            super.numeroRiesgos++;
        }
        if (precipitacion < 20) {
            riesgosDetectados.add("Sequía costera");
            super.numeroRiesgos++;
        }
    }
    
    @Override
    public String toString() {
        return "DispositivoCosta{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, humedad=" + String.format("%.1f", humedad) + "%, salinidad=" + String.format("%.2f", salinidad) + "ppt, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + "} "+ super.toString();
    }
}

class DispositivoSierra extends Dispositivo {
    public double altitud;
    public double estabilidadSuelo;
    
    public DispositivoSierra(String id, String ubicacion, double temperatura, double precipitacion, double altitud, double estabilidadSuelo) {
        super(id, ubicacion, temperatura, precipitacion);
        this.altitud = altitud;
        this.estabilidadSuelo = estabilidadSuelo;
    }
    
    @Override
    public void procesarDatos() {
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

        if (temperatura < 5) {
            riesgosDetectados.add("Riesgo de heladas");
            super.numeroRiesgos++;
        }
        if (precipitacion > 150 && estabilidadSuelo < 4) {
            riesgosDetectados.add("Alto riesgo de deslizamiento");
            super.numeroRiesgos++;
        }
        if (estabilidadSuelo < 2) {
            riesgosDetectados.add("Terreno muy inestable");
            super.numeroRiesgos++;
        }
        if (altitud > 4000 && temperatura < 10) {
            riesgosDetectados.add("Condiciones de páramo extremas");
            super.numeroRiesgos++;
        }
        if (precipitacion < 30) {
            riesgosDetectados.add("Sequía en zona montañosa");
            super.numeroRiesgos++;
        }
    }
    
    @Override
    public String toString() {
        return "DispositivoSierra{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, altitud=" + String.format("%.0f", altitud) + "m, estabilidadSuelo=" + String.format("%.1f", estabilidadSuelo) + "/10, estado=" + estado + ", riesgos=" + riesgosDetectados.size() +"} " + super.toString();
    }
}

class DispositivoOriente extends Dispositivo {
    public double humedad;
    public double calidadAire;
    public double biodiversidad;
    
    public DispositivoOriente(String id, String ubicacion, double temperatura, double precipitacion, double humedad, double calidadAire, double biodiversidad) {
        super(id, ubicacion, temperatura, precipitacion);
        this.humedad = humedad;
        this.calidadAire = calidadAire;
        this.biodiversidad = biodiversidad;
    }
    
    @Override
    public void procesarDatos() {

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

        
        if (calidadAire > 75) {
            riesgosDetectados.add("Contaminación del aire");
            super.numeroRiesgos++;
        }
        if (precipitacion > 400) {
            riesgosDetectados.add("Riesgo de inundación amazónica");
            super.numeroRiesgos++;
        }
        if (biodiversidad < 2) {
            riesgosDetectados.add("Pérdida crítica de biodiversidad");
            super.numeroRiesgos++;
        }
        if (humedad < 75) {
            riesgosDetectados.add("Sequía en selva tropical");
            super.numeroRiesgos++;
        }
        if (temperatura > 30 && humedad > 90) {
            riesgosDetectados.add("Estrés térmico tropical");
            super.numeroRiesgos++;
        }
    }
    
    @Override
    public String toString() {
        return "DispositivoOriente{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, humedad=" + String.format("%.1f", humedad) + "%, calidadAire=" + String.format("%.1f", calidadAire) + "ICA, biodiversidad=" + String.format("%.1f", biodiversidad) + "/10, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + "} " + super.toString();
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
    }
    
    public void calcularTotalRiesgos() {
        this.totalRiesgos = 0;
        for (Dispositivo dispositivo : dispositivos) {
            this.totalRiesgos += dispositivo.numeroRiesgos;
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