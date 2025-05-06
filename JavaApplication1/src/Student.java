public class Student extends Person{
    private String lop;
    private float GPA;

    public Student(String lop, float GPA) {
        this.lop = lop;
        this.GPA = GPA;
       
    }
    
    public Student() {
        lop = "";
        GPA = 3.2F;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public void greet() {
        System.out.println("bodfjds");
    }
    
}
