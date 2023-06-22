package Polimorfismo_15_06;

import java.util.ArrayList;

public class Estudante {
	public String matricula;
	public String cpf;
	public String nome;
	public String email;
	ArrayList<Intercurso> cursos = new ArrayList<Intercurso>();

	public double getValorTotal() {
		double valorTotal = 0.0;

		for (Intercurso curso : cursos) {
			valorTotal += curso.GetCusto_do_Curso();
		}

		return valorTotal;
	}
}
