import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int minimoAlunos = 0;
		int alunosPontuais = 0;
		boolean erro = false;
		try {
			System.out.print("Número mínimo de alunos presentes para que a aula não seja cancelada = ");
			minimoAlunos = sc.nextInt();

			System.out.print("tempoChegada = ");
			String temp = sc.next();

			temp = temp.substring(1, temp.indexOf("]"));

			String[] temp2 = temp.split(",");

			int[] tempoChegada = new int[temp2.length];
			for (int i = 0; i < temp2.length; i++) {
				tempoChegada[i] = Integer.parseInt(temp2[i]);
				if (tempoChegada[i] >= 0) {
					alunosPontuais++;
				}
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Entrada inválida!");
			System.out.println("Tente inserir um valor como: [-2,-1,0,1,2]");
			erro = true;
		} catch (IllegalArgumentException e2) {
			System.out.println("Entrada inválida!");
			System.out.println("Tente inserir um valor inteiro no primeiro campo.");
			System.out.println("Tente inserir um valor como: [-2,-1,0,1,2] no campo tempoChegada.");
			erro = true;
		} catch (InputMismatchException e3) {
			System.out.println("Entrada inválida!");
			System.out.println("Tente inserir um valor inteiro no primeiro campo.");
			System.out.println("Tente inserir um valor como: [-2,-1,0,1,2] no campo tempoChegada.");
			erro = true;
		}
		if (alunosPontuais >= minimoAlunos && erro == false) {
			System.out.println("Aula normal");
		} else if (alunosPontuais < minimoAlunos && erro == false) {
			System.out.println("Aula cancelada");
		}
		sc.close();
	}
}