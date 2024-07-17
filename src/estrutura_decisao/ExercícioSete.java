package estrutura_decisao;

import javax.swing.JOptionPane;

public class ExercícioSete {
	public static void main(String[] args) {
		int ano = Integer.parseInt(JOptionPane.showInputDialog("Em qual ano você nasceu?"));
		int mesNascimento = Integer.parseInt(JOptionPane.showInputDialog("Em qual mês você nasceu?"));
		int mesAtual = Integer.parseInt(JOptionPane.showInputDialog("Em qual mês você está executando esse programa?"));

		// Verificação mês de aniversário
		if (mesNascimento == mesAtual) {
			JOptionPane.showMessageDialog(null,
					"Mês atual referente a seu aniversário!\nCaso você já tenha feito"
							+ " aniversário esse mês, sua idade atual é " + (2024 - ano)
							+ "\nCaso ainda não, sua idade atual é " + ((2024 - ano) - 1));
		} else if (mesNascimento < mesAtual) {
			JOptionPane.showMessageDialog(null, "Não é o mês do seu aniversário!\nSua idade atual: " + (2024 - ano));
		} else {
			JOptionPane.showMessageDialog(null,
					"Não é o mês do seu aniversário!\nSua idade atual: " + ((2024 - ano) - 1));
		}

	}
}
