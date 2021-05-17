package Objects;

public class User {

    private String User_Id;
    private String User_Fname;
    private String User_Lname;
    private String User_Password;
    private String User_Phone;
    private String User_Address;

    public User(String User_Id, String User_Fname, String User_Lname, String User_Password, String User_Phone, String User_Address) {
        this.User_Id = User_Id;
        this.User_Fname = User_Fname;
        this.User_Lname = User_Lname;
        this.User_Password = User_Password;
        this.User_Phone = User_Phone;
        this.User_Address = User_Address;
    }
    
    public String getString(){
        return "User Id: " + User_Id + ", First name: " + User_Fname + ", Surname: " + User_Lname + ", Phone number: " + User_Phone;
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String User_Id) {
        this.User_Id = User_Id;
    }

    public String getUser_Fname() {
        return User_Fname;
    }

    public void setUser_Fname(String User_Fname) {
        this.User_Fname = User_Fname;
    }

    public String getUser_Lname() {
        return User_Lname;
    }

    public void setUser_Lname(String User_Lname) {
        this.User_Lname = User_Lname;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String User_Password) {
        this.User_Password = User_Password;
    }

    public String getUser_Phone() {
        return User_Phone;
    }

    public void setUser_Phone(String User_Phone) {
        this.User_Phone = User_Phone;
    }

    public String getUser_Address() {
        return User_Address;
    }

    public void setUser_Address(String User_Address) {
        this.User_Address = User_Address;
    }
    
    


}
