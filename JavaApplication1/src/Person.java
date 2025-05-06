public class Person {
    private String name, tuoi, birth;
    
    public void greet() {
        System.out.println("Hello");
    }
    
    public Person() {
        this.name = "";
        this.tuoi = "";
        this.birth = "";
    }
    
    public Person(String name, String tuoi, String birth) {
        this.name = name;
        this.tuoi = tuoi;
        this.birth = birth;
    }
       
    public void setName(String name) {
        this.name = name;
    }
    
    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }
    
    public void setBirth(String Birth) {
        this.birth = Birth;
    }
    
    public String getName() {
        return this.name;
    }

    public String getTuoi() {
        return tuoi;
    }

    public String getBirth() {
        return birth;
    }
    @Override
    public String toString() {
        return " " + name + " " + tuoi + " " + birth;
    }
    
}
