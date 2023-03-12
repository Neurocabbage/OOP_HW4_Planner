import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Planner {
    /**
     * Добавление, изменение и удаление задач.
     */
    static Scanner sc = new Scanner(System.in);

    private LocalDateTime InputDeadlineDate(){
        boolean checkInput = false;
        LocalDateTime deadline = null;
        while (!checkInput) {
            System.out.println("Enter a deadline date:\nYYYY-MM-DD" +
                    "\nfor example, 2023-04-12");
            LocalDate deadlineDate = null;
            if (sc.hasNextLine()) {
                deadlineDate = LocalDate.parse(sc.nextLine());
                System.out.println(deadlineDate);
            }
            System.out.println("Enter a deadline time hh:mm");
            LocalTime deadlineTime = null;
            if (sc.hasNextLine()) {
                deadlineTime = LocalTime.parse(sc.nextLine());
                System.out.println(deadlineTime);
            }
            assert deadlineDate != null;
            assert deadlineTime != null;
            deadline = LocalDateTime.of(deadlineDate, deadlineTime);
            System.out.println(deadline);
            checkInput = true;
        }
        return deadline;
    }
    public void inputTask() {
        LocalDateTime deadline = this.InputDeadlineDate();
        System.out.println("Enter what to do:");
        String themeOfTask = null;
        if (sc.hasNextLine()) {
            themeOfTask = sc.nextLine();
        }
        TaskTree.addTask(new Task(LocalDate.now(), LocalDateTime.now().toLocalTime(), deadline, themeOfTask));
    }

    public void chosenDateDeadline(){
        System.out.println("Enter a deadline date to show the task. ");
        System.out.println("In the form YYYY-MM-dd, например, 2023-11-11");
        if (sc.hasNextLine()) {
            LocalDate deadlineDate = LocalDate.parse(sc.nextLine());
            System.out.println(deadlineDate);
            TaskTree.printTaskBeforeDate(deadlineDate);
        }

    }
    public void changeTask(){
        System.out.println("Enter an id of the task to change it:");
        String searchId = sc.nextLine();
        Task searchTask = TaskTree.searchById(searchId);
        if (searchTask!=null){
            try {
                boolean checkInput = false;
                while (!checkInput){
                    System.out.println("What do you want to change?\n1 - dealine date/time \n2 - Theme of the task");
                    if (sc.hasNextLine()){//hasNextInt
                        String choice = sc.nextLine();//?nextInt
                        switch (choice) {
                            case "1" -> {
                                checkInput = true;
                                System.out.println("Current date/time: " + searchTask.getDeadline());
                                LocalDateTime deadline = this.InputDeadlineDate();
                                searchTask.setDeadline(deadline);//LocalDateTime.of(deadlineDate, deadlineTime)
                            }
                            case "2" -> {
                                checkInput = true;
                                System.out.println("Current theme: " + searchTask.getTaskTheme());
                                System.out.println("New theme:");
                                if (sc.hasNextLine()) {
                                    String description = sc.nextLine();
                                    searchTask.setTaskTheme(description);
                                }
                            }
                            default -> System.out.println("Incorrect input. Try again.");
                        }
                    }
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } else System.out.println("The task is not found");
    }
    public void deleteTask(){
        System.out.println("Enter an id of the task to delete it:");
        String searchId = sc.nextLine();
        Task searchTask = TaskTree.searchById(searchId);
        if (searchTask!=null){
            TaskTree.removeTaskByID(searchId);
            System.out.println("The task is deleted successfully");
        }
    }
}