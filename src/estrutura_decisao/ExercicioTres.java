package estrutura_decisao;

import javax.swing.JOptionPane;

public class ExercicioTres {
	public static void main(String[] args) {
		int diaPrimeiraData = Integer
				.parseInt(JOptionPane.showInputDialog("Comparação de datas\nDia da primeira data:"));
		int mesPrimeiraData = Integer.parseInt(JOptionPane.showInputDialog("Mês da primeira data:"));
		int anoPrimeiraData = Integer.parseInt(JOptionPane.showInputDialog("Ano da primeira data:"));
		int diaSegundaData = Integer
				.parseInt(JOptionPane.showInputDialog("Agora a Segunda data\nDia da segunda data:"));
		int mesSegundaData = Integer.parseInt(JOptionPane.showInputDialog("Mês da segunda data:"));
		int anoSegundaData = Integer.parseInt(JOptionPane.showInputDialog("Ano da segunda data:"));

		// Testes com o ano, depois mês e depois dia
		if (anoPrimeiraData < anoSegundaData) {
			JOptionPane.showMessageDialog(null, "A primeira data ocorreu primeiro");
		} else if (anoPrimeiraData > anoSegundaData) {
			JOptionPane.showMessageDialog(null, "A segunda data ocorreu primeiro");
		} else if (mesPrimeiraData < mesSegundaData) {
			JOptionPane.showMessageDialog(null, "A primeira data ocorreu primeiro");
		} else if (mesPrimeiraData > mesSegundaData) {
			JOptionPane.showMessageDialog(null, "A segunda data ocorreu primeiro");
		} else if (diaPrimeiraData < diaSegundaData) {
			JOptionPane.showMessageDialog(null, "A primeira data ocorreu primeiro");
		} else if (diaPrimeiraData > diaSegundaData) {
			JOptionPane.showMessageDialog(null, "A segunda data ocorreu primeiro");
		} else {
			JOptionPane.showMessageDialog(null, "As datas são idênticas");
		}

	}
}
