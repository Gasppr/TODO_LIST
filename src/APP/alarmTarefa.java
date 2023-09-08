package APP;

import java.time.LocalDate;
import java.util.List;
import java.lang.Thread;

public abstract class alarmTarefa implements Runnable {

    public  static  void AcionadorDeTarefas(List<Tarefa> listaTarefa ){
        new Thread(){

           final LocalDate dataAtual = LocalDate.now();
            @Override
            public void run() {
                // o que vai acontecer dentro da thread


                for (Tarefa tarefa : listaTarefa) {

                    if (tarefa.getData_de_prioridade().equals(dataAtual)){
                        System.out.println(" Tarefas para fazer hoje :  " + tarefa.getNome() );
                    }
                }


            }
        }.start();
        //Vai executar o que tiver dentro de forma paralela passar
        // para a proxima thread
    }

}
