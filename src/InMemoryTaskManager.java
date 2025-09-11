import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    HashMap<Integer, Task> taskList = new HashMap<>();
    HashMap<Integer, Epic> epicList = new HashMap<>();
    HashMap<Integer, Subtask> subtaskList = new HashMap<>();

    //private List<Task> historyList = new ArrayList<>();
    HistoryManager historyList = new InMemoryHistoryManager();

    public static int id = 0;
    //int historyActualListSize = 0;

    public HistoryManager getDefaultHistory(){
        return historyList;
    }

    public void createTask(Task task){
        id++;
        task.setId(id);
        taskList.put(id, task);
    }

    public void createEpic(Epic epic){
        id++;
        epic.setId(id);
        epicList.put(id, epic);
    }

    public void createSubtask(Subtask subtask){
        id++;
        subtask.setId(id);
        subtaskList.put(id, subtask);
        addToEpic(subtask);
    }

    public void addToEpic(Subtask subtask){
        for (Integer epicId: epicList.keySet()){
            if (epicId.equals(subtask.getEpicId())){
                epicList.get(epicId).addToList(subtask);
            }
        }
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

    @Override
    public void removeAllTasks(){
        taskList.clear();
    }

    @Override
    public void removeAllEpics(){

        epicList.clear();
        subtaskList.clear();
    }

    @Override
    public Task findById(int id){

        Task task = null;
        if (taskList.containsKey(id)){
            task = taskList.get(id);
        } else if (epicList.containsKey(id)){
            task = epicList.get(id);
        } else if (subtaskList.containsKey(id)){
            task = subtaskList.get(id);
        }

        historyList.add(task);

        return task;
    }

    @Override
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

    public void removeSubForEpic(Task epic){
        Epic findEpic = (Epic) epic;

        ArrayList<Integer> subId = new ArrayList<>();
        for (Subtask sub: findEpic.returnSubList()){
            if (subtaskList.containsKey(sub.getId())){
                subtaskList.remove(sub.getId());
            }
        }

        findEpic.subtasksForEpic.clear();
        findEpic.status = Statuses.NEW;
    }

    public void updateTask (Task task){
        if (taskList.containsKey(task.getId())){
            taskList.put(task.getId(), task);
        }
    }

    public void updateEpic(Epic epic){
        epic.setId(epic.id);
        if (epicList.containsKey(epic.getId())){
            epic.status = epicList.get(epic.getId()).status;
            epic.subtasksForEpic = epicList.get(epic.getId()).returnSubList();
            epicList.put(epic.getId(), epic);
        }
    }

    public void updateSubtask(Subtask subtask){
        if (subtaskList.containsKey(subtask.getId())){
            subtaskList.put(subtask.getId(), subtask);
            addToEpic(subtask);
            updateEpicStatus(subtask);
        }
    }

    public ArrayList<Subtask> returnEpicsSub(Epic epic){
        return epic.returnSubList();
    }

    private void updateEpicStatus(Subtask subtask){
        for (Epic epic: epicList.values()) {
            if (epic.getId() == subtask.getEpicId()) {
                HashSet<Statuses> uniqueStatuses = new HashSet<>();
                for (Subtask sub: epic.returnSubList()){
                    uniqueStatuses.add(sub.status);
                }
                if (uniqueStatuses.isEmpty()){
                    epic.status = Statuses.NEW;
                } else if (uniqueStatuses.contains(Statuses.NEW) && !uniqueStatuses.contains(Statuses.IN_PROGRESS) && !uniqueStatuses.contains(Statuses.DONE)){
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
