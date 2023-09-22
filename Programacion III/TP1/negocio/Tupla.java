package negocio;

public class Tupla<T1, T2> {

	private T1 _elem1;
	private T2 _elem2;
	
	public Tupla(T1 elem1, T2 elem2) {
		set_elem1((T1) elem1);
		set_elem2((T2) elem2);
	}

	public T2 get_elem2() {
		return _elem2;
	}

	public void set_elem2(T2 _elem2) {
		this._elem2 = _elem2;
	}

	public T1 get_elem1() {
		return _elem1;
	}

	public void set_elem1(T1 _elem1) {
		this._elem1 = _elem1;
	}
}
