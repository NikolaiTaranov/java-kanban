import java.util.ArrayList;

public class Epic extends Task {
    protected int id;
    ArrayList<Subtask> subList = new ArrayList<>();

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
        if (subList.isEmpty()) {
            subList.add(subtask);
        } else {
            for (Subtask sub : subList) {
                if (sub.getId() == subtask.getId()) {
                    oldSub = sub;
                }
            }
            if (oldSub != null){
                removeSub(oldSub);
            }
            subList.add(subtask);
        }
    }

    public void removeSub(Subtask sub){
        subList.remove(sub);
    }

    public ArrayList<Subtask> returnSubList(){
        return subList;
    }
}
