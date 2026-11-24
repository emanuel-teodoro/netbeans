/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desempenho;

/**
 *
 * @author emmanuel.7931
 */
public class RelatorioAvaliacao {
    public String gerarRelatorio(Funcionario funcionario,
            ResultadoAvaliacao resultado, int faltas,
            String criterios) {

        return "===== RELATÓRIO DE DESEMPENHO =====\n\n"
                + "Nome: " + funcionario.getNome() + "\n"
                + "Cargo: " + funcionario.getCargo() + "\n"
                + "Pontuação: " + resultado.getPontuacaoFinal() + "\n"
                + "Faltas: " + faltas + "\n"
                + "Critérios atendidos: " + criterios + "\n"
                + "Parecer final: " + resultado.getClassificacao();
    }
}
