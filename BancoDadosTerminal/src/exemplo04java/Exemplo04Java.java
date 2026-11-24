/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package exemplo04java;
import java.util.Scanner;
/**
 *
 * @author shkna
 */
public class Exemplo04Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Aluno aluno = new Aluno();

        Scanner scanner = new Scanner(System.in);

        int opcao = 0; 

        while (opcao != 5) {

            System.out.println("==== MENU ALUNO ====");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Buscar Aluno");
            System.out.println("3. Atualizar Aluno");
            System.out.println("4. Excluir Aluno");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {

                case 1:
                    System.out.println("=== ADICIONAR ALUNO ===");
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();

                    System.out.print("Digite o curso: ");
                    String curso = scanner.nextLine();

                    aluno.adicionarAluno(nome, email, curso);
                    break;

                case 2:
                    System.out.println("=== BUSCAR ALUNO ===");
                    System.out.print("Digite o ID do aluno: ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine(); // consome o ENTER

                    aluno.buscarAluno(idBusca);
                    break;

                case 3:
                    System.out.println("=== ATUALIZAR ALUNO ===");
                    System.out.print("Digite o ID do aluno: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // consome o ENTER

                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite o novo email: ");
                    String novoEmail = scanner.nextLine();

                    System.out.print("Digite o novo curso: ");
                    String novoCurso = scanner.nextLine();

                    aluno.atualizarAluno(novoNome, novoEmail, novoCurso, idAtualizar);
                    break;

                case 4:
                    System.out.println("=== EXCLUIR ALUNO ===");
                    System.out.print("Digite o ID do aluno: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine(); // consome o ENTER

                    aluno.excluirAluno(idExcluir);
                    break;

                case 5:
                  
                    System.out.println("Saindo do programa.");
                    break;

                default:
                     System.out.println("Opcao invalida! Tente novamente.");
                    break;
            }

        }

        scanner.close();
    }
        
        
        /*
        Aluno aluno = new Aluno();
        String nome, email, curso;
        int id;
      
        
        try (Scanner scanner = new Scanner(System.in)) {
         
         while (true) {
                
                // Exibe o menu de opções
                System.out.println("1. Adicionar Aluno");
                System.out.println("2. Buscar Aluno"); 
                System.out.println("3. Atualizar Aluno");
                System.out.println("4. Excluir Aluno");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opcao: ");

                int opcao = -1;

                // Tratamento de erro para entrada não-numérica
                try {
                    opcao = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Por favor, digite um número válido (1-5).");
                    scanner.nextLine(); // Limpa o buffer do scanner
                    continue; // Volta ao início do loop
                }
                
                scanner.nextLine(); // Limpa o buffer após ler o número (consome o "Enter")
        
               
                 switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome: ");
                        nome = scanner.nextLine();
                        System.out.print("Digite o email: ");
                        email = scanner.nextLine();
                        System.out.print("Digite o curso: ");
                        curso = scanner.nextLine();
                        scanner.nextLine(); // Limpa o buffer
                        
                        aluno.adicionarAluno(nome,email,curso);
                        break;

                    case 2:
                        System.out.print("Digite o ID do aluno para buscar: ");
                        id = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer
                        
                        aluno.buscarAluno(id); 
                        break;

                    case 3:
                        System.out.print("Digite o ID do aluno para atualizar: ");
                        id = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer
                        System.out.print("Digite o novo nome: ");
                        nome = scanner.nextLine();
                         System.out.print("Digite o novo email: ");
                        email = scanner.nextLine();
                        System.out.print("Digite o novo curso: ");
                        curso = scanner.nextLine();
                        
                       aluno.atualizarAluno(nome, email, curso, id); 
                        break;

                    case 4:
                        // --- EXCLUIR ---
                        System.out.print("Digite o ID do aluno para excluir: ");
                        id = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer
                        
                        aluno.excluirAluno(id);  
                        break;

                    case 5:
                        // --- SAIR ---
                        System.out.println("Saindo do programa...");
                        return; // Encerra o método main e, consequentemente, o programa

                    default:
                        // --- OPÇÃO INVÁLIDA ---
                        System.err.println("Opcao invalida! Por favor, escolha de 1 a 5.");
                        break;
                }
            }
            
        }
        */
        
       // --- Teste 1: Adicionar Alunos---
     //   System.out.println("--- Adicionando Alunos ---");
     //   aluno.adicionarAluno("Sergio", "sergio@senac.com.br", "ADS");
        
       // --- Teste 2: Listar Alunos ---
     //   System.out.println("Buscar Alunos.");
     //   aluno.buscarAluno(1); 
 
      // --- Teste 3: Atualizar Alunos ---
     //    System.out.println("Atualiza Alunos.");
     //    aluno.atualizarAluno("Sergio", "sergio@senac.com.br", "ADS", 3); 
        
    // --- Teste 4: Excluir Alunos ---
    //    System.out.println("Excluir Alunos.");
     //   aluno.excluirAluno(3);  

    
}
