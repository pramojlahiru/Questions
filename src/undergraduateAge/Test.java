package undergraduateAge;
import java.io.FileNotFoundException;

class Date {

    int year;
    int month;
    int day;

    Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    static boolean equals(Date d1, Date d2) throws InvalidDaysException,FileNotFoundException {
        if (d1.day > 31 || d2.day > 31) {
            throw new InvalidDaysException();
        }
        if (d1.year == d2.year && d1.month == d2.month && d1.day == d2.day) {
            return true;
        } else {
            return false;
        }
    }

    static boolean before(Date d1, Date d2) {
        if (d1.year >= d2.year && d1.month >= d2.month && d1.day > d2.day) {
            return true;
        } else {
            return false;
        }
    }

}

public class Test {

    public static void main(String[] args) {
        Date d1 = new Date(2001, 5, 20);
        Date d2 = new Date(2005, 5, 50);
        try {
            Date.equals(d1, d2);
        } catch (InvalidDaysException e) {
            System.out.println(e.getMessage());
            //System.out.println("Catched..");
        }catch(FileNotFoundException f){
            System.out.println(f.getMessage());
        }
        Student pamba = new Student("Sandun", true, new Date(1992, 10, 02));
        Date printDate = pamba.age(new Date(2016, 07, 29));
        
        System.out.println(printDate.year);
        System.out.println(printDate.month);
        System.out.println(printDate.day);
        
        Undergraduate nimalUndergraduate = new Undergraduate("Nimal", true, new Date(1980, 5, 5), "UCSC");
        Undergraduate malaUndergraduate = new Undergraduate("Mala", false, new Date(1982, 6, 4), "UCSC");
        Date nimalAge = nimalUndergraduate.age(new Date(2016, 7, 29));
        Date malaAge =malaUndergraduate.age(new Date(2016, 7, 29));
        System.out.println(nimalAge.year);
        System.out.println(malaAge.year);
        //System.out.println("");
    }
}

class InvalidDaysException extends Exception {

    @Override
    public String getMessage() {
        String message = "message eka alluwa.. lol";
        return message; //To change body of generated methods, choose Tools | Templates.
    }
    
}

class Student{
    String name;
    boolean male;
    Date birthDate;
    Student (String name, boolean male, Date birthDate){
        //super(birthDate.year, birthDate.month, birthDate.day); meka one une me class eka date class eken extends karapu nisa
        this.name = name;
        this.male = male;
        this.birthDate = birthDate;
    }
    
    
    static boolean equals(Student s1, Student s2) throws InvalidDaysException,FileNotFoundException{
        if (s1.name == s2.name && s1.male == s2.male && Date.equals(s1.birthDate, s2.birthDate)){
            return true;
        } else {
            return false;
        }
    }
    
    Date age(Date currentDate){
        int year = currentDate.year-this.birthDate.year;
        int month = currentDate.month-this.birthDate.month;
        int day = currentDate.day-this.birthDate.day;
        
        Date age = new Date(year, month, day);
        return age;
    }
}

class Undergraduate extends Student{
    String university;
    Undergraduate(String name, boolean male, Date birthDate, String university){
        super(name, male, birthDate);
        this.university = university;
}
    
}