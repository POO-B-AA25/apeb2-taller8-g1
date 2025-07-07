
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problema5_PlataformaEmprendimientosLoja {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        String[] nombresTecnologicos = {"TechLoja", "InnovaSoft", "CodeCrafters", "DigitalHub", "SmartSolutions"};
        String[] nombresArtesanales = {"Artesanías Loja", "Manos Creativas", "Tradición Viva", "Arte Ancestral", "Tejidos del Sur"};
        String[] nombresAgricolas = {"Café Premium", "Frutas Andinas", "Orgánicos Loja", "Granja Verde", "Cosecha Dorada"};
        String[] nombresGastronomicos = {"Sabores Lojanos", "Cocina Fusion", "Delicias del Valle", "Restaurante Típico", "Panadería Artesanal"};
        String[] tecnologiasPrincipales = {"Java", "Python"};
        String[] materiales = {"Madera", "Cerámica", "Textil"};
        String[] cultivosPrincipales = {"Cafe", "Maiz", "Arroz"};
        String[] especialidades = {"Plato tipico", "Repostería", "Comida Internacional"};
        String[] mentoresDisponibles = {"Dr. María González - Marketing", "Ing. Carlos Vega - Contabilidad", "Lic. Ana Torres - Desarrollo Software", "Eco. Luis Morales - Finanzas", "Ing. Sofia Ruiz - Producción", "Dr. Pedro Jiménez - Comercio Internacional"};
        ArrayList<Emprendimiento> emprendimientos = new ArrayList<>();
        System.out.println("=== PLATAFORMA DE EMPRENDIMIENTOS LOJA ===");
        System.out.print("Ingrese el nombre de la organización: ");
        String nombreOrganizacion = sc.nextLine();
        System.out.print("Ingrese el período de registro (ej: 2024-S1): ");
        String periodo = sc.nextLine();
        String continuar;
        int idReporte = 1;

        do {
            System.out.println("\n--- REGISTRAR EMPRENDIMIENTOS ---");
            System.out.println("Período: " + periodo);
            ArrayList<Emprendimiento> emprendimientosPeriodo = new ArrayList<>();
            String continuarEmprendimientos = "S";

            do {
                System.out.println("\nSeleccione el tipo de emprendimiento:");
                System.out.println("1. Tecnológico");
                System.out.println("2. Artesanal");
                System.out.println("3. Agrícola");
                System.out.println("4. Gastronómico");
                System.out.print("Opción: ");

                int tipoEmprendimiento = sc.nextInt();
                sc.nextLine();
                if (tipoEmprendimiento < 1 || tipoEmprendimiento > 4) {
                    System.out.println("Tipo inválido. Intente nuevamente.");
                    continue;
                }

                String nombre = "";
                String[] nombresArray;

                switch (tipoEmprendimiento) {
                    case 1 -> {
                        nombresArray = nombresTecnologicos;
                        nombre = nombresArray[random.nextInt(nombresArray.length)];
                    }
                    case 2 -> {
                        nombresArray = nombresArtesanales;
                        nombre = nombresArray[random.nextInt(nombresArray.length)];
                    }
                    case 3 -> {
                        nombresArray = nombresAgricolas;
                        nombre = nombresArray[random.nextInt(nombresArray.length)];
                    }
                    case 4 -> {
                        nombresArray = nombresGastronomicos;
                        nombre = nombresArray[random.nextInt(nombresArray.length)];
                    }
                }

                String idEmprendimiento = "EMP" + String.format("%03d", random.nextInt(999) + 1);
                String propietario = "Propietario " + (random.nextInt(100) + 1);
                String contacto = "09" + String.format("%08d", random.nextInt(99999999));

                System.out.println("Emprendimiento: " + nombre);
                System.out.println("ID: " + idEmprendimiento);
                System.out.println("Propietario: " + propietario);
                System.out.println("Contacto: " + contacto);
                Emprendimiento emprendimientoCreado = null;

                switch (tipoEmprendimiento) {
                    case 1 -> {
                        int clientesAtendidos = random.nextInt(500) + 50;
                        int proyectosDesarrollados = random.nextInt(20) + 5;
                        String tecnologiaPrincipal = tecnologiasPrincipales[random.nextInt(tecnologiasPrincipales.length)];
                        boolean tieneApp = random.nextBoolean();

                        EmprendimientoTecnologico empTech = new EmprendimientoTecnologico(idEmprendimiento, nombre, propietario, contacto, clientesAtendidos, proyectosDesarrollados, tecnologiaPrincipal, tieneApp);
                        empTech.desarrollarProductos();
                        empTech.evaluarCrecimiento();
                        empTech.participarEnFeria("TechFair Loja");
                        emprendimientoCreado = empTech;
                    }
                    case 2 -> {
                        int productosUnicos = random.nextInt(50) + 10;
                        String materialPrincipal = materiales[random.nextInt(materiales.length)];
                        boolean esPatrimonio = random.nextBoolean();
                        int añosExperiencia = random.nextInt(25) + 5;

                        EmprendimientoArtesanal empArt = new EmprendimientoArtesanal(idEmprendimiento, nombre, propietario, contacto, productosUnicos, materialPrincipal, esPatrimonio, añosExperiencia);
                        empArt.desarrollarProductos();
                        empArt.evaluarCrecimiento();
                        empArt.participarEnFeria("Feria Artesanal Loja");
                        emprendimientoCreado = empArt;
                    }
                    case 3 -> { 
                        double hectareasCultivo = 1.0 + (random.nextDouble() * 19.0);
                        String cultivoPrincipal = cultivosPrincipales[random.nextInt(cultivosPrincipales.length)];
                        boolean esCertificadoOrganico = random.nextBoolean();
                        int toneladas = random.nextInt(100) + 10;

                        EmprendimientoAgricola empAgri = new EmprendimientoAgricola( idEmprendimiento, nombre, propietario, contacto, hectareasCultivo, cultivoPrincipal, esCertificadoOrganico, toneladas);
                        empAgri.desarrollarProductos();
                        empAgri.evaluarCrecimiento();
                        empAgri.participarEnFeria("Feria Agrícola Regional");
                        emprendimientoCreado = empAgri;
                    }
                    case 4 -> {
                        int platosMenu = random.nextInt(30) + 15;
                        String especialidad = especialidades[random.nextInt(especialidades.length)];
                        boolean tieneDelivery = random.nextBoolean();
                        int clientesDiarios = random.nextInt(150) + 20;
                        EmprendimientoGastronomico empGast = new EmprendimientoGastronomico( idEmprendimiento, nombre, propietario, contacto, platosMenu, especialidad, tieneDelivery, clientesDiarios);
                        empGast.desarrollarProductos();
                        empGast.evaluarCrecimiento();
                        empGast.participarEnFeria("Festival Gastronómico Loja");
                    }
                }
                if (emprendimientoCreado != null) {
                    if (emprendimientoCreado.requiereAcompañamiento()) {
                        int numMentores = random.nextInt(3) + 1;
                        for (int i = 0; i < numMentores; i++) {
                            String mentor = mentoresDisponibles[random.nextInt(mentoresDisponibles.length)];
                            emprendimientoCreado.asignarMentor(mentor);
                        }
                    }
                    System.out.println(emprendimientoCreado);
                    emprendimientosPeriodo.add(emprendimientoCreado);

                    if (!emprendimientoCreado.mentores.isEmpty()) {
                        System.out.println("Mentores asignados:");
                        for (String mentor : emprendimientoCreado.mentores) {
                            System.out.println("  - " + mentor);
                        }
                    }
                }

                System.out.println("\n¿Desea registrar otro emprendimiento en este período? (S/N)");
                continuarEmprendimientos = sc.nextLine();

            } while (continuarEmprendimientos.equals("S"));

            emprendimientos.addAll(emprendimientosPeriodo);
            System.out.println("\n=== EMPRENDIMIENTOS REGISTRADOS ===");
            for (Emprendimiento emp : emprendimientosPeriodo) {
                System.out.println(emp);
            }
            
            System.out.println("\n=== SIMULACIÓN DE EVOLUCIÓN ===");
            for (Emprendimiento emp : emprendimientosPeriodo) {
                emp.simularEvolucion();
                System.out.println(emp);
            }

            System.out.println("\n¿Desea registrar otro período? (S/N)");
            continuar = sc.nextLine().toUpperCase();
            if (continuar.equals("S")) {
                System.out.print("Ingrese el nuevo período: ");
                periodo = sc.nextLine();
            }

            idReporte++;

        } while (continuar.equals("S"));
        System.out.println("\n=== RESUMEN FINAL DE LA PLATAFORMA ===");
        System.out.println("Organización: " + nombreOrganizacion);
        System.out.println("Total de emprendimientos: " + emprendimientos.size());
    }
}

abstract class Emprendimiento {
    public String id;
    public String nombre;
    public String propietario;
    public String contacto;
    public String mision;
    public String estado;
    public ArrayList<String> productos;
    public ArrayList<String> mentores;
    public Emprendimiento(String id, String nombre, String propietario, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.propietario = propietario;
        this.contacto = contacto;
        this.mision = "Generar valor e impacto en la comunidad de Loja";
        this.estado = "Iniciando";
        this.productos = new ArrayList<>();
        this.mentores = new ArrayList<>();
    }
    public abstract void desarrollarProductos();
    public abstract void evaluarCrecimiento();
    public abstract void participarEnFeria(String tipoFeria);
    public abstract void simularEvolucion();
    public abstract boolean requiereAcompañamiento();
    public void asignarMentor(String mentor) {
        mentores.add(mentor);
    }
    @Override
    public String toString() {
        return "Emprendimiento{" + "id=" + id + ", nombre=" + nombre + ", propietario=" + propietario + ", contacto=" + contacto + ", estado=" + estado + ", productos=" + productos.size() + ", mentores=" + mentores.size() + '}';
    }
}

class EmprendimientoTecnologico extends Emprendimiento {
    public int clientesAtendidos;
    public int proyectosDesarrollados;
    public String tecnologiaPrincipal;
    public boolean tieneApp;
    public EmprendimientoTecnologico(String id, String nombre, String propietario, String contacto, int clientesAtendidos, int proyectosDesarrollados, String tecnologiaPrincipal, boolean tieneApp) {
        super(id, nombre, propietario, contacto);
        this.clientesAtendidos = clientesAtendidos;
        this.proyectosDesarrollados = proyectosDesarrollados;
        this.tecnologiaPrincipal = tecnologiaPrincipal;
        this.tieneApp = tieneApp;
    }
    @Override
    public void desarrollarProductos() {
        productos.add("Desarrollo de software personalizado");
        productos.add("Consultoría en " + tecnologiaPrincipal);
        if (tieneApp) {
            productos.add("Aplicación móvil");
        }
        productos.add("Soporte técnico");
    }
    @Override
    public void evaluarCrecimiento() {
        if (clientesAtendidos > 300 && proyectosDesarrollados > 15) {
            estado = "Consolidado";
        } else if (clientesAtendidos > 150) {
            estado = "Creciendo";
        } else {
            estado = "Iniciando";
        }
    }
    @Override
    public void participarEnFeria(String tipoFeria) {
        System.out.println(nombre + " participará en " + tipoFeria + " con demo tecnológica");
    }
    @Override
    public void simularEvolucion() {
        clientesAtendidos += 50;
        proyectosDesarrollados += 3;
        if (!tieneApp && clientesAtendidos > 200) {
            tieneApp = true;
            productos.add("Nueva app móvil");
        }
        evaluarCrecimiento();
    }
    @Override
    public boolean requiereAcompañamiento() {
        return proyectosDesarrollados < 10 || !tieneApp;
    }

    @Override
    public String toString() {
        return "EmprendimientoTecnologico{" + "id=" + id + ", nombre=" + nombre + ", clientes=" + clientesAtendidos + ", proyectos=" + proyectosDesarrollados + ", tecnologia=" + tecnologiaPrincipal + ", tieneApp=" + tieneApp + ", estado=" + estado + ", productos=" + productos.size() + " }" + super.toString();
    }
}

class EmprendimientoArtesanal extends Emprendimiento {
    public int productosUnicos;
    public String materialPrincipal;
    public boolean esPatrimonio;
    public int anosExperiencia;
    public EmprendimientoArtesanal(String id, String nombre, String propietario, String contacto, int productosUnicos, String materialPrincipal, boolean esPatrimonio, int anosExperiencia) {
        super(id, nombre, propietario, contacto);
        this.productosUnicos = productosUnicos;
        this.materialPrincipal = materialPrincipal;
        this.esPatrimonio = esPatrimonio;
        this.anosExperiencia = anosExperiencia;
    }
    @Override
    public void desarrollarProductos() {
        productos.add("Artesanías en " + materialPrincipal);
        productos.add("Productos decorativos");
        if (esPatrimonio) {
            productos.add("Productos de patrimonio cultural");
        }
        productos.add("Talleres artesanales");
    }
    @Override
    public void evaluarCrecimiento() {
        if (productosUnicos > 30 && anosExperiencia > 15) {
            estado = "Maestro artesano";
        } else if (productosUnicos > 20) {
            estado = "Artesano reconocido";
        } else {
            estado = "Artesano en formación";
        }
    }
    @Override
    public void participarEnFeria(String tipoFeria) {
        System.out.println(nombre + " participará en " + tipoFeria + " con exhibición artesanal");
    }
    @Override
    public void simularEvolucion() {
        productosUnicos += 5;
        anosExperiencia += 1;
        if (productosUnicos > 40) {
            productos.add("Línea premium de productos");
        }
        evaluarCrecimiento();
    }
    @Override
    public boolean requiereAcompañamiento() {
        return anosExperiencia < 10 || productosUnicos < 20;
    }
    @Override
    public String toString() {
        return "EmprendimientoArtesanal{" + "id=" + id + ", nombre=" + nombre + ", productos=" + productosUnicos + ", material=" + materialPrincipal + ", patrimonio=" + esPatrimonio + ", experiencia=" + anosExperiencia + ", estado=" + estado + " }" + super.toString();
    }
}

class EmprendimientoAgricola extends Emprendimiento {
    public double hectareasCultivo;
    public String cultivoPrincipal;
    public boolean esCertificadoOrganico;
    public int toneladas;
    public EmprendimientoAgricola(String id, String nombre, String propietario, String contacto, double hectareasCultivo, String cultivoPrincipal, boolean esCertificadoOrganico, int toneladas) {
        super(id, nombre, propietario, contacto);
        this.hectareasCultivo = hectareasCultivo;
        this.cultivoPrincipal = cultivoPrincipal;
        this.esCertificadoOrganico = esCertificadoOrganico;
        this.toneladas = toneladas;
    }
    @Override
    public void desarrollarProductos() {
        productos.add(cultivoPrincipal + " fresco");
        productos.add("Productos procesados de " + cultivoPrincipal);
        if (esCertificadoOrganico) {
            productos.add("Certificación orgánica");
        }
        productos.add("Semillas y plantines");
    }
    @Override
    public void evaluarCrecimiento() {
        if (hectareasCultivo > 15 && toneladas > 80) {
            estado = "Productor consolidado";
        } else if (hectareasCultivo > 8) {
            estado = "Productor en crecimiento";
        } else {
            estado = "Pequeño productor";
        }
    }
    @Override
    public void participarEnFeria(String tipoFeria) {
        System.out.println(nombre + " participará en " + tipoFeria + " con degustación de productos");
    }
    @Override
    public void simularEvolucion() {
        hectareasCultivo += 2.0;
        toneladas += 15;
        if (hectareasCultivo > 20) {
            productos.add("Exportación internacional");
        }
        evaluarCrecimiento();
    }
    @Override
    public boolean requiereAcompañamiento() {
        return hectareasCultivo < 10 || !esCertificadoOrganico;
    }
    @Override
    public String toString() {
        return "EmprendimientoAgricola{" + "id=" + id + ", nombre=" + nombre + ", hectareas=" + String.format("%.1f", hectareasCultivo) + ", cultivo=" + cultivoPrincipal + ", organico=" + esCertificadoOrganico + ", produccion=" + toneladas + ", estado=" + estado + " }" + super.toString();
    }
}

class EmprendimientoGastronomico extends Emprendimiento {
    public int platosMenu;
    public String especialidad;
    public boolean tieneDelivery;
    public int clientesDiarios;
    public EmprendimientoGastronomico(String id, String nombre, String propietario, String contacto, int platosMenu, String especialidad, boolean tieneDelivery, int clientesDiarios) {
        super(id, nombre, propietario, contacto);
        this.platosMenu = platosMenu;
        this.especialidad = especialidad;
        this.tieneDelivery = tieneDelivery;
        this.clientesDiarios = clientesDiarios;
    }
    @Override
    public void desarrollarProductos() {
        productos.add("Menú de " + especialidad);
        productos.add("Servicio de restaurante");
        if (tieneDelivery) {
            productos.add("Servicio de delivery");
        }
        productos.add("Eventos y catering");
    }
    @Override
    public void evaluarCrecimiento() {
        if (clientesDiarios > 120 && platosMenu > 25) {
            estado = "Restaurante establecido";
        } else if (clientesDiarios > 60) {
            estado = "Negocio en crecimiento";
        } else {
            estado = "Negocio familiar";
        }
    }
    @Override
    public void participarEnFeria(String tipoFeria) {
        System.out.println(nombre + " participará en " + tipoFeria + " con degustación gastronómica");
    }
    @Override
    public void simularEvolucion() {
        platosMenu += 5;
        clientesDiarios += 20;
        if (clientesDiarios > 100 && !tieneDelivery) {
            tieneDelivery = true;
            productos.add("Nuevo servicio de delivery");
        }
        evaluarCrecimiento();
    }
    @Override
    public boolean requiereAcompañamiento() {
        return clientesDiarios < 80 || platosMenu < 20;
    }
    @Override
    public String toString() {
        return "EmprendimientoGastronomico{" + "id=" + id + ", nombre=" + nombre + ", platos=" + platosMenu + ", especialidad=" + especialidad + ", delivery=" + tieneDelivery + ", clientes=" + clientesDiarios + ", estado=" + estado + " }" + super.toString();
    }
}
