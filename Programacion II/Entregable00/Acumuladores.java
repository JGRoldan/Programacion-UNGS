package acumuladores;

public class Acumuladores {

	//-------------------
	//----EJERCICIO 1----
	//-------------------
	
	//Recorro las filas
	public boolean todosMultiplosEnAlgunaFila(int [][] mat, int num) {
		//Caso base
		if(mat.length==0 || num<=0) return false;
		
		boolean algunoMultiplo = false;
		
		for(int f=0; f<mat.length;f++) {
			algunoMultiplo |= filaMultiplo(mat[f], num);
		}
		return algunoMultiplo;
	}
	
	//Recorro columna de la fila para verificar si TODOS son multiplos
	
	public boolean filaMultiplo(int [] mat, int num) {
		boolean todosMultiplos = true;
		
		for(int c=0;c<mat.length;c++) {
			todosMultiplos &= esMultiplo(mat[c], num);
		}
		return todosMultiplos;
	}
	
	//Verifico si cada elemento es Multiplo
	public boolean esMultiplo(int num1, int num2) {
		return num1%num2==0;
	}
	
	
	
	//-------------------
	//----EJERCICIO 2----
	//-------------------
	
	public boolean hayInterseccionPorFila(int [][] mat1, int [][] mat2) {
		//Caso base
		if(mat1.length!=mat2.length || mat1.length==0 || mat2.length==0) return false;
		
		boolean tieneIntersection = true;
		
		for(int f=0; f<mat1.length;f++) {
			tieneIntersection &= filaMatrices(mat1[f], mat2[f]);
		}
		return tieneIntersection;
	}
	
	public boolean filaMatrices(int []m1, int [] m2) {
		boolean algunaIntersection = false;
		
		for(int f=0;f<m1.length;f++) {
			algunaIntersection |= compararValorConMatriz(m1[f], m2);
		}
		
		return algunaIntersection;
	}
	
	public boolean compararValorConMatriz(int valor, int []m2) {
		boolean algunElementoIntersection = false;
		for(int c=0;c<m2.length;c++) {
			algunElementoIntersection |= comparoValorConCadaColumna(valor,m2[c]);
		}
		return algunElementoIntersection;
	}
	
	public boolean comparoValorConCadaColumna(int n, int m) {
		return n==m;
	}
	
	
	//-------------------
	//----EJERCICIO 3----
	//-------------------
	
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		if(mat.length==0 || nColum<0 || mat[0].length <= nColum) return false;
		
		boolean algunaSumaMas = false;
		
		for(int f=0; f<mat.length;f++) {
			algunaSumaMas |= (sumaFila(mat,f) > sumaCol(mat, nColum));
		}
		
		return algunaSumaMas;
	}
	
	public int sumaFila(int [][] mat, int fila) {
		int filaSuma = 0;
		
		for(int c = 0; c<mat[0].length;c++) {
			filaSuma += mat[fila][c];
		}
		return filaSuma;
	}
	
	public int sumaCol(int [][] mat, int nColum) {
		int sumaCol = 0;
		
		for(int c = 0; c<mat[0].length;c++) {
			if(c==nColum) {
				for(int f = 0; f<mat.length;f++) {
					sumaCol += mat[f][c];						
				}				
			}
		}
		return sumaCol;
	}
	
	
	
	//-------------------
	//----EJERCICIO 4----
	//-------------------
	
	public boolean hayInterseccionPorColumna(int [][] mat1, int [][] mat2) {
		//Caso base
		if(mat1.length==0 
				|| mat2.length==0
				|| mat1[0].length!=mat2[0].length ) return false;
		
		boolean tieneIntersection = false;

//		cantidad de columas 
		for(int c = 0; c< mat1[0].length; c++) {
			tieneIntersection |= recorroFila(mat1, mat2,c);
		}
		
		return tieneIntersection;
	}
	
	public boolean recorroFila(int[][] mat1, int [][]mat2, int c) {
		boolean igualdadValores = false;
		for(int f = 0; f<mat1.length;f++) {
			igualdadValores |= recorrerOtraMat(mat2,mat1[f][c],c);
		}
		return igualdadValores;
	}
	
//		Recorro la segunda matriz y comparo el valor de la funcion anterior 
//		con cada columna correspondiente
	
	public boolean recorrerOtraMat(int [][] mat2, int numComparar, int c) {
		boolean esIgual = false;
			for(int f = 0; f<mat2.length;f++) {
				esIgual |= (numComparar == mat2[f][c]);
			}
		
		return esIgual;
	}
	
}
