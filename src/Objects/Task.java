package Objects;

import java.time.LocalDate;

public class Task {

    private int Project_ProjectID;
    private String Project_Title;
    private LocalDate Project_StartDate;
    private LocalDate Project_EndDate;

    public Task(int Project_ProjectID, String Project_Title, LocalDate Project_StartDate, LocalDate Project_EndDate) {
        this.Project_ProjectID = Project_ProjectID;
        this.Project_Title = Project_Title;
        this.Project_StartDate = Project_StartDate;
        this.Project_EndDate = Project_EndDate;
    }

    public String getString() {
        return "Project Title: " + Project_Title + "Start Date: " + Project_StartDate + "End Date: " + Project_EndDate;
    }

    public int getProject_ProjectID() {
        return Project_ProjectID;
    }

    public void setProject_ProjectID(int Project_ProjectID) {
        this.Project_ProjectID = Project_ProjectID;
    }

    public String getProject_Title() {
        return Project_Title;
    }

    public void setProject_Title(String Project_Title) {
        this.Project_Title = Project_Title;
    }

    public LocalDate getProject_StartDate() {
        return Project_StartDate;
    }

    public void setProject_StartDate(LocalDate Project_StartDate) {
        this.Project_StartDate = Project_StartDate;
    }

    public LocalDate getProject_EndDate() {
        return Project_EndDate;
    }

    public void setProject_EndDate(LocalDate Project_EndDate) {
        this.Project_EndDate = Project_EndDate;
    }

}
