package co.edu.javeriana.cadenacines.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import co.edu.javeriana.cadenacines.negocio.Boleta;
import co.edu.javeriana.cadenacines.negocio.CadenaCines;
import co.edu.javeriana.cadenacines.negocio.CentroComercial;
import co.edu.javeriana.cadenacines.negocio.Cine;
import co.edu.javeriana.cadenacines.negocio.Cliente;
import co.edu.javeriana.cadenacines.negocio.ClienteMiembro;
import co.edu.javeriana.cadenacines.negocio.Funcion;
import co.edu.javeriana.cadenacines.negocio.FuncionCorriente;
import co.edu.javeriana.cadenacines.negocio.FuncionGala;
import co.edu.javeriana.cadenacines.negocio.ICadenaCines;
import co.edu.javeriana.cadenacines.negocio.Pelicula;
import co.edu.javeriana.cadenacines.persintencia.ManejoArchivos;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;

import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class TestGUIcadenaCines extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTarifa;
	private JTable tbFunciones;
	private Vector<Vector<Number>> rowData;
	private String[] nombreColumnas = {"id", "fecha", "hora", "tarifa", "sala", "centro", "tipo", "etiqueta"};
	private Vector<String> columnas;
	private Vector<Vector<Number>> rowData2;
	private String[] nombreColumnas2 = {"fila", "número", "tipo"};
	private Vector <String> columnas2;
	private Vector<Vector<Number>> rowData3;
	private String[] nombreColumnas3 = {"id", "nombre","email","tipo","miembo desde"};
	private Vector <String> columnas3;
	private Vector<Vector<Number>> rowData4;
	private String[] nombreColumnas4 ={"silla","cine","función","película","valor"};
	private Vector<String> columnas4;
	private JComboBox<String> comboPeliculas;
	private JComboBox<String> comboSalas;
	private JTable tbSillas;
	private JButton btnComprarBoletaSilla;
	private int cont = 0;
	private JTable tbClientes;
	private JTable tbReporte;
	private JScrollPane scrollPaneReporte;
	private JLabel serviciosSistema;
	private JButton leerArchivos;
	private JButton agregarFuncionBtn;
	private JButton btnCargarDatosSistema;
	private JButton btnMostrarReporteBoletas;
	private JButton btnComprarBoletas;
	private JButton btnSalvarDatosSistema;
	private JButton btnConsultarFuncionesPara;
	private JComboBox<String> comboMinutos;
	private JComboBox<String> comboHora;
	private JLabel label;
	private JButton btnRegistrar;
	private JComboBox<String> comboTipoFuncion;
	private JLabel lblNewLabel_2;
	private JComboBox<String> comboAnio;
	private JLabel lblPeli;
	private JButton btnRegresar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox<String> comboMes;
	private JLabel lblTarifa;
	private JLabel lblTipo;
	private JLabel lblHora;
	private JComboBox<String> comboEtiquetaFuncion;
	private JComboBox<String> comboDia;
	private JLabel lblSalaDeCine;
	private JLabel lblConsultarFuncionesPara;
	private JLabel lblPelcula;
	private JComboBox<String> comboPeliculas2;
	private JLabel lblFuncionesAsociadas;
	private JScrollPane scrollPane;
	private JButton btnBuscarFunciones;
	private JButton btnRegresar_1;
	private JComboBox<String> comboFunciones;
	private JLabel lblComprarBoletas;
	private JLabel lblNewLabel_3;
	private JLabel lblClientes;
	private JComboBox<String> comboClientes;
	private JScrollPane scrollPaneSillas;
	private JButton btnMostrarSillasDisponibles;
	private JLabel lblSillasDisponibles;
	private JButton btnRegresarBoletas;
	private JLabel lblReporteDeBoletas;
	private JLabel lblClientes_1;
	private JScrollPane scrollPaneClientes;
	private JLabel lblBoletasCompradasPor;
	private JLabel lblCliente;
	private JButton btnMostrar;
	private ICadenaCines cadenaC;
	private JLabel lbl_Imagen;
	private JLabel lblNewLabel_4;
	private JLabel lblImagenPerro;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUIcadenaCines frame;
					frame =  new TestGUIcadenaCines();
					frame.setVisible(true);
					JMenuBar menuBar;
					JMenu menu, submenu;
					JMenuItem menuItem;
					//Create the menu bar.
					menuBar = new JMenuBar();
					// add the menuBar to the frame
					frame.setJMenuBar(menuBar);
					//Build the first menu.
					menu = new JMenu("Menu");
					menuBar.add(menu);
					menuItem = new JMenuItem("A text-only menu item");
					menu.add(menuItem);
					menuItem = new JMenuItem("Both text and icon",
					new ImageIcon("images/middle.gif"));
					menu.add(menuItem);
					menu.addSeparator();
					submenu = new JMenu("A submenu");
					menu.add(submenu);
					menuItem = new JMenuItem("An item in the submenu");
					submenu.add(menuItem);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestGUIcadenaCines() {
		
		

		cadenaC = new CadenaCines("Cine Co");
		ManejoArchivos a = new ManejoArchivos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 656);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 11, 664, 611);
		contentPane.add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 653, 593);
		panel.add(tabbedPane);

		JPanel menuServicios = new JPanel();
		tabbedPane.addTab("Menu de servicios", null, menuServicios, null);
		menuServicios.setLayout(null);

		serviciosSistema = new JLabel("Servicios del Sistema");
		serviciosSistema.setForeground(Color.RED);
		serviciosSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		serviciosSistema.setBounds(170, 11, 164, 31);
		menuServicios.add(serviciosSistema);

		JPanel agregarFuncion = new JPanel();
		tabbedPane.addTab("Agregar funcion", null, agregarFuncion, null);
		agregarFuncion.setLayout(null);




		leerArchivos = new JButton("Leer archivos de texto");
		leerArchivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(getParent());
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					if(chooser.getSelectedFile().getName().equals("centrosCinesSillas.txt")){
						try{
							String nombre = chooser.getSelectedFile().getName();
							a.agregarCentrosCinesSilla(cadenaC,nombre);
							JOptionPane.showMessageDialog(null, "Datos cargados correctamente",null, JOptionPane.INFORMATION_MESSAGE);


						}
						catch(Exception e){
							String a = e.getMessage();
							JOptionPane.showMessageDialog(null,a,"Error", JOptionPane.ERROR_MESSAGE);

						}

					}
					else if(chooser.getSelectedFile().getName().equals("Peliculas.txt")){
						try{
							String nombre = chooser.getSelectedFile().getName();
							a.ingresarPeliculas(nombre, (CadenaCines) cadenaC);
							JOptionPane.showMessageDialog(null, "Datos cargados correctamente",null, JOptionPane.INFORMATION_MESSAGE);
						}
						catch(Exception e){
							String a = e.getMessage();
							JOptionPane.showMessageDialog(null,a,"Error", JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();

						}


					}
					else if(chooser.getSelectedFile().getName().equals("Clientes.txt")){
						try{
							String nombre = chooser.getSelectedFile().getName();
							a.ingresarClientes(nombre, (CadenaCines) cadenaC);
							JOptionPane.showMessageDialog(null, "Datos cargados correctamente",null, JOptionPane.INFORMATION_MESSAGE);



						}
						catch(Exception e){
							String a = e.getMessage();
							JOptionPane.showMessageDialog(null,a,"Error", JOptionPane.ERROR_MESSAGE);
							e.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Archivo invalido");
					}


				}
			}
		});
		leerArchivos.setBounds(20, 63, 251, 23);
		menuServicios.add(leerArchivos);



		lblNewLabel = new JLabel("Datos de una nueva funci\u00F3n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(20, 11, 203, 20);
		agregarFuncion.add(lblNewLabel);

		lblPeli = new JLabel("Pel\u00EDcula");
		lblPeli.setForeground(Color.BLACK);
		lblPeli.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeli.setBounds(20, 42, 63, 20);
		agregarFuncion.add(lblPeli);

		lblSalaDeCine = new JLabel("Sala de cine");
		lblSalaDeCine.setForeground(Color.BLACK);
		lblSalaDeCine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalaDeCine.setBounds(20, 73, 91, 14);
		agregarFuncion.add(lblSalaDeCine);

		lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 112, 46, 14);
		agregarFuncion.add(lblNewLabel_1);

		lblTarifa = new JLabel("Tarifa");
		lblTarifa.setForeground(Color.BLACK);
		lblTarifa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTarifa.setBounds(20, 145, 46, 14);
		agregarFuncion.add(lblTarifa);

		lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(20, 176, 46, 20);
		agregarFuncion.add(lblTipo);


		btnRegresar = new JButton("Regresar");
		btnRegresar.setIcon(new ImageIcon("./imagenes/regresar.png"));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);

			}
		});
		btnRegresar.setBounds(290, 291, 89, 67);
		agregarFuncion.add(btnRegresar);

		textTarifa = new JTextField();
		textTarifa.setHorizontalAlignment(SwingConstants.CENTER);
		textTarifa.setBounds(152, 144, 138, 20);
		agregarFuncion.add(textTarifa);
		textTarifa.setColumns(10);

		comboTipoFuncion = new JComboBox<String>();
		comboTipoFuncion.setModel(new DefaultComboBoxModel(new String[] {"Gala", "Corriente"}));
		comboTipoFuncion.setBounds(152, 178, 91, 18);
		agregarFuncion.add(comboTipoFuncion);

		comboEtiquetaFuncion = new JComboBox();
		comboEtiquetaFuncion.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboEtiquetaFuncion.setBounds(333, 179, 46, 18);
		agregarFuncion.add(comboEtiquetaFuncion);

		lblNewLabel_2 = new JLabel("Etiqueta");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(262, 176, 61, 19);
		agregarFuncion.add(lblNewLabel_2);

		comboAnio = new JComboBox();
		comboAnio.setModel(new DefaultComboBoxModel(new String[] {"2016"}));
		comboAnio.setBounds(152, 111, 61, 22);
		agregarFuncion.add(comboAnio);

		comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboMes.setBounds(226, 111, 52, 22);
		agregarFuncion.add(comboMes);

		comboDia = new JComboBox();
		comboDia.setForeground(Color.BLACK);
		comboDia.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDia.setBounds(288, 110, 46, 22);
		agregarFuncion.add(comboDia);

		lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(432, 176, 46, 20);
		agregarFuncion.add(lblHora);

		comboHora = new JComboBox();
		comboHora.setModel(new DefaultComboBoxModel(new String[] {"23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "11", "10", "09", "08", "07", "06", "05", "03", "02", "01", "00"}));
		comboHora.setBounds(515, 178, 46, 20);
		agregarFuncion.add(comboHora);

		comboMinutos = new JComboBox();
		comboMinutos.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboMinutos.setBounds(571, 178, 40, 20);
		agregarFuncion.add(comboMinutos);

		label = new JLabel("      :");
		label.setBounds(549, 182, 22, 12);
		agregarFuncion.add(label);



		JPanel consultarFuncion = new JPanel();
		tabbedPane.addTab("Consultar funciones", null, consultarFuncion, null);
		consultarFuncion.setLayout(null);

		lblConsultarFuncionesPara = new JLabel("Consultar funciones para una pel\u00EDcula");
		lblConsultarFuncionesPara.setForeground(Color.RED);
		lblConsultarFuncionesPara.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsultarFuncionesPara.setBounds(10, 24, 247, 24);
		consultarFuncion.add(lblConsultarFuncionesPara);

		lblPelcula = new JLabel("Pel\u00EDcula");
		lblPelcula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPelcula.setBounds(80, 82, 61, 24);
		consultarFuncion.add(lblPelcula);

		comboPeliculas2 = new JComboBox();
		comboPeliculas2.setBounds(180, 86, 283, 20);
		consultarFuncion.add(comboPeliculas2);


		lblFuncionesAsociadas = new JLabel("Funciones asociadas");
		lblFuncionesAsociadas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuncionesAsociadas.setBounds(10, 147, 131, 24);
		consultarFuncion.add(lblFuncionesAsociadas);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 182, 580, 136);
		consultarFuncion.add(scrollPane);

		tbFunciones = getDatosFunciones();
		scrollPane.setViewportView(tbFunciones);

		btnBuscarFunciones = new JButton("");
		btnBuscarFunciones.setIcon(new ImageIcon("./imagenes/search.png"));
		btnBuscarFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rowData.removeAllElements();
				String elemento = (String) comboPeliculas2.getSelectedItem();
				long cod = Long.parseLong(elemento.substring(0, 4));				
				Pelicula peliculaBuscar = ((CadenaCines) cadenaC).buscarPelicula(cod);
				List<Funcion> funciones = peliculaBuscar.getFunciones();
				LocalDateTime datosFechaFuncion;
				String fecha;
				for(Funcion actual: funciones)
				{
					Vector fila = new Vector();
					fila.add(actual.getId());
					datosFechaFuncion  = actual.getFecha();
					fecha = datosFechaFuncion.getYear()+"/"+datosFechaFuncion.getMonthValue()+"/"+datosFechaFuncion.getDayOfMonth();
					fila.add(fecha);
					fila.add(actual.getFecha().getHour());
					fila.add(actual.getTarifa());
					fila.add(actual.getCine().getSala());
					fila.add(actual.getCine().getCentro().getNombre());
					if(actual instanceof FuncionGala)
					{
						fila.add("Gala");
						FuncionGala actualGala = (FuncionGala) actual;
						if(actualGala.isTrajeEtiqueta() == true)
						{
							fila.add("sí");

						}else
						{
							fila.add("no");
						}
					}else if(actual instanceof FuncionCorriente)
					{
						fila.add("Corriente");
						fila.add(" ");
					}
					rowData.add(fila);
				}
				tbFunciones = new JTable(rowData, columnas);
				scrollPane.setViewportView(getDatosFunciones());


			}
		});
		btnBuscarFunciones.setBounds(180, 117, 122, 54);
		consultarFuncion.add(btnBuscarFunciones);

		btnRegresar_1 = new JButton("Regresar");
		btnRegresar_1.setIcon(new ImageIcon("./imagenes/regresar.png"));
		btnRegresar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rowData.removeAllElements();
				tabbedPane.setSelectedIndex(0);
				comboPeliculas2.removeAllItems();
			}
		});
		btnRegresar_1.setBounds(10, 384, 138, 64);
		consultarFuncion.add(btnRegresar_1);
		
		lblImagenPerro = new JLabel("");
		lblImagenPerro.setIcon(new ImageIcon("./imagenes/ReporteClientes.png"));
		lblImagenPerro.setBounds(10, 11, 648, 565);
		consultarFuncion.add(lblImagenPerro);

		JPanel comparBoleta = new JPanel();
		tabbedPane.addTab("Comprar boletas", null, comparBoleta, null);
		comparBoleta.setLayout(null);

		lblComprarBoletas = new JLabel("Comprar boletas");
		lblComprarBoletas.setForeground(Color.RED);
		lblComprarBoletas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblComprarBoletas.setBounds(97, 11, 141, 26);
		comparBoleta.add(lblComprarBoletas);

		lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClientes.setBounds(31, 47, 46, 24);
		comparBoleta.add(lblClientes);

		comboClientes = new JComboBox();
		comboClientes.setBounds(107, 48, 300, 26);
		comparBoleta.add(comboClientes);

		lblNewLabel_3 = new JLabel("Funci\u00F3n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(31, 93, 58, 26);
		comparBoleta.add(lblNewLabel_3);

		comboFunciones = new JComboBox();
		comboFunciones.setBounds(107, 95, 300, 26);
		comparBoleta.add(comboFunciones);

		scrollPaneSillas = new JScrollPane();
		scrollPaneSillas.setBounds(31, 166, 217, 265);
		comparBoleta.add(scrollPaneSillas);

		tbSillas = getDatosSillas();
		scrollPaneSillas.setViewportView(tbSillas);

		btnMostrarSillasDisponibles = new JButton("Mostrar sillas disponibles");
		btnMostrarSillasDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rowData2.removeAllElements();
				String idFuncion = (String)comboFunciones.getSelectedItem();
				Long id = Long.parseLong(idFuncion.substring(0, 1));
				Funcion escogida = ((CadenaCines) cadenaC).buscarFuncion(id);
				List<Boleta> boletasFuncion = escogida.getBoletas();

				for(Boleta actual: boletasFuncion)
				{
					if(actual.isComprada()==true)
					{
						Vector fila = new Vector();
						fila.add(actual.getSillas().getFila());
						fila.add(actual.getSillas().getNumero());
						fila.add(actual.getSillas().getTipo());
						rowData2.add(fila);
						tbSillas = new JTable(rowData2, columnas2);
						scrollPaneSillas.setViewportView(getDatosSillas());
					}
				}

			}
		});
		btnMostrarSillasDisponibles.setBounds(176, 132, 177, 23);
		comparBoleta.add(btnMostrarSillasDisponibles);

		lblSillasDisponibles = new JLabel("Sillas disponibles");
		lblSillasDisponibles.setForeground(Color.RED);
		lblSillasDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSillasDisponibles.setBounds(10, 130, 103, 26);
		comparBoleta.add(lblSillasDisponibles);

		btnComprarBoletaSilla = new JButton("");
		btnComprarBoletaSilla.setIcon(new ImageIcon("./imagenes/buy.png"));
		btnComprarBoletaSilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idCliente = (String)comboClientes.getSelectedItem();
				Long idC = Long.parseLong(idCliente.substring(0, 1));
				Cliente cliente = ((CadenaCines) cadenaC).buscarCliente(idC);
				String idFuncion = (String) comboFunciones.getSelectedItem();
				Long id = Long.parseLong(idFuncion.substring(0,1));
				Funcion escogida = ((CadenaCines) cadenaC).buscarFuncion(id);
				Cine cine = escogida.getCine();
				List<Boleta> boletas = escogida.getBoletas();
				int seleccion = tbSillas.getSelectedRow();
				TableModel modelo = tbSillas.getModel();
				String fila = (String) modelo.getValueAt(seleccion, 0);
				int numero = (int) modelo.getValueAt(seleccion, 1);
				Long valorB = cliente.valorBoletas(cadenaC.comprarBoleta(fila, numero, escogida,cliente));
				cont += valorB;
				JOptionPane.showMessageDialog(null, "El valor de la compra actual es :$ " + cont , null, JOptionPane.INFORMATION_MESSAGE);
				rowData2.remove(seleccion);
				tbSillas = new JTable(rowData2, columnas2);
				scrollPaneSillas.setViewportView(tbSillas);
			}
		});
		btnComprarBoletaSilla.setBounds(31, 462, 141, 89);
		comparBoleta.add(btnComprarBoletaSilla);

		btnRegresarBoletas = new JButton("Regresar");
		btnRegresarBoletas.setIcon(new ImageIcon("./imagenes/regresar.png"));
		btnRegresarBoletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboClientes.removeAllItems();
				comboFunciones.removeAllItems();
				tabbedPane.setSelectedIndex(0);
				rowData2.removeAllElements();
			}
		});
		btnRegresarBoletas.setBounds(502, 486, 103, 65);
		comparBoleta.add(btnRegresarBoletas);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("./imagenes/ComprarBoleta.png"));
		lblNewLabel_6.setBounds(10, 11, 638, 554);
		comparBoleta.add(lblNewLabel_6);

		JPanel mostrarReporte = new JPanel();
		tabbedPane.addTab("Reporte clientes", null, mostrarReporte, null);
		mostrarReporte.setLayout(null);

		lblReporteDeBoletas = new JLabel("Reporte de boletas compradas por los clientes");
		lblReporteDeBoletas.setForeground(Color.RED);
		lblReporteDeBoletas.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblReporteDeBoletas.setBounds(62, 11, 344, 23);
		mostrarReporte.add(lblReporteDeBoletas);

		lblClientes_1 = new JLabel("Clientes");
		lblClientes_1.setForeground(Color.WHITE);
		lblClientes_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClientes_1.setBounds(62, 45, 46, 14);
		mostrarReporte.add(lblClientes_1);

		scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(62, 70, 518, 160);
		mostrarReporte.add(scrollPaneClientes);

		tbClientes = getDatosClientes();
		scrollPaneClientes.setViewportView(tbClientes);

		for(Cliente actual : ((CadenaCines) cadenaC).getClientes())
		{
			Vector fila = new Vector();
			fila.add(actual.getId());
			fila.add(actual.getNombre());
			fila.add(actual.getEmail());
			if(actual instanceof ClienteMiembro)
			{
				fila.add("miembro");
				fila.add(((ClienteMiembro) actual).getFechaMembresia());
			}
			else
			{
				fila.add("particular");

			}
			rowData3.add(fila);
			tbSillas = new JTable(rowData3, columnas3);
			scrollPaneSillas.setViewportView(getDatosClientes());


		}


		lblBoletasCompradasPor = new JLabel("Boletas compradas por cliente");
		lblBoletasCompradasPor.setForeground(Color.WHITE);
		lblBoletasCompradasPor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBoletasCompradasPor.setBounds(62, 275, 190, 23);
		mostrarReporte.add(lblBoletasCompradasPor);

		lblCliente = new JLabel("");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(251, 283, 33, 23);
		mostrarReporte.add(lblCliente);

		scrollPaneReporte = new JScrollPane();
		scrollPaneReporte.setBounds(72, 309, 576, 194);
		mostrarReporte.add(scrollPaneReporte);

		tbReporte = getDatosReporte();
		scrollPaneReporte.setViewportView(tbReporte);
		btnMostrar = new JButton("Mostrar boletas compradas");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rowData4.removeAllElements();
				int index = tbClientes.getSelectedRow();
				TableModel modelo = tbClientes.getModel();
				Long idCliente= (Long) modelo.getValueAt(index, 0);
				Cliente cliente = ((CadenaCines) cadenaC).buscarCliente(idCliente);
				List<Boleta> boletas = new ArrayList<Boleta>();
				boletas = cliente.getBoletas();
				for(Boleta actual : boletas)
				{
					Vector fila = new Vector();
					fila.add(actual.getSillas().toStringTipo());
					fila.add(actual.getFuncion().getCine().getSala());
					if(actual.getFuncion() instanceof FuncionCorriente )
					{
						FuncionCorriente f = (FuncionCorriente) actual.getFuncion();
						fila.add(f.toString());
					}
					else
					{
						FuncionGala f = (FuncionGala) actual.getFuncion();
						fila.add(f.toString());
					}
					fila.add(actual.getFuncion().getPelicula().toStringSD());
					fila.add(actual.getFuncion().getTarifa());
					rowData4.add(fila);
				}
				tbReporte = new JTable(rowData4, columnas4);
				scrollPaneReporte.setViewportView(getDatosReporte());
			}
		});
		btnMostrar.setBounds(188, 241, 276, 23);
		mostrarReporte.add(btnMostrar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("./imagenes/regresar.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(534, 510, 89, 55);
		mostrarReporte.add(btnNewButton);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("./imagenes/Cine-Palomitas-Bebida.png"));
		lblNewLabel_7.setBounds(0, 0, 648, 554);
		mostrarReporte.add(lblNewLabel_7);
		
		comboPeliculas = new JComboBox();
		comboPeliculas.setBounds(152, 42, 171, 20);
		agregarFuncion.add(comboPeliculas);
		comboSalas = new JComboBox();
		comboSalas.setBounds(152, 72, 171, 20);
		agregarFuncion.add(comboSalas);
		agregarFuncionBtn = new JButton("Agregar funcion");
		agregarFuncionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboPeliculas.removeAllItems();
				List<String> peliculas = inicio(cadenaC);
				for(String actual: peliculas)
				{
					comboPeliculas.addItem(actual);
				}
				List<String> salas = salaCines(cadenaC);
				for(String actual: salas)
				{
					comboSalas.addItem(actual);
				}
				
				tabbedPane.setSelectedIndex(1);


			}
		});
		agregarFuncionBtn.setBounds(20, 117, 251, 23);
		menuServicios.add(agregarFuncionBtn);

		btnConsultarFuncionesPara = new JButton("Consultar funciones para una pelicula");
		btnConsultarFuncionesPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
				comboPeliculas2.removeAllItems();
				Map<Long, Pelicula> peliculas = new TreeMap<Long,Pelicula>();
				peliculas = ((CadenaCines) cadenaC).mostrarPeliculasSD(cadenaC);
				if(peliculas != null)
				{

					for(Pelicula actual: peliculas.values())
					{
						comboPeliculas2.addItem(actual.toStringSD());
					}
				}
			}
		});
		btnConsultarFuncionesPara.setBounds(20, 174, 251, 23);
		menuServicios.add(btnConsultarFuncionesPara);

		btnComprarBoletas = new JButton("Comprar boletas");
		btnComprarBoletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cont = 0;
				comboClientes.removeAllItems();
				comboFunciones.removeAllItems();
				tabbedPane.setSelectedIndex(3);
				List<Cliente> clientes = ((CadenaCines) cadenaC).getClientes();
				if(clientes != null)
				{
					for(Cliente actual : clientes)
					{
						if(actual instanceof ClienteMiembro){
							comboClientes.addItem(actual.getId()+"- "+actual.getNombre()+" -"+" miembro");
						}
						else{
							comboClientes.addItem(actual.getId()+"- "+actual.getNombre()+" -"+" particular");
						}
					}

				}
				List<Funcion> funciones = new ArrayList<Funcion>();
				for(Pelicula pelis : ((CadenaCines) cadenaC).getPeliculas().values())
				{
					funciones.addAll(pelis.getFunciones());
				}

				if(funciones != null)
				{
					for(Funcion actual : funciones)
					{
						LocalDateTime fechaFuncion = actual.getFecha();
						String fecha = fechaFuncion.getYear()+"/"+fechaFuncion.getMonthValue()+"/"+fechaFuncion.getDayOfMonth();
						comboFunciones.addItem(actual.getId()+" - "+fecha+" - "+actual.getFecha().getHour()+":"+
								actual.getFecha().getMinute()+"-"
								+actual.getCine().getSala()
								+" - "+actual.getCine().getCentro().getNombre());

					}

				}
			}
		});
		btnComprarBoletas.setBounds(20, 222, 251, 23);
		menuServicios.add(btnComprarBoletas);

		btnMostrarReporteBoletas = new JButton("Mostrar reporte boletas compradas");
		btnMostrarReporteBoletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
				rowData3.removeAllElements();
				for(Cliente actual : ((CadenaCines) cadenaC).getClientes())
				{
					Vector fila = new Vector();
					fila.add(actual.getId());
					fila.add(actual.getNombre());
					fila.add(actual.getEmail());
					if(actual instanceof ClienteMiembro)
					{
						fila.add("miembro");
						fila.add(((ClienteMiembro) actual).getFechaMembresia());
					}
					else
					{
						fila.add("particular");

					}
					rowData3.add(fila);
					tbClientes = new JTable(rowData3, columnas3);
					scrollPaneClientes.setViewportView(getDatosClientes());
				}
			}
		});

		btnMostrarReporteBoletas.setBounds(317, 63, 240, 23);
		menuServicios.add(btnMostrarReporteBoletas);

		btnSalvarDatosSistema = new JButton("Salvar los datos del sistema");
		btnSalvarDatosSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFileChooser chooser = new JFileChooser();
					int returnVal = chooser.showSaveDialog(getParent());
					if( returnVal == JFileChooser.APPROVE_OPTION ){
						String pathArchivo = chooser.getSelectedFile().getParent();
						String nombre = chooser.getSelectedFile().getName();
						ManejoArchivos.SerializarCadenaCines(cadenaC,pathArchivo,nombre);
						JOptionPane.showMessageDialog(null, "Sistema guardado con éxito", "Info", JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (IOException e) {

					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}
			}

		});
		btnSalvarDatosSistema.setBounds(317, 117, 240, 23);
		menuServicios.add(btnSalvarDatosSistema);

		btnCargarDatosSistema = new JButton("Cargar los datos del sistema");
		btnCargarDatosSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					JFileChooser chooser = new JFileChooser();
					int returnValue = chooser.showOpenDialog(getParent());
					if(returnValue == JFileChooser.APPROVE_OPTION)
					{
						String ruta = chooser.getSelectedFile().getAbsolutePath();
						cadenaC = ManejoArchivos.DesserializarCadenaCines(ruta);

					}


				}catch(Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCargarDatosSistema.setBounds(317, 174, 240, 23);
		menuServicios.add(btnCargarDatosSistema);
		
		lbl_Imagen = new JLabel();
		lbl_Imagen.setIcon(new ImageIcon("./imagenes/Menu3.png"));
		lbl_Imagen.setBounds(0, 0, 648, 472);
		menuServicios.add(lbl_Imagen);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon("./imagenes/add.jpg"));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pelicula = (String) comboPeliculas.getSelectedItem();
				Long codPeli = Long.parseLong(pelicula.substring(0, 4));
				String idCine1 = (String) comboSalas.getSelectedItem();
				Long idCine = Long.parseLong(idCine1.substring(0,1));
				String fecha = (String) comboAnio.getSelectedItem()+"/"+comboMes.getSelectedItem()+"/"+comboDia.getSelectedItem();
				String hora = (String) comboHora.getSelectedItem()+":"+comboMinutos.getSelectedItem();
				String tarifa1 = (String) textTarifa.getText();
				Long tarifa = Long.parseLong(tarifa1);
				String tipo = (String) comboTipoFuncion.getSelectedItem();
				String gala = (String) comboEtiquetaFuncion.getSelectedItem();

				if(tipo.equalsIgnoreCase("gala")){
					if(gala.equalsIgnoreCase("si")){
						long a = cadenaC.agregarFuncionGala(codPeli, idCine, fecha, hora, tarifa,true);
						if(a!=-1){
							JOptionPane.showMessageDialog(null, "Se agregó la función con ID: "+ a, null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "No se agregó función", null, JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						long a = cadenaC.agregarFuncionGala(codPeli, idCine, fecha, hora, tarifa,false);
						if(a!=-1){
							JOptionPane.showMessageDialog(null, "Se agregó la función con ID: "+ a, null, JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "No se agregó función", null, JOptionPane.ERROR_MESSAGE);
						}

					}


				}
				else{

					long a=cadenaC.agregarFuncionCorriente(codPeli, idCine, fecha, hora, tarifa);
					if(a!=-1){
						JOptionPane.showMessageDialog(null, "Se agregó la función con ID: "+ a, null, JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "No se agregó función", null, JOptionPane.ERROR_MESSAGE);
					}

				}
				
				textTarifa.setText(null	);

			}
		});
		btnRegistrar.setBounds(46, 303, 153, 55);
		agregarFuncion.add(btnRegistrar);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("./imagenes/consultarF.jpg"));
		lblNewLabel_4.setBounds(0, 0, 648, 358);
		agregarFuncion.add(lblNewLabel_4);
		
	




	}

	public List<String> inicio(ICadenaCines miCine){
		List<String> pelis = new ArrayList<String>();
		for (Pelicula a : ((CadenaCines) miCine).mostrarPeliculasSD(miCine).values() ){
			pelis.add(a.toStringSD());	

		}

		return pelis;

	}

	public List<String> salaCines(ICadenaCines miCine){
		List<String> salas = new ArrayList<String>();
		for(CentroComercial centros : ((CadenaCines) miCine).getCentros()){	
			for(Cine cine : centros.getCines()){
				salas.add(cine.toStringSD());
			}
		}

		return salas;

	}

	public JTable getDatosFunciones()
	{
		if(tbFunciones == null)
		{
			rowData = new Vector<Vector<Number>>();
			columnas = new Vector<String>(Arrays.asList(this.nombreColumnas));
			tbFunciones = new JTable(rowData, columnas);
			tbFunciones.setForeground(new Color(255, 0, 0));
			tbFunciones.setBorder(new LineBorder(new Color(0, 0, 0)));
			tbFunciones.setBackground(new Color(255, 0, 0));
			tbFunciones.setForeground(Color.BLUE);
			tbFunciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbFunciones.setCellSelectionEnabled(true);
			tbFunciones.setColumnSelectionAllowed(true);
			tbFunciones.getTableHeader().setReorderingAllowed(false);
			tbFunciones.getTableHeader().setResizingAllowed(false);
		}
		return tbFunciones;
	}

	public JTable getDatosSillas()
	{
		if(tbSillas == null){
			rowData2 = new Vector<Vector<Number>>();
			columnas2 = new Vector<String>(Arrays.asList(this.nombreColumnas2));
			tbSillas = new JTable(rowData2, columnas2);
			tbSillas.setCellSelectionEnabled(true);
			tbSillas.setColumnSelectionAllowed(true);
			tbSillas.getTableHeader().setReorderingAllowed(false);
			tbSillas.getTableHeader().setResizingAllowed(false);
		}
		return tbSillas;
	}
	private JTable getDatosClientes() {
		if(tbClientes == null){
			rowData3 = new Vector<Vector<Number>>();
			columnas3 = new Vector<String>(Arrays.asList(this.nombreColumnas3));
			tbClientes = new JTable(rowData3, columnas3);
			tbClientes.setCellSelectionEnabled(true);
			tbClientes.setColumnSelectionAllowed(true);
			tbClientes.getTableHeader().setReorderingAllowed(false);
			tbClientes.getTableHeader().setResizingAllowed(false);
		}
		return tbClientes;
	}
	private JTable getDatosReporte() {
		if(tbReporte == null){
			rowData4 = new Vector<Vector<Number>>();
			columnas4 = new Vector<String>(Arrays.asList(this.nombreColumnas4));
			tbReporte = new JTable(rowData4, columnas4);
			tbReporte.setCellSelectionEnabled(true);
			tbReporte.setColumnSelectionAllowed(true);
			tbReporte.getTableHeader().setReorderingAllowed(false);
			tbReporte.getTableHeader().setResizingAllowed(false);
		}
		return tbReporte;
	}
	public JButton getBtnComprarBoletaSilla() {
		return btnComprarBoletaSilla;
	}
	public JScrollPane getScrollPaneReporte() {
		return scrollPaneReporte;
	}
	public JLabel getServiciosSistema() {
		return serviciosSistema;
	}
	public JButton getLeerArchivos() {
		return leerArchivos;
	}
	public JButton getAgregarFuncionBtn() {
		return agregarFuncionBtn;
	}
	public JButton getBtnCargarDatosSistema() {
		return btnCargarDatosSistema;
	}
	public JButton getBtnMostrarReporteBoletas() {
		return btnMostrarReporteBoletas;
	}
	public JButton getBtnComprarBoletas() {
		return btnComprarBoletas;
	}
	public JButton getBtnSalvarDatosSistema() {
		return btnSalvarDatosSistema;
	}
	public JButton getBtnConsultarFuncionesPara() {
		return btnConsultarFuncionesPara;
	}
	public JComboBox<?> getComboMinutos() {
		return comboMinutos;
	}
	public JComboBox getComboHora() {
		return comboHora;
	}
	public JLabel getLabel() {
		return label;
	}
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	public JComboBox getComboTipoFuncion() {
		return comboTipoFuncion;
	}
	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}
	public JComboBox getComboAnio() {
		return comboAnio;
	}
	public JLabel getLblPeli() {
		return lblPeli;
	}
	public JButton getBtnRegresar() {
		return btnRegresar;
	}
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}
	public JComboBox getComboMes() {
		return comboMes;
	}
	public JLabel getLblTarifa() {
		return lblTarifa;
	}
	public JTextField getTextTarifa() {
		return textTarifa;
	}
	public JLabel getLblTipo() {
		return lblTipo;
	}
	public JLabel getLblHora() {
		return lblHora;
	}
	public JComboBox getComboEtiquetaFuncion() {
		return comboEtiquetaFuncion;
	}
	public JComboBox getComboDia() {
		return comboDia;
	}
	public JLabel getLblSalaDeCine() {
		return lblSalaDeCine;
	}
	public JLabel getLblConsultarFuncionesPara() {
		return lblConsultarFuncionesPara;
	}
	public JLabel getLblPelcula() {
		return lblPelcula;
	}
	public JComboBox getComboPeliculas2() {
		return comboPeliculas2;
	}
	public JLabel getLblFuncionesAsociadas() {
		return lblFuncionesAsociadas;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JButton getBtnBuscarFunciones() {
		return btnBuscarFunciones;
	}
	public JButton getBtnRegresar_1() {
		return btnRegresar_1;
	}
	public JComboBox getComboFunciones() {
		return comboFunciones;
	}
	public JLabel getLblComprarBoletas() {
		return lblComprarBoletas;
	}
	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}
	public JLabel getLblClientes() {
		return lblClientes;
	}
	public JComboBox getComboClientes() {
		return comboClientes;
	}
	public JScrollPane getScrollPaneSillas() {
		return scrollPaneSillas;
	}
	public JButton getBtnMostrarSillasDisponibles() {
		return btnMostrarSillasDisponibles;
	}
	public JLabel getLblSillasDisponibles() {
		return lblSillasDisponibles;
	}
	public JButton getBtnRegresarBoletas() {
		return btnRegresarBoletas;
	}
	public JLabel getLblReporteDeBoletas() {
		return lblReporteDeBoletas;
	}
	public JLabel getLblClientes_1() {
		return lblClientes_1;
	}
	public JScrollPane getScrollPaneClientes() {
		return scrollPaneClientes;
	}
	public JLabel getLblBoletasCompradasPor() {
		return lblBoletasCompradasPor;
	}
	public JLabel getLblCliente() {
		return lblCliente;
	}
	public JButton getBtnMostrar() {
		return btnMostrar;
	}
}
