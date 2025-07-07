<<<<<<< HEAD

=======
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Problema5_PlataformaEmprendimientosLoja {
<<<<<<< HEAD

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
=======
    
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        
        // Datos predefinidos
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        String[] nombresTecnologicos = {"TechLoja", "InnovaSoft", "CodeCrafters", "DigitalHub", "SmartSolutions"};
        String[] nombresArtesanales = {"Artesanías Loja", "Manos Creativas", "Tradición Viva", "Arte Ancestral", "Tejidos del Sur"};
        String[] nombresAgricolas = {"Café Premium", "Frutas Andinas", "Orgánicos Loja", "Granja Verde", "Cosecha Dorada"};
        String[] nombresGastronomicos = {"Sabores Lojanos", "Cocina Fusion", "Delicias del Valle", "Restaurante Típico", "Panadería Artesanal"};
<<<<<<< HEAD
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

=======
        
        String[] mentoresDisponibles = {"Dr. María González - Marketing", "Ing. Carlos Vega - Contabilidad", 
                                       "Lic. Ana Torres - Desarrollo Software", "Eco. Luis Morales - Finanzas",
                                       "Ing. Sofia Ruiz - Producción", "Dr. Pedro Jiménez - Comercio Internacional"};
        
        ArrayList<Emprendimiento> emprendimientos = new ArrayList<>();
        ArrayList<ReporteEmprendimiento> reportes = new ArrayList<>();
        
        System.out.println("=== PLATAFORMA DE EMPRENDIMIENTOS LOJA ===");
        System.out.print("Ingrese el nombre de la organización: ");
        String nombreOrganizacion = sc.nextLine();
        
        System.out.print("Ingrese el período de registro (ej: 2024-S1): ");
        String periodo = sc.nextLine();
        
        String continuar = "S";
        int idReporte = 1;
        
        do {
            System.out.println("\n--- REGISTRAR EMPRENDIMIENTOS ---");
            System.out.println("Período: " + periodo);
            
            ArrayList<Emprendimiento> emprendimientosPeriodo = new ArrayList<>();
            String continuarEmprendimientos = "S";
            
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
            do {
                System.out.println("\nSeleccione el tipo de emprendimiento:");
                System.out.println("1. Tecnológico");
                System.out.println("2. Artesanal");
                System.out.println("3. Agrícola");
                System.out.println("4. Gastronómico");
                System.out.print("Opción: ");
<<<<<<< HEAD

                int tipoEmprendimiento = sc.nextInt();
                sc.nextLine();
=======
                
                int tipoEmprendimiento = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                if (tipoEmprendimiento < 1 || tipoEmprendimiento > 4) {
                    System.out.println("Tipo inválido. Intente nuevamente.");
                    continue;
                }
<<<<<<< HEAD

                String nombre = "";
                String[] nombresArray;

=======
                
                // Generar datos aleatorios del emprendimiento
                String nombre = "";
                String[] nombresArray = {};
                
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD

                String idEmprendimiento = "EMP" + String.format("%03d", random.nextInt(999) + 1);
                String propietario = "Propietario " + (random.nextInt(100) + 1);
                String contacto = "09" + String.format("%08d", random.nextInt(99999999));

=======
                
                String idEmprendimiento = "EMP" + String.format("%03d", random.nextInt(999) + 1);
                String propietario = "Propietario " + (random.nextInt(100) + 1);
                String contacto = "09" + String.format("%08d", random.nextInt(99999999));
                
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                System.out.println("Emprendimiento: " + nombre);
                System.out.println("ID: " + idEmprendimiento);
                System.out.println("Propietario: " + propietario);
                System.out.println("Contacto: " + contacto);
<<<<<<< HEAD
                Emprendimiento emprendimientoCreado = null;

                switch (tipoEmprendimiento) {
                    case 1 -> {
                        int clientesAtendidos = random.nextInt(500) + 50;
                        int proyectosDesarrollados = random.nextInt(20) + 5;
                        String tecnologiaPrincipal = tecnologiasPrincipales[random.nextInt(tecnologiasPrincipales.length)];
                        boolean tieneApp = random.nextBoolean();

                        EmprendimientoTecnologico empTech = new EmprendimientoTecnologico(idEmprendimiento, nombre, propietario, contacto, clientesAtendidos, proyectosDesarrollados, tecnologiaPrincipal, tieneApp);
=======
                
                // Crear emprendimiento según el tipo
                Emprendimiento emprendimientoCreado = null;
                
                switch (tipoEmprendimiento) {
                    case 1 -> { // Tecnológico
                        int clientesAtendidos = random.nextInt(500) + 50;
                        int proyectosDesarrollados = random.nextInt(20) + 5;
                        String tecnologiaPrincipal = random.nextBoolean() ? "Java" : 
                                                   random.nextBoolean() ? "Python" : "JavaScript";
                        boolean tieneApp = random.nextBoolean();
                        
                        EmprendimientoTecnologico empTech = new EmprendimientoTecnologico(
                            idEmprendimiento, nombre, propietario, contacto, 
                            clientesAtendidos, proyectosDesarrollados, tecnologiaPrincipal, tieneApp);
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                        empTech.desarrollarProductos();
                        empTech.evaluarCrecimiento();
                        empTech.participarEnFeria("TechFair Loja");
                        emprendimientoCreado = empTech;
<<<<<<< HEAD
                    }
                    case 2 -> {
                        int productosUnicos = random.nextInt(50) + 10;
                        String materialPrincipal = materiales[random.nextInt(materiales.length)];
                        boolean esPatrimonio = random.nextBoolean();
                        int añosExperiencia = random.nextInt(25) + 5;

                        EmprendimientoArtesanal empArt = new EmprendimientoArtesanal(idEmprendimiento, nombre, propietario, contacto, productosUnicos, materialPrincipal, esPatrimonio, añosExperiencia);
=======
                        
                        System.out.println("Emprendimiento Tecnológico creado:");
                        System.out.println("- Clientes atendidos: " + clientesAtendidos);
                        System.out.println("- Proyectos desarrollados: " + proyectosDesarrollados);
                        System.out.println("- Tecnología principal: " + tecnologiaPrincipal);
                        System.out.println("- Tiene app móvil: " + (tieneApp ? "Sí" : "No"));
                    }
                    case 2 -> { // Artesanal
                        int productosUnicos = random.nextInt(50) + 10;
                        String materialPrincipal = random.nextBoolean() ? "Madera" : 
                                                  random.nextBoolean() ? "Cerámica" : "Textil";
                        boolean esPatrimonio = random.nextBoolean();
                        int añosExperiencia = random.nextInt(25) + 5;
                        
                        EmprendimientoArtesanal empArt = new EmprendimientoArtesanal(
                            idEmprendimiento, nombre, propietario, contacto,
                            productosUnicos, materialPrincipal, esPatrimonio, añosExperiencia);
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                        empArt.desarrollarProductos();
                        empArt.evaluarCrecimiento();
                        empArt.participarEnFeria("Feria Artesanal Loja");
                        emprendimientoCreado = empArt;
<<<<<<< HEAD
                    }
                    case 3 -> { 
                        double hectareasCultivo = 1.0 + (random.nextDouble() * 19.0);
                        String cultivoPrincipal = cultivosPrincipales[random.nextInt(cultivosPrincipales.length)];
                        boolean esCertificadoOrganico = random.nextBoolean();
                        int toneladas = random.nextInt(100) + 10;

                        EmprendimientoAgricola empAgri = new EmprendimientoAgricola( idEmprendimiento, nombre, propietario, contacto, hectareasCultivo, cultivoPrincipal, esCertificadoOrganico, toneladas);
=======
                        
                        System.out.println("Emprendimiento Artesanal creado:");
                        System.out.println("- Productos únicos: " + productosUnicos);
                        System.out.println("- Material principal: " + materialPrincipal);
                        System.out.println("- Es patrimonio cultural: " + (esPatrimonio ? "Sí" : "No"));
                        System.out.println("- Años de experiencia: " + añosExperiencia);
                    }
                    case 3 -> { // Agrícola
                        double hectareasCultivo = 1.0 + (random.nextDouble() * 19.0); // 1-20 hectáreas
                        String cultivoPrincipal = random.nextBoolean() ? "Café" : 
                                                 random.nextBoolean() ? "Maíz" : "Frutas";
                        boolean esCertificadoOrganico = random.nextBoolean();
                        int toneladas = random.nextInt(100) + 10;
                        
                        EmprendimientoAgricola empAgri = new EmprendimientoAgricola(
                            idEmprendimiento, nombre, propietario, contacto,
                            hectareasCultivo, cultivoPrincipal, esCertificadoOrganico, toneladas);
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                        empAgri.desarrollarProductos();
                        empAgri.evaluarCrecimiento();
                        empAgri.participarEnFeria("Feria Agrícola Regional");
                        emprendimientoCreado = empAgri;
<<<<<<< HEAD
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
=======
                        
                        System.out.println("Emprendimiento Agrícola creado:");
                        System.out.println("- Hectáreas de cultivo: " + String.format("%.1f", hectareasCultivo));
                        System.out.println("- Cultivo principal: " + cultivoPrincipal);
                        System.out.println("- Certificado orgánico: " + (esCertificadoOrganico ? "Sí" : "No"));
                        System.out.println("- Producción anual: " + toneladas + " toneladas");
                    }
                    case 4 -> { // Gastronómico
                        int platosMenu = random.nextInt(30) + 15;
                        String especialidad = random.nextBoolean() ? "Comida Típica" : 
                                             random.nextBoolean() ? "Repostería" : "Comida Internacional";
                        boolean tieneDelivery = random.nextBoolean();
                        int clientesDiarios = random.nextInt(150) + 20;
                        
                        EmprendimientoGastronomico empGast = new EmprendimientoGastronomico(
                            idEmprendimiento, nombre, propietario, contacto,
                            platosMenu, especialidad, tieneDelivery, clientesDiarios);
                        empGast.desarrollarProductos();
                        empGast.evaluarCrecimiento();
                        empGast.participarEnFeria("Festival Gastronómico Loja");
                        emprendimientoCreado = empGast;
                        
                        System.out.println("Emprendimiento Gastronómico creado:");
                        System.out.println("- Platos en el menú: " + platosMenu);
                        System.out.println("- Especialidad: " + especialidad);
                        System.out.println("- Tiene delivery: " + (tieneDelivery ? "Sí" : "No"));
                        System.out.println("- Clientes diarios: " + clientesDiarios);
                    }
                }
                
                // Asignar mentores si es necesario
                if (emprendimientoCreado != null) {
                    if (emprendimientoCreado.requiereAcompañamiento()) {
                        int numMentores = random.nextInt(3) + 1; // 1-3 mentores
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                        for (int i = 0; i < numMentores; i++) {
                            String mentor = mentoresDisponibles[random.nextInt(mentoresDisponibles.length)];
                            emprendimientoCreado.asignarMentor(mentor);
                        }
                    }
<<<<<<< HEAD
                    System.out.println(emprendimientoCreado);
                    emprendimientosPeriodo.add(emprendimientoCreado);

=======
                    
                    emprendimientosPeriodo.add(emprendimientoCreado);
                    
                    System.out.println("Estado: " + emprendimientoCreado.estado);
                    System.out.println("Productos/Servicios: " + emprendimientoCreado.productos.size());
                    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
                    if (!emprendimientoCreado.mentores.isEmpty()) {
                        System.out.println("Mentores asignados:");
                        for (String mentor : emprendimientoCreado.mentores) {
                            System.out.println("  - " + mentor);
                        }
                    }
                }
<<<<<<< HEAD

                System.out.println("\n¿Desea registrar otro emprendimiento en este período? (S/N)");
                continuarEmprendimientos = sc.nextLine();

            } while (continuarEmprendimientos.equals("S"));

            emprendimientos.addAll(emprendimientosPeriodo);
=======
                
                System.out.println("\n¿Desea registrar otro emprendimiento en este período? (S/N)");
                continuarEmprendimientos = sc.nextLine().toUpperCase();
                
            } while (continuarEmprendimientos.equals("S"));
            
            // Crear reporte
            ReporteEmprendimiento reporte = new ReporteEmprendimiento(
                idReporte, periodo, nombreOrganizacion, emprendimientosPeriodo);
            reportes.add(reporte);
            
            // Añadir emprendimientos a la lista general
            emprendimientos.addAll(emprendimientosPeriodo);
            
            System.out.println("\n=== REPORTE DE EMPRENDIMIENTOS GENERADO ===");
            System.out.println(reporte);
            
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
            System.out.println("\n=== EMPRENDIMIENTOS REGISTRADOS ===");
            for (Emprendimiento emp : emprendimientosPeriodo) {
                System.out.println(emp);
            }
            
<<<<<<< HEAD
            System.out.println("\n=== SIMULACIÓN DE EVOLUCIÓN ===");
            for (Emprendimiento emp : emprendimientosPeriodo) {
                emp.simularEvolucion();
                System.out.println(emp);
            }

            System.out.println("\n¿Desea registrar otro período? (S/N)");
            continuar = sc.nextLine().toUpperCase();
=======
            // Simular evolución de emprendimientos
            System.out.println("\n=== SIMULACIÓN DE EVOLUCIÓN ===");
            for (Emprendimiento emp : emprendimientosPeriodo) {
                emp.simularEvolucion();
                System.out.println(emp.nombre + " - Nueva fase: " + emp.estado);
            }
            
            System.out.println("\n¿Desea registrar otro período? (S/N)");
            continuar = sc.nextLine().toUpperCase();
            
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
            if (continuar.equals("S")) {
                System.out.print("Ingrese el nuevo período: ");
                periodo = sc.nextLine();
            }
<<<<<<< HEAD

            idReporte++;

        } while (continuar.equals("S"));
        System.out.println("\n=== RESUMEN FINAL DE LA PLATAFORMA ===");
        System.out.println("Organización: " + nombreOrganizacion);
        System.out.println("Total de emprendimientos: " + emprendimientos.size());
=======
            
            idReporte++;
            
        } while (continuar.equals("S"));
        
        System.out.println("\n=== RESUMEN FINAL DE LA PLATAFORMA ===");
        System.out.println("Organización: " + nombreOrganizacion);
        System.out.println("Períodos registrados: " + reportes.size());
        System.out.println("Total de emprendimientos: " + emprendimientos.size());
        
        // Estadísticas por tipo
        long empTecnologicos = emprendimientos.stream().filter(e -> e instanceof EmprendimientoTecnologico).count();
        long empArtesanales = emprendimientos.stream().filter(e -> e instanceof EmprendimientoArtesanal).count();
        long empAgricolas = emprendimientos.stream().filter(e -> e instanceof EmprendimientoAgricola).count();
        long empGastronomicos = emprendimientos.stream().filter(e -> e instanceof EmprendimientoGastronomico).count();
        
        System.out.println("\n=== DISTRIBUCIÓN POR TIPO ===");
        System.out.println("Tecnológicos: " + empTecnologicos);
        System.out.println("Artesanales: " + empArtesanales);
        System.out.println("Agrícolas: " + empAgricolas);
        System.out.println("Gastronómicos: " + empGastronomicos);
        
        System.out.println("\n=== HISTORIAL DE REPORTES ===");
        for (ReporteEmprendimiento reporte : reportes) {
            System.out.println("Reporte " + reporte.id + " - " + reporte.periodo + 
                             " (" + reporte.emprendimientos.size() + " emprendimientos)");
        }
        
        sc.close();
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

abstract class Emprendimiento {
<<<<<<< HEAD
    public String id;
    public String nombre;
    public String propietario;
    public String contacto;
    public String mision;
    public String estado;
    public ArrayList<String> productos;
    public ArrayList<String> mentores;
=======
    protected String id;
    protected String nombre;
    protected String propietario;
    protected String contacto;
    protected String mision;
    protected String estado;
    protected ArrayList<String> productos;
    protected ArrayList<String>     ;
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    public abstract void desarrollarProductos();
    public abstract void evaluarCrecimiento();
    public abstract void participarEnFeria(String tipoFeria);
    public abstract void simularEvolucion();
    public abstract boolean requiereAcompañamiento();
<<<<<<< HEAD
    public void asignarMentor(String mentor) {
        mentores.add(mentor);
    }
    @Override
    public String toString() {
        return "Emprendimiento{" + "id=" + id + ", nombre=" + nombre + ", propietario=" + propietario + ", contacto=" + contacto + ", estado=" + estado + ", productos=" + productos.size() + ", mentores=" + mentores.size() + '}';
=======
    
    public void asignarMentor(String mentor) {
        if (!mentores.contains(mentor)) {
            mentores.add(mentor);
        }
    }
    
    @Override
    public String toString() {
        return "Emprendimiento{" + "id=" + id + ", nombre=" + nombre + 
               ", propietario=" + propietario + ", contacto=" + contacto + 
               ", estado=" + estado + ", productos=" + productos.size() + 
               ", mentores=" + mentores.size() + '}';
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

class EmprendimientoTecnologico extends Emprendimiento {
<<<<<<< HEAD
    public int clientesAtendidos;
    public int proyectosDesarrollados;
    public String tecnologiaPrincipal;
    public boolean tieneApp;
    public EmprendimientoTecnologico(String id, String nombre, String propietario, String contacto, int clientesAtendidos, int proyectosDesarrollados, String tecnologiaPrincipal, boolean tieneApp) {
=======
    private int clientesAtendidos;
    private int proyectosDesarrollados;
    private String tecnologiaPrincipal;
    private boolean tieneApp;
    
    public EmprendimientoTecnologico(String id, String nombre, String propietario, String contacto,
                                   int clientesAtendidos, int proyectosDesarrollados, 
                                   String tecnologiaPrincipal, boolean tieneApp) {
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        super(id, nombre, propietario, contacto);
        this.clientesAtendidos = clientesAtendidos;
        this.proyectosDesarrollados = proyectosDesarrollados;
        this.tecnologiaPrincipal = tecnologiaPrincipal;
        this.tieneApp = tieneApp;
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void desarrollarProductos() {
        productos.add("Desarrollo de software personalizado");
        productos.add("Consultoría en " + tecnologiaPrincipal);
        if (tieneApp) {
            productos.add("Aplicación móvil");
        }
        productos.add("Soporte técnico");
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void participarEnFeria(String tipoFeria) {
        System.out.println(nombre + " participará en " + tipoFeria + " con demo tecnológica");
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public boolean requiereAcompañamiento() {
        return proyectosDesarrollados < 10 || !tieneApp;
    }
<<<<<<< HEAD

    @Override
    public String toString() {
        return "EmprendimientoTecnologico{" + "id=" + id + ", nombre=" + nombre + ", clientes=" + clientesAtendidos + ", proyectos=" + proyectosDesarrollados + ", tecnologia=" + tecnologiaPrincipal + ", tieneApp=" + tieneApp + ", estado=" + estado + ", productos=" + productos.size() + " }" + super.toString();
=======
    
    @Override
    public String toString() {
        return "EmprendimientoTecnologico{" + "id=" + id + ", nombre=" + nombre + 
               ", clientes=" + clientesAtendidos + ", proyectos=" + proyectosDesarrollados + 
               ", tecnologia=" + tecnologiaPrincipal + ", tieneApp=" + tieneApp + 
               ", estado=" + estado + ", productos=" + productos.size() + '}';
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

class EmprendimientoArtesanal extends Emprendimiento {
<<<<<<< HEAD
    public int productosUnicos;
    public String materialPrincipal;
    public boolean esPatrimonio;
    public int anosExperiencia;
    public EmprendimientoArtesanal(String id, String nombre, String propietario, String contacto, int productosUnicos, String materialPrincipal, boolean esPatrimonio, int anosExperiencia) {
=======
    private int productosUnicos;
    private String materialPrincipal;
    private boolean esPatrimonio;
    private int añosExperiencia;
    
    public EmprendimientoArtesanal(String id, String nombre, String propietario, String contacto,
                                 int productosUnicos, String materialPrincipal, 
                                 boolean esPatrimonio, int añosExperiencia) {
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        super(id, nombre, propietario, contacto);
        this.productosUnicos = productosUnicos;
        this.materialPrincipal = materialPrincipal;
        this.esPatrimonio = esPatrimonio;
<<<<<<< HEAD
        this.anosExperiencia = anosExperiencia;
    }
=======
        this.añosExperiencia = añosExperiencia;
    }
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void desarrollarProductos() {
        productos.add("Artesanías en " + materialPrincipal);
        productos.add("Productos decorativos");
        if (esPatrimonio) {
            productos.add("Productos de patrimonio cultural");
        }
        productos.add("Talleres artesanales");
    }
<<<<<<< HEAD
    @Override
    public void evaluarCrecimiento() {
        if (productosUnicos > 30 && anosExperiencia > 15) {
=======
    
    @Override
    public void evaluarCrecimiento() {
        if (productosUnicos > 30 && añosExperiencia > 15) {
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
            estado = "Maestro artesano";
        } else if (productosUnicos > 20) {
            estado = "Artesano reconocido";
        } else {
            estado = "Artesano en formación";
        }
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void participarEnFeria(String tipoFeria) {
        System.out.println(nombre + " participará en " + tipoFeria + " con exhibición artesanal");
    }
<<<<<<< HEAD
    @Override
    public void simularEvolucion() {
        productosUnicos += 5;
        anosExperiencia += 1;
=======
    
    @Override
    public void simularEvolucion() {
        productosUnicos += 5;
        añosExperiencia += 1;
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        if (productosUnicos > 40) {
            productos.add("Línea premium de productos");
        }
        evaluarCrecimiento();
    }
<<<<<<< HEAD
    @Override
    public boolean requiereAcompañamiento() {
        return anosExperiencia < 10 || productosUnicos < 20;
    }
    @Override
    public String toString() {
        return "EmprendimientoArtesanal{" + "id=" + id + ", nombre=" + nombre + ", productos=" + productosUnicos + ", material=" + materialPrincipal + ", patrimonio=" + esPatrimonio + ", experiencia=" + anosExperiencia + ", estado=" + estado + " }" + super.toString();
=======
    
    @Override
    public boolean requiereAcompañamiento() {
        return añosExperiencia < 10 || productosUnicos < 20;
    }
    
    @Override
    public String toString() {
        return "EmprendimientoArtesanal{" + "id=" + id + ", nombre=" + nombre + 
               ", productos=" + productosUnicos + ", material=" + materialPrincipal + 
               ", patrimonio=" + esPatrimonio + ", experiencia=" + añosExperiencia + 
               ", estado=" + estado + '}';
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

class EmprendimientoAgricola extends Emprendimiento {
<<<<<<< HEAD
    public double hectareasCultivo;
    public String cultivoPrincipal;
    public boolean esCertificadoOrganico;
    public int toneladas;
    public EmprendimientoAgricola(String id, String nombre, String propietario, String contacto, double hectareasCultivo, String cultivoPrincipal, boolean esCertificadoOrganico, int toneladas) {
=======
    private double hectareasCultivo;
    private String cultivoPrincipal;
    private boolean esCertificadoOrganico;
    private int toneladas;
    
    public EmprendimientoAgricola(String id, String nombre, String propietario, String contacto,
                                double hectareasCultivo, String cultivoPrincipal, 
                                boolean esCertificadoOrganico, int toneladas) {
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        super(id, nombre, propietario, contacto);
        this.hectareasCultivo = hectareasCultivo;
        this.cultivoPrincipal = cultivoPrincipal;
        this.esCertificadoOrganico = esCertificadoOrganico;
        this.toneladas = toneladas;
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void desarrollarProductos() {
        productos.add(cultivoPrincipal + " fresco");
        productos.add("Productos procesados de " + cultivoPrincipal);
        if (esCertificadoOrganico) {
            productos.add("Certificación orgánica");
        }
        productos.add("Semillas y plantines");
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void participarEnFeria(String tipoFeria) {
        System.out.println(nombre + " participará en " + tipoFeria + " con degustación de productos");
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void simularEvolucion() {
        hectareasCultivo += 2.0;
        toneladas += 15;
        if (hectareasCultivo > 20) {
            productos.add("Exportación internacional");
        }
        evaluarCrecimiento();
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public boolean requiereAcompañamiento() {
        return hectareasCultivo < 10 || !esCertificadoOrganico;
    }
<<<<<<< HEAD
    @Override
    public String toString() {
        return "EmprendimientoAgricola{" + "id=" + id + ", nombre=" + nombre + ", hectareas=" + String.format("%.1f", hectareasCultivo) + ", cultivo=" + cultivoPrincipal + ", organico=" + esCertificadoOrganico + ", produccion=" + toneladas + ", estado=" + estado + " }" + super.toString();
=======
    
    @Override
    public String toString() {
        return "EmprendimientoAgricola{" + "id=" + id + ", nombre=" + nombre + 
               ", hectareas=" + String.format("%.1f", hectareasCultivo) + ", cultivo=" + cultivoPrincipal + 
               ", organico=" + esCertificadoOrganico + ", produccion=" + toneladas + 
               ", estado=" + estado + '}';
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    }
}

class EmprendimientoGastronomico extends Emprendimiento {
<<<<<<< HEAD
    public int platosMenu;
    public String especialidad;
    public boolean tieneDelivery;
    public int clientesDiarios;
    public EmprendimientoGastronomico(String id, String nombre, String propietario, String contacto, int platosMenu, String especialidad, boolean tieneDelivery, int clientesDiarios) {
=======
    private int platosMenu;
    private String especialidad;
    private boolean tieneDelivery;
    private int clientesDiarios;
    
    public EmprendimientoGastronomico(String id, String nombre, String propietario, String contacto,
                                    int platosMenu, String especialidad, 
                                    boolean tieneDelivery, int clientesDiarios) {
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
        super(id, nombre, propietario, contacto);
        this.platosMenu = platosMenu;
        this.especialidad = especialidad;
        this.tieneDelivery = tieneDelivery;
        this.clientesDiarios = clientesDiarios;
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void desarrollarProductos() {
        productos.add("Menú de " + especialidad);
        productos.add("Servicio de restaurante");
        if (tieneDelivery) {
            productos.add("Servicio de delivery");
        }
        productos.add("Eventos y catering");
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public void participarEnFeria(String tipoFeria) {
        System.out.println(nombre + " participará en " + tipoFeria + " con degustación gastronómica");
    }
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
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
<<<<<<< HEAD
=======
    
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
    @Override
    public boolean requiereAcompañamiento() {
        return clientesDiarios < 80 || platosMenu < 20;
    }
<<<<<<< HEAD
    @Override
    public String toString() {
        return "EmprendimientoGastronomico{" + "id=" + id + ", nombre=" + nombre + ", platos=" + platosMenu + ", especialidad=" + especialidad + ", delivery=" + tieneDelivery + ", clientes=" + clientesDiarios + ", estado=" + estado + " }" + super.toString();
    }
}
=======
    
    @Override
    public String toString() {
        return "EmprendimientoGastronomico{" + "id=" + id + ", nombre=" + nombre + 
               ", platos=" + platosMenu + ", especialidad=" + especialidad + 
               ", delivery=" + tieneDelivery + ", clientes=" + clientesDiarios + 
               ", estado=" + estado + '}';
    }
}

class ReporteEmprendimiento {
    public int id;
    public String periodo;
    public String organizacion;
    public ArrayList<Emprendimiento> emprendimientos;
    public int totalProductos;
    public int totalMentores;
    
    public ReporteEmprendimiento(int id, String periodo, String organizacion, 
                               ArrayList<Emprendimiento> emprendimientos) {
        this.id = id;
        this.periodo = periodo;
        this.organizacion = organizacion;
        this.emprendimientos = new ArrayList<>(emprendimientos);
        this.calcularTotales();
    }
    
    private void calcularTotales() {
        this.totalProductos = 0;
        this.totalMentores = 0;
        for (Emprendimiento emp : emprendimientos) {
            this.totalProductos += emp.productos.size();
            this.totalMentores += emp.mentores.size();
        }
    }
    
    @Override
    public String toString() {
        return "ReporteEmprendimiento{" + "id=" + id + ", periodo=" + periodo + 
               ", organizacion=" + organizacion + ", emprendimientos=" + emprendimientos.size() + 
               ", totalProductos=" + totalProductos + ", totalMentores=" + totalMentores + '}';
    }
}
>>>>>>> 5e3829b40e6ba2d1b0e80b9581fd4d81af7f167b
