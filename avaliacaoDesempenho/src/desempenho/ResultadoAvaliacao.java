/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desempenho;

/**
 *
 * @author emmanuel.7931
 */
public class ResultadoAvaliacao {
    private double pontuacaoFinal;
    private String classificacao;

    public ResultadoAvaliacao(double pontuacaoFinal, String classificacao) {
        this.pontuacaoFinal = pontuacaoFinal;
        this.classificacao = classificacao;
    }

    public double getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    public String getClassificacao() {
        return classificacao;
    }
}
