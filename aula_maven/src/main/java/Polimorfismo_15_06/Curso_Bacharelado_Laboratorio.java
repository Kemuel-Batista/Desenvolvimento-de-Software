package Polimorfismo_15_06;

public class Curso_Bacharelado_Laboratorio extends Curso implements Intercurso {
	public double custo_lab;

	@Override
	public double GetCusto_do_Curso() {
		return valor_parcela + this.custo_lab;
	}
}
