package interfaces;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import negocio.grafo.Grafo;

public class VentanaGrafo {
	private JLabel _frame;
	private DibujarGrafo _graphDrawer;
	private JPanel _panel;
	
	public VentanaGrafo(JLabel _frameImg, Grafo grafo) {
		inicializarFrame(_frameImg);
		dibujarGrafo(grafo);
	}

	public void remove() {
		_frame.getRootPane().remove(_graphDrawer); //Si saco este funciona igual
		_panel.setVisible(false); //Si saco este, al hacer click en volver. Queda el grafo en la pantalla ppal
	}
	
	private void dibujarGrafo(Grafo grafo) {
		_graphDrawer = new DibujarGrafo(grafo);
		_graphDrawer.setPreferredSize(new Dimension(400, 250));
		_panel.add(_graphDrawer);
	}

	private void inicializarFrame(JLabel _frameImg) {
		_frame = _frameImg;
		_panel = new JPanel();
		_panel.setBounds(38, 120, 400, 250);
		_frame.add(_panel);
	}

}


