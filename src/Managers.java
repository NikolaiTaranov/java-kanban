//Полагаю просто заготовка на будущее
public class Managers <T extends HistoryManager> {

    InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
    InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
    T taskManager;
    public Managers(T task){
        taskManager = task;
    }

    public HistoryManager getDefault(){
        return taskManager;
    }

    HistoryManager getDefaultHistory(){
        return inMemoryHistoryManager;
    }
}
