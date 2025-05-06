
import java.util.Scanner;

abstract class Car{
    protected double price;
    protected int year;
    
    public abstract String toString();
    public abstract double calculateSalePrice();
}
//Constructors : Hamf tao
class SportCar extends Car {
    public SportCar(double x, int y){
        year = y;
        price = x;
    }
    @Override
    public double calculateSalePrice(){
        if(year > 2018){
            price = price * 0.8;
        }else if(year > 2010){
            price *= 0.5;
        }else{
            price *= 0.1;
        }
        return price;
    }
    @Override 
    public String toString(){
        String x = String.format("%.2f", price);
        return "Price: " + x + " VND"+ " | Year: " + year;
    }
}

class ClassicCar extends Car {
    public ClassicCar(double x, int y){
        year = y;
        price = x;
    }
    @Override 
    public double calculateSalePrice(){
        price = price* 1.12 + 20000000;
        return price;
    }
    @Override
    public String toString(){
        return "Price: " + String.format("%.2f", price) + " VND"+ " | Year: " + year;
    }
 }




public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String cc  = sc.next();
            double price = sc.nextDouble();
            int year = sc.nextInt();
            if(cc.equals("CC")) {
                Car car = new ClassicCar(price, year);
                System.out.println(car);
            }else{
                Car car = new SportCar(price,year);
                System.out.println(car);
            }
        }
    }
}






