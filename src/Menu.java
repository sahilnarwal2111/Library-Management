import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Library Management: ");
        System.out.println("Press 1 if u are existing user");
        System.out.println("Press 2 if u are new user");
        System.out.println("Press 3 if u r admin");
        int first = sc.nextInt();
        int second;
        int third;
        while(true) {
            if (first == 1) {
                System.out.println("Press 1 for lending a book");
                System.out.println("Press 2 for Returning a book");
                second = sc.nextInt();
                if (second == 1) {
                    System.out.println("Enter your email");
                    String email = sc.next();
                    System.out.println("Enetr ur phone");
                    String phone = sc.next();
                    //verification of being registered
                    Student st1 = new Student(phone, email);
                    boolean verify = Queries.verifyBeforeLending(st1);
                    if(verify){
                        Queries.showAllBooks();
                        System.out.println("Select a book form above list");
                        String bookName = sc.next();
                        Student st = new Student(phone, email, bookName);
                        boolean answer = Queries.lendBook(st);


                        if (answer) {
                            System.out.println("Book loaned ...");
                        } else {
                            System.out.println("Some error ocurred");
                        }
                    }
                    else {
                        System.out.println("Please Register Yourself First!");
                        break;
                    }
                } else {
                    System.out.println("Enter your email");
                    String email = sc.next();
                    System.out.println("Enetr ur phone");
                    String phone = sc.next();
                    System.out.println("Enter book name for returning");
                    String bookName = sc.next();
                    Books b = new Books(bookName);
                    boolean answer = Queries.returnBook(b);
                    if (answer) {
                        System.out.println("Book returned ...");
                    } else {
                        System.out.println("Something error ");
                    }
                }

            } else if (first == 2) {
                System.out.println("Enter Your Phone Number");
                String phone = sc.next();
                System.out.println("Enter your email Id:");
                String email = sc.next();

                //Creating a object to store student
                Student st = new Student(phone, email);
                boolean answer = Queries.insertStudentToDB(st);
                System.out.println(st);
                if (answer) {
                    System.out.println("Student added succesfully...");
                    System.out.println("Please login for further actions...");
                    break;
                } else {
                    System.out.println("Something error ");
                }
            } else if(first == 3) {
                System.out.println("Press 1 if u want to add books");
                System.out.println("Press 2 if see all available books");
                System.out.println("Press 3 to go back");
                third = sc.nextInt();
                if (third == 1) {
                    System.out.println("Enter the book name");
                    String bookName = sc.next();
                    Books b = new Books(bookName, true);
                    boolean answer = Queries.insertBookToDB(b);
                    System.out.println(b);
                    if (answer) {
                        System.out.println("Book added successfulyy>>");
                    } else System.out.println("Not added error");

                } else if(third == 2){
                    Queries.showAllBooks();
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }
    }
}
