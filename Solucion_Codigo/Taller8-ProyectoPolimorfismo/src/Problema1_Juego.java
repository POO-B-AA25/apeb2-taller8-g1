
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problema1_Juego {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        String[] nombres = {"Thorin", "Legolas", "Gandalf", "Aragorn", "Gimli", "Arwen", "Boromir", "Faramir"};
        String[] apellidos = {"Escudodorado", "Hojaverde", "Elgris", "Montaraz", "Hacharoja", "Lunaplata", "Espadadiamante"};

        ArrayList<Personaje> listaPersonajes = new ArrayList<>();

        String nombreJuego = "Batalla " + 1;


        System.out.println("Juego creado: " + nombreJuego);

        String continuarPersonajes;
        do {
            System.out.println("\n¿Deseas añadir un personaje a este juego? (S/N)");
            continuarPersonajes = sc.nextLine().toUpperCase();

            if (continuarPersonajes.equals("S")) {
                String nombre = nombres[random.nextInt(nombres.length)];
                String apellido = apellidos[random.nextInt(apellidos.length)];

                int habilidades = 50 + random.nextInt(50);
                int estrategias = 50 + random.nextInt(50);
                int atributos = 50 + random.nextInt(50);
                int puntosVida = 80 + random.nextInt(40);
                int nivelExperiencia = 1 + random.nextInt(5);
                int batallasGanadas = random.nextInt(10);

                System.out.println("\nSeleccione el tipo de personaje:");
                System.out.println("1. Guerrero");
                System.out.println("2. Mago");
                System.out.println("3. Arquero");
                System.out.print("Opción: ");
                int tipoPersonaje = sc.nextInt();
                sc.nextLine();

                switch (tipoPersonaje) {
                    case 1 -> {
                        int fuerza = 70 + random.nextInt(30);
                        Guerrero guerrero = new Guerrero(fuerza, habilidades, estrategias, atributos,
                                puntosVida, nivelExperiencia, batallasGanadas,
                                nombre, apellido);
                        guerrero.calcularHabilidadesEspecificas();
                        guerrero.calcularPoderCombate();
                        listaPersonajes.add(guerrero);
                        System.out.println("Guerrero añadido: " + guerrero);
                    }
                    case 2 -> {
                        int poder = 60 + random.nextInt(40);
                        Mago mago = new Mago(poder, habilidades, estrategias, atributos,
                                puntosVida, nivelExperiencia, batallasGanadas,
                                nombre, apellido);
                        mago.calcularHabilidadesEspecificas();
                        mago.calcularPoderCombate();
                        listaPersonajes.add(mago);
                        System.out.println("Mago añadido: " + mago);
                    }
                    case 3 -> {
                        int presicion = 65 + random.nextInt(35);
                        Arquero arquero = new Arquero(presicion, habilidades, estrategias, atributos,
                                puntosVida, nivelExperiencia, batallasGanadas,
                                nombre, apellido);
                        arquero.calcularHabilidadesEspecificas();
                        arquero.calcularPoderCombate();
                        listaPersonajes.add(arquero);
                        System.out.println("Arquero añadido: " + arquero);
                    }
                    default ->
                        System.out.println("Opción no válida.");
                }
            }

        } while (continuarPersonajes.equals("S"));

        System.out.println("\n=== LISTA FINAL DE PERSONAJES ===");
        for (Personaje p : listaPersonajes) {
            System.out.println(p);
        }

        if (listaPersonajes.size() >= 2) {
            System.out.println("\n=== SIMULANDO COMBATES ===");
            for (int i = 0; i < Math.min(3, listaPersonajes.size() - 1); i++) {
                Personaje p1 = listaPersonajes.get(random.nextInt(listaPersonajes.size()));
                Personaje p2 = listaPersonajes.get(random.nextInt(listaPersonajes.size()));

                if (p1 != p2) {
                    System.out.println("\n--- COMBATE " + (i + 1) + " ---");
                    System.out.println(p1.nombre + " " + p1.apellidos + " VS " + p2.nombre + " " + p2.apellidos);


                    double resultado1 = p1.poderCombateCalculado;
                    double resultado2 = p2.poderCombateCalculado;

                    if (resultado1 > resultado2) {
                        System.out.println("¡" + p1.nombre + " " + p1.apellidos + " GANA!");
                        p1.subirNivel();
                    } else if (resultado2 > resultado1) {
                        System.out.println("¡" + p2.nombre + " " + p2.apellidos + " GANA!");
                        p2.subirNivel();
                    } else {
                        System.out.println("¡EMPATE!");
                    }

                    System.out.println("Poder de combate " + p1.nombre + ": " + String.format("%.2f", resultado1));
                    System.out.println("Poder de combate " + p2.nombre + ": " + String.format("%.2f", resultado2));
                }
            }
        }

        System.out.println("\nPrograma finalizado.");
        sc.close();
    }

}

abstract class Personaje {

    public int habilidades;
    public int estrategias;
    public int atributos;
    public int puntosVida;
    public int nivelExperiencia;
    public int batallasGanadas;
    public String nombre;
    public String apellidos;
    public double poderCombateCalculado;

    public Personaje() {}

    public Personaje(int habilidades, int estrategias, int atributos, int puntosVida,int nivelExperiencia, int batallasGanadas, String nombre, String apellidos) {
        this.habilidades = habilidades;
        this.estrategias = estrategias;
        this.atributos = atributos;
        this.puntosVida = puntosVida;
        this.nivelExperiencia = nivelExperiencia;
        this.batallasGanadas = batallasGanadas;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }



    public abstract double ataque();

    public abstract double defensa();

    public abstract void calcularPoderCombate();

    public void subirNivel() {
        this.nivelExperiencia++;
        this.batallasGanadas++;
        this.puntosVida += 10;
        System.out.println(this.nombre + " ha subido al nivel " + this.nivelExperiencia + "!");
    }

    @Override
    public String toString() {
        return "Personaje{" + "habilidades=" + habilidades + ", estrategias=" + estrategias + ", atributos=" + atributos + ", puntosVida=" + puntosVida + ", nivelExperiencia=" + nivelExperiencia + ", batallasGanadas=" + batallasGanadas
                + ", nombre=" + nombre + ", apellidos=" + apellidos + ", juego=" + ", poderCombate=" + String.format("%.2f", poderCombateCalculado) + '}';
    }
}

class Guerrero extends Personaje {

    public int fuerza;
    public int fuerzaTotal;
    public int defensaTotal;
    public int resistenciaTotal;

    public Guerrero() {}

    public Guerrero(int fuerza, int habilidades, int estrategias, int atributos,int puntosVida, int nivelExperiencia, int batallasGanadas, String nombre, String apellidos){
        super(habilidades, estrategias, atributos, puntosVida, nivelExperiencia, batallasGanadas, nombre, apellidos);
        this.fuerza = fuerza;
    }

    public void calcularHabilidadesEspecificas() {
        this.fuerzaTotal = this.fuerza + this.habilidades;
        this.defensaTotal = this.atributos + this.estrategias;
        this.resistenciaTotal = this.puntosVida + this.atributos;
    }

    @Override
    public double ataque() {
        return (fuerzaTotal * 1.5) + (nivelExperiencia * 10);
    }

    @Override
    public double defensa() {
        return (defensaTotal * 1.2) + (resistenciaTotal * 0.5);
    }

    @Override
    public void calcularPoderCombate() {
        this.poderCombateCalculado = ataque() + defensa();
    }

    @Override
    public String toString() {
        return "Guerrero{fuerza=" + fuerza + ", fuerzaTotal=" + fuerzaTotal
                + ", defensaTotal=" + defensaTotal + ", resistenciaTotal=" + resistenciaTotal + "} " + super.toString();
    }
}

class Mago extends Personaje {

    public int poder;
    public int poderMagico;
    public int inteligencia;
    public int manaTotal;

    public Mago() {}

    public Mago(int poder, int habilidades, int estrategias, int atributos,
            int puntosVida, int nivelExperiencia, int batallasGanadas,
            String nombre, String apellidos) {
        super(habilidades, estrategias, atributos, puntosVida, nivelExperiencia,
                batallasGanadas, nombre, apellidos);
        this.poder = poder;
    }

    public void calcularHabilidadesEspecificas() {
        this.poderMagico = this.poder + this.habilidades;
        this.inteligencia = this.estrategias + this.atributos;
        this.manaTotal = this.poder + this.estrategias;
    }

    @Override
    public double ataque() {
        return (poderMagico * 1.8) + (inteligencia * 1.0) + (nivelExperiencia * 12);
    }

    @Override
    public double defensa() {
        return (inteligencia * 1.4) + (manaTotal * 0.6) + (puntosVida * 0.3);
    }

    @Override
    public void calcularPoderCombate() {
        this.poderCombateCalculado = ataque() + defensa();
    }

    @Override
    public String toString() {
        return "Mago{poder=" + poder + ", poderMagico=" + poderMagico
                + ", inteligencia=" + inteligencia + ", manaTotal=" + manaTotal + "} " + super.toString();
    }
}

class Arquero extends Personaje {

    public int presicion;
    public int punteria;
    public int agilidad;
    public int alcance;

    public Arquero() {}

    public Arquero(int presicion, int habilidades, int estrategias, int atributos, int puntosVida, int nivelExperiencia, int batallasGanadas, String nombre, String apellidos) {
        super(habilidades, estrategias, atributos, puntosVida, nivelExperiencia,
                batallasGanadas, nombre, apellidos);
        this.presicion = presicion;
    }

    public void calcularHabilidadesEspecificas() {
        this.punteria = this.presicion + this.habilidades;
        this.agilidad = this.estrategias + this.atributos;
        this.alcance = this.presicion + this.estrategias;
    }

    @Override
    public double ataque() {
        return (punteria * 1.6) + (alcance * 0.8) + (nivelExperiencia * 8);
    }

    @Override
    public double defensa() {
        return (agilidad * 1.1) + (alcance * 0.5) + (puntosVida * 0.4);
    }

    @Override
    public void calcularPoderCombate() {
        this.poderCombateCalculado = ataque() + defensa();
    }

    @Override
    public String toString() {
        return "Arquero{presicion=" + presicion + ", punteria=" + punteria
                + ", agilidad=" + agilidad + ", alcance=" + alcance + "} " + super.toString();
    }
}

