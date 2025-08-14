public class Epic extends Task {
    protected int id;
    public Epic(String name, String description) {
        super(name, description);
        this.status = Statuses.NEW;
        this.id = TaskManager.id;
    }

    public Epic(String name, String description, int id) {
        super(name, description, id);
    }

    public String getName(){
        return name;
    }
}
