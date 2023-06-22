package Polimorfismo_15_06;

public interface Intercurso {
	/*
	 * A interface define as assinaturas dos métodos. Não define propriedades
	 * Quando temos uma classe abstrata sem nenhum atributo e nós temos apenas
	 * métodos abstratos dentro dessa classe, a gente pode transformar essa classe
	 * em uma interface
	 * Interface == uma classe abstrata que somente tem métodos abstratos
	 * No java não conseguimos estender duas classes, então no java a maneira que
	 * termos
	 * de implementar diferentes comportamentos de diferentes classes é através de
	 * uma interface
	 * A interface vai definir qual é o comportamento que aquela classe precisa
	 * implementar e
	 * define apenas a assinatura da classe
	 */
	double GetCusto_do_Curso();
}