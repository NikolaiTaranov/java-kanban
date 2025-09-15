import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {

    @Test
    public void CreationTest(){
        TaskManager manager = new InMemoryTaskManager();
        Task task1 = new Task("name1", "dis1");
        Task task2 = new Task("name2", "dis2");
        task1.setId(1);
        task2.setId(2);
        manager.createTask(task1);
        manager.createTask(task2);

        Epic epic1 = new Epic("Приготовить ужин", "Котлетки");
        Epic epic2 = new Epic("Ремонт", "на кухне");
        epic1.setId(3);
        epic2.setId(4);
        manager.createEpic(epic1);
        manager.createEpic(epic2);

        Subtask sub21 = new Subtask("Натянуть потолки", "белые",3);
        Subtask sub22 = new Subtask("Положить плитку", "белые",3);
        sub21.setId(5);
        sub21.setId(6);
        manager.createSubtask(sub21);
        manager.createSubtask(sub22);

        manager.findById(1);
        manager.findById(2);
        manager.findById(3);

        printAllTasks(manager);
    }


    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.returnTaskList().values()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Task epic : manager.returnEpicList().values()) {
            System.out.println(epic);
            Epic epic1 = (Epic) epic;
            for (Task task : epic1.returnSubList()) {
                System.out.println("--> " + task);
            }
        }
        System.out.println("Подзадачи:");
        for (Task subtask : manager.returnSubList().values()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getDefaultHistory()) {
            System.out.println(task);
        }

    }

}