package estrutura_decisao;

import javax.swing.JOptionPane;

public class ExercicioQuatro {
	public static void main(String[] args) {
		double r1 = Double.parseDouble(JOptionPane.showInputDialog("Comprimento do primeiro segmento de reta"));
		double r2 = Double.parseDouble(JOptionPane.showInputDialog("Comprimento do segundo segmento de reta"));
		double r3 = Double.parseDouble(JOptionPane.showInputDialog("Comprimento do terceiro segmento de reta"));

		// Verificação se corresponde a um triângulo
		if ((r1 + r2 > r3) && (r1 + r3 > r2) && (r2 + r3 > r1)) {
			// Análise para descobrir o tipo do triângulo (Equilátero), (Isósceles),
			// (Escaleno)
			if ((r1 == r2) && (r1 == r3)) {
				JOptionPane.showMessageDialog(null,
						"Os segmentos podem formar um triângulo!\nEle é equilátero (3 lados iguais)");
			} else if ((r1 == r2) || (r1 == r3) || (r2 == r3)) {
				JOptionPane.showMessageDialog(null,
						"Os segmentos podem formar um triângulo!\nEle é isósceles (2 lados iguais)");
			} else {
				JOptionPane.showMessageDialog(null,
						"Os segmentos podem formar um triângulo!\nEle é escaleno (3 lados diferentes)");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Os segmentos não podem formar um triângulo!");
		}
	}

}
