import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private List<Task> historyList = new ArrayList<>();
    int historyListLimit = 10;

    @Override
    public void add(Task task){
        if (historyList.size() < historyListLimit){
            historyList.add(task);
        } else {
            historyList.removeFirst();
            historyList.add(task);
        }
    }

    @Override
    public List<Task> getHistory(){
        return historyList;
    }
}
