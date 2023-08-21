public enum Status {

    TO_DO("To-Do"),
    DOING("Doing"),
    DONE("Done");


    private String status;
     Status(String Status){
        this.status = Status;
     }

     public String getStatus(){
         return this.status;
     }

     public void setStatus(String Status){
         this.status = Status;
     }

}
