public class Desafio_1 {
	
	public Desafio_1() {
		int temp = 0;
		for (int i = 12; i < 899002; i++) { // valores encontrados -- > 18720
			if (i % 10 != 0) {
				temp = i + this.getReverso(i);
				if (temp < 1000000 && this.verificarDigitos(temp)) {
					System.out.println(i);
				}
			}
		}
	}

	public boolean verificarDigitos(int number) {
		String temp = number + "";
		int digito;
		for (int i = 0; i < temp.length(); i++) {
			digito = temp.charAt(i);
			if (digito % 2 == 0) {
				return false;
			}
		}
		return true;
	}

	public int getReverso(int valor) {
		String temp = valor + "";
		String resultado = "";
		for (int i = temp.length() - 1; i >= 0; i--) {
			resultado += temp.charAt(i);
		}
		return Integer.parseInt(resultado);
	}

	public static void main(String[] args) {
		new Desafio_1();
	}
}