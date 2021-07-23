package Objects;

import java.time.LocalDate;

public class Task {

    private int Task_TaskID;
    private String Task_Title;
    private LocalDate Task_StartDate;
    private LocalDate Task_EndDate;
    private String Task_Desc;

    public Task(int Task_TaskID, String Task_Title, LocalDate Task_StartDate, LocalDate Task_EndDate, String Task_Desc) {
        this.Task_TaskID = Task_TaskID;
        this.Task_Title = Task_Title;
        this.Task_StartDate = Task_StartDate;
        this.Task_EndDate = Task_EndDate;
        this.Task_Desc = Task_Desc;
    }

    public String getString() {
        return "Task Title: " + Task_Title + "Task Start: " + Task_StartDate + "Task End: " + Task_EndDate + "Task Desc: " + Task_Desc;

    }

    public int getTask_TaskID() {
        return Task_TaskID;
    }

    public void setTask_TaskID(int Task_TaskID) {
        this.Task_TaskID = Task_TaskID;
    }

    public String getTask_Title() {
        return Task_Title;
    }

    public void setTask_Title(String Task_Title) {
        this.Task_Title = Task_Title;
    }

    public LocalDate getTask_StartDate() {
        return Task_StartDate;
    }

    public void setTask_StartDate(LocalDate Task_StartDate) {
        this.Task_StartDate = Task_StartDate;
    }

    public LocalDate getTask_EndDate() {
        return Task_EndDate;
    }

    public void setTask_EndDate(LocalDate Task_EndDate) {
        this.Task_EndDate = Task_EndDate;
    }

    public String getTask_Desc() {
        return Task_Desc;
    }

    public void setTask_Desc(String Task_Desc) {
        this.Task_Desc = Task_Desc;
    }

}
