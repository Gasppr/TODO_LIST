package saveRead;

import APP.Tarefa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.List;


public class SalvarTarefas {


        public static void salvar(List<Tarefa> tarefas) {


            try (Writer writer = new FileWriter("/home/paulo/IdeaProjects/TODO_LIST/TarefasSalvas/TarefasSalvas.json")) {
                Gson gson = new GsonBuilder().create();
                gson.toJson(tarefas, writer);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

}
