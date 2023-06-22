package Polimorfismo_15_06;

public class Consumidor_Intercurso {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudante aluno = new Estudante();

		Curso_Bacharelado curso1 = new Curso_Bacharelado();
		curso1.nome = "BSI";
		curso1.valor_parcela = 1000.0;

		Curso_Bacharelado_Laboratorio curso2 = new Curso_Bacharelado_Laboratorio();
		curso2.nome = "ODONTO";
		curso2.valor_parcela = 1500.0;
		curso2.custo_lab = 500.0;

		// aluno.cursos.add(curso1);
		aluno.cursos.add(curso2);

		System.out.println("O valor das parcelas de seus cursos é de R$ " + aluno.getValorTotal());
	}
}