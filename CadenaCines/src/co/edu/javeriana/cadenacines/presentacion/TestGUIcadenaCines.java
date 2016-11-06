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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JList;

public class TestGUIcadenaCines extends JFrame {
	
	private JPanel contentPane;

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
		setBounds(100, 100, 689, 375);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("TextField.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 11, 688, 314);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 653, 284);
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
				    				
				    			
				    		}
				    		catch(Exception e){
				    			String a = e.getMessage();
				    			JOptionPane.showMessageDialog(null,a,null, JOptionPane.ERROR_MESSAGE);
				    			
				    		}
			
				    	}
				    	else if(chooser.getSelectedFile().getName().equals("Peliculas.txt")){
				    		try{
				    			a.ingresarPeliculas(chooser.getSelectedFile().getName(), (CadenaCines) cadenaC);
				    			System.out.println("#Pelis");
				    				
				    			
				    		}
				    		catch(Exception e){
				    			String a = e.getMessage();
				    			JOptionPane.showMessageDialog(null,a,null, JOptionPane.ERROR_MESSAGE);
				    			
				    		}
				    		
				    		
				    	}
				    	else if(chooser.getSelectedFile().getName().equals("Clientes.txt")){
				    		try{
				    			a.ingresarClientes(chooser.getSelectedFile().getName(), (CadenaCines) cadenaC);
				    			
				    				
				    			
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
		leerArchivos.setBounds(20, 63, 240, 23);
		menuServicios.add(leerArchivos);
		
		JPanel agregarFuncion = new JPanel();
		tabbedPane.addTab("Agregar funcion", null, agregarFuncion, null);
		agregarFuncion.setLayout(null);
		
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
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(97, 222, 89, 23);
		agregarFuncion.add(btnRegistrar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(262, 222, 89, 23);
		agregarFuncion.add(btnRegresar);
		
	
		
		JPanel consultarFuncion = new JPanel();
		tabbedPane.addTab("Consultar funciones", null, consultarFuncion, null);
		consultarFuncion.setLayout(null);
		
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
		agregarFuncionBtn.setBounds(20, 117, 240, 23);
		menuServicios.add(agregarFuncionBtn);
		
		JButton btnConsultarFuncionesPara = new JButton("Consultar funciones para una pelicula");
		btnConsultarFuncionesPara.setBounds(20, 174, 240, 23);
		menuServicios.add(btnConsultarFuncionesPara);
		
		JButton btnComprarBoletas = new JButton("Comprar boletas");
		btnComprarBoletas.setBounds(20, 222, 240, 23);
		menuServicios.add(btnComprarBoletas);
		
		JButton btnMostrarReporteBoletas = new JButton("Mostrar reporte boletas compradas");
		btnMostrarReporteBoletas.setBounds(317, 63, 240, 23);
		menuServicios.add(btnMostrarReporteBoletas);
		
		JButton btnSalvarDatosSistema = new JButton("Salvar los datos del sistema");
		btnSalvarDatosSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ManejoArchivos.SerializarCadenaCines(cadenaC);
					JOptionPane.showMessageDialog(null, "Sistema guardado con éxito", "Info", JOptionPane.INFORMATION_MESSAGE);
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
		
		
		
		
	}
}
