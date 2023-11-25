package interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JPanel;

import negocio.grafo.Grafo;

public class DibujarGrafo extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Grafo _grafo;
	private Set<Integer> _vertices;
	private int[] _xCoords, _yCoords;
	
    public DibujarGrafo(Grafo grafo) {
        _grafo = grafo;
        _vertices = new HashSet<Integer>(); 
        _xCoords = new int[0];
        _yCoords = new int[0];
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        _vertices = _grafo.obtenerVertices();
        dibujarVertices(g);
        dibujarArcos(g);

    }

	private void dibujarVertices(Graphics g) {
        int index = 0;
        int numVertices = _vertices.size();
        _xCoords = new int[numVertices];
        _yCoords = new int[numVertices];
        
        for (int v : _vertices) {
            _xCoords[index] = (int) (120 + 80 * Math.cos(2 * Math.PI * index / numVertices));
            _yCoords[index] = (int) (120 + 80 * Math.sin(2 * Math.PI * index / numVertices));
            g.fillOval(_xCoords[index], _yCoords[index], 10, 10);
            g.drawString(String.valueOf(v), _xCoords[index] - 15, _yCoords[index] - 15);
            index++;
        }	
	}
	
	private void dibujarArcos(Graphics g) {
        for (int v : _vertices) {
            int x1 = _xCoords[v - 1] + 5;
            int y1 = _yCoords[v - 1] + 5;
            TreeSet<Integer> neighbors = _grafo.obtenerVecinos(v);
            for (int neighbor : neighbors) {
                int x2 = _xCoords[neighbor - 1] + 5;
                int y2 = _yCoords[neighbor - 1] + 5;
                g.setColor(new Color((int)(Math.random() * 0x1000000))); //random color
                g.drawLine(x1, y1, x2, y2);
            }
        }
	}

}
