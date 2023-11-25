package interfaces;

import java.io.BufferedReader;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import negocio.conjuntoDominante.ConjuntoDominanteBackTracking;
import negocio.conjuntoDominante.ConjuntoDominanteHolistico;
import negocio.grafo.Grafo;
import negocio.grafoJson.GrafoJson;

public class VentanaSolucion {
	
	private JFrame _frame;
	private String _archivo;
	private JTextPane _txtPaneSolucion;
	
	public VentanaSolucion(JFrame frame, String archivo) {
		inicializarComponentes(frame, archivo);
		inicializarSolucion();
	}

	private void inicializarSolucion() {
		_frame.getContentPane().add(_txtPaneSolucion);
	}
	
	public void remove() {
		_frame.getContentPane().remove(_txtPaneSolucion);
	}
	
	private void inicializarComponentes(JFrame frame, String archivo) {
		_frame = frame;
		_archivo = archivo;
		_txtPaneSolucion = new JTextPane();
		_txtPaneSolucion.setBounds(37, 220, 400, 100);
		cargarTxtPane();
		frame.getContentPane().add(_txtPaneSolucion);
	}

	private void cargarTxtPane() {
	    String solucionHolistica = calcularConjuntoDominante(true);
	    String solucionBacktracking = calcularConjuntoDominante(false);

	    _txtPaneSolucion.setText(
	        "Conjunto dominante HOLISTICO: " + solucionHolistica + "\n \n"
	        +
	        "Conjunto dominante BACKTRACKING: " + solucionBacktracking
	    );
	}

	private String calcularConjuntoDominante(boolean isHolistico) {
	    Grafo grafo = leerGrafoDesdeJson();
	    if (isHolistico) {
	        Set<Integer> conjuntoDominante = ConjuntoDominanteHolistico.calcularConjuntoDominante(grafo);
	        return conjuntoDominante.toString();
	    } else {
	        Set<Integer> conjDominanteBacktracking = ConjuntoDominanteBackTracking.calcularConjuntoDominanteBacktracking(grafo);
	        return conjDominanteBacktracking.toString();
	    }
	}

	private Grafo leerGrafoDesdeJson() {
	    GrafoJson grafoJson = new GrafoJson("assets/data/" + _archivo);
	    BufferedReader reader = grafoJson.leerJson();
	    return grafoJson.crearGrafo(reader);
	}
}
