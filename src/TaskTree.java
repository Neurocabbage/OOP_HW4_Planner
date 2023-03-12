import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class TaskTree  {
    /**
     * Для хранения и сортировки задач
     */
    private static TreeSet<Task> taskTree;

    static {
        /**
         * Сортировка по срочности
         */
        taskTree = new TreeSet<>(Comparator.comparing(Task::getDeadline));
    }

    public static TreeSet<Task> getTaskTree() {
        return taskTree;
    }

    public static void addTask(Task task) {
        taskTree.add(task);
    }
    public static void clearTaskTree(){
        taskTree.clear();
    }
    public static void removeTaskByID(String id){
        taskTree.removeIf(task -> task.getId().equals(id));
    }

    public static void printTask(){
        if (taskTree.size()>0) {
            for (Task task : taskTree) {
                System.out.println(task);
            }
        } else System.out.println("The task is not found");
    }
       public static Task searchById(String id){
        for (Task task:taskTree) {
            if (task.getId().equals(id)) return task;
        }
        return null;
    }

    public static void printTaskBeforeDate(LocalDate date){
        for (Task task : taskTree) {
            if (task.compareTo(date) <= 0)
                System.out.println(task);
        }

    }

}
