import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilmotecaPeliAleatoria extends JFrame{

    JPanel jp;
    FilmotecaDAO gestor; //Objeto para acceder a la BD
    Pelicula peli; //Objeto Pelicula en el que cargaremos la pelicula aleatoria

    JLabel etiquetaTitulo, etiquetaDirector, etiquetaGenero, etiquetaDuracion, etiquetaNacionalidad, etiquetaYear;
    JLabel titulo, director, genero, duracion, nacionalidad, year;

    public FilmotecaPeliAleatoria() { 
        super("Película aleatoria del día"); 
        setSize(400,320);

        jp=new JPanel(false); 
        jp.setLayout(null);

        this.setContentPane(jp);

        // 2. Configurar el comportamiento al cerrar la ventana (Si es llamada desde fuera, libera recursos pero no cierra el programa)
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        // 3. Rellenamos el objeto con la pelicula elegida aleatoriamente
        gestor = new FilmotecaDAO();
        peli = gestor.peliculaAleatoria();

        // 4. Creamos la ventana
        this.creaVentana();
    } 


    public void creaVentana(){ //Creamos la vista
        //Creamos los elementos gráficos de la aplicación que estamos creando
        getContentPane().setLayout(null); 

        //Título de la película
        etiquetaTitulo = new JLabel("Título: ");
        etiquetaTitulo.setBounds(30, 30, 100, 20);
        getContentPane().add(etiquetaTitulo);

        titulo = new JLabel(peli.getTitulo());
        titulo.setBounds(130, 30, 200, 20);
        getContentPane().add(titulo);

        //Director de la película
        etiquetaDirector = new JLabel("Director: ");
        etiquetaDirector.setBounds(30, 70, 200, 20);
        getContentPane().add(etiquetaDirector);

        director = new JLabel(peli.getDirector());
        director.setBounds(130, 70, 200, 20);
        getContentPane().add(director);

        //Género de la película
        etiquetaGenero = new JLabel("Género: ");
        etiquetaGenero.setBounds(30, 110, 200, 20);
        getContentPane().add(etiquetaGenero);

        genero = new JLabel(peli.getGenero());
        genero.setBounds(130, 110, 200, 20);
        getContentPane().add(genero);

        //Duración de la película
        etiquetaDuracion = new JLabel("Duración: ");
        etiquetaDuracion.setBounds(30, 150, 200, 20);
        getContentPane().add(etiquetaDuracion);

        duracion = new JLabel(peli.getDuracion()+" minutos");
        duracion.setBounds(130, 150, 200, 20);
        getContentPane().add(duracion);

        //Nacionalidad de la película
        etiquetaNacionalidad = new JLabel("Nacionalidad: ");
        etiquetaNacionalidad.setBounds(30, 190, 200, 20);
        getContentPane().add(etiquetaNacionalidad);

        nacionalidad = new JLabel(peli.getNacionalidad());
        nacionalidad.setBounds(130, 190, 200, 20);
        getContentPane().add(nacionalidad);

        //Año de la película
        etiquetaYear = new JLabel("Año: ");
        etiquetaYear.setBounds(30, 230, 200, 20);
        getContentPane().add(etiquetaYear);

        year = new JLabel(peli.getYear()+"");
        year.setBounds(130, 230, 200, 20);
        getContentPane().add(year);

        setVisible(true); 
    } 
}