import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void addNewTask() {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task = new Task("Test addNewTask", "Test addNewTask description");
        final int taskId = manager.createTask(task);

        final Task savedTask = taskManager.getTask(taskId);

        assertNotNull(savedTask, "Задача не найдена.");
        assertEquals(task, savedTask, "Задачи не совпадают.");

        final List<Task> tasks = taskManager.getTasks();

        assertNotNull(tasks, "Задачи не возвращаются.");
        assertEquals(1, tasks.size(), "Неверное количество задач.");
        assertEquals(task, tasks.get(0), "Задачи не совпадают.");
    }

    @Test
    public void equalsById(){
        Task task1 = new Task("name1", "dis1");
        Task task2 = new Task("name2", "dis2");
        task1.setId(1);
        task2.setId(1);

        Assertions.assertEquals(task1, task2);
    }

    @Test
    public void equalsEpicsById(){
        Epic epic1 = new Epic("name1", "dis1");
        Epic epic2 = new Epic("name2", "dis2");
        epic1.setId(2);
        epic2.setId(2);

        Assertions.assertEquals(epic1, epic2);
    }
}