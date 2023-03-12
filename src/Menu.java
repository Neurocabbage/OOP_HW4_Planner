import java.util.Scanner;

public class Menu {
    static public void startApplication() {
        Scanner scanner = new Scanner(System.in);
        Planner planner = new Planner();
        try {
            while (true) {
                System.out.println("""
                        Choose options:
                        1 - Add new task
                        2 - Change task
                        3 - Cancel task
                        4 - View all tasks
                        5 - Clean planner
                        6 - Sort tasks by deadline
                        7 - Exit""");
                switch (scanner.nextInt()) {
                    case 1 -> planner.inputTask();
                    case 2 -> planner.changeTask();
                    case 3 -> planner.deleteTask();
                    case 4 -> TaskTree.printTask();
                    case 5 -> TaskTree.clearTaskTree();
                    case 6 -> planner.chosenDateDeadline();//compareTo сравнивает даты
                    case 7 -> {
                        System.out.println("Complete");
                        scanner.close();
                        System.exit(0);
                    }
                    default -> System.out.println("incorrect input");
                }
            }
        }
        catch(Exception ex){
            System.out.println("Please enter number of option");
        }
    }
}
