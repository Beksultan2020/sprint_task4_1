package Java_EE.Spring_Task1;

import java.util.ArrayList;

public class DBManager_Tasks {
    private static ArrayList<Tasks> tasks = new ArrayList<>();
    private static long id = 6l;

    static {
        tasks.add(new Tasks(1L, "Примета джуна #1 \"С шашкой наголо\"", "Спустя 1,5 года работы решил поделиться своей историей, поскольку сам пользовался и вдохновлялся такими статьями в начале своего пути Java-разработчика.", "2023-12-10", "Да"));
        tasks.add(new Tasks(2L, "Покрытие тестами и/или Как добавить JaCoCo в проект Gradle", "Чтобы спокойно спать по ночам разработчикам нужно писать тесты. Много тестов. И один из способов проверять себя - это следить за процентным покрытием тестами кода. ", "2022-9-21", "нет"));
        tasks.add(new Tasks(3L, "Java Ok - мой долгий путь в джаву", "Истогрия моей любви к джаве и сайту Джавараш", "2020-03-03", "Да"));
        tasks.add(new Tasks(5L, "Изучаем синхронизированные коллекции, учимся работать с базами данных на Java", "Свежее видео, подготовленное LazyCoder, посвящено коллекциям для работы", "2023-12-15","Да"));
    }

    public static ArrayList<Tasks> getAllTasks() {
        return tasks;
    }

    public static Tasks getTask(Long id) {
        for (Tasks task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }


    public static void addTask(Tasks task) {
        task.setId(id);
        tasks.add(task);
        id++;
    }

    public static void deleteTask(Long id) {
        for (Tasks task : tasks) {
            if (task.getId().equals(id)) {
                tasks.remove(task);
                break;
            }
        }
    }


}
