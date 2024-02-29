import java.util.List;

public class BookInfo {
    private String Writer;
    private String Title;
    private int Number_of_Book;
    private int Return_Date;

    public BookInfo(String writer_of_Book, String Title, int number_of_Book) {
        this.Writer = writer_of_Book;
        this.Title = Title;
        this.Number_of_Book=number_of_Book;

    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String Writer) {
        Writer = Writer;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        Title = Title;
    }

    public int getNumber_of_Book() {
        return Number_of_Book;
    }

    public void setNumber_of_Book(int number_of_Book) {
        Number_of_Book = number_of_Book;
    }

    public int getReturn_Date() {
        return Return_Date;
    }

    public void increaseBookNumber() {
        Number_of_Book++;
    }


    }
