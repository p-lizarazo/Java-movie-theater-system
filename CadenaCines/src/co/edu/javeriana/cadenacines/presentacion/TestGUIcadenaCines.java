package co.edu.javeriana.cadenacines.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.javeriana.cadenacines.negocio.CadenaCines;
import co.edu.javeriana.cadenacines.negocio.CentroComercial;
import co.edu.javeriana.cadenacines.negocio.Cine;
import co.edu.javeriana.cadenacines.negocio.Funcion;
import co.edu.javeriana.cadenacines.negocio.FuncionCorriente;
import co.edu.javeriana.cadenacines.negocio.FuncionGala;
import co.edu.javeriana.cadenacines.negocio.ICadenaCines;
import co.edu.javeriana.cadenacines.negocio.Pelicula;
import co.edu.javeriana.cadenacines.negocio.Silla;
import co.edu.javeriana.cadenacines.negocio.SillaComparator;
import co.edu.javeriana.cadenacines.persintencia.ManejoArchivos;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TestGUIcadenaCines extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textTarifa;
	private JTable tbFunciones;
	private Vector<Vector<Number>> rowData;
	private String[] nombreColumnas = {"id", "fecha", "hora", "tarifa", "sala", "centro", "tipo", "etiqueta"};
	private Vector<String> columnas;
	private JComboBox comboPeliculas;
	private JComboBox comboSalas;
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
		
		
		ICadenaCines cadenaC = new CadenaCines("Cine Co");
		ManejoArchivos a = new ManejoArchivos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 453);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 11, 693, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 653, 370);
		panel.add(tabbedPane);
		
		JPanel menuServicios = new JPanel();
		menuServicios.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Menu de servicios", null, menuServicios, null);
		menuServicios.setLayout(null);
		
		JLabel serviciosSistema = new JLabel("Servicios del Sistema");
		serviciosSistema.setForeground(Color.RED);
		serviciosSistema.setFont(new Font("Tahoma", Font.PLAIN, 18));
		serviciosSistema.setBounds(170, 11, 164, 31);
		menuServicios.add(serviciosSistema);
		
		JPanel agregarFuncion = new JPanel();
		tabbedPane.addTab("Agregar funcion", null, agregarFuncion, null);
		agregarFuncion.setLayout(null);
		
		
	
		
		JButton leerArchivos = new JButton("Leer archivos de texto");
		leerArchivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				chooser.setFileFilter(filter);
				 int returnVal = chooser.showOpenDialog(getParent());
				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	if(chooser.getSelectedFile().getName().equals("centrosCinesSillas.txt")){
				    		try{
				    			a.agregarCentrosCinesSilla(cadenaC,chooser.getSelectedFile().getName());
				    			JOptionPane.showMessageDialog(null, "Datos cargados correctamente",null, JOptionPane.INFORMATION_MESSAGE);
				    				
				    			
				    		}
				    		catch(Exception e){
				    			String a = e.getMessage();
				    			JOptionPane.showMessageDialog(null,a,null, JOptionPane.ERROR_MESSAGE);
				    			
				    		}
			
				    	}
				    	else if(chooser.getSelectedFile().getName().equals("Peliculas.txt")){
				    		try{
				    			a.ingresarPeliculas(chooser.getSelectedFile().getName(), (CadenaCines) cadenaC);
				    			comboPeliculas = new JComboBox(inicio(cadenaC).toArray());
				    			
				    			comboSalas = new JComboBox(salaCines(cadenaC).toArray());
				    			comboSalas.setBounds(152, 72, 193, 23);
				    			agregarFuncion.add(comboSalas);
				    			
				    			
				    			
				    			
				    			comboPeliculas.setBounds(152, 42, 203, 20);
				    			agregarFuncion.add(comboPeliculas);
				    			
				    			
				    			JOptionPane.showMessageDialog(null, "Datos cargados correctamente",null, JOptionPane.INFORMATION_MESSAGE);
				    				
				    			
				    		}
				    		catch(Exception e){
				    			String a = e.getMessage();
				    			JOptionPane.showMessageDialog(null,a,null, JOptionPane.ERROR_MESSAGE);
				    			e.printStackTrace();
				    			
				    		}
				    		
				    		
				    	}
				    	else if(chooser.getSelectedFile().getName().equals("Clientes.txt")){
				    		try{
				    			a.ingresarClientes(chooser.getSelectedFile().getName(), (CadenaCines) cadenaC);
				    			JOptionPane.showMessageDialog(null, "Datos cargados correctamente",null, JOptionPane.INFORMATION_MESSAGE);
				    			
				    				
				    			
				    		}
				    		catch(Exception e){
				    			String a = e.getMessage();
				    			JOptionPane.showMessageDialog(null,a,null, JOptionPane.ERROR_MESSAGE);
				    			
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
		
		
		
		JLabel lblNewLabel = new JLabel("Datos de una nueva funci\u00F3n");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(20, 11, 203, 20);
		agregarFuncion.add(lblNewLabel);
		
		JLabel lblPeli = new JLabel("Pel\u00EDcula");
		lblPeli.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeli.setBounds(20, 42, 63, 20);
		agregarFuncion.add(lblPeli);
		
		JLabel lblSalaDeCine = new JLabel("Sala de cine");
		lblSalaDeCine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalaDeCine.setBounds(20, 73, 91, 14);
		agregarFuncion.add(lblSalaDeCine);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 112, 46, 14);
		agregarFuncion.add(lblNewLabel_1);
		
		JLabel lblTarifa = new JLabel("Tarifa");
		lblTarifa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTarifa.setBounds(20, 145, 46, 14);
		agregarFuncion.add(lblTarifa);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(20, 176, 46, 20);
		agregarFuncion.add(lblTipo);
		
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
			
			}
		});
		btnRegresar.setBounds(262, 222, 89, 23);
		agregarFuncion.add(btnRegresar);
		
		textTarifa = new JTextField();
		textTarifa.setHorizontalAlignment(SwingConstants.CENTER);
		textTarifa.setBounds(152, 144, 138, 20);
		agregarFuncion.add(textTarifa);
		textTarifa.setColumns(10);
		
		JComboBox comboTipoFuncion = new JComboBox();
		comboTipoFuncion.setModel(new DefaultComboBoxModel(new String[] {"Gala", "Corriente"}));
		comboTipoFuncion.setBounds(152, 178, 91, 18);
		agregarFuncion.add(comboTipoFuncion);
		
		JComboBox comboEtiquetaFuncion = new JComboBox();
		comboEtiquetaFuncion.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboEtiquetaFuncion.setBounds(333, 179, 46, 18);
		agregarFuncion.add(comboEtiquetaFuncion);
		
		JLabel lblNewLabel_2 = new JLabel("Etiqueta");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(262, 176, 61, 19);
		agregarFuncion.add(lblNewLabel_2);
		
		JComboBox comboAnio = new JComboBox();
		comboAnio.setModel(new DefaultComboBoxModel(new String[] {"2016"}));
		comboAnio.setBounds(152, 111, 61, 22);
		agregarFuncion.add(comboAnio);
		
		JComboBox comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboMes.setBounds(226, 111, 52, 22);
		agregarFuncion.add(comboMes);
		
		JComboBox comboDia = new JComboBox();
		comboDia.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDia.setBounds(288, 110, 46, 22);
		agregarFuncion.add(comboDia);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(432, 176, 46, 20);
		agregarFuncion.add(lblHora);
		
		JComboBox comboHora = new JComboBox();
		comboHora.setModel(new DefaultComboBoxModel(new String[] {"23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "11", "10", "09", "08", "07", "06", "05", "03", "02", "01", "00"}));
		comboHora.setBounds(515, 178, 46, 20);
		agregarFuncion.add(comboHora);
		
		JComboBox comboMinutos = new JComboBox();
		comboMinutos.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		comboMinutos.setBounds(571, 178, 40, 20);
		agregarFuncion.add(comboMinutos);
		
		JLabel label = new JLabel("      :");
		label.setBounds(549, 182, 22, 12);
		agregarFuncion.add(label);
		
	
				
		JPanel consultarFuncion = new JPanel();
		tabbedPane.addTab("Consultar funciones", null, consultarFuncion, null);
		consultarFuncion.setLayout(null);
		
		JLabel lblConsultarFuncionesPara = new JLabel("Consultar funciones para una pel\u00EDcula");
		lblConsultarFuncionesPara.setForeground(Color.RED);
		lblConsultarFuncionesPara.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConsultarFuncionesPara.setBounds(80, 27, 277, 24);
		consultarFuncion.add(lblConsultarFuncionesPara);
		
		JLabel lblPelcula = new JLabel("Pel\u00EDcula");
		lblPelcula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPelcula.setBounds(80, 86, 61, 24);
		consultarFuncion.add(lblPelcula);
		
		JComboBox comboPeliculas2 = new JComboBox();
		comboPeliculas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		comboPeliculas2.setBounds(180, 90, 283, 20);
		consultarFuncion.add(comboPeliculas2);
		
		
		
		
		JLabel lblFuncionesAsociadas = new JLabel("Funciones asociadas");
		lblFuncionesAsociadas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuncionesAsociadas.setBounds(10, 147, 131, 24);
		consultarFuncion.add(lblFuncionesAsociadas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 182, 580, 136);
		consultarFuncion.add(scrollPane);
		
		tbFunciones = getDatosFunciones();
		scrollPane.setViewportView(tbFunciones);
		
		JButton btnBuscarFunciones = new JButton("Buscar Funciones");
		btnBuscarFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
					fecha = datosFechaFuncion.getMonth()+"/"+datosFechaFuncion.getMonth()+"/"+datosFechaFuncion.getDayOfMonth();
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
		btnBuscarFunciones.setBounds(499, 89, 122, 23);
		consultarFuncion.add(btnBuscarFunciones);
		
		JPanel comparBoleta = new JPanel();
		tabbedPane.addTab("Comprar boletas", null, comparBoleta, null);
		comparBoleta.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Reporte clientes", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton agregarFuncionBtn = new JButton("Agregar funcion");
		agregarFuncionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				tabbedPane.setSelectedIndex(1);
				
				
			}
		});
		agregarFuncionBtn.setBounds(20, 117, 251, 23);
		menuServicios.add(agregarFuncionBtn);
		
		JButton btnConsultarFuncionesPara = new JButton("Consultar funciones para una pelicula");
		btnConsultarFuncionesPara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnConsultarFuncionesPara.setBounds(20, 174, 251, 23);
		menuServicios.add(btnConsultarFuncionesPara);
		
		JButton btnComprarBoletas = new JButton("Comprar boletas");
		btnComprarBoletas.setBounds(20, 222, 251, 23);
		menuServicios.add(btnComprarBoletas);
		
		JButton btnMostrarReporteBoletas = new JButton("Mostrar reporte boletas compradas");
		btnMostrarReporteBoletas.setBounds(317, 63, 240, 23);
		menuServicios.add(btnMostrarReporteBoletas);
		
		JButton btnSalvarDatosSistema = new JButton("Salvar los datos del sistema");
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
		
		JButton btnCargarDatosSistema = new JButton("Cargar los datos del sistema");
		btnCargarDatosSistema.setBounds(317, 174, 240, 23);
		menuServicios.add(btnCargarDatosSistema);
		
		JButton btnRegistrar = new JButton("Registrar");
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
				
				
				
			}
		});
		btnRegistrar.setBounds(97, 222, 89, 23);
		agregarFuncion.add(btnRegistrar);
		
		
		
	
		
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
			tbFunciones.getTableHeader().setReorderingAllowed(false);
		}
		return tbFunciones;
	}
}
