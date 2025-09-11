import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {

//    @Test
//    public void checkManagersObject(){
//
//        InMemoryHistoryManager historyManager = new InMemoryHistoryManager();
//        //Managers<historyManager> taskManagerManager = new Managers<>();
//        Assertions.assertEquals(taskManager.getDefault(), historyManager);
//    }

    @Test
    public void epicLikeSubtask(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Epic epic1 = new Epic("Основная", "Таска");
        epic1.setId(1);
        manager.createEpic(epic1);
        //epic1.addToList(epic1);

    }

    @Test
    public void findDifferentObjectsInTaskManager(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task1 = new Task("Прочитать книгу", "книга - Война и мар");
        manager.createTask(task1);
        Epic epic1 = new Epic("Приготовить ужин", "Котлетки");
        manager.createEpic(epic1);
        Subtask sub1 = new Subtask("Натянуть потолки", "белые",2);
        manager.createSubtask(sub1);

        Assertions.assertEquals(task1, manager.findById(1));
        Assertions.assertEquals(epic1, manager.findById(2));
        Assertions.assertEquals(sub1, manager.findById(3));
    }

    @Test
    public void checkObjectsWithTheSameId(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task1 = new Task("Прочитать книгу", "книга - Война и мар");
        manager.createTask(task1);
        Task task2 = new Task("Прочитать книгу2", "книга - Война и мар2", 1, Statuses.IN_PROGRESS);
        manager.createTask(task2);

        Assertions.assertEquals(2, manager.findById(2).getId());
    }

    @Test
    public void checkTheFinalVersionOfTask(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task1 = new Task("Прочитать книгу", "книга - Война и мар");
        manager.createTask(task1);

        Task task2 = task1;
        manager.updateTask(task1);
        Assertions.assertEquals(task1, task2);
    }

}