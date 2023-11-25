package interfaces;

import javax.swing.JFrame;

public class Interfaz extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interfaz() {
		initialize();
		UIprincipal.crear(this);
	}
	
	public JFrame getFrame() {
		return this;
	}
	
	private void initialize() {
		new JFrame();
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
	    setLocationRelativeTo(null);
	    setTitle("Conjunto Dominante Minimo");
	}
}