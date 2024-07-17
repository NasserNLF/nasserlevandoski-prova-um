package estrutura_decisao;

import javax.swing.JOptionPane;

public class ExercicioDois {
	public static void main(String[] args) {
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Coloque um número inteiro"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Coloque mais um número inteiro"));
		int n3 = Integer.parseInt(JOptionPane.showInputDialog("Coloque mais um número inteiro"));
		int maiorNumero, numeroIntermediario, menorNumero = 0;

		// Bloco para verificar o maior Número
		if ((n1 >= n2) && (n1 >= n3)) {
			maiorNumero = n1;
		} else if ((n2 >= n1) && (n2 >= n3)) {
			maiorNumero = n2;
		} else {
			maiorNumero = n3;

		}

		// Bloco para identificar o número intermediário
		if (((n1 >= n2) && (n1 <= n3)) || ((n1 <= n2) && (n1 >= n3))) {
			numeroIntermediario = n1;
		} else if (((n2 >= n1) && (n2 <= n3)) || ((n2 <= n1) && (n2 >= n3))) {
			numeroIntermediario = n2;
		} else {
			numeroIntermediario = n3;
		}

		// Bloco para identificar o menor número
		if ((n1 <= n2) && (n1 <= n3)) {
			menorNumero = n1;
		} else if ((n2 <= n1) && (n2 <= n3)) {
			menorNumero = n2;
		} else {

			menorNumero = n3;
		}
		JOptionPane.showMessageDialog(null, String.format("Os números em ordem descrescente:\n%d, %d, %d", maiorNumero,
				numeroIntermediario, menorNumero));
	}

}
