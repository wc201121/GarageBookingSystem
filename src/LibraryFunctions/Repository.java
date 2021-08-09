package LibraryFunctions;

import Objects.*;
import java.sql.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Repository {

    private static final String DatabaseLocation = System.getProperty("user.dir") + "\\TaskManagment.accdb";
    private static Connection con;
    private static Employee currentEmployee;
    private static User currentUser;

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://" + DatabaseLocation, "", "");
            return con;
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return null;

    }

// <editor-fold defaultstate="collapsed" desc="Employee operations">
    public static Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public static boolean EmployeeLogIn(String userID, String password) {
        try {
            String sql = "SELECT * FROM Employee where Employee_ID = '" + userID + "'";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);

            if (rs.next()) {
                currentEmployee = new Employee(rs.getString("Employee_Id"), rs.getString("Employee_Fname"), rs.getString("Employee_Lname"), rs.getString("Employee_Password"), rs.getString("Employee_Dept"), rs.getString("Employee_Phone"), rs.getDouble("Employee_HourlyRate"));
                if (!Hasher.CompareHashed(currentEmployee.getEmployee_Password(), password)) {
                    return false;
                }
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return currentEmployee != null;
    }

    public static ArrayList<Task> getEmployeesTasks(String UserID) {
        ArrayList<Task> TaskList = new ArrayList<>();
        try {

            String sql = "SELECT Task.Task_TaskID, Task.Task_Title, Task.Task_StartDate, Task.Task_EndDate"
                    + "FROM Task INNER JOIN TaskAssignment ON Task.Task_TaskID = TaskAssignment.TaskAssignment_TaskID\n"
                    + "WHERE (((TaskAssignment.TaskAssignment_EmployeeID)='" + UserID + "'))";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            while (rs.next()) {
                Task nextTask = new Task(rs.getInt("Task_TaskID"), rs.getString("Task_Title"), rs.getDate("Task_StartDate").toLocalDate(), rs.getDate("Task_EndDate").toLocalDate(), rs.getString("Task_Desc"));
                TaskList.add(nextTask);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return TaskList;
    }

    public static ArrayList<TaskTimeLog> getAllUsersTimeLogs(String userID) {
        ArrayList<TaskTimeLog> timeLogs = new ArrayList<>();
        try {

            String sql = "SELECT TaskTimeLog.*\n"
                    + "FROM TaskAssignment INNER JOIN TaskTimeLog ON TaskAssignment.TaskAssignment_Id = TaskTimeLog.TaskTimeLog_TaskAssignmentId\n"
                    + "WHERE (((TaskAssignment.TaskAssignment_EmployeeID)='" + userID + "'));";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            while (rs.next()) {
                TaskTimeLog ptl = new TaskTimeLog(rs.getInt("TaskTimeLog_Id"), rs.getDate("TaskTimeLog_DateLogged"), rs.getString("TaskTimeLog_DescriptionOfWork"), rs.getInt("TaskTimeLog_HoursLogged"), rs.getInt("TaskTimeLog_TaskAssignmentId"));
                timeLogs.add(ptl);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return timeLogs;
    }

    public static ArrayList<TaskTimeLog> getUsersTimeLogsInDateRange(String userID, String fromDate, String toDate) {

        ArrayList<TaskTimeLog> timeLogs = new ArrayList<>();
        try {
            String sql = "SELECT TaskTimeLog.TaskTimeLog_Id, TaskTimeLog.TaskTimeLog_DateLogged, TaskTimeLog.TaskTimeLog_DescriptionOfWork, TaskTimeLog.TaskTimeLog_HoursLogged, TaskTimeLog.TaskTimeLog_TaskAssignmentId\n"
                    + "FROM TaskAssignment INNER JOIN TaskTimeLog ON TaskAssignment.TaskAssignment_Id = TaskTimeLog.TaskTimeLog_TaskAssignmentId\n"
                    + "WHERE (((TaskAssignment.TaskAssignment_EmployeeID)='" + userID + "') AND ((TaskTimeLog.TaskTimeLog_DateLogged)>=" + getSQLDateString(fromDate) + " And (TaskTimeLog.TaskTimeLog_DateLogged)<=" + getSQLDateString(toDate) + "));";

            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);

            while (rs.next()) {
                TaskTimeLog ptl = new TaskTimeLog(rs.getInt("TaskTimeLog_Id"), rs.getDate("TaskTimeLog_DateLogged"), rs.getString("TaskTimeLog_DescriptionOfWork"), rs.getInt("TaskTimeLog_HoursLogged"), rs.getInt("TaskTimeLog_TaskAssignmentId"));
                timeLogs.add(ptl);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return timeLogs;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="User operations">
    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean UserLogIn(String userID, String password) {
        try {
            String sql = "SELECT * FROM Employee where User_ID = '" + userID + "'";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);

            if (rs.next()) {
                currentUser = new User(rs.getString("User_Id"), rs.getString("User_Fname"), rs.getString("User_Lname"), rs.getString("User_Password"), rs.getString("User_Phone"), rs.getString("User_Address"));
                if (!Hasher.CompareHashed(currentUser.getUser_Password(), password)) {
                    return false;
                }
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return currentUser != null;
    }

// </editor-fold>    
// <editor-fold defaultstate="collapsed" desc="Return ArrayList of all Objects">
    public static ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Employee";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            while (rs.next()) {
                Employee nextEmployee = new Employee(rs.getString("Employee_Id"), rs.getString("Employee_Fname"), rs.getString("Employee_Lname"), rs.getString("Employee_Password"), rs.getString("Employee_Dept"), rs.getString("Employee_Phone"), rs.getDouble("Employee_HourlyRate"));
                EmployeeList.add(nextEmployee);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return EmployeeList;
    }

    public static ArrayList<Task> getAllTasks() {
        ArrayList<Task> TaskList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Task";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            while (rs.next()) {
                Task nextTask = new Task(rs.getInt("Task_TaskID"), rs.getString("Task_Title"), rs.getDate("Task_StartDate").toLocalDate(), rs.getDate("Task_EndDate").toLocalDate(), rs.getString("Task_Desc"));
                TaskList.add(nextTask);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return TaskList;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Returns 1 field"> 
    public static String getTaskNameFromTaskID(int TaskID) {
        String TaskName = null;
        try {

            String sql = "SELECT Task_Title FROM Task where TaskID = " + TaskID;
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);

            if (rs.next()) {
                TaskName = rs.getString("Task_Title");
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return TaskName;
    }

    public static String getTaskNameFromTimeLogID(int TimeLogID) {
        String TaskName = null;
        try {

            String sql = "SELECT Task.Task_Title\n"
                    + "FROM (Task INNER JOIN TaskAssignment ON Task.Task_TaskID = TaskAssignment.TaskAssignment_TaskID) INNER JOIN TaskTimeLog ON TaskAssignment.TaskAssignment_Id = TaskTimeLog.TaskTimeLog_TaskAssignmentId\n"
                    + "WHERE (((TaskTimeLog.TaskTimeLog_Id)=" + TimeLogID + "))";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);

            if (rs.next()) {
                TaskName = rs.getString("Task_Title");
            }

            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return TaskName;
    }

    public static double getEmployeePay(String employeeID) {
        double hourlyPay = 0.0;
        try {
            String sql = "SELECT Employee.Employee_HourlyRate\n"
                    + "FROM Employee\n"
                    + "WHERE Employee.Employee_Id= '" + employeeID + "';";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);

            if (rs.next()) {
                hourlyPay = rs.getInt("Employee_HourlyRate");
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return hourlyPay;
    }

    public static String getEmployeeName(int employeeID) {
        String employeeName = null;
        try {

            String sql = "SELECT Employee.Employee_Lname, Employee.Employee_Fname\n"
                    + "FROM Employee\n"
                    + "WHERE (((Employee.Employee_Id)='" + employeeID + "'));";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);

            if (rs.next()) {
                employeeName = rs.getString("Employee_Fname") + rs.getString("Employee_Lname");
            }

            rs.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);

        }
        return employeeName;
    }

    public static HashMap<String, Integer> getAllEmployeeHoursInDateRange(String fromDate, String toDate) {
        HashMap<String, Integer> EmployeeHours = new HashMap<String, Integer>();
        try {
            String sql = "SELECT DISTINCT TaskAssignment.TaskAssignment_EmployeeID\n"
                    + "FROM TaskAssignment INNER JOIN TaskTimeLog ON TaskAssignment.TaskAssignment_Id = TaskTimeLog.TaskTimeLog_TaskAssignmentId\n"
                    + "GROUP BY TaskTimeLog.TaskTimeLog_DateLogged, TaskAssignment.TaskAssignment_EmployeeID\n"
                    + "HAVING (((TaskTimeLog.TaskTimeLog_DateLogged)>=" + getSQLDateString(fromDate) + "  And (TaskTimeLog.TaskTimeLog_DateLogged)<=" + getSQLDateString(toDate) + "));";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);

            //loop through the users arraylist and add up the time, add user Id and total to employee hours hashmap
            while (rs.next()) {
                ArrayList<TaskTimeLog> IndividualTimeLog = getUsersTimeLogsInDateRange(rs.getString("TaskAssignment_EmployeeID"), fromDate, toDate);
                int totalHours = 0;
                for (int i = 0; i < IndividualTimeLog.size(); i++) {
                    totalHours = totalHours + IndividualTimeLog.get(i).getTaskTimeLog_HoursLogged();
                }

                EmployeeHours.put(rs.getString("TaskAssignment_EmployeeID"), totalHours);
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return EmployeeHours;
    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="SQL date conversion functions">
    private static String getSQLDateString(Date date) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        return "'" + DATE_FORMAT.format(date) + "'";
    }

    private static String getSQLDateString(String date) {
        try {
            SimpleDateFormat UK_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
            return "'" + DATE_FORMAT.format(UK_DATE_FORMAT.parse(date)) + "'";
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
        return "";
    }
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Insert/Update functions">   
    public static void insertNewTask(Task task) {

        try {
            String sql = "SELECT Task.* FROM Task";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            if (rs.next()) {
                rs.moveToInsertRow();
                rs.updateString("Task_Title", task.getTask_Title());
                rs.updateDate("Task_StartDate", Date.valueOf(task.getTask_StartDate()));
                rs.updateDate("Task_EndDate", Date.valueOf(task.getTask_EndDate()));
                rs.insertRow();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
    }

    public static void insertNewEmployee(Employee employee) {

        try {
            String sql = "SELECT Employee.* FROM Employee";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            if (rs.next()) {
                rs.moveToInsertRow();
                rs.updateString("Employee_ID", employee.getEmployee_Id());
                rs.updateString("Employee_Lname", employee.getEmployee_Lname());
                rs.updateString("Employee_Fname", employee.getEmployee_Fname());
                rs.updateString("Employee_Password", employee.getEmployee_Password());
                rs.updateString("Employee_Dept", employee.getEmployee_Dept());
                rs.updateString("Employee_Phone", employee.getEmployee_Phone());;
                rs.updateDouble("Employee_HourlyRate", employee.getEmployee_HourlyRate());
                rs.insertRow();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
    }

    public static void updateEmployee(Employee employee) {
        try {
            String sql = "SELECT Employee.* FROM Employee where Employee_Id = '" + employee.getEmployee_Id() + "'";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            if (rs.next()) {
                rs.updateString("Employee_Fname", employee.getEmployee_Fname());
                rs.updateString("Employee_Lname", employee.getEmployee_Lname());
                rs.updateString("Employee_Dept", employee.getEmployee_Dept());
                rs.updateDouble("Employee_HourlyRate", employee.getEmployee_HourlyRate());
                rs.updateRow();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
    }

    public static void insertNewUser(User user) {

        try {
            String sql = "SELECT Employee.* FROM Employee";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            if (rs.next()) {
                rs.moveToInsertRow();
                rs.updateString("User_ID", user.getUser_Id());
                rs.updateString("User_Lname", user.getUser_Lname());
                rs.updateString("User_Fname", user.getUser_Fname());
                rs.updateString("User_Password", user.getUser_Password());
                rs.updateString("User_Phone", user.getUser_Phone());
                rs.updateString("User_Address", user.getUser_Address());
                rs.insertRow();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
    }
    
        public static void updateUser(User user) {
        try {
            String sql = "SELECT User.* FROM User where User_Id = '"  + user.getUser_Id() + "'";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            if (rs.next()) {
                rs.updateString("User_Fname", user.getUser_Fname());
                rs.updateString("User_Lname", user.getUser_Lname());
                rs.updateString("User_Password", user.getUser_Password());
                rs.updateString("User_Phone", user.getUser_Phone());
                rs.updateString("User_Address", user.getUser_Address());
                rs.updateRow();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error in the repository class: " + e);
        }
    }

    public static void removeUser(User user) {

        try {
            String sql = "DELETE Employee.* FROM Employee";
            ResultSet rs = ExecuteSQL.executeQuery(getConnection(), sql);
            

        } catch (Exception e) {
            System.out.println("Error in the respository calss: " + e);

        }

    }

// </editor-fold>
}
