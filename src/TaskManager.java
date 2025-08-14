import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TaskManager {
    HashMap<Integer, Task> taskList = new HashMap<>();
    HashMap<Integer, Epic> epicList = new HashMap<>();
    HashMap<Integer, Subtask> subtaskList = new HashMap<>();

    public static int id = 0;

    public void createTask(Task task){

        taskList.put(task.getId(), task);
    }

    public void createEpic(Epic epic){

        epicList.put(epic.getId(), epic);
    }

    public void createSubtask(Subtask subtask){
        subtaskList.put(subtask.getId(), subtask);
    }

    public HashMap<Integer, Task> returnTaskList(){
        return taskList;
    }

    public HashMap<Integer, Epic> returnEpicList(){
        return epicList;
    }

    public HashMap<Integer, Subtask> returnSubList(){
        return subtaskList;
    }

    public void removeAllTasks(){
        taskList.clear();
    }

    public void removeAllEpics(){

        epicList.clear();
        subtaskList.clear();
    }

    public Task findById(int id){
        Task task = null;
        if (taskList.containsKey(id)){
            task = taskList.get(id);
        } else if (epicList.containsKey(id)){
            task = epicList.get(id);
        } else if (subtaskList.containsKey(id)){
            task = subtaskList.get(id);
        }
        return task;
    }

    public void removeById(int id){
        if (taskList.containsKey(id)){
            taskList.remove(id);
        } else if (epicList.containsKey(id)){
            epicList.remove(id);
            for (Subtask sub: subtaskList.values()){
                if (sub.getEpicId() == id){
                    subtaskList.remove(sub.getId());
                }
            }
        } else if (subtaskList.containsKey(id)){
            subtaskList.remove(id);
        }
    }

    public void updateTask (Task task){
        if (taskList.containsKey(task.getId())){
            task.status = taskList.get(task.getId()).status;
            updateTaskStatus(task);
            taskList.put(task.getId(), task);
        }
    }

    public void updateEpic(Epic epic){
        if (epicList.containsKey(epic.getId())){
            epic.status = epicList.get(epic.getId()).status;
            epicList.put(epic.getId(), epic);
        }
    }

    public void updateSubtask(Subtask subtask){
        if (subtaskList.containsKey(subtask.getId())){
            subtask.status = subtaskList.get(subtask.getId()).status;
            updateSubtaskStatus(subtask);
            subtaskList.put(subtask.getId(), subtask);
            updateEpicStatus(subtask);
        }
    }

    public ArrayList<Subtask> returnEpicsSub(Epic epic){
        ArrayList<Subtask> subList = new ArrayList<>();
        for (Subtask sub: subtaskList.values()){
            if (epic.getId() == sub.getEpicId()){
                subList.add(sub);
            }
        }
        return subList;
    }

    private void updateTaskStatus(Task task){
        if (task.status.equals(Statuses.NEW)){
            task.status = Statuses.IN_PROGRESS;
        } else if (task.status.equals(Statuses.IN_PROGRESS)){
            task.status = Statuses.DONE;
        }
    }

    private void updateSubtaskStatus(Subtask subtask){
        if (subtask.status.equals(Statuses.NEW)){
            subtask.status = Statuses.IN_PROGRESS;
        } else if (subtask.status.equals(Statuses.IN_PROGRESS)){
            subtask.status = Statuses.DONE;
        }
    }

    private void updateEpicStatus(Subtask subtask){
        for (Epic epic: epicList.values()){
            if (epic.getId() == subtask.getEpicId()){
                HashSet<Statuses> uniqueStatuses = new HashSet<>();
                ArrayList<Subtask> subList = returnEpicsSub(epic);
                for (Subtask sub: subList){
                    uniqueStatuses.add(sub.status);
                }
                if (uniqueStatuses.contains(Statuses.NEW) && !uniqueStatuses.contains(Statuses.IN_PROGRESS) && !uniqueStatuses.contains(Statuses.DONE)){
                    epic.status = Statuses.NEW;
                } else if (!uniqueStatuses.contains(Statuses.NEW) && !uniqueStatuses.contains(Statuses.IN_PROGRESS) && uniqueStatuses.contains(Statuses.DONE)){
                    epic.status = Statuses.DONE;
                } else {
                    epic.status = Statuses.IN_PROGRESS;
                }
            }
        }
    }
}
