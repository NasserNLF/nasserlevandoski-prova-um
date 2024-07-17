package estrutura_decisao;

import javax.swing.JOptionPane;

public class ExercicioSeis {
	public static void main(String[] args) {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Cardápio:\nPrato 1 - Miojo\nPrato 2 - Ensopado\nPrato 3 - Rest de Onte\nPrato 4- Rest de La Almoce\nPrato"
						+ " 5 - Rest de la jante\nEscolha um prato para maiores informações sobre:"));
		
		//Descrição dos pratos
		switch (opcao) {
		case 1:
			JOptionPane.showMessageDialog(null, "Macarrao Instantâneo Paulista");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Legumes em uma sopa carioca");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Prato frânces que aproveita a comida do dia anterior");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Prato francês que aproveita o resto do almoço");
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Prato francês que aproveita o resto do jantar");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida");
		}
	}
}
