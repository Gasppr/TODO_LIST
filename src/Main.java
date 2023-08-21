import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.Collections;

public class Main {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Tarefa> tarefas = new LinkedList<Tarefa>();
        Tarefa tarefa1 = new Tarefa(1,"Fazer CRD", "Fazer o back-end do to-do list e adicionar as funcionalidades CRD","21/02/2023", "Back-end", Status.DOING, 1);
        Tarefa tarefa2 = new Tarefa(2, "Clase da Tarefa", "Criar uma classe com os atributos da tarefa","21/12/2023", "Back-end", Status.DONE, 1);
        Tarefa tarefa3 = new Tarefa(3, "Fazer tela dos cards das tarefas", "Usar pre modelos prontos de cards e customizar","21/03/2023", "Front-end", Status.TO_DO, 3);
        Tarefa tarefa4 = new Tarefa(4, "Banco de dados", "Criar o banco de dados da terefa e seus relacionamentos","21/02/2023", "BD", Status.TO_DO, 5);
        Tarefa tarefa5 = new Tarefa(5, "Fazer menu crud", "Criar uma aba para o CRUD ","21/02/2023", "Front-end", Status.TO_DO, 3);
        tarefas.add(tarefa1);
        tarefas.add(tarefa2);
        tarefas.add(tarefa3);
        tarefas.add(tarefa4);
        tarefas.add(tarefa5);


        Function<Tarefa, Integer> extraiPrioridade = t -> t.getPrioridade();
        Comparator<Tarefa> comparePrioridade = Comparator.comparing(extraiPrioridade);

        tarefa1.read();
        int op = 1;
//        Status status = Status.TO_DO;
//        System.out.println(status.getStatus());

        System.out.println("----------- SEJA BEM-VINDO AO TO-DO LIST COROTINHO -------------");
        do {

            tarefas.sort(comparePrioridade);
             System.out.println("Escolha uma das opções \n 1- Criar tarefa \n 2- Ver lista de tarefa \n 3- Apagar tarefa \n 4- Sair");
            System.out.println("Digite a opção: ");
            op = sc.nextInt();

            ////////////////////////// CRIAR TAREFA /////////////////////////////////////////////////////////////////////
            if (op == 1) {

                Tarefa tarefa;

                System.out.println("ID da tarefa: ");
                int id = sc.nextInt();
                System.out.println("Nome da tarefa: ");
                String nome = sc.next();;
                System.out.println("Descrição da tarefa: ");
                String descricao = sc.next();
                System.out.println("Data de prioridade da tarefa: ");
                String data = sc.next();
                System.out.println("Categoria da tarefa: ");
                String categoria = sc.next();
                System.out.println("Status da tarefa: \n 1-TO-DO \n 2-DOING \n 3-DONE");
                String opStatus = sc.next();
                Status status;

                if (opStatus.equals("1")){status = Status.TO_DO;}
                else if (opStatus.equals("2")){status = Status.DOING;}
                else if (opStatus.equals("3")){status = Status.DONE;}
                else {status = Status.TO_DO;}

                System.out.println("Prioridade da tarefa 1 - 5");
                Integer opPrior = sc.nextInt();

                if (opPrior < 0 || opPrior > 5){

                    if (opPrior > 5){
                        opPrior = 5;
                    }
                    else {
                        opPrior = 0;
                    }
                }



                try {
                     tarefas.add(new Tarefa(id, nome, descricao, data, categoria, status, opPrior ));
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Erro ao criar tarefa");
                }

           /////////////////////////////////////// LISTAR TAREFAS ////////////////////////////////////////////////////////////////////

            } else if (op == 2) {

                
                System.out.println(" 1- Todas as tarefas \n 2- listar por categoria \n 3- listar por status");
                int opcao = sc.nextInt();
               // if (opcao == 1){for (Tarefa tarefa : tarefas){tarefa.read();}}
                if (opcao == 1){

                    for (Tarefa tarefa : tarefas){tarefa.read();}

                }

                
                else if(opcao == 2){
                    System.out.println("Todas as categorias:");
                    for (Tarefa tarefa : tarefas){
                        System.out.println(tarefa.getCategoria());
                    }
                    System.out.println("Digite qual cateogria deseja filtar:");
                    String opCategoria = sc.next();

                   tarefas.stream().filter(value -> value.getCategoria().equals(opCategoria)).forEach(Tarefa::read);

                }
                else if(opcao == 3 ){
                    System.out.println("Status:");
                    for (Tarefa tarefa : tarefas){
                        System.out.println(tarefa.getStatus());
                    }
                    System.out.println("Digite qual Status deseja filtar:");
                    String opStatus = sc.next();

                    tarefas.stream().filter(value -> value.getStatus().equals(Status.valueOf(opStatus))).forEach(Tarefa::read);

                }
                else {for (Tarefa tarefa : tarefas){tarefa.read();}}

            }
            //////////////////////////// DELETAR TAREFA //////////////////////////////////////////////////////////////////////////////////
           else if (op == 3) {

                System.out.println("Todas as Tarefas: ");
                for (Tarefa tarefa : tarefas){tarefa.read();}
                System.out.println("Digite o id da tarefa que deseja excluir: ");
                Integer opDelete = sc.nextInt();


                tarefas.removeIf( v -> v.getId() == opDelete );

            }

           //////////////////////// FIM //////////////////////////////////////////////////////

            else{
                System.out.println("Até mais");
            }

        }
        while ((op > 0 && op < 4));














    }

}