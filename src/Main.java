public class Main {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        System.out.println("Create new Task");
        Task task1 = new Task("Прочитать книгу", "книга - Война и мар");
        Task task2 = new Task("Покормить кота", "в 12:00");
        manager.createTask(task1);
        manager.createTask(task2);
        System.out.println("Выведем все таски");
        System.out.println(manager.returnTaskList());
        System.out.println("Выведем таску по id");
        System.out.println(manager.findById(2));
        System.out.println("Обновим таску");
        manager.updateTask(new Task("Покормить собаку","в 13:00", 2, Statuses.IN_PROGRESS));
        //manager.updateTask(new Task("Покормить собаку","в 13:00", 2, Statuses.DONE));
        System.out.println(manager.returnTaskList());
        System.out.println("----------------------------------------\n");

        System.out.println("Создадим два эпика");
        Epic epic1 = new Epic("Приготовить ужин", "Котлетки");
        Epic epic2 = new Epic("Ремонт", "на кухне");
        manager.createEpic(epic1);
        manager.createEpic(epic2);
        System.out.println("Выведем все эпики");
        System.out.println(manager.returnEpicList());
        System.out.println("Создадим три сабтаски");
        Subtask sub21 = new Subtask("Натянуть потолки", "белые",4);
        Subtask sub22 = new Subtask("Положить плитку", "белые",4);
        Subtask sub31 = new Subtask("Приготовить котлеты", "куриные",3);
        manager.createSubtask(sub21);
        manager.createSubtask(sub22);
        manager.createSubtask(sub31);
        System.out.println("Выведем все сабтаски");
        System.out.println(manager.returnSubList());
        System.out.println("Выведем все сабтаски эпика");
        System.out.println(manager.returnEpicsSub(epic2));
        System.out.println("Обновим эпик");
        manager.updateEpic(new Epic("Ремонт1", "на кухне1", 4));
        System.out.println(manager.returnEpicList());
        System.out.println("Обновим сабтаски");
        manager.updateSubtask(new Subtask("Натянуть потолки1", "черные", 5, 4, Statuses.DONE));
        //manager.updateSubtask(new Subtask("Натянуть потолки1", "черные1", 5, 4));
        manager.updateSubtask(new Subtask("Положить плитку1", "белые", 6, 4, Statuses.DONE));
        //manager.updateSubtask(new Subtask("Положить плитку1", "белые1", 6, 4));
        System.out.println("Все сабтаски эпика" + manager.returnEpicsSub(epic2));
        System.out.println("Просто все сабтаски" + manager.subtaskList);
        System.out.println("Проверим статус эпика");
        System.out.println(manager.findById(4));
        System.out.println("Выведем все эпики");
        System.out.println(manager.returnEpicList());
        System.out.println("Все сабтаски эпика после удаления");
        System.out.println("Айди эпика " + manager.findById(4));
        manager.removeSubForEpic(manager.findById(4));
        System.out.println("Все сабтаски " + manager.returnSubList());

        System.out.println("Все сабтаски эпика " + manager.returnEpicsSub(epic2));
        System.out.println("Статус эпика");
        System.out.println(manager.findById(4));



    }
}
