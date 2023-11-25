package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import negocio.grafo.Grafo;
import negocio.grafoJson.GrafoJson;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class UIprincipal {

	private JFrame _frame;
	private JLabel _frameImg;
	private JButton _btnSolucion;
	private JButton _btnCrearGrafo;
	private JButton _btnVolver;
	private JComboBox<String> _comboBoxGrafos;
	private JLabel _lblTitulo;
	private VentanaSolucion _ventanaSolucion;
	private VentanaGrafo _ventanaGrafo;
	
	public UIprincipal(JFrame frame) {
		_frame = frame;
		initialize();
	}
	
	public static UIprincipal crear(JFrame frame) {
		return new UIprincipal(frame);
	}
	
    public JFrame getFrame() {
		return _frame;
	}
    
	private void initialize() {
		iniciarComponentes();
		addActionListeners();	
	}

	private void iniciarComponentes() {
		iniciarImagenes();
		iniciarComboBox();
		iniciarBotones();
	}
	
	private void iniciarImagenes() {
		ImageIcon fondoImg = new ImageIcon(this.getClass().getResource("/assets/imagen/fondo.jpg"));
		_frameImg = new JLabel(fondoImg);
		_frameImg.setSize(700,500);
		_frame.getContentPane().add(_frameImg);
		
		Image iconImagen = new ImageIcon(this.getClass().getResource("/assets/imagen/icono.png")).getImage();
		Image iconResize = iconImagen.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		_frame.setIconImage(iconResize);
	}

	private void iniciarComboBox() {
		Map<Integer, String> jsonFiles = new HashMap<>();
		_lblTitulo = new JLabel("Seleccione una opcion");
		_lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		_lblTitulo.setForeground(Color.white);
		_lblTitulo.setBounds(37, 180, 150, 33);
		_frameImg.add(_lblTitulo);
		
		leerJSONPath(jsonFiles);
		_comboBoxGrafos = new JComboBox<String>();
		_comboBoxGrafos.addItem("");
        for (String value : jsonFiles.values()) {
        	_comboBoxGrafos.addItem(value);
        }
		_comboBoxGrafos.setBackground(new Color(255, 255, 255));
		_comboBoxGrafos.setToolTipText("Seleccione un grafo");
		_comboBoxGrafos.setBounds(37, 210, 320, 22);
		_frameImg.add(_comboBoxGrafos);
	}
	
	private void leerJSONPath(Map<Integer, String> jsonFiles) {
        String rutaDeDirectorioJSON = "src/assets/data/";
        File directorio = new File(rutaDeDirectorioJSON);
        
        if (directorio.exists()) {
            File[] files = directorio.listFiles();
            if (files != null) {
                int count = 1;
                for (File file : files) {
                    jsonFiles.put(count, file.getName());
                    count++;
                }
            }
        }
	}
	
	private void iniciarBotones() {
		_btnSolucion = new JButton("SOLUCION");
		_btnSolucion.setBackground(new Color(255,255,255));
		_btnSolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		_btnSolucion.setBounds(37, 260, 110, 33);
		_frameImg.add(_btnSolucion);
		
		_btnCrearGrafo = new JButton("VER GRAFO");
		_btnCrearGrafo.setBackground(new Color(255,255,255));
		_btnCrearGrafo.setFont(new Font("Tahoma", Font.BOLD, 12));
		_btnCrearGrafo.setBounds(247, 260, 110, 33);
		_frameImg.add(_btnCrearGrafo);
		
		_btnVolver = new JButton("VOLVER");
		_btnVolver.setBackground(new Color(255,255,255));
		_btnVolver.setFont(new Font("Tahoma", Font.BOLD, 12));
		_btnVolver.setBounds(37, 400, 110, 33);
		_frameImg.add(_btnVolver);
		_btnVolver.setVisible(false);
	}
	
	private void addActionListeners() {
		_btnSolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(checkGrafoSeleccionado()) {
					_ventanaSolucion = new VentanaSolucion(_frame, _comboBoxGrafos.getSelectedItem().toString());
					cambiarImagenFondo("/assets/imagen/solucion.jpg");
				}
			}
		
		});

		_btnCrearGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkGrafoSeleccionado()) {
					_ventanaGrafo = new VentanaGrafo(_frameImg, dameGrafo());
					cambiarImagenFondo("/assets/imagen/grafo.jpg");					
				}
			}
		});
		
		_btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setMenuVisible(true);
				cambiarImagenFondo("/assets/imagen/fondo.jpg");
				if (_ventanaGrafo != null)
					_ventanaGrafo.remove();
			}
		});
	}

	private void cambiarImagenFondo(String ruta) {
		ImageIcon fondoImg = new ImageIcon(this.getClass().getResource(ruta));
		_frameImg.setIcon(fondoImg);
	}

	private Grafo dameGrafo() {
		GrafoJson grafoJson = new GrafoJson("assets/data/"+_comboBoxGrafos.getSelectedItem().toString());
		BufferedReader reader = grafoJson.leerJson();
		Grafo grafo = grafoJson.crearGrafo(reader);
		
		return grafo;
	}

	private void setMenuVisible(boolean flag) {
		_btnSolucion.setVisible(flag);
		_btnCrearGrafo.setVisible(flag);
		_comboBoxGrafos.setVisible(flag);
		_lblTitulo.setVisible(flag);
		if(_ventanaSolucion!=null)
			_ventanaSolucion.remove();
		_btnVolver.setVisible(!flag);
	}

	private boolean checkGrafoSeleccionado() {
		if(_comboBoxGrafos.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Tiene que seleccionar un grafo.", "Grafo no seleccionado.", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		else {
			setMenuVisible(false);
			return true;
		}
	}
}
