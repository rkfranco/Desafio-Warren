import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio_3 {

	HashMap<Integer, ArrayList<Integer>> respostas = new HashMap<Integer, ArrayList<Integer>>();
	int number;
	int menorTamanho = 0;
	int qtdArrays = 0;

	public Desafio_3() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite um número: ");
		this.setNumber(sc.nextInt());
		System.out.print("Digite um vetor: ");
		int[] vector = this.stringToVector(sc.next());

		ArrayList<Integer> caminho = new ArrayList<Integer>();

		buscarP(caminho, vector);

		System.out.println(this.getNumber());
		this.printFiltrar(vector);
		sc.close();
	}

	public void printFiltrar(int[] vector) {
		int qtdArraysFiltro = 0;
		HashMap<Integer, ArrayList<Integer>> temp = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = this.getQtdArrays() - 1; i >= 0; i--) {
			if (this.getRespostas().get(i).size() <= this.getMenorTamanho() || this.getMenorTamanho() == 0) {
				Collections.sort(this.getRespostas().get(i));
				if (!temp.containsValue(getRespostas().get(i))) {
					this.setMenorTamanho(this.getRespostas().get(i).size());
					temp.put(qtdArraysFiltro, this.getRespostas().get(i));
					qtdArraysFiltro++;
				}
			}

		}
		this.printHashMap(temp, qtdArraysFiltro);
	}

	public void printHashMap(HashMap<Integer, ArrayList<Integer>> map, int qtdArraysFiltro) {
		for (int i = 0; i < qtdArraysFiltro; i++) {
			if (this.getMenorTamanho() >= map.get(i).size()) {
				System.out.println(map.get(i).toString());
			}
		}
	}

	public void buscarP(ArrayList<Integer> caminho, int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			int somaP = vector[i];
			caminho = new ArrayList<Integer>();
			caminho.add(somaP);
			if (somaP == this.getNumber()) {
				this.getRespostas().put(this.getQtdArrays(), caminho);
				this.setQtdArrays(getQtdArrays() + 1);
			} else {
				if (somaP < this.getNumber()) {
					buscar(caminho, vector, somaP);
				}
			}
		}
	}

	public void buscar(ArrayList<Integer> caminho, int[] vector, int somaP) {
		ArrayList<Integer> temp;
		for (int i = 0; i < vector.length; i++) {
			temp = new ArrayList<Integer>();
			temp.addAll(caminho);
			int somaB = somaP;
			somaB += vector[i];
			if (somaB == this.getNumber()) {
				temp.add(vector[i]);
				this.getRespostas().put(this.getQtdArrays(), temp);
				this.setQtdArrays(getQtdArrays() + 1);
				return;
			} else {
				if (somaB > this.getNumber()) {
					return;
				} else {
					temp.add(vector[i]);
					buscar(temp, vector, somaB);
				}
			}
		}
	}

	public int[] stringToVector(String input) {
		try {
			input = input.substring(1, input.indexOf("]"));
			String[] temp = input.split(",");

			int[] vector = new int[temp.length];
			for (int i = 0; i < temp.length; i++) {
				vector[i] = Integer.parseInt(temp[i]);
			}
			return vector;
		} catch (StringIndexOutOfBoundsException e) {
			this.printMensageError();
		} catch (IllegalArgumentException e2) {
			this.printMensageError();
		} catch (InputMismatchException e3) {
			this.printMensageError();
		}
		return null;
	}

	public void printMensageError() {
		System.out.println("Entrada inválida!");
		System.out.println("Tente inserir um valor como: [-2,-1,0,1,2]");
	}

	public HashMap<Integer, ArrayList<Integer>> getRespostas() {
		return respostas;
	}

	public void setRespostas(HashMap<Integer, ArrayList<Integer>> respostas) {
		this.respostas = respostas;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getMenorTamanho() {
		return menorTamanho;
	}

	public void setMenorTamanho(int menorTamanho) {
		this.menorTamanho = menorTamanho;
	}

	public int getQtdArrays() {
		return qtdArrays;
	}

	public void setQtdArrays(int qtdArrays) {
		this.qtdArrays = qtdArrays;
	}

	public static void main(String[] args) {
		new Desafio_3();
	}
}