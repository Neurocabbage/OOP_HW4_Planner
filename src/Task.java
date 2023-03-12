import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Task implements Comparable<LocalDate>{
    private String id;
    private LocalDate dateAdding;
    private LocalTime timeAdding;
    private LocalDateTime deadline;
    private String taskTheme;
    private static Integer countId;

    static {
        countId = TaskTree.getTaskTree().size();
    }

    public Task(LocalDate dateAdding, LocalTime timeAdding, LocalDateTime deadline, String taskTheme) {
        this.id = String.format("T#%d", ++countId);
        this.dateAdding = dateAdding;
        this.timeAdding = timeAdding;
        this.deadline = deadline;
        this.taskTheme = taskTheme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDateAdding() {
        return dateAdding;
    }

    public void setDateAdding(LocalDate dateAdding) {
        this.dateAdding = dateAdding;
    }

    public LocalTime getTimeAdding() {
        return timeAdding;
    }

    public void setTimeAdding(LocalTime timeAdding) {
        this.timeAdding = timeAdding;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public String getTaskTheme() {
        return taskTheme;
    }

    public void setTaskTheme(String taskTheme) {
        this.taskTheme = taskTheme;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(dateAdding, task.dateAdding) &&
                Objects.equals(timeAdding, task.timeAdding) && Objects.equals(deadline, task.deadline) &&
                Objects.equals(taskTheme, task.taskTheme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateAdding, timeAdding, deadline, taskTheme);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", dateAdding=" + dateAdding +
                ", timeAdding=" + timeAdding +
                ", deadline=" + deadline +
                ", taskTheme='" + taskTheme + '\'' +
                '}';
    }

//    public String taskInCsv(){
//        StringBuilder sb = new StringBuilder();
//        sb.append(id).append(',').append(dateAdding).append(',').append(timeAdding).append(',').append(deadline)
//                .append(',').append(taskTheme);
//        return sb.toString();
//    }

    @Override
    public int compareTo(LocalDate date) {
        LocalDate dateThis = LocalDate.from(this.deadline);
        if (dateThis.isAfter(date)) {
            return 1;
        } else if (dateThis.isBefore(date))
            return -1;
        else
            return 0;
    }

}
