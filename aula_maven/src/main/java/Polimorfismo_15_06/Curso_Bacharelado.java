package Polimorfismo_15_06;

public class Curso_Bacharelado extends Curso implements Intercurso {
    @Override
    public double GetCusto_do_Curso() {
        return valor_parcela;
    }
}