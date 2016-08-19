
public class Posicion {
	
	private Celda [][] casilla;		//variable privada (casilla) de tipo celda[][]
	
	public Posicion(Celda[][] posicion){
		casilla = posicion;
	}
	
	
	
	//metodo que cambia la letra por un numero:
	private static int asignacionLetraANumero(String LetraCelda){
		int NumeroLetra = 0;
		switch(LetraCelda){
		case "A" :{ NumeroLetra = 1; break;}
		case "B" :{ NumeroLetra = 2; break;}
		case "C" :{ NumeroLetra = 3; break;}
		case "D" :{ NumeroLetra = 4; break;}
		case "E" :{ NumeroLetra = 5; break;}
		case "F" :{ NumeroLetra = 6; break;}
		case "G" :{ NumeroLetra = 7; break;}
		case "H" :{ NumeroLetra = 8; break;}
		case "I" :{ NumeroLetra = 9; break;}
		case "J" :{ NumeroLetra = 10; break;}
		case "K" :{ NumeroLetra = 11; break;}
		case "L" :{ NumeroLetra = 12; break;}
		case "M" :{ NumeroLetra = 13; break;}
		case "N" :{ NumeroLetra = 14; break;}
		case "O" :{ NumeroLetra = 15; break;}
		case "P" :{ NumeroLetra = 16; break;}
		case "Q" :{ NumeroLetra = 17; break;}
		case "R" :{ NumeroLetra = 18; break;}
		case "S" :{ NumeroLetra = 19; break;}
		case "T" :{ NumeroLetra = 20; break;}
		case "U" :{ NumeroLetra = 21; break;}
		case "V" :{ NumeroLetra = 22; break;}
		case "W" :{ NumeroLetra = 23; break;}
		case "X" :{ NumeroLetra = 24; break;}
		case "Y" :{ NumeroLetra = 25; break;}
		case "Z" :{ NumeroLetra = 26; break;}
		}
		return NumeroLetra ;				
		}

	//metodo que devuelve true si la variable es un numero (para separar letras de numeros)
	private static boolean EsUnNumero(char x){
		try{
			Integer.parseInt(String.valueOf(x));
			return true;}
		catch(NumberFormatException ex){
			return false;}
		}
	
	//metodo que devuelve la fila a partir de las letras
	private static int getFila(String NombreCelda){
	
		String letras = "";
		String numeros = "";
		int NumeroAInt = 0;
		
		
		for(int i = 0; i < NombreCelda.length(); i++){				//separa numeros de letras
			char x = NombreCelda.charAt(i);
			if(EsUnNumero(x)){
				numeros = numeros + x;
			}
			else{
				letras = letras + x;
			}
		}
		NumeroAInt = Integer.parseInt(numeros);			//cadena numeros convertida a int
	
		return NumeroAInt - 1;
	}
	
	//metodo que devuelve la columna a partir del numero
	private static int getColumna(String NombreCelda){
		int columna = 0;
		String letras = "";
		String numeros = "";

		for(int i = 0; i < NombreCelda.length(); i++){				//separa numeros de letras
			char x = NombreCelda.charAt(i);
			if(EsUnNumero(x)){
				numeros = numeros + x;
			}
			else{
				letras = letras + x;
			}
		}
		
		if(letras.length() == 1){
			columna = asignacionLetraANumero(letras) -1;		//-1 por que las coordenadas empiezan en el 0
		}
		else if(letras.length() == 2){
			int letra1 = asignacionLetraANumero(letras.substring(0, 1));
			int letra2 = asignacionLetraANumero(letras.substring(1, 2));
			columna = ((26*letra1)+ letra2) - 1;
		}
		else if(letras.length() == 3){
			int letra1 = asignacionLetraANumero(letras.substring(0, 1));
			int letra2 = asignacionLetraANumero(letras.substring(1, 2));
			int letra3 = asignacionLetraANumero(letras.substring(2, 3));
			columna = ((((26*letra1) + letra2)*26)+ letra3) -1;
		}
		
	
		return columna;
	}
	
	//Metodo que te devuelve el valor que hay en la celda a partir del nombre de la celda con letras y numeros
	public Celda darPosicionCelda(String nombreCelda){		// se mete el nombre tipo AGF56
		int filaFinal = getFila(nombreCelda);					//devuelve la fila a partir del nombre
		int columnaFinal = getColumna(nombreCelda);				//devuelve la columna a partir del nombre
		Celda celdaObtenida = (casilla[filaFinal][columnaFinal]);
		return celdaObtenida;									//devuelve la celda
	}

	
}