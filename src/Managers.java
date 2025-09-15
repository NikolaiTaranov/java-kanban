//Полагаю просто заготовка на будущее
public interface Managers {

    //InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
    //InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
    //T taskManager;
//    public Managers(T task){
//        taskManager = task;
//    }

    public static TaskManager getDefault(){
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory(){
        return new InMemoryHistoryManager();
    }
}
