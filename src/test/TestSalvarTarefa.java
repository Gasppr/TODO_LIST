package test;

import APP.Status;
import APP.Tarefa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TestSalvarTarefa {

    public static void main(String[] args) throws IOException {
        List<Tarefa> testTarefas = new ArrayList<>();
        Gson gson = new Gson();
        Tarefa tarefa1 = new Tarefa(1, "Fazer CRD", "Fazer o back-end do to-do list e adicionar as funcionalidades CRD", "12-02-2023", "Back-end", Status.DOING, 1);
        Tarefa tarefa2 = new Tarefa(1, "Fazer CRD", "Fazer o back-end do to-do list e adicionar as funcionalidades CRD", "12-02-2023", "Back-end", Status.DOING, 1);
        Tarefa tarefa3 = new Tarefa(1, "Fazer CRD", "Fazer o back-end do to-do list e adicionar as funcionalidades CRD", "12-02-2023", "Back-end", Status.DOING, 1);
        Tarefa tarefa4 = new Tarefa(1, "Fazer CRD", "Fazer o back-end do to-do list e adicionar as funcionalidades CRD", "12-02-2023", "Back-end", Status.DOING, 1);

        testTarefas.add(tarefa1);
        testTarefas.add(tarefa2);
        testTarefas.add(tarefa3);
        testTarefas.add(tarefa4);


        try (Writer writer = new FileWriter("")) {
            gson = new GsonBuilder().create();
            gson.toJson(testTarefas, writer);
        }



        try {

            BufferedReader br = new BufferedReader(new FileReader(""));

            //Converte String JSON para objeto Java
            List<Tarefa> lista = gson.fromJson(br, List.class);

            System.out.println(lista);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }




