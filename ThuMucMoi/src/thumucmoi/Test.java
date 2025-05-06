package thumucmoi;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

interface Callable{
    String call();
}

interface Browsable{
    String browse();
}

class Smartphone implements Callable, Browsable{
    private List<String> number;
    private List<String> url;
    
    public Smartphone(List<String> numbers, List<String> url){
        this.number = numbers;
        this.url = url;
    }

    
public String call(){
        String ketqua = "";
        for(String num : this.number){
            boolean check = true;
            for (int idx = 0; idx < num.length(); idx++) {
                if(num.charAt(idx) >= '0' && num.charAt(idx) <= '9'){
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
            if (check == true)  ketqua += "Calling... " + num + "\n";
            else ketqua += "Invalid number!\n";
        }
        return ketqua;
    }

    public String browse(){
        String ketqua = "";
        for(String url : this.url){
            boolean check = true;
            for(int idx = 0; idx < url.length(); idx++){
                if(url.charAt(idx) >= '0' && url.charAt(idx) <= '9'){
                    check = false;
                    break;
                }
            }

            if(check == true) ketqua += "Browsing: " + url +"!\n";
            else ketqua += "Invalid URL!\n";
        }
        return ketqua;
    }
}
public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            String dong1 = sc.nextLine();
            String[] x = dong1.split(" ");
            ArrayList<String> number =  new ArrayList<String>(Arrays.asList(x));

            String dong2 = sc.nextLine();
            String[] y = dong2.split(" ");
            ArrayList<String> url = new ArrayList<String>(Arrays.asList(y)); 
            
            Smartphone smartphone = new Smartphone(number,url);
            System.out.print(smartphone.call());
            System.out.print(smartphone.browse());
        }
    }
}


//import java.util.Scanner;
//
//class Book{
//    private String name;
//    private Author author;
//    private double price;
//    private int qty = 0;
//    
//    public Book(String name, Author author, double price){
//        this.name = name;
//        this.author = author;
//        this.price = price;
//    }
//    public Book(String name, Author author, double price, int qty){
//        this.name = name;
//        this.author = author;
//        this.price = price;
//        this.qty = qty;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public int getQty() {
//        return qty;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public void setQty(int qty) {
//        this.qty = qty;
//    }
//    
//    public String toString(){
//        return "Book[name="+ this.name + author.toString()+ "price=" + this.price + ", qty=" + this.qty + "]";
//    }
//}
//
//class Author{
//    private String name;
//    private String email;
//    private char gender;
//
//    public Author(String name, String email, char gender) {
//        this.name = name;
//        this.email = email;
//        this.gender = gender;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public char getGender() {
//        return gender;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setGender(char gender) {
//        this.gender = gender;
//    }
//    
//     public String toString(){
//        return ", Author[" + String.format("name=%s, email=%s, gender=%c ", this.name, this.email, this.gender) + "], ";
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        sc.nextLine();
//        while(t-- > 0){
//            if(sc.nextLine().equals("Book")){
//                String name = sc.nextLine();
//                double price = sc.nextDouble();
//                int qty = sc.nextInt();
//                sc.nextLine();
//                sc.nextLine();
//                String nameA = sc.nextLine();
//                String email = sc.nextLine();
//                char gender = sc.nextLine().charAt(0);
//                sc.nextLine();
//                Book book = new Book(name, new Author(nameA, email, gender), price, qty);
//                System.out.println(book.toString());
//            }else{
//                String nameA = sc.nextLine();
//                String email = sc.nextLine();
//                char gender = sc.nextLine().charAt(0);
//                sc.nextLine();
//                String name = sc.nextLine();
//                double price = sc.nextDouble();
//                int qty = sc.nextInt();
//                sc.nextLine();
//                sc.nextLine();
//                Book book = new Book(name, new Author(nameA, email, gender), price, qty);
//                System.out.println(book.toString());
//            }
//        }
//    }
//}

