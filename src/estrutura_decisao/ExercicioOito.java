package estrutura_decisao;

import javax.swing.JOptionPane;

public class ExercicioOito {
	public static void main(String[] args) {
		int diaDaSemana = Integer
				.parseInt(JOptionPane.showInputDialog("Digite um valor para ver qual dia da semana ele representa:"));

		switch (diaDaSemana) {
		case 1:
			JOptionPane.showMessageDialog(null, "Domingo");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Segunda-feira");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Terça-feira");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Quarta-feira");
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Quinta-feira");
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Sexta-feira");
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "Sábado");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Valor inválido");
			break;

		}
	}
}
