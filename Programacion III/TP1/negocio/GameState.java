package negocio;

import java.util.ArrayList;
import java.util.List;

public class GameState {
	
	private int _moveCount;
	private List<Tupla<String, Integer>> _records;
	private int _usosComodin;
	private int _nivelActual;
	private boolean _estadoComodin;
	
	public GameState() {
		this._moveCount = 0;
		this._records = new ArrayList<Tupla<String, Integer>>();
		this._usosComodin = 0;
		this._estadoComodin = false;
	}
	
	public int getMoveCount() {
		return this._moveCount;
	}
	
	public void resetMoveCount() {
		this._moveCount = 0;
	}
	
	public void addMove() {
		this._moveCount++;
	}
	
	public void addUsoComodin() {
		this._usosComodin++;
	}
	
	public void cambiarEstadoComodin() {
		this._estadoComodin = !this._estadoComodin;
	}
	
	public void setNivelYComodin(int level) {
		this._nivelActual = level;
	}
	
	public void resetUsosComodin() {
		this._usosComodin = 0;
		this._estadoComodin = false;
	}
	
    public void verificarSiExisteRecord() {
		String nuevoNivel = "" + _nivelActual + "x" + _nivelActual;
		boolean acumBoolean = true;
		//verifica si no hay un record asociado a ese nivel
		for(Tupla<String, Integer>  iterador : this._records) { 
			acumBoolean = acumBoolean && iterador.get_elem1()!=nuevoNivel;
		}
		//si no hay record en ese nivel, se crea
		if(acumBoolean) 
			_records.add(new Tupla<String, Integer>(nuevoNivel, 0));
	}

    public int getRecord() {
		for(Tupla<String, Integer> iterador : this._records)
			if(iterador.get_elem1().equals(""+_nivelActual+"x"+_nivelActual)) {
				return iterador.get_elem2();
			}
		return 0;
	}
    
	public boolean checkWin(boolean playerWon) {
		if(playerWon)
			checkRecord(_moveCount);
		return playerWon;
	}

	public boolean verifiedWin(ArrayList<Boolean> celdasApagadas) {
		return checkWin(celdasApagadas) ? true : false;
	}
	
	public boolean puedeUsarComodin() {
		return usoValidoComodin() && getWildCardState();
	}
	
	public boolean getWildCardState() {
		return this._estadoComodin;
	}
	
    private void checkRecord(int moveCount) {
    	for(Tupla<String, Integer> iterador : this._records) {
    		if((iterador.get_elem1().equals(""+_nivelActual+"x"+_nivelActual))
    				&& (iterador.get_elem2().intValue()>moveCount
    						|| iterador.get_elem2().intValue()==0)) {
    			iterador.set_elem2(moveCount - 1); //seteamos el nuevo record
    		}
    	}
    }
    
    private boolean checkWin(ArrayList<Boolean> celdasApagadas) {
    	boolean acumBoolean = true;
        for (boolean celdaApagada : celdasApagadas) {
            acumBoolean = acumBoolean && celdaApagada;
        }
        return acumBoolean;
    }
    
	private boolean usoValidoComodin() {
		if(this._nivelActual == 3 && this._usosComodin==0)
			return true;
		else if(this._nivelActual == 4 && this._usosComodin<2)
			return true;
		else if(this._nivelActual == 5 && this._usosComodin<4)
			return true;
		else
			return false;
	}
}
