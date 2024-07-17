package estrutura_decisao;

import javax.swing.JOptionPane;

public class ExercicioCinco {
	public static void main(String[] args) {
		char letra = JOptionPane.showInputDialog("Digite uma letra").charAt(0);

		/*
		 * TABELA ASCII a - 97 e - 101 i - 105 o - 111 u - 117
		 */
		if ((letra == 97) || (letra == 101) || (letra == 105) || (letra == 111) || (letra == 117)) {
			JOptionPane.showMessageDialog(null, "A letra é uma vogal");
		} else {
			JOptionPane.showMessageDialog(null, "A letra não é uma vogal");
		}
	}
}
