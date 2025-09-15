import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void equalsById() {
        Task task1 = new Task("name1", "dis1");
        Task task2 = new Task("name2", "dis2");
        task1.setId(1);
        task2.setId(1);

        Assertions.assertEquals(task1, task2);
    }

    @Test
    public void equalsEpicsById() {
        Epic epic1 = new Epic("name1", "dis1");
        Epic epic2 = new Epic("name2", "dis2");
        epic1.setId(2);
        epic2.setId(2);

        Assertions.assertEquals(epic1, epic2);
    }
}