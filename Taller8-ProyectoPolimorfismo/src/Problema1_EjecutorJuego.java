
public class Problema1_EjecutorJuego {

    public static Personaje guerrero;
    public static Personaje mago;
    public static Personaje arquero;

    public static void main(String args[]) {
        guerrero = new Guerrero("Gigante", 3);
        mago = new Mago("Gigante", 3);
        arquero = new Arquero("Gigante ", 3);
        guerrero.ataque(mago);
        System.out.println(guerrero);
        System.out.println(mago);
    }
}

abstract class Personaje {

    public int vidas;
    public int experiencia;
    public int batallasGanadas;

    public Personaje(int vidas) {
        this.vidas = vidas;
    }
    

    public abstract boolean ataque(Personaje personaje);

    public abstract int defensa();

    @Override
    public String toString() {
        return "Personaje{" + "vida=" + vidas + ", expereincias=" + experiencia + ", batallasGanadas=" + batallasGanadas + '}';
    }

}

class Guerrero extends Personaje {

    public String habilidades;

    public Guerrero(String habilidades, int vidas) {
        super(vidas);
        this.habilidades = habilidades;
    }
    
       

    public boolean ataque(Personaje personaje) {
        int numero = (int) (Math.random() * 2);
        boolean gana = (numero == 1) ? true : false;
        if(gana) {
            this.experiencia += 1;
            this.batallasGanadas += 1;
            personaje.vidas -= 1;
        }  else {
            this.vidas -= 1;
            personaje.batallasGanadas += 1;
            personaje.experiencia += 1;
        }
        return gana;
    }

    public int defensa() {
        return 0;
    }

    @Override
    public String toString() {
        return "Guerrero{" + "habilidades=" + habilidades + "} " + super.toString();
    }

}

class Mago extends Personaje {

    public String habilidades;

    public Mago(String habilidades, int vidas) {
        super(vidas);
        this.habilidades = habilidades;
    }
    
    
    public boolean ataque(Personaje personaje) {
        return false;
    }

    public int defensa() {
        return 0;
    }

    @Override
    public String toString() {
        return "Mago{" + "habilidades=" + habilidades + "} " + super.toString();
    }

}

class Arquero extends Personaje {

    public String atributos;

    public Arquero(String atributos, int vidas) {
        super(vidas);
        this.atributos = atributos;
    }
    
    
    public boolean ataque(Personaje personaje) {
        return false;
    }

    public int defensa() {
        return 0;
    }

    @Override
    public String toString() {
        return "Arquero{" + "atributos=" + atributos + "} " + super.toString();
    }

}
