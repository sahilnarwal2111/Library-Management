public class Student {
    private String phoneNo;
    private String email;
    public String bookName;

    public Student(String phoneNo , String email, String bookName){
        super();
        this.email = email;
        this.phoneNo = phoneNo;
        this.bookName = bookName;
    }
    public Student(String phoneNo , String email){
        super();

        this.phoneNo = phoneNo;
        this.email = email;
    }

//    public Student(String bookName , String email){
//        super();
//        this.bookName = bookName;
//        this.email = email;
//    }
    public Student(){
        super();
    }
    public Student(String email){
        super();
        this.email = email;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String toString(){
        return "Student phone number: " + phoneNo + " " + "Email Id: " + email;
    }

}
