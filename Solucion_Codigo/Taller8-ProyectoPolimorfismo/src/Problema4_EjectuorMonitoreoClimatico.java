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
<<<<<<< HEAD
                sc.nextLine(); 
=======
                sc.nextLine(); // Limpiar buffer
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                
                if (tipoRegion < 1 || tipoRegion > 3) {
                    System.out.println("Región inválida. Intente nuevamente.");
                    continue;
                }
                
<<<<<<< HEAD

=======
                // Generar datos aleatorios del dispositivo
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
                
<<<<<<< HEAD

                Dispositivo dispositivoCreado = null;
                
                switch (tipoRegion) {
                    case 1 -> {
                        double temperatura = 22.0 + (random.nextDouble() * 13.0); 
                        double precipitacion = random.nextDouble() * 300.0; 
                        double humedad = 60.0 + (random.nextDouble() * 35.0);
                        double salinidad = random.nextDouble() * 5.0; 
=======
                // Crear dispositivo según la región
                Dispositivo dispositivoCreado = null;
                
                switch (tipoRegion) {
                    case 1 -> { // Costa
                        double temperatura = 22.0 + (random.nextDouble() * 13.0); // 22-35°C
                        double precipitacion = random.nextDouble() * 300.0; // 0-300mm
                        double humedad = 60.0 + (random.nextDouble() * 35.0); // 60-95%
                        double salinidad = random.nextDouble() * 5.0; // 0-5 ppt
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                        
                        DispositivoCosta deviceCosta = new DispositivoCosta(idDispositivo, ubicacion, temperatura, precipitacion, humedad, salinidad);
                        deviceCosta.procesarDatos();
                        deviceCosta.detectarRiesgos();
                        dispositivoCreado = deviceCosta;
<<<<<<< HEAD
                        System.out.println(dispositivoCreado);
                    }
                    case 2 -> { 
                        double temperatura = 5.0 + (random.nextDouble() * 20.0); 
                        double precipitacion = random.nextDouble() * 200.0; 
                        double altitud = 2000.0 + (random.nextDouble() * 2500.0); 
                        double estabilidadSuelo = random.nextDouble() * 10.0; 
=======
                        
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
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                        
                        DispositivoSierra deviceSierra = new DispositivoSierra(idDispositivo, ubicacion, temperatura, precipitacion, altitud, estabilidadSuelo);
                        deviceSierra.procesarDatos();
                        deviceSierra.detectarRiesgos();
                        dispositivoCreado = deviceSierra;
                        
<<<<<<< HEAD
                        System.out.println(dispositivoCreado);
                    }
                    case 3 -> {
                        double temperatura = 20.0 + (random.nextDouble() * 12.0);
                        double precipitacion = 100.0 + (random.nextDouble() * 400.0); 
                        double humedad = 70.0 + (random.nextDouble() * 25.0); 
                        double calidadAire = random.nextDouble() * 100.0; 
                        double biodiversidad = random.nextDouble() * 10.0;
=======
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
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                        
                        DispositivoOriente deviceOriente = new DispositivoOriente(idDispositivo, ubicacion, temperatura, precipitacion, humedad, calidadAire, biodiversidad);
                        deviceOriente.procesarDatos();
                        deviceOriente.detectarRiesgos();
                        dispositivoCreado = deviceOriente;
                        
<<<<<<< HEAD
                        System.out.println(dispositivoCreado);
=======
                        System.out.println("Dispositivo Oriente instalado:");
                        System.out.println("- Temperatura: " + String.format("%.1f", temperatura) + "°C");
                        System.out.println("- Precipitación: " + String.format("%.1f", precipitacion) + "mm");
                        System.out.println("- Humedad: " + String.format("%.1f", humedad) + "%");
                        System.out.println("- Calidad del aire: " + String.format("%.1f", calidadAire) + " ICA");
                        System.out.println("- Biodiversidad: " + String.format("%.1f", biodiversidad) + "/10");
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                    }
                }
                
                if (dispositivoCreado != null) {
                    dispositivosReporte.add(dispositivoCreado);
<<<<<<< HEAD
                    System.out.println("Riesgos detectados: " + dispositivoCreado.numeroRiesgos);
                    for (String riesgo : dispositivoCreado.riesgosDetectados) {
                        System.out.println(riesgo);
=======
                    System.out.println("Riesgos detectados: " + dispositivoCreado.riesgosDetectados.size());
                    for (String riesgo : dispositivoCreado.riesgosDetectados) {
                        System.out.println("  " + riesgo);
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                    }
                }
                
                System.out.println("\n¿Desea instalar otro dispositivo en este período? (S/N)");
                continuarDispositivos = sc.nextLine().toUpperCase();
                
            } while (continuarDispositivos.equals("S"));
<<<<<<< HEAD

            ReporteAmbiental reporte = new ReporteAmbiental(idReporte, periodoMonitoreo, nombreRed, dispositivosReporte);
            reporte.calcularTotalRiesgos();
            reportes.add(reporte);
            

=======
            
            // Crear reporte ambiental
            ReporteAmbiental reporte = new ReporteAmbiental(idReporte, periodoMonitoreo, nombreRed, dispositivosReporte);
            reportes.add(reporte);
            
            // Añadir dispositivos a la lista general
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
        
<<<<<<< HEAD
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
=======
        // Estadísticas por región
        long dispositivosCosta = dispositivos.stream().filter(d -> d instanceof DispositivoCosta).count();
        long dispositivosSierra = dispositivos.stream().filter(d -> d instanceof DispositivoSierra).count();
        long dispositivosOriente = dispositivos.stream().filter(d -> d instanceof DispositivoOriente).count();
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        
        System.out.println("\n=== DISTRIBUCIÓN POR REGIÓN ===");
        System.out.println("Costa: " + dispositivosCosta + " dispositivos");
        System.out.println("Sierra: " + dispositivosSierra + " dispositivos");
        System.out.println("Oriente: " + dispositivosOriente + " dispositivos");
        
        System.out.println("\n=== HISTORIAL DE REPORTES ===");
        for (ReporteAmbiental reporte : reportes) {
            System.out.println("Reporte " + reporte.id + " - " + reporte.periodo + " (" + reporte.dispositivos.size() + " dispositivos)");
        }
        
<<<<<<< HEAD
=======
        sc.close();
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

abstract class Dispositivo {
<<<<<<< HEAD
    public String id;
    public String ubicacion;
    public double temperatura;
    public double precipitacion;
    public String estado;
    public ArrayList<String> riesgosDetectados = new ArrayList<>();
    public int numeroRiesgos;
    
=======
    protected String id;
    protected String ubicacion;
    protected double temperatura;
    protected double precipitacion;
    protected String estado;
    protected ArrayList<String> riesgosDetectados;
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    
    public Dispositivo(String id, String ubicacion, double temperatura, double precipitacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.temperatura = temperatura;
        this.precipitacion = precipitacion;
        this.estado = "Activo";
<<<<<<< HEAD
=======
        this.riesgosDetectados = new ArrayList<>();
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
    
    public abstract void procesarDatos();
    public abstract void detectarRiesgos();
    
    @Override
    public String toString() {
<<<<<<< HEAD
        return "Dispositivo{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + "} ";
=======
        return "Dispositivo{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + '}';
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

class DispositivoCosta extends Dispositivo {
<<<<<<< HEAD
    public double humedad;
    public double salinidad;
=======
    private double humedad;
    private double salinidad;
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    
    public DispositivoCosta(String id, String ubicacion, double temperatura, double precipitacion, double humedad, double salinidad) {
        super(id, ubicacion, temperatura, precipitacion);
        this.humedad = humedad;
        this.salinidad = salinidad;
    }
    
    @Override
    public void procesarDatos() {
<<<<<<< HEAD

=======
        // Protocolo específico para la costa
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD
      

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
=======
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
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        }
    }
    
    @Override
    public String toString() {
<<<<<<< HEAD
        return "DispositivoCosta{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, humedad=" + String.format("%.1f", humedad) + "%, salinidad=" + String.format("%.2f", salinidad) + "ppt, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + "} "+ super.toString();
=======
        return "DispositivoCosta{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, humedad=" + String.format("%.1f", humedad) + "%, salinidad=" + String.format("%.2f", salinidad) + "ppt, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + '}';
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

class DispositivoSierra extends Dispositivo {
<<<<<<< HEAD
    public double altitud;
    public double estabilidadSuelo;
=======
    private double altitud;
    private double estabilidadSuelo;
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    
    public DispositivoSierra(String id, String ubicacion, double temperatura, double precipitacion, double altitud, double estabilidadSuelo) {
        super(id, ubicacion, temperatura, precipitacion);
        this.altitud = altitud;
        this.estabilidadSuelo = estabilidadSuelo;
    }
    
    @Override
    public void procesarDatos() {
<<<<<<< HEAD
=======
        // Protocolo específico para la sierra
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD

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
=======
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
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        }
    }
    
    @Override
    public String toString() {
<<<<<<< HEAD
        return "DispositivoSierra{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, altitud=" + String.format("%.0f", altitud) + "m, estabilidadSuelo=" + String.format("%.1f", estabilidadSuelo) + "/10, estado=" + estado + ", riesgos=" + riesgosDetectados.size() +"} " + super.toString();
=======
        return "DispositivoSierra{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, altitud=" + String.format("%.0f", altitud) + "m, estabilidadSuelo=" + String.format("%.1f", estabilidadSuelo) + "/10, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + '}';
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

class DispositivoOriente extends Dispositivo {
<<<<<<< HEAD
    public double humedad;
    public double calidadAire;
    public double biodiversidad;
=======
    private double humedad;
    private double calidadAire;
    private double biodiversidad;
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    
    public DispositivoOriente(String id, String ubicacion, double temperatura, double precipitacion, double humedad, double calidadAire, double biodiversidad) {
        super(id, ubicacion, temperatura, precipitacion);
        this.humedad = humedad;
        this.calidadAire = calidadAire;
        this.biodiversidad = biodiversidad;
    }
    
    @Override
    public void procesarDatos() {
<<<<<<< HEAD

=======
        // Protocolo específico para el oriente
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD

        
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
=======
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
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        }
    }
    
    @Override
    public String toString() {
<<<<<<< HEAD
        return "DispositivoOriente{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, humedad=" + String.format("%.1f", humedad) + "%, calidadAire=" + String.format("%.1f", calidadAire) + "ICA, biodiversidad=" + String.format("%.1f", biodiversidad) + "/10, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + "} " + super.toString();
=======
        return "DispositivoOriente{" + "id=" + id + ", ubicacion=" + ubicacion + ", temperatura=" + String.format("%.1f", temperatura) + "°C, precipitacion=" + String.format("%.1f", precipitacion) + "mm, humedad=" + String.format("%.1f", humedad) + "%, calidadAire=" + String.format("%.1f", calidadAire) + "ICA, biodiversidad=" + String.format("%.1f", biodiversidad) + "/10, estado=" + estado + ", riesgos=" + riesgosDetectados.size() + '}';
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD
    }
    
    public void calcularTotalRiesgos() {
        this.totalRiesgos = 0;
        for (Dispositivo dispositivo : dispositivos) {
            this.totalRiesgos += dispositivo.numeroRiesgos;
=======
        this.calcularTotalRiesgos();
    }
    
    private void calcularTotalRiesgos() {
        this.totalRiesgos = 0;
        for (Dispositivo dispositivo : dispositivos) {
            this.totalRiesgos += dispositivo.riesgosDetectados.size();
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        }
    }
    
    public ArrayList<String> obtenerRiesgosCriticos() {
        ArrayList<String> riesgosCriticos = new ArrayList<>();
        for (Dispositivo dispositivo : dispositivos) {
            for (String riesgo : dispositivo.riesgosDetectados) {
<<<<<<< HEAD
                if (riesgo.contains("extrema") || riesgo.contains("crítica") || riesgo.contains("Alto riesgo") || riesgo.contains("muy inestable")) { 
=======
                if (riesgo.contains("extrema") || riesgo.contains("crítica") || riesgo.contains("Alto riesgo") || riesgo.contains("muy inestable")) {
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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