import java.awt.print.Book;

public class Books {
    private String bookName;
    private boolean Status;
    private String lender;

    public Books(String bookName, boolean Status, String lender){
        super();
        this.bookName = bookName;
        this.lender = lender;
        this.Status = Status;
    }

    public Books(String bookName, boolean Status){
        super();
        this.bookName = bookName;
        this.Status = Status;
    }

    public Books(String bookName){
        super();
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    public Books(){
        super();

    }




}
