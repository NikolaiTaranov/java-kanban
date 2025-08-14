public class Task {
    protected String name;
    protected String description;
    protected int id;
    protected Statuses status;

    public Task(String name, String description) {
        TaskManager.id++;
        this.name = name;
        this.description = description;
        this.id = TaskManager.id;
        this.status = Statuses.NEW;
    }

    public Task(String name, String description,int id){
        this.name = name;
        this.description = description;
        if (id <=0 ){
            System.out.println("id should be more than 0");
        } else {
            this.id = id;
        }
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
