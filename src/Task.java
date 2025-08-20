import java.util.Objects;

public class Task {
    protected String name;
    protected String description;
    protected int id;
    protected Statuses status;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = Statuses.NEW;
    }

    public Task(String name, String description, int id, Statuses status){
        this.name = name;
        this.description = description;
        if (id <=0 ){
            System.out.println("id should be more than 0");
        } else {
            this.id = id;
        }
        this.status = status;
    }

    public Task(){}

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}


