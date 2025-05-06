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
    private List<String> numbers;
    private List<String> url;
    
    public Smartphone(List<String> numbers, List<String> url){
        this.numbers = numbers;
        this.url = url;
    }
    
    @Override 
    public String call(){
        ArrayList<String> arr = new ArrayList<>();
        boolean check = true;
        for(String string : this.numbers){
            for(char c:string.toCharArray()){
                if(c >= '0' && c <= '9'){
                }else{
                    arr.add("Invalid number!\n");
                    check = false;
                    break;
                }
            }
            if(check == true) arr.add("Calling... " + string + "\n");
            check = true;
        }
        return arr.toString();
    }
    
    @Override
    public String browse(){
        ArrayList<String> arr = new ArrayList<>();
        boolean check = true;
        for(String string:url){
            for(char c:string.toCharArray()){
                if(!(c >= '0' && c <= '9')){
                   
                }else{
                    arr.add("Invalid URL!\n");
                    check = false;
                    break;
                }
            }
            if(check == true){
                 arr.add("Browsing: " + string + "!\n");
            }
            check = true;
        }
        return arr.toString();
    }
}

public class ThuMucMoi{
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