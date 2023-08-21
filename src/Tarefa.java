import java.util.Date;
import java.util.Objects;

public class Tarefa {



    private int id ;
    private String nome;
    private String descricao;

    private String data_de_prioridade;
    private String categoria;


    private int prioridade ;

    private Status status;




    //CREATE TAREFA
    public Tarefa(int Id , String Nome, String Descricao, String Data_de_prioridade, String Categoria, Status status, int prioridade){

       this.id = Id;
       this.nome = Nome;
       this.descricao = Descricao;
       this.data_de_prioridade = Data_de_prioridade;
       this.categoria = Categoria;
       this.status = status;
       this.prioridade = prioridade;

    }


    //READ TAREFA
    public void read(){


        System.out.println("ID: "+ this.id + ", nome: " +  this.getNome() + ", descrição: " + this.getDescricao() +
                ", data: " + this.getData_de_prioridade() + ", categoria: " + this.getCategoria() + ", Status: " + getStatus() + ", Prioridade: " + this.getPrioridade());

    }





    //DELETE TAREFA
    public void delete(Tarefa tarefa){




    }






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getData_de_prioridade() {
        return data_de_prioridade;
    }

    public void setData_de_prioridade(String data_de_prioridade) {
        this.data_de_prioridade = data_de_prioridade;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }




}


