import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problema3_EjectuorEstadisticasFutbol {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        // Nombres aleatorios para jugadores
        String[] nombres = {"Carlos", "Diego", "Fernando", "Gabriel", "Andrés", "Sebastián", "Mateo", "Santiago", 
                           "Alejandro", "Ricardo", "Pablo", "Joaquín", "Emilio", "Rodrigo", "Nicolás"};
        
        // RUTs aleatorios (simplificados)
        String[] ruts = {"12345678-9", "87654321-K", "11223344-5", "99887766-3", "55443322-1", 
                        "44556677-8", "33221100-2", "77889900-4", "66554433-7", "22334455-6",
                        "88776655-0", "99001122-9", "11337799-K", "55667788-3", "44332211-5"};

        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<PartidoRegistro> partidos = new ArrayList<>();
        
        System.out.println("=== SISTEMA DE ESTADÍSTICAS DE FÚTBOL ===");
        System.out.print("Ingrese el nombre del equipo: ");
        String nombreEquipo = sc.nextLine();
        
        System.out.print("Ingrese el nombre del partido/rival: ");
        String nombrePartido = sc.nextLine();
        
        String continuar = "S";
        int idPartido = 1;
        
        do {
            System.out.println("\n--- REGISTRAR ESTADÍSTICAS DEL PARTIDO: " + nombrePartido + " ---");
            ArrayList<Jugador> jugadoresPartido = new ArrayList<>();
            String continuarJugadores = "S";
            
            do {
                System.out.println("\nSeleccione el tipo de jugador:");
                System.out.println("1. Atacante");
                System.out.println("2. Defensor");
                System.out.println("3. Portero");
                System.out.print("Opción: ");
                
                int tipoJugador = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                
                if (tipoJugador < 1 || tipoJugador > 3) {
                    System.out.println("Opción inválida. Intente nuevamente.");
                    continue;
                }
                
                // Generar datos aleatorios del jugador
                String nombre = nombres[random.nextInt(nombres.length)];
                String rut = ruts[random.nextInt(ruts.length)];
                int dorsal = random.nextInt(23) + 1; // Dorsales del 1 al 23
                
                // Verificar que el dorsal no esté repetido en este partido
                boolean dorsalRepetido = false;
                for (Jugador j : jugadoresPartido) {
                    if (j.dorsal == dorsal) {
                        dorsalRepetido = true;
                        break;
                    }
                }
                
                if (dorsalRepetido) {
                    dorsal = random.nextInt(23) + 1; // Generar nuevo dorsal
                }
                
                System.out.println("Jugador generado: " + nombre + " (Dorsal: " + dorsal + ", RUT: " + rut + ")");
                
                // Generar estadísticas aleatorias según el tipo
                Jugador jugadorCreado = null;
                
                switch (tipoJugador) {
                    case 1 -> { // Atacante
                        int goles = random.nextInt(4); // 0-3 goles
                        int pases = 15 + random.nextInt(35); // 15-50 pases
                        int recuperaciones = random.nextInt(8); // 0-7 recuperaciones
                        
                        Atacante atacante = new Atacante(nombre, dorsal, rut, goles, pases, recuperaciones);
                        atacante.calcularValoracion();
                        jugadorCreado = atacante;
                        
                        System.out.println("Atacante registrado - Goles: " + goles + ", Pases: " + pases + ", Recuperaciones: " + recuperaciones);
                    }
                    case 2 -> { // Defensor
                        int goles = random.nextInt(2); // 0-1 goles
                        int pases = 20 + random.nextInt(40); // 20-60 pases
                        int recuperaciones = 3 + random.nextInt(12); // 3-15 recuperaciones
                        
                        Defensor defensor = new Defensor(nombre, dorsal, rut, goles, pases, recuperaciones);
                        defensor.calcularValoracion();
                        jugadorCreado = defensor;
                        
                        System.out.println("Defensor registrado - Goles: " + goles + ", Pases: " + pases + ", Recuperaciones: " + recuperaciones);
                    }
                    case 3 -> { // Portero
                        int goles = 0; // Los porteros raramente anotan
                        int atajadas = 2 + random.nextInt(8); // 2-10 atajadas
                        
                        Portero portero = new Portero(nombre, dorsal, rut, goles, atajadas);
                        portero.calcularValoracion();
                        jugadorCreado = portero;
                        
                        System.out.println("Portero registrado - Goles: " + goles + ", Atajadas: " + atajadas);
                    }
                }
                
                if (jugadorCreado != null) {
                    jugadoresPartido.add(jugadorCreado);
                    System.out.println("Valoración del jugador: " + jugadorCreado.valoracion + " puntos");
                }
                
                System.out.println("\n¿Desea registrar otro jugador para este partido? (S/N)");
                continuarJugadores = sc.nextLine().toUpperCase();
                
            } while (continuarJugadores.equals("S"));
            
            // Crear registro del partido
            PartidoRegistro partido = new PartidoRegistro(idPartido, nombrePartido, nombreEquipo, jugadoresPartido);
            partidos.add(partido);
            
            // Añadir jugadores a la lista general
            jugadores.addAll(jugadoresPartido);
            
            System.out.println("\n=== RESUMEN DEL PARTIDO ===");
            System.out.println(partido);
            
            System.out.println("\n=== ESTADÍSTICAS INDIVIDUALES ===");
            for (Jugador jugador : jugadoresPartido) {
                System.out.println(jugador);
            }
            
            // Encontrar MVP del partido
            Jugador mvp = partido.obtenerMVP();
            System.out.println("\n MVP DEL PARTIDO: " + mvp.nombre + " (Dorsal: " + mvp.dorsal + ") - Valoración: " + mvp.valoracion + " puntos");
            
            System.out.println("\n¿Desea registrar otro partido? (S/N)");
            continuar = sc.nextLine().toUpperCase();
            idPartido++;
            
        } while (continuar.equals("S"));
        
        System.out.println("\n=== ESTADÍSTICAS FINALES ===");
        System.out.println("Equipo: " + nombreEquipo);
        System.out.println("Partidos registrados: " + partidos.size());
        System.out.println("Total de jugadores: " + jugadores.size());
        
        System.out.println("\n=== HISTORIAL DE PARTIDOS ===");
        for (PartidoRegistro partido : partidos) {
            System.out.println("Partido " + partido.id + ": " + partido.nombrePartido + " - " + partido.jugadores.size() + " jugadores registrados");
        }
        
        System.out.println("\n=== RANKING GENERAL DE JUGADORES ===");
        jugadores.sort((j1, j2) -> Double.compare(j2.valoracion, j1.valoracion));
        for (int i = 0; i < Math.min(5, jugadores.size()); i++) {
            Jugador j = jugadores.get(i);
            System.out.println((i + 1) + ". " + j.nombre + " (Dorsal: " + j.dorsal + ") - " + j.valoracion + " puntos");
        }
        
        sc.close();
    }
}

abstract class Jugador {
    protected String nombre;
    protected int dorsal;
    protected String rut;
    protected int goles;
    protected double valoracion;
    
    public Jugador(String nombre, int dorsal, String rut, int goles) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.rut = rut;
        this.goles = goles;
    }
    
    public abstract void calcularValoracion();
    
    protected double calcularValorGoles() {
        return goles * 30;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", dorsal=" + dorsal + ", rut=" + rut + ", goles=" + goles + ", valoracion=" + valoracion + '}';
    }
}

class Atacante extends Jugador {
    private int pases;
    private int recuperaciones;
    
    public Atacante(String nombre, int dorsal, String rut, int goles, int pases, int recuperaciones) {
        super(nombre, dorsal, rut, goles);
        this.pases = pases;
        this.recuperaciones = recuperaciones;
    }
    
    @Override
    public void calcularValoracion() {
        double valorGoles = calcularValorGoles();
        double valorRecuperaciones = recuperaciones * 3;
        this.valoracion = valorGoles + valorRecuperaciones;
    }
    
    @Override
    public String toString() {
        return "Atacante{" + "nombre=" + nombre + ", dorsal=" + dorsal + ", rut=" + rut + ", goles=" + goles + ", pases=" + pases + ", recuperaciones=" + recuperaciones + ", valoracion=" + valoracion + '}';
    }
}

class Defensor extends Jugador {
    private int pases;
    private int recuperaciones;
    
    public Defensor(String nombre, int dorsal, String rut, int goles, int pases, int recuperaciones) {
        super(nombre, dorsal, rut, goles);
        this.pases = pases;
        this.recuperaciones = recuperaciones;
    }
    
    @Override
    public void calcularValoracion() {
        double valorGoles = calcularValorGoles();
        double valorRecuperaciones = recuperaciones * 4;
        this.valoracion = valorGoles + valorRecuperaciones;
    }
    
    @Override
    public String toString() {
        return "Defensor{" + "nombre=" + nombre + ", dorsal=" + dorsal + ", rut=" + rut + ", goles=" + goles + ", pases=" + pases + ", recuperaciones=" + recuperaciones + ", valoracion=" + valoracion + '}';
    }
}

class Portero extends Jugador {
    private int atajadas;
    
    public Portero(String nombre, int dorsal, String rut, int goles, int atajadas) {
        super(nombre, dorsal, rut, goles);
        this.atajadas = atajadas;
    }
    
    @Override
    public void calcularValoracion() {
        double valorGoles = calcularValorGoles();
        double valorAtajadas = atajadas * 5;
        this.valoracion = valorGoles + valorAtajadas;
    }
    
    @Override
    public String toString() {
        return "Portero{" + "nombre=" + nombre + ", dorsal=" + dorsal + ", rut=" + rut + ", goles=" + goles + ", atajadas=" + atajadas + ", valoracion=" + valoracion + '}';
    }
}

class PartidoRegistro {
    public int id;
    public String nombrePartido;
    public String equipo;
    public ArrayList<Jugador> jugadores;
    public double valoracionTotal;
    
    public PartidoRegistro(int id, String nombrePartido, String equipo, ArrayList<Jugador> jugadores) {
        this.id = id;
        this.nombrePartido = nombrePartido;
        this.equipo = equipo;
        this.jugadores = new ArrayList<>(jugadores);
        this.calcularValoracionTotal();
    }
    
    private void calcularValoracionTotal() {
        this.valoracionTotal = 0;
        for (Jugador jugador : jugadores) {
            this.valoracionTotal += jugador.valoracion;
        }
    }
    
    public Jugador obtenerMVP() {
        if (jugadores.isEmpty()) return null;
        
        Jugador mvp = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if (jugador.valoracion > mvp.valoracion) {
                mvp = jugador;
            }
        }
        return mvp;
    }
    
    @Override
    public String toString() {
        return "PartidoRegistro{" + "id=" + id + ", nombrePartido=" + nombrePartido + ", equipo=" + equipo + ", jugadores=" + jugadores.size() + ", valoracionTotal=" + String.format("%.2f", valoracionTotal) + '}';
    }
}