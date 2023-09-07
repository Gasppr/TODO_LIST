import APP.Status;
import APP.Tarefa;
import com.google.gson.Gson;
import saveRead.SalvarTarefas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        Scanner sc = new Scanner(System.in);

        List<Tarefa> tarefas = new ArrayList<>();
        Tarefa tarefa1 = new Tarefa(1,"Fazer CRD", "Fazer o back-end do to-do list e adicionar as funcionalidades CRD","12-02-2023", "Back-end", Status.DOING, 1);
        Tarefa tarefa2 = new Tarefa(2, "Clase da Tarefa", "Criar uma classe com os atributos da tarefa","12-12-2023", "Back-end", Status.DONE, 1);
        Tarefa tarefa3 = new Tarefa(3, "Fazer tela dos cards das tarefas", "Usar pre modelos prontos de cards e customizar","12-03-2023", "Front-end", Status.TO_DO, 3);
        Tarefa tarefa4 = new Tarefa(4, "Banco de dados", "Criar o banco de dados da terefa e seus relacionamentos","12-02-2023", "BD", Status.TO_DO, 5);
        Tarefa tarefa5 = new Tarefa(5, "Fazer menu crud", "Criar uma aba para o CRUD ","12-02-2023", "Front-end", Status.TO_DO, 3);
        tarefas.add(tarefa1);
        tarefas.add(tarefa2);
        tarefas.add(tarefa3);
        tarefas.add(tarefa4);
        tarefas.add(tarefa5);



        Function<Tarefa, Integer> extraiPrioridade = Tarefa::getPrioridade;
        Comparator<Tarefa> comparePrioridade = Comparator.comparing(extraiPrioridade);

        int op = 1;

        System.out.println("----------- SEJA BEM-VINDO AO TO-DO LIST COROTINHO -------------");
        do {

            tarefas.sort(comparePrioridade);
            System.out.println("Escolha uma das opções \n 1- Criar tarefa \n 2- Ver lista de tarefa \n 3- Apagar tarefa \n 4- Sair");
            System.out.println("Digite a opção: ");
            op = sc.nextInt();

            if (op == 1)
            {

                Tarefa tarefa = new Tarefa();

                tarefa.setId(tarefas.size() + 1);

                System.out.println("Nome da tarefa: ");
                tarefa.setNome(sc.next());

                System.out.println("Descrição da tarefa: ");
                tarefa.setDescricao(sc.next());

                System.out.println("Data de prioridade da tarefa: ");
                tarefa.setData_de_prioridade(sc.next());


                System.out.println("Categoria da tarefa: ");
                tarefa.setCategoria(sc.next());

                System.out.println("Status da tarefa: \n 1-TO-DO \n 2-DOING \n 3-DONE");
                String opStatus = sc.next();
                Status status;
                switch (opStatus){
                    case "1" -> status = Status.TO_DO;
                    case "2" -> status = Status.DOING;
                    case "3" -> status = Status.DONE;
                    default -> status = Status.TO_DO;
                }
                tarefa.setStatus(status);

                System.out.println("Prioridade da tarefa 1 - 5");
                int opPrior = sc.nextInt();
                if (opPrior < 0 || opPrior > 5){

                    if (opPrior > 5){
                        opPrior = 5;
                    }
                    else {
                        opPrior = 0;
                    }
                }
                tarefa.setPrioridade(opPrior);

                try {
                     tarefas.add(tarefa);

                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Erro ao criar tarefa");
                }
            }



            else if (op == 2)
            {

                System.out.println(" 1- Todas as tarefas \n 2- listar por categoria \n 3- listar por status");
                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1 -> {
                        for (Tarefa tarefa : tarefas) {
                            tarefa.read();
                        }
                        try {

                            BufferedReader br = new BufferedReader(new FileReader("/home/paulo/IdeaProjects/TODO_LIST/TarefasSalvas/TarefasSalvas.json"));

                            //Converte String JSON para objeto Java
                            List lista = gson.fromJson(br, List.class);

                            for (Object tarefa : lista){
                                System.out.println(tarefa);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                    case 2 -> {
                        System.out.println("Todas as categorias:");
                        for (Tarefa tarefa : tarefas) {
                            System.out.println(tarefa.getCategoria());
                        }
                        System.out.println("Digite qual cateogria deseja filtar:");
                        String opCategoria = sc.next();
                        tarefas.stream().filter(value -> value.getCategoria().equals(opCategoria)).forEach(Tarefa::read);
                    }
                    case 3 -> {
                        System.out.println("Status:");
                        for (Tarefa tarefa : tarefas) {
                            System.out.println(tarefa.getStatus());
                        }
                        System.out.println("Digite qual Status deseja filtar:");
                        String opStatus = sc.next();
                        tarefas.stream().filter(value -> value.getStatus().equals(Status.valueOf(opStatus))).forEach(Tarefa::read);
                    }
                    default -> {
                        for (Tarefa tarefa : tarefas) {
                            tarefa.read();
                        }
                    }
                }
            }

           else if (op == 3)
           {
                System.out.println("Todas as Tarefas: ");
                for (Tarefa tarefa : tarefas){tarefa.read();}
                System.out.println("Digite o id da tarefa que deseja excluir: ");
                int opDelete = sc.nextInt();

                tarefas.removeIf( tarefa -> tarefa.getId() == opDelete );
            }
            else{
                System.out.println("Até mais");
            }


        }
        while ((op > 0 && op < 4));
        SalvarTarefas.salvar(tarefas);













    }

}