import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problema2_EjecutorRestaurante {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        
        String[] platosMenuCarta = {"Repe", "Lomo Saltado", "Arroz con Pollo", "Ceviche", "Paella"};
        String[] platosMenuDia = {"Sopa del Día", "Guiso Casero", "Pescado a la Plancha", "Pollo Asado"};
        String[] platosMenuNino = {"Nuggets", "Pizza Mini", "Hamburguesa Infantil", "Salchipapas"};
        String[] platosMenuEconomico = {"Arroz Relleno", "Tallarines Rojos", "Menestra", "Sopa Criolla"};
        
        System.out.println("=== SISTEMA DE RESTAURANTE ===");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        
        ArrayList<Menu> menus = new ArrayList<>();
        String continuar = "S";
        
        do {
            System.out.println("\n--- SELECCIONE TIPO DE MENÚ ---");
            System.out.println("1. Menú a la Carta");
            System.out.println("2. Menú del Día");
            System.out.println("3. Menú Niño");
            System.out.println("4. Menú Económico");
            System.out.print("Opción: ");
            
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            
            Menu menuSeleccionado = null;
            
            switch (opcion) {
                case 1 -> {
                    // Generar valores aleatorios para MenuCarta
                    double valorGuarnicion = 0.3 + (random.nextDouble() * 0.7); // 0.3 - 1.0
                    int guarnicionesPedidas = random.nextInt(3) + 1; // 1-3
                    double valorBebida = 0.5 + (random.nextDouble() * 1.5); // 0.5 - 2.0
                    String nombrePlato = platosMenuCarta[random.nextInt(platosMenuCarta.length)];
                    double valorInicial = 3.0 + (random.nextDouble() * 4.0); // 3.0 - 7.0
                    
                    MenuCarta menuCarta = new MenuCarta(valorGuarnicion, guarnicionesPedidas, valorBebida, nombrePlato, valorInicial);
                    menuCarta.calcularGuarnicion();
                    menuCarta.Porcentaje();
                    menuCarta.calcularvalorTotal();
                    menuSeleccionado = menuCarta;
                    
                    System.out.println("Menú a la Carta creado: " + nombrePlato);
                }
                case 2 -> {
                    // Generar valores aleatorios para MenuDia
                    double valorPostre = 0.5 + (random.nextDouble() * 1.5); // 0.5 - 2.0
                    double valorBebida = 0.5 + (random.nextDouble() * 1.5); // 0.5 - 2.0
                    String nombrePlato = platosMenuDia[random.nextInt(platosMenuDia.length)];
                    double valorInicial = 2.5 + (random.nextDouble() * 3.5); // 2.5 - 6.0
                    int postresPedidos = random.nextInt(2) + 1; // 1-2
                    
                    MenuDia menuDia = new MenuDia(valorPostre, valorBebida, nombrePlato, valorInicial);
                    menuDia.postresPedidos = postresPedidos;
                    menuDia.calcularPostre();
                    menuDia.calcularvalorTotal();
                    menuSeleccionado = menuDia;
                    
                    System.out.println("Menú del Día creado: " + nombrePlato);
                }
                case 3 -> {
                    // Generar valores aleatorios para MenuNino
                    double valorHelado = 0.5 + (random.nextDouble() * 1.0); // 0.5 - 1.5
                    double valorPastel = 0.8 + (random.nextDouble() * 1.2); // 0.8 - 2.0
                    String nombrePlato = platosMenuNino[random.nextInt(platosMenuNino.length)];
                    double valorInicial = 2.0 + (random.nextDouble() * 2.0); // 2.0 - 4.0
                    int heladosPedidos = random.nextInt(2) + 1; // 1-2
                    int pastelesPedidos = random.nextInt(2); // 0-1
                    
                    MenuNino menuNino = new MenuNino(valorHelado, valorPastel, nombrePlato, valorInicial);
                    menuNino.heladosPedidos = heladosPedidos;
                    menuNino.pastelesPedidos = pastelesPedidos;
                    menuNino.calcularHelados();
                    menuNino.calcularPasteles();
                    menuNino.calcularvalorTotal();
                    menuSeleccionado = menuNino;
                    
                    System.out.println("Menú Niño creado: " + nombrePlato);
                }
                case 4 -> {
                    // Generar valores aleatorios para MenuEconomico
                    double porcentajeDescuento = 0.10 + (random.nextDouble() * 0.20); // 0.10 - 0.30
                    String nombrePlato = platosMenuEconomico[random.nextInt(platosMenuEconomico.length)];
                    double valorInicial = 2.0 + (random.nextDouble() * 2.5); // 2.0 - 4.5
                    
                    MenuEconomico menuEconomico = new MenuEconomico(porcentajeDescuento, nombrePlato, valorInicial);
                    menuEconomico.calcularvalorTotal();
                    menuSeleccionado = menuEconomico;
                    
                    System.out.println("Menú Económico creado: " + nombrePlato);
                }
                default -> {
                    System.out.println("Opción inválida. Intente nuevamente.");
                    continue;
                }
            }
            
            if (menuSeleccionado != null) {
                menus.add(menuSeleccionado);
                System.out.println("Menú añadido a la cuenta.");
                System.out.println("Detalles: " + menuSeleccionado);
            }
            
            System.out.println("\n¿Desea añadir otro menú? (S/N)");
            continuar = sc.nextLine().toUpperCase();
            
        } while (continuar.equals("S"));
        
        // Crear cuenta con todos los menús
        Cuenta cuenta = new Cuenta(nombreCliente, menus);
        cuenta.calcularIVA();
        cuenta.calcularTotal();
        
        System.out.println("\n=== CUENTA FINAL ===");
        System.out.println(cuenta);
        
        System.out.println("\n=== RESUMEN DE MENÚS ===");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i));
        }
        
        sc.close();
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

    @Override
    public String toString() {
        return "MenuNino{" + "valorHelado=" + valorHelado + ", valorPastel=" + valorPastel + ", heladosPedidos=" + heladosPedidos + ", totalHelados=" + totalHelados + ", pastelesPedidos=" + pastelesPedidos + ", totalPasteles=" + totalPasteles + "} " + super.toString();
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

    @Override
    public String toString() {
        return "MenuEconomico{" + "porcentajeDescuento=" + porcentajeDescuento + "} " + super.toString();
    }
    
}

class Cuenta {

    public String cliente;
    public ArrayList<Menu> menus;
    public double subTotalPagar;
    public double iva;
    public double totalPagar;

    public Cuenta(String cliente, ArrayList<Menu> menus) {
        this.cliente = cliente;
        this.menus = menus;
        this.calcularSubTotal();
    }
    
    private void calcularSubTotal() {
        this.subTotalPagar = 0;
        for (Menu menu : menus) {
            this.subTotalPagar += menu.valorTotal;
        }
    }

    public void calcularIVA() {
        this.iva = this.subTotalPagar * 0.15;
    }
    
    public void calcularTotal() {
        this.totalPagar = this.subTotalPagar + this.iva;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "cliente=" + cliente + ", cantidadMenus=" + menus.size() + ", subTotalPagar=" + String.format("%.2f", subTotalPagar) + ", iva=" + String.format("%.2f", iva) + ", totalPagar=" + String.format("%.2f", totalPagar) + '}';
    }

}