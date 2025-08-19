public class Subtask extends Task{
    private int epicId;
    public Subtask(String name, String description, int epicId) {
        super(name, description);
        this.id = TaskManager.id;
        this.status = Statuses.NEW;
        this.epicId = epicId;
    }

    public Subtask(String name, String description, int id, int epicId, Statuses status) {

        super(name, description, id, status);
        this.epicId = epicId;
    }

    public int getEpicId(){
        return epicId;
    }
}
