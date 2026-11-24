/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desempenho;

/**
 *
 * @author emmanuel.7931
 */
public class AvaliacaoDesempenho {
        
        private double notaProdutividade;
    private int numeroFaltas;
    private boolean cumpriuMetas;
    private boolean realizouTreinamento;
    private boolean participouProjetos;

    public AvaliacaoDesempenho(double notaProdutividade, int numeroFaltas,
            boolean cumpriuMetas, boolean realizouTreinamento,
            boolean participouProjetos) {

        this.notaProdutividade = notaProdutividade;
        this.numeroFaltas = numeroFaltas;
        this.cumpriuMetas = cumpriuMetas;
        this.realizouTreinamento = realizouTreinamento;
        this.participouProjetos = participouProjetos;
    }

    public ResultadoAvaliacao calcularAvaliacao() {

        double resultado = notaProdutividade * 2;

        if (cumpriuMetas) {
            resultado += 2;
        }

        if (realizouTreinamento) {
            resultado += 1;
        }

        if (participouProjetos) {
            resultado += 2;
        }

        resultado -= numeroFaltas * 0.5;

        if (resultado < 0) {
            resultado = 0;
        }

        if (resultado > 25) {
            resultado = 25;
        }

        String classificacao;

        if (resultado >= 20) {
            classificacao = "Excelente";
        } else if (resultado >= 15) {
            classificacao = "Bom";
        } else if (resultado >= 10) {
            classificacao = "Regular";
        } else {
            classificacao = "Insatisfatório";
        }

        return new ResultadoAvaliacao(resultado, classificacao);
    }
}
