package interfaces;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InterfazVisual {
	private JFrame _frame;
	private JPanel _panel;
	private GridState _gridState;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazVisual window = new InterfazVisual();
					window._frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InterfazVisual() {
		this._gridState = new GridState();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		_frame = new JFrame("Lights Out Game");
		_frame.setResizable(false);
		_frame.setBounds(100, 100, 628, 475);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);
		_frame.setResizable(false);
        _frame.setLocationRelativeTo(null);

		/////////////////////
		//CREACION DE PANEL PARA GRILLA
		/////////////////////
		_panel = new JPanel();
		_panel.setBackground(new Color(192, 192, 192));
		_panel.setBounds(225, 48, 338, 336);
		
		/////////////////////
		//CREACION DE LABELS 
		/////////////////////
		JLabel puntosLabel =  new JLabel("Movimientos: "); 
		puntosLabel.setBounds(340, 11, 100, 23);
		
		JLabel recordLabel =  new JLabel("Rercord: ") ; 
		recordLabel.setBounds(490,  11, 100, 23);
		
		/////////////////////
		//CREACION DE COMBOBOX
		/////////////////////
		JComboBox comboBox = new JComboBox();
		String [] levels = {"Selecciona un nivel:", "3x3", "4x4", "5x5"};
    	comboBox.setModel(new DefaultComboBoxModel(levels));
		comboBox.setBounds(27, 48, 188, 22);
		_gridState.setSelectedLevel(comboBox, _panel, puntosLabel, recordLabel);
		
		/////////////////////
		//CREACION DE BOTONES
		/////////////////////
        JButton btnStart =  new JButton("Start");  
        btnStart.setBounds(27, 81, 89, 23);
        
        JButton btnRestart =  new JButton("Reset") ;
        btnRestart.setBounds(126, 81, 89, 23);
        
        JButton btnWildCard = new JButton("Comodin") ;
        btnWildCard.setBounds(27, 400 , 89, 23);
        
        _gridState.setClickOnStart(btnStart, _panel);
        _gridState.setClickOnRestart(btnRestart, _panel);
        _gridState.setClickOnWildCard(btnWildCard,_panel);
        
		/////////////////////
		//CREACION DE REGLAS
		/////////////////////
        JTextArea gameRules = new JTextArea();
        gameRules.setFont(new Font("consolas", Font.PLAIN, 16));
    	gameRules.setWrapStyleWord(true);
    	gameRules.setLineWrap(true);
    	gameRules.setText("El objetivo del juego es dejar todos los casilleros en color GRIS. \n\nComodines 3x3: 1 \nComodines 4x4: 2 \nComodines 5x5: 4");
    	gameRules.setBounds(27, 120, 188, 264);
    	
        addComponentToFrame(_panel);
        addComponentToFrame(puntosLabel);
        addComponentToFrame(recordLabel);
        addComponentToFrame(comboBox);
        addComponentToFrame(btnStart);
        addComponentToFrame(btnRestart);
        addComponentToFrame(gameRules);
        addComponentToFrame(btnWildCard);
	}
	
	private void addComponentToFrame(JComponent component) {
		_frame.getContentPane().add(component);
	}
}