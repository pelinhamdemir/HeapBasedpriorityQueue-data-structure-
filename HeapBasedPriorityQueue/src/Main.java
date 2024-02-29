import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HeapBasedQueue<CustomerInfo> pqueueForHarry= new HeapBasedQueue<>(200);
        HeapBasedQueue<CustomerInfo> pqueueForMeta= new HeapBasedQueue<>(200);
        HeapBasedQueue<CustomerInfo> pqueueForStranger= new HeapBasedQueue<>(200);
        System.out.println("Enter log file name:");
        String filename;
        Scanner keyboard = new Scanner(System.in);
        filename=keyboard.nextLine();
        String filePath = ("C:\\Users\\efe_2\\IdeaProjects\\Assignment4\\src\\"+filename);
        File file=new File(filePath);
        List<BookInfo> bookList = new ArrayList<>();
        List<DayInfo> dayList = new ArrayList<>();
        List<CustomerInfo> customerList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int section = 0; // 0 - Book Info, 1 - Day Info, 2 - Customer Info

            while ((line = br.readLine()) != null) {
                if (line.startsWith("***BOOK INFO**")) {
                    section = 0;
                    continue;
                } else if (line.startsWith("**DAY INFO**")) {
                    section = 1;
                    continue;
                } else if (line.startsWith("***CUSTOMER INFO***")) {
                    section = 2;
                    continue;
                }



                switch (section) {
                    case 0: // Book Info
                        String[] bookInfo = line.split(",");
                        String writer = bookInfo[0].trim();
                        String title = bookInfo[1].trim();
                        int quantity = Integer.valueOf(bookInfo[2].trim());
                        BookInfo book = new BookInfo(writer, title, quantity);
                        bookList.add(book);
                        break;
                    case 1: // Day Info
                        int dayNumber = Integer.parseInt(line.trim());
                        DayInfo day = new DayInfo(dayNumber);
                        dayList.add(day);
                        break;
                    case 2: // Customer Info
                        String[] customerInfo = line.split(",");
                        if (customerInfo.length < 5) {
                            // Invalid line, skip or handle accordingly
                            continue;}
                        int yearOfBirth = Integer.parseInt(customerInfo[0].trim());
                        String customerId = customerInfo[1].trim();
                        int dayOfPurchase = Integer.parseInt(customerInfo[2].trim());
                        int purchaseQuantity = Integer.parseInt(customerInfo[3].trim());
                        String bookTitle = customerInfo[4].trim();
                       CustomerInfo customer = new CustomerInfo(yearOfBirth,
                                customerId, dayOfPurchase, purchaseQuantity, bookTitle);
                        if (customer.getdesiredName().equalsIgnoreCase("Harry Potter and the Goblet of Fire"))
                            pqueueForHarry.insert(customer);
                        else if (customer.getdesiredName().equalsIgnoreCase("The Metamorphosis"))
                            pqueueForMeta.insert(customer);
                        else if (customer.getdesiredName().equalsIgnoreCase("The Stranger"))
                            pqueueForStranger.insert(customer);
                        break;
                    default:
                        break;}}} catch (IOException e) {e.printStackTrace();
        }int m=0;
        pqueueForHarry.get(5).setdateOfReservation(14);
while(m<dayList.size()){

    System.out.println("Day "+dayList.get(m).getnumber()+":");
    System.out.println("Customer Info:");
    if(dayList.get(m).getnumber()==14)
        CustomerInfo.getBook(pqueueForStranger,pqueueForHarry,pqueueForMeta, "Harry Potter and the Goblet of Fire",bookList,  dayList.get(m).getnumber());
    if(dayList.get(m).getnumber()==16)
        CustomerInfo.getBook(pqueueForStranger,pqueueForHarry,pqueueForMeta,"The Metamorphosis",bookList, dayList.get(m).getnumber());
    if(dayList.get(m).getnumber()==18)
        CustomerInfo.getBook(pqueueForStranger,pqueueForHarry,pqueueForMeta,"The Metamorphosis",bookList, dayList.get(m).getnumber());
    if(dayList.get(m).getnumber()==30)
        CustomerInfo.getBook(pqueueForStranger,pqueueForHarry,pqueueForMeta, "Harry Potter and the Goblet of Fire",bookList, dayList.get(m).getnumber());
m++;
}






    }
}
