package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.GameState;

public class GridState {

	private GameState _gameState;
	private JButton[][] _buttons;
	
	public GridState() {
		this._gameState = new GameState();
	}
	
	public void setSelectedLevel(JComboBox comboBox ,JPanel panel, JLabel puntosLabel, JLabel recordLabel) {
		this.selectedLevel(comboBox, panel, puntosLabel, recordLabel);
	}
	
	public void setClickOnStart(JButton btnStart, JPanel panel) {
		this.clickOnStart(btnStart, panel);
    }
	
	public void setClickOnRestart(JButton btnRestart, JPanel panel) {
		this.clickOnRestart(btnRestart, panel);
	}
	
	public void setClickOnWildCard(JButton wildCard, JPanel panel) {
		this.clickOnWildCard(wildCard, panel);
	}
	
	private void selectedLevel(JComboBox comboBox ,JPanel panel, JLabel puntosLabel, JLabel recordLabel) {
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLevel = (String) comboBox.getSelectedItem();
                if (!selectedLevel.equals("Selecciona un nivel:")) {
                    int level = Integer.parseInt(selectedLevel.substring(0, 1));
                    gridGenerator(panel, level, puntosLabel, recordLabel);
                    _gameState.setNivelYComodin(level);
                    _gameState.verificarSiExisteRecord();
                }
            }
        });
	}
	
	private void gridGenerator(JPanel panel, int level, JLabel puntosLabel, JLabel recordLabel) {
		
        panel.removeAll(); // Limpiamos el panel antes de agregar la nueva grilla
        panel.setLayout(new GridLayout(level, level));
        
        createGrid(panel, level);
        addMouseListenerToButtons(panel, puntosLabel, recordLabel);
        
        panel.revalidate(); // Actualizamos la disposición del panel
        panel.setVisible(false);
    }

	private void createGrid(JPanel panel, int level) {
		_buttons = new JButton[level][level];
		for (int row = 0; row < level; row++) {
            for (int col = 0; col < level; col++) {
                JButton button = new JButton();
                button.setBackground(Color.ORANGE);
                panel.add(button);
                _buttons[row][col] = button; // Asigna el botón a la matriz de botones
            }
        }
	}
	
	private void addMouseListenerToButtons(JPanel panel, JLabel puntosLabel, JLabel recordLabel) {
		for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                	button.addMouseListener((MouseListener) new MouseAdapter() {
                		@Override
                		public void mouseClicked(MouseEvent e) {
                			updateUIGrid(button, panel,puntosLabel, recordLabel);
                		}
                	});  
            }
        }
	}

	private void updateUIGrid(JButton clickedButton, JPanel panel, JLabel puntosLabel, JLabel recordLabel) {
			toggleCellStateAndCheckWin(clickedButton, panel);
	        puntosLabel.setText("Movimientos: " + _gameState.getMoveCount());
	        recordLabel.setText("Record: "+ _gameState.getRecord());
	}

	private void toggleCellStateAndCheckWin(JButton clickedButton, JPanel panel) {
		_gameState.addMove();
		int rowCount = (int) Math.sqrt(panel.getComponentCount());
		int clickedIndex = panel.getComponentZOrder(clickedButton);
		int clickedRow = clickedIndex / rowCount;        
		int clickedColumn = clickedIndex % rowCount;

		if(_gameState.puedeUsarComodin()) {
			toggleEstadoComodin(clickedButton);
			_gameState.addUsoComodin();
			_gameState.cambiarEstadoComodin();
			checkPlayerWon(panel);
		}
		else {
			toggleRowAndColumn(panel, rowCount, clickedRow, clickedColumn);
			clickedButton.setBackground(clickedButton.getBackground() == Color.ORANGE ? Color.LIGHT_GRAY : Color.ORANGE); //aca solo cambia el boton clickeado
			checkPlayerWon(panel);
		}
	}

	private void toggleRowAndColumn(JPanel panel, int rowCount, int clickedRow, int clickedColumn) {
		for (int i = 0; i < rowCount; i++) { //Cambia de color fila y columna
			JButton rowButton = (JButton) panel.getComponent(clickedRow * rowCount + i);
			JButton columnButton = (JButton) panel.getComponent(clickedColumn + i * rowCount);
			
			rowButton.setBackground(rowButton.getBackground() == Color.ORANGE ? Color.LIGHT_GRAY : Color.ORANGE);
			columnButton.setBackground(columnButton.getBackground() == Color.ORANGE ? Color.LIGHT_GRAY : Color.ORANGE);
		}
	}
	
	private void toggleEstadoComodin(JButton clickedButton) {
		clickedButton.setBackground(clickedButton.getBackground() == Color.ORANGE ? Color.LIGHT_GRAY : Color.ORANGE);
	}
	
	private void checkPlayerWon(JPanel panel) {
		if(_gameState.checkWin(checkGrid(panel))) {
			restart(panel);
			showWinMessage();
		}
	}
	
	private boolean checkGrid(JPanel panel) {
		ArrayList<Boolean> celdasApagadas = setArrayCeldasApagadas(panel);
		return _gameState.verifiedWin(celdasApagadas);
	}
	
	private ArrayList<Boolean> setArrayCeldasApagadas(JPanel panel) {
		ArrayList<Boolean> celdasApagadas = new ArrayList<Boolean>();
		for (int i = 0; i < panel.getComponentCount(); i++) {
			if(panel.getComponent(i).getBackground() == Color.LIGHT_GRAY)
				celdasApagadas.add(true);
			else
				celdasApagadas.add(false);
		}
		return celdasApagadas;
	}

	private void showWinMessage() {
		JOptionPane.showMessageDialog(null, "Has ganado el juego!", "Victoria", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void clickOnStart(JButton btnStart, JPanel panel) {
        btnStart.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		restart(panel);
        		startGame(panel);
        		panel.setVisible(true);	//muestra el panel
        	}
        });  
	}

	private void clickOnRestart(JButton btnRestart, JPanel panel) {
        btnRestart.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		restart(panel);
        	}
        });
	}
	
	private void startGame(JPanel panel) {
        Random random = new Random();
        for (Component component : panel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                boolean isOn = random.nextBoolean();
                button.setBackground(isOn ? Color.LIGHT_GRAY : Color.ORANGE);
            }
        }
    }
	
	private void restart(JPanel panel) {
		_gameState.resetMoveCount();
		_gameState.resetUsosComodin();
		panel.setVisible(false); //quita el panel
	}
	
	private void clickOnWildCard(JButton btnWildCard, JPanel panel) {
		btnWildCard.addActionListener(new ActionListener() {
			@Override
        	public void actionPerformed(ActionEvent e) {
				_gameState.cambiarEstadoComodin();
        	}
        });
	}

}
