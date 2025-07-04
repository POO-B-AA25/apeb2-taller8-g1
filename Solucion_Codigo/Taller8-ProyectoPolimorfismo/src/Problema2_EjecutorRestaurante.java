
import java.util.ArrayList;

public class Problema2_EjecutorRestaurante {
    public static void main(String args[]) {
        
        MenuCarta menu1= (new MenuCarta(0.5, 2, 1,"Repe",3.5 ));
        menu1.calcularGuarnicion();
        menu1.Porcentaje();
        menu1.calcularvalorTotal();
        MenuEconomico menu2=(new MenuEconomico(0.15, "Arroz Relleno", 3.5));
        menu2.calcularvalorTotal();
        System.out.println(menu1);
        System.out.println(menu2);
        Cuenta cuenta1 = new Cuenta ("Felipe", menu1, menu1.valorTotal );
        Cuenta cuenta2 = new Cuenta ("Ana", menu2, menu2.valorTotal );
        cuenta1.calcularIVA();
        cuenta2.calcularIVA();
        cuenta1.calcularTotal();
        cuenta2.calcularTotal();
        System.out.println(cuenta1);
        System.out.println(cuenta2);
    }
}

abstract class Menu {

    public String nombrePlato;
    public double valorTotal;
    public double valorInicial;

    public Menu(String nombrePlato, double valorInicial) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
    }

    public abstract void calcularvalorTotal();

    @Override
    public String toString() {
        return "Menu{" + "nombrePlato=" + nombrePlato + ", valorTotal=" + valorTotal + ", valorInicial=" + valorInicial + '}';
    }

}

class MenuCarta extends Menu {

    public double valorGuarnicion;
    public int guarnicionesPedidas;
    public double totalGuarnicion;
    public double valorBebida;
    public double porcentajeAdicional;

    public MenuCarta(double valorGuarnicion, int guarnicionesPedidas, double valorBebida, String nombrePlato, double valorInicial) {
        super(nombrePlato, valorInicial);
        this.valorGuarnicion = valorGuarnicion;
        this.guarnicionesPedidas = guarnicionesPedidas;
        this.valorBebida = valorBebida;
    }

    public void calcularGuarnicion() {
        this.totalGuarnicion = this.guarnicionesPedidas * this.valorGuarnicion;
    }

    public void Porcentaje() {
        this.porcentajeAdicional = super.valorInicial * 0.05;
    }

    @Override
    public void calcularvalorTotal() {
        super.valorTotal = totalGuarnicion + this.valorBebida + super.valorInicial + this.porcentajeAdicional;
    }

    @Override
    public String toString() {
        return "MenuCarta{" + "valorGuarnicion=" + valorGuarnicion + ", guarnicionesPedidas=" + guarnicionesPedidas + ", totalGuarnicion=" + totalGuarnicion + ", valorBebida=" + valorBebida + ", porcentajeAdicional=" + porcentajeAdicional + "} " + super.toString();
    }

}

class MenuDia extends Menu {

    public double valorBebida;
    public double valorPostre;
    public int postresPedidos;
    public double totalPostres;

    public MenuDia(double valorPostre, double valorBebida, String nombrePlato, double valorInicial) {
        super(nombrePlato, valorInicial);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }

    public void calcularPostre() {
        this.totalPostres = this.postresPedidos * this.valorPostre;
    }

    @Override
    public void calcularvalorTotal() {
        super.valorTotal = this.totalPostres + this.valorBebida + super.valorInicial;
    }

    @Override
    public String toString() {
        return "MenuDia{" + "valorBebida=" + valorBebida + ", valorPostre=" + valorPostre + ", postresPedidos=" + postresPedidos + ", totalPostres=" + totalPostres + "} " + super.toString();
    }

}

class MenuNino extends Menu {

    public double valorHelado;
    public double valorPastel;
    public int heladosPedidos;
    public double totalHelados;
    public int pastelesPedidos;
    public double totalPasteles;

    public MenuNino(double valorHelado, double valorPastel, String nombrePlato, double valorInicial) {
        super(nombrePlato, valorInicial);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }

    public void calcularHelados() {
        this.totalHelados = this.heladosPedidos * this.valorHelado;
    }

    public void calcularPasteles() {
        this.totalPasteles = this.pastelesPedidos * this.valorPastel;
    }

    @Override
    public void calcularvalorTotal() {
        this.valorTotal = super.valorInicial + this.totalHelados + this.totalPasteles;
    }

}

class MenuEconomico extends Menu {

    double porcentajeDescuento;

    public MenuEconomico(double porcentajeDescuento, String nombrePlato, double valorInicial) {
        super(nombrePlato, valorInicial);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void calcularvalorTotal() {
        super.valorTotal = super.valorInicial * porcentajeDescuento + super.valorInicial;
    }
}

class Cuenta {

    public String cliente;
    public Menu menu;
    public double subTotalPagar;
    public double iva;
    public double totalPagar;

    public Cuenta(String cliente, Menu menu, double subTotalPagar) {
        this.cliente = cliente;
        this.menu = menu;
        this.subTotalPagar = subTotalPagar;

    }

    public void calcularIVA() {
        this.iva = this.subTotalPagar * 0.15;
    }
    public void calcularTotal() {
        this.totalPagar = this.subTotalPagar + this.iva;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "cliente=" + cliente + ", menu=" + menu + ", subTotalPagar=" + subTotalPagar + ", iva=" + iva + ", totalPagar=" + totalPagar + '}';
    }

}
