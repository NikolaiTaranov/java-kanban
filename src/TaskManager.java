import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TaskManager {
    void removeAllTasks();

    void removeAllEpics();

    Task findById(int id);

    void removeById(int id);

    public HashMap<Integer, Task> returnTaskList();

    public HashMap<Integer, Epic> returnEpicList();

    public HashMap<Integer, Subtask> returnSubList();

    public void createTask(Task task);

    public void createEpic(Epic epic);

    public void createSubtask(Subtask subtask);

    public HistoryManager getDefaultHistory();

}
