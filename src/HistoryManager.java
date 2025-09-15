import java.util.ArrayList;
import java.util.List;

public interface HistoryManager extends Managers {
    void add(Task task);
    List<Task> getHistory();
}
