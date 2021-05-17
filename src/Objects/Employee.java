package Objects;

//class allows us to find and create employee accounts and retrieve their information

import LibraryFunctions.*;

public class Employee { //the different relations to an employee (Employee_ID makes it unique)

    private String Employee_Id;
    private String Employee_Fname;
    private String Employee_Lname;
    private String Employee_Password;
    private String Employee_Dept;
    private String Employee_Office;
    private String Employee_Phone;
    private double Employee_HourlyRate;

    public Employee(String Employee_Id, String Employee_Fname, String Employee_Lname, String Employee_Password, String Employee_Dept, String Employee_Office, String Employee_Phone, double Employee_HourlyRate) {
        this.Employee_Id = Employee_Id;
        this.Employee_Fname = Employee_Fname;
        this.Employee_Lname = Employee_Lname;
        this.Employee_Password = Employee_Password;
        this.Employee_Dept = Employee_Dept;
        this.Employee_Office = Employee_Office;
        this.Employee_Phone = Employee_Phone;
        this.Employee_HourlyRate = Employee_HourlyRate;
    }
    
    public String getString (){ //allows us to retrieve and display employee (non sensitive) information
        return "Employee Id: " + Employee_Id + ", First name: " + Employee_Fname + ", Surname: " + Employee_Lname + ", Department: " + Employee_Dept + ", Office: " + Employee_Office + ", Phone number: " + Employee_Phone;
    }

    public String getEmployee_Id() {
        return Employee_Id;
    }

    public void setEmployee_Id(String Employee_Id) {
        this.Employee_Id = Employee_Id;
    }

    public String getEmployee_Fname() {
        return Employee_Fname;
    }

    public void setEmployee_Fname(String Employee_Fname) {
        this.Employee_Fname = Employee_Fname;
    }

    public String getEmployee_Lname() {
        return Employee_Lname;
    }

    public void setEmployee_Lname(String Employee_Lname) {
        this.Employee_Lname = Employee_Lname;
    }

    public String getEmployee_Password() {
        return Employee_Password;
    }

    public void setEmployee_Password(String Employee_Password) {
        this.Employee_Password = Employee_Password;
    }

    public String getEmployee_Dept() {
        return Employee_Dept;
    }

    public void setEmployee_Dept(String Employee_Dept) {
        this.Employee_Dept = Employee_Dept;
    }

    public String getEmployee_Office() {
        return Employee_Office;
    }

    public void setEmployee_Office(String Employee_Office) {
        this.Employee_Office = Employee_Office;
    }

    public String getEmployee_Phone() {
        return Employee_Phone;
    }

    public void setEmployee_Phone(String Employee_Phone) {
        this.Employee_Phone = Employee_Phone;
    }

    public double getEmployee_HourlyRate() {
        return Employee_HourlyRate;
    }

    public void setEmployee_HourlyRate(double Employee_HourlyRate) {
        this.Employee_HourlyRate = Employee_HourlyRate;
    }
    
    

}
