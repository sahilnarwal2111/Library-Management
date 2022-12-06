import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class Queries {
    public static boolean insertStudentToDB(Student st){

        boolean f = false;
        try {
            Connection con = Main.getConnection();

            String q = "insert into student_name(phone,name) values(?,?)";
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1,st.getPhoneNo());
            pstmt.setString(2,st.getEmail());

            pstmt.executeUpdate();
            f = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return f;

    }
    public static boolean insertBookToDB(Books b){

        boolean f = false;
        try {
            Connection con = Main.getConnection();

            String q = "insert into book(name, status, lender) values(?,true,null)";
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1,b.getBookName());

            pstmt.executeUpdate();
            f = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return f;

    }
    public static void showAllBooks(){
        try{
            Connection con = Main.getConnection();

            String q = "select * from book;";

            assert con != null;
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            while (set.next()){
                String name = set.getString(1);
                String status = set.getString(2);
                String lender = set.getString(3);
                System.out.println("Book Name = " + name);
                System.out.println("Status = " + status);
                System.out.println("Lender' Name = " + lender);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean lendBook(Student st){

        boolean f = false;
        try {
            Connection con = Main.getConnection();
            String b = st.bookName;
            System.out.println(b);
            String q = "update book set status = "+0+" , lender = (?) where name = (?)  ;";

            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(q);

//            pstmt.setString(1,st.getPhoneNo());
            pstmt.setString(1,st.getEmail());
            pstmt.setString(2,b);

            pstmt.executeUpdate();
            f = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return f;

    }

    public static boolean returnBook(Books b){

        boolean f = false;
        try {
            Connection con = Main.getConnection();


            String q = "update book set status = "+1+" , lender = (?) where name = (?)  ;";

//            String q = "insert into student_name(phone,name) values(?,?)";
            assert con != null;
            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1,null);
            pstmt.setString(2,b.getBookName());

            pstmt.executeUpdate();
            f = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return f;

    }

    public static boolean verifyBeforeLending(Student st1){
        boolean verify = false;
        try{
            Connection con = Main.getConnection();

            String q = "select * from student_name;";

            assert con != null;
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(q);
            String phoneOfEntered = st1.getPhoneNo();
            String emailOfEntered = st1.getEmail();
            while (set.next()){
                String phone = set.getString(1);
                String email = set.getString(2);
                if(Objects.equals(phone, phoneOfEntered) && Objects.equals(email, emailOfEntered)){
                    verify = true;
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return verify;
    }
}
