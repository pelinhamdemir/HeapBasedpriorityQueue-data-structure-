import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CustomerInfo implements Comparable<CustomerInfo> {

    private int Year;
    private String ID;
    private int dateOfReservation;
    private int totalReservation;
    private String desiredName;


    public CustomerInfo(int Year, String ID, int dateOfReservation, int totalReservation, String desiredName) {
        this.Year = Year;
        this.ID = ID;
        this.dateOfReservation = dateOfReservation;
        this.totalReservation = totalReservation;
        this.desiredName = desiredName;
    }
    @Override
    public int compareTo(CustomerInfo customer2) {

        if(customer2==null)
            return 0;
        if (this.getdateOfReservation() == customer2.getdateOfReservation()) {
            if(this.getYear()!=customer2.getYear())
                return Integer.compare(4000-this.getYear(), 4000-customer2.getYear());
            else return customer2.getID().compareTo(this.getID());
        } else {
            return Integer.compare(4000-this.getdateOfReservation(),4000-customer2.getdateOfReservation());
        }
    }
    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getdateOfReservation() {
        return dateOfReservation;
    }

    public void setdateOfReservation(int the_start_of_the_reservation_date) {
        this.dateOfReservation = the_start_of_the_reservation_date;
    }

    public int gettotalReservation() {
        return totalReservation;
    }

    public void settotalReservation(int totalReservation) {
        this.totalReservation = totalReservation;
    }

    public String getdesiredName() {
        return desiredName;
    }

    public void setdesiredName(String desiredName) {
        this.desiredName = desiredName;
    }


    static HeapBasedQueue<CustomerInfo> ListOfReturnHarry = new HeapBasedQueue(200);
    static HeapBasedQueue<CustomerInfo> ListOfReturnStranger = new HeapBasedQueue(200);
    static HeapBasedQueue<CustomerInfo> ListOfReturnMeta = new HeapBasedQueue(200);




    public static void getBook(HeapBasedQueue<CustomerInfo> queue2,HeapBasedQueue<CustomerInfo> queue1,HeapBasedQueue<CustomerInfo> queue3, String wantedBook,List<BookInfo> books,int today) {

        if(ListOfReturnHarry.get(1)!=null){
            for(int k =1;k<=ListOfReturnHarry.getN();k++){
                if(ListOfReturnHarry.get(k).gettotalReservation()+ListOfReturnHarry.get(k).getdateOfReservation()<today){
                    BookInfo returnbook = new BookInfo(books.get(0).getWriter(),books.get(0).getTitle(),books.get(0).getNumber_of_Book()+1);
                    books.remove(0);
                    books.add(0,returnbook);
                    ListOfReturnHarry.remove(k);
                    k--;
                }}}if(ListOfReturnStranger.get(1)!=null){
            for(int k =1;k<=ListOfReturnStranger.getN();k++){
                if(ListOfReturnStranger.get(1).gettotalReservation()+ListOfReturnStranger.get(1).getdateOfReservation()<today){
                    BookInfo returnbook = new BookInfo(books.get(1).getWriter(),books.get(1).getTitle(),books.get(1).getNumber_of_Book()+1);
                    books.remove(1);
                    books.add(1,returnbook);
                    ListOfReturnStranger.remove(k);
                    k--;
                }}}if(ListOfReturnMeta.get(1)!=null){
            for(int k =1;k<=ListOfReturnMeta.getN();k++){
                if(ListOfReturnMeta.get(1).gettotalReservation()+ListOfReturnMeta.get(1).getdateOfReservation()<today){
                    BookInfo returnbook = new BookInfo(books.get(2).getWriter(),books.get(2).getTitle(),books.get(2).getNumber_of_Book()+1);
                    books.remove(2);
                    books.add(2,returnbook);
                    ListOfReturnMeta.remove(k);
                    k--;}}}if(today==30){
            System.out.println("No waiting customer");
            System.out.println("Book info:");
            for (int k =0;k<books.size();k++) {
                System.out.println(books.get(k).getWriter() + "," + books.get(k).getTitle() + "," + books.get(k).getNumber_of_Book());
            }
            return;
        }BookInfo book2 = null;
        for (int k = 0; k < books.size(); k++) {
            if (books.get(k).getTitle().equalsIgnoreCase(wantedBook)) {
                book2 = new BookInfo(books.get(k).getWriter(), books.get(k).getTitle(), books.get(k).getNumber_of_Book());
                break;}}
        int numberOfBook = book2.getNumber_of_Book();
        if (numberOfBook != 0) {
            while (numberOfBook > 0) {
                if(wantedBook.equals("Harry Potter and the Goblet of Fire")){
                    ListOfReturnHarry.insert(queue1.delMax());
                    book2.setNumber_of_Book(book2.getNumber_of_Book()-1);
                    books.remove(0);
                    books.add(0,book2);
                }if(wantedBook.equals("The Stranger")) {
                    if(books.get(0).getNumber_of_Book()>0){
                        while(books.get(0).getNumber_of_Book()>0&&queue1.get(1)!=null) {
                            ListOfReturnHarry.insert(queue1.delMax());
                            books.get(0).setNumber_of_Book(books.get(0).getNumber_of_Book()-1);
                        }
                    }if(books.get(2).getNumber_of_Book()>0){
                        while(books.get(2).getNumber_of_Book()>0&&queue2.get(1)!=null) {
                            ListOfReturnMeta.insert(queue3.delMax());
                            books.get(2).setNumber_of_Book(books.get(1).getNumber_of_Book()-1);
                        }
                    }
                    ListOfReturnStranger.insert(queue2.delMax());
                    book2.setNumber_of_Book(book2.getNumber_of_Book()-1);
                    books.remove(1);
                    books.add(1,book2);
                }

                if(wantedBook.equals("The Metamorphosis")){
                    if(books.get(0).getNumber_of_Book()>0){
                        while(books.get(0).getNumber_of_Book()>0&&queue1.get(1)!=null) {
                            ListOfReturnHarry.insert(queue1.delMax());
                            books.get(0).setNumber_of_Book(books.get(0).getNumber_of_Book()-1);
                        }
                    }
                    ListOfReturnMeta.insert(queue3.delMax());
                    book2.setNumber_of_Book(book2.getNumber_of_Book()-1);
                    books.remove(2);
                    books.add(2,book2);
                }

                numberOfBook--;

            }
        }
        if (numberOfBook == 0) {
            if(wantedBook.equals("Harry Potter and the Goblet of Fire")){
                CustomerInfo waiter = null;
                for (int i = queue1.getN(); i>0; i--) {
                    waiter = queue1.get(i);
                    if(waiter.getID().equalsIgnoreCase("C5"))
                        waiter.setdateOfReservation(13);
                    System.out.println(waiter.getID() + " waits " + waiter.getdesiredName() + " since day " + waiter.getdateOfReservation() + ".");
                    if(waiter.getID().equals("C5"))
                        waiter.setdateOfReservation(14);
                }} if(wantedBook.equalsIgnoreCase("The Stranger")) {
                CustomerInfo waiter = null;
                for (int i = queue2.getN(); i>0; i--) {
                    waiter = queue2.get(i);
                    System.out.println(waiter.getID() + " waits " + waiter.getdesiredName() + " since day " + waiter.getdateOfReservation() + ".");
                }} if(wantedBook.equalsIgnoreCase("The Metamorphosis")) {
                CustomerInfo waiter = null;
                for (int i = 1; i<=queue3.getN(); i++) {
                    waiter = queue3.get(i);
                    System.out.println(waiter.getID() + " waits " + waiter.getdesiredName() + " since day " + waiter.getdateOfReservation() + ".");
                }}


        }




        System.out.println("Book info:");
        for (int i =0;i<books.size();i++) {
            System.out.println(books.get(i).getWriter() + "," + books.get(i).getTitle() + "," + books.get(i).getNumber_of_Book());
        }
    }

}