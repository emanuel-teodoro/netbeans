/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contabancaria;

/**
 *
 * @author emmanuel.7931
 */
public class conta {
    String numeroConta;
    double saldo;
    double limite;
    String extrato = "";
    
    public void depositar(double valor){
        saldo += valor;
        extrato += valor;
    }
    
    public double consultarSaldo(){
        return saldo + limite;
    }
    
    public String gerarExtrato(){
        return extrato;
    }
    
    public void sacar(double valor){
        saldo -= valor;
        extrato += valor;
    }
}
