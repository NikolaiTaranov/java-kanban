import java.util.ArrayList;

public class Epic extends Task {
    protected int id;
    ArrayList<Subtask> subtasksForEpic = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
        this.status = Statuses.NEW;
    }

    public Epic(String name, String description, int id) {
        super(name, description);
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId (){
        return id;
    }

    public void addToList(Subtask subtask) {
        Subtask oldSub = null;
        if (subtasksForEpic.isEmpty()) {
            subtasksForEpic.add(subtask);
        } else {
            for (Subtask sub : subtasksForEpic) {
                if (sub.getId() == subtask.getId()) {
                    oldSub = sub;
                }
            }
            if (oldSub != null){
                removeSub(oldSub);
            }
            subtasksForEpic.add(subtask);
        }
    }

    public void removeSub(Subtask sub){
        subtasksForEpic.remove(sub);
    }

    public ArrayList<Subtask> returnSubList(){
        return subtasksForEpic;
    }
}
