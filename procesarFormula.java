
public class procesarFormula extends Celda {
	//inicializacion de variables de la clase
	private String formula;
	private Posicion coordenadasAsignadas;

	public procesarFormula(String formula, Posicion coordenadas){		//cuando utilizas el metodo le pasas la formula, y la posicion que ocupa
		this.formula = formula;
		coordenadasAsignadas = coordenadas;
	}
	
	public int operar(String formulaIntroducida){			//metodo que a partir de la formula introducida opera
		String SinIgual = formulaIntroducida.substring(1);	//quita el = de la cadena
		String [] sumando = SinIgual.split("\\+");			//crea un array separando la formula por los +
		int res = 0;
		Celda numerito = null;								//inicializa variable tipo celda
		
		for(int i = 0; i < sumando.length; i++){			//for que pasa de formula a valor y los suma
			numerito = coordenadasAsignadas.darPosicionCelda(sumando[i]);		//da el entero que esta en la posicion del sumando[i]
			res = res + numerito.darNumero();		
		}
		return res;
	}

	@Override
	public int darNumero() {
		return this.operar(formula) ;			//obtiene el valor de la celda lo opera y lo devuelve
	}

}
