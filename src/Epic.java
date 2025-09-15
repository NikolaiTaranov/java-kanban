import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Epic extends Task {
    private List<Subtask> subtasksForEpic = new ArrayList<>();

    public Epic(String name, String description) {
        super(name, description);
        this.status = Statuses.NEW;
    }

    public void updateStatus(Subtask subtask) {

        HashSet<Statuses> uniqueStatuses = new HashSet<>();
        for (Subtask sub : subtasksForEpic) {
            uniqueStatuses.add(sub.status);
        }
        if (uniqueStatuses.isEmpty()) {
            status = Statuses.NEW;
        } else if (uniqueStatuses.contains(Statuses.NEW) && !uniqueStatuses.contains(Statuses.IN_PROGRESS) && !uniqueStatuses.contains(Statuses.DONE)) {
            status = Statuses.NEW;
        } else if (!uniqueStatuses.contains(Statuses.NEW) && !uniqueStatuses.contains(Statuses.IN_PROGRESS) && uniqueStatuses.contains(Statuses.DONE)) {
            status = Statuses.DONE;
        } else {
            status = Statuses.IN_PROGRESS;
        }
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

    public List<Subtask> returnSubList(){
        return subtasksForEpic;
    }

    public void setSubtaskList (List<Subtask> list){
        subtasksForEpic = list;
    }
}
