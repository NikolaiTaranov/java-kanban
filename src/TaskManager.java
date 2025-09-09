import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    void removeAllTasks();

    void removeAllEpics();

    Task findById(int id);

    void removeById(int id);

}
