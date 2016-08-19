
public class NumeroIntroducido extends Celda {
	
	private int numero;
	
	public NumeroIntroducido(int numero){
		this.numero = numero;
	}
	@Override
	public int darNumero() {			//devuelve el numero entero que metes en la celda
		return this.numero;
	}
}