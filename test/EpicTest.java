import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    public void epicLikeSubtask(){
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Subtask subtask2 = new Subtask("name2", "dis2", 1);
        manager.updateSubtask(new Subtask("name2", "dis1", 1));
        System.out.println();


    }
}