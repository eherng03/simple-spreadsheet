
public class Main {
	
	public static void main(String[] args) {
		java.util.Scanner teclado = new java.util.Scanner(System.in);
		int tablas = teclado.nextInt(); 	//numero de hojas
		String  tablaParaImprimir = "";			//variable en la que se almacenaran los datos ya con forma de tabla
		Celda[][] mat = null;					//inicializa la nueva variable tipo celda
			
		for(int t = 0; t < tablas; t++){						//numero de tablas (bucle de lectura)
			int columnas = teclado.nextInt();
			int filas = teclado.nextInt();
			mat = new Celda [filas][columnas];					//define el tamaño de la variable mat(riz)
			Posicion posicion = new Posicion(mat);
			for(int x = 0; x < filas ; x++){				//x = numero de fila(bucle que rellena la matriz
				
				
				//String filaX = teclado.nextLine(); (otra forma)
				//String [] elementoX = filaX.split(" ");
				
				
				for(int y = 0; y < columnas  ; y++){			//Y = numero de columna
					//mat[x][y][t] = elementox[y];  (otra forma)
					String elemento = teclado.next();
					char igual = '=';
					if(elemento.charAt(0) == igual){			//si empieza por  = procesa la formula
						mat[x][y] = new procesarFormula(elemento, posicion);		//mete en la posicion x, y el valor de la suma				
					} 	//fin del if
					else{
						int numero = Integer.parseInt(elemento);
						mat[x][y] = new NumeroIntroducido(numero);		//mete en la posicion x, y el valor del numero introducido
					}
					
					
					//......................................................................
					// Va almacenando en la String tablaParaImprimir los elementos de la matriz para imprimirlos
					if(y == 0){					//Si es el primer elemento de la fila no mete espacio
						tablaParaImprimir = tablaParaImprimir + mat[x][y].darNumero();
					}
					else if(x != filas -1){
						if(y == columnas -1){				//si es el ultimo elemento de la columna mete un fin de linea
							tablaParaImprimir = tablaParaImprimir + " " + mat[x][y].darNumero() + "\n";
						}
						else{								//si no, mete un espacio entre los elementos
							tablaParaImprimir = tablaParaImprimir + " " + mat[x][y].darNumero();
						}
					}
					else if(x == filas -1){
														
						tablaParaImprimir = tablaParaImprimir + " " + mat[x][y].darNumero();
						
					}
					
				}  		// fin del for columnas
			}			// fin del for filas
				
			}				//fin del for tablas
		
		
			teclado.close();
			
			System.out.println(tablaParaImprimir);
			
			
	}

}
