package Objects;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class TaskTimeLog {

    private int TaskTimeLog_Id;
    private Date TaskTimeLog_DateLogged;
    private String TaskTimeLog_DescriptionOfWork;
    private int TaskTimeLog_HoursLogged;
    private int TaskTimeLog_TaskAssignmentId;

    public TaskTimeLog(int TaskTimeLog_Id, Date TaskTimeLog_DateLogged, String TaskTimeLog_DescriptionOfWork, int TaskTimeLog_HoursLogged, int TaskTimeLog_TaskAssignmentId) {
        this.TaskTimeLog_Id = TaskTimeLog_Id;
        this.TaskTimeLog_DateLogged = TaskTimeLog_DateLogged;
        this.TaskTimeLog_DescriptionOfWork = TaskTimeLog_DescriptionOfWork;
        this.TaskTimeLog_HoursLogged = TaskTimeLog_HoursLogged;
        this.TaskTimeLog_TaskAssignmentId = TaskTimeLog_TaskAssignmentId;
    }

    public String getString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Date Logged: " + dateFormat.format(TaskTimeLog_DateLogged) + ", Description of work: " + TaskTimeLog_DescriptionOfWork + ", Hours logged: " + TaskTimeLog_HoursLogged;
    }

    public int getTaskTimeLog_Id() {
        return TaskTimeLog_Id;
    }

    public void setTaskTimeLog_Id(int TaskTimeLog_Id) {
        this.TaskTimeLog_Id = TaskTimeLog_Id;
    }

    public Date getTaskTimeLog_DateLogged() {
        return TaskTimeLog_DateLogged;
    }

    public void setTaskTimeLog_DateLogged(Date TaskTimeLog_DateLogged) {
        this.TaskTimeLog_DateLogged = TaskTimeLog_DateLogged;
    }

    public String getTaskTimeLog_DescriptionOfWork() {
        return TaskTimeLog_DescriptionOfWork;
    }

    public void setTaskTimeLog_DescriptionOfWork(String TaskTimeLog_DescriptionOfWork) {
        this.TaskTimeLog_DescriptionOfWork = TaskTimeLog_DescriptionOfWork;
    }

    public int getTaskTimeLog_HoursLogged() {
        return TaskTimeLog_HoursLogged;
    }

    public void setTaskTimeLog_HoursLogged(int TaskTimeLog_HoursLogged) {
        this.TaskTimeLog_HoursLogged = TaskTimeLog_HoursLogged;
    }

    public int getTaskTimeLog_TaskAssignmentId() {
        return TaskTimeLog_TaskAssignmentId;
    }

    public void setTaskTimeLog_TaskAssignmentId(int TaskTimeLog_TaskAssignmentId) {
        this.TaskTimeLog_TaskAssignmentId = TaskTimeLog_TaskAssignmentId;
    }

}
