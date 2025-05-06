import java.util.Scanner;

public class SinhVien extends Person {
    private String MaSV;
    private String HoTen;
    private String NgaySinh;
    private String Lop;
    private float GPA;

    

    

    public void setTen(String sc){
        HoTen = sc;
    }
    public void setLop(String sc){
        Lop = sc;
    }
    public void setNgaySinh(String sc){
        NgaySinh = sc;
    }
    public void setGPA(float sc){
        GPA = sc;

    }

    private void CheckChuanHoa(){
        StringBuilder sb = new StringBuilder(NgaySinh);
            if(sb.charAt(1) == '/'){
                sb.insert(0,'0');
            } 
            if(sb.charAt(4) == '/'){
                sb.insert(3,'0');
            }
        NgaySinh = sb.toString();
    }

    private void ChuyenInHoa(){
         StringBuilder sb = new StringBuilder(HoTen);
         for(int i = 0; i < sb.length() - 1; i++){
             if(sb.charAt(i) == ' '){
                Character.toUpperCase(sb.charAt(i+1));
             }
         }
         HoTen = sb.toString();
    }



    public void in(){
        CheckChuanHoa();
        ChuyenInHoa();
        System.out.print(HoTen + " " + Lop + " " + NgaySinh + " ");
        //SV001 Hoang Van Long CNTT2 26/07/2000 0.20
        System.out.printf("%.2f", GPA);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return HoTen;
    }
    public static void main(String[] args) {
        Person s  = new Person("ạdfksdjf","jsfksjf", "ksfksakjf");
        System.out.println(s);
        
    }
}