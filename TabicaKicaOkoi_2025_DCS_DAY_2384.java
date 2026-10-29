import java.util.ArrayList;
import java.util.List;

// 1. Interface
interface Displayable {
    void displayDetails();
}

// 2. Abstract Class with Encapsulated Fields
abstract class Student implements Displayable {
    
    private String name;
    private String regNumber;

  
    public Student(String name, String regNumber) {
        this.name = name;
        this.regNumber = regNumber;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    
    public abstract double calculateFinalScore();
}

// 3. Subclass: CourseworkStudent (Inheritance)
class CourseworkStudent extends Student {
    private double courseworkMark;
    private double finalExamMark;

    public CourseworkStudent(String name, String regNumber, double courseworkMark, double finalExamMark) {
        super(name, regNumber);
        this.courseworkMark = courseworkMark;
        this.finalExamMark = finalExamMark;
    }

    @Override
    public double calculateFinalScore() {
        // 40% Coursework + 60% Final Exam
        return (courseworkMark * 0.40) + (finalExamMark * 0.60);
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Coursework Student ---");
        System.out.println("Name: " + getName());
        System.out.println("Reg No: " + getRegNumber());
        System.out.println("Coursework Mark: " + courseworkMark);
        System.out.println("Final Exam Mark: " + finalExamMark);
        System.out.printf("Final Score: %.2f%%\n\n", calculateFinalScore());
    }
}


class ResearchStudent extends Student {
    private double dissertationMark;
    private double defenseMark;

    public ResearchStudent(String name, String regNumber, double dissertationMark, double defenseMark) {
        super(name, regNumber);
        this.dissertationMark = dissertationMark;
        this.defenseMark = defenseMark;
    }

    @Override
    public double calculateFinalScore() {
        
        return (dissertationMark * 0.70) + (defenseMark * 0.30);
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Research Student ---");
        System.out.println("Name: " + getName());
        System.out.println("Reg No: " + getRegNumber());
        System.out.println("Dissertation Mark: " + dissertationMark);
        System.out.println("Defense Mark: " + defenseMark);
        System.out.printf("Final Score: %.2f%%\n\n", calculateFinalScore());
    }
}

// 4. Main Class
public class TabicaKicaOkoi_2025_DCS_DAY_2384 {
    public static void main(String[] args) {
        // Demonstrating Runtime Polymorphism
        List<Student> students = new ArrayList<>();

      
        students.add(new CourseworkStudent("Tabica Kica Okoi", "2025/DCS/DAY/2384", 82.0, 88.0));
        students.add(new CourseworkStudent("Sarah Akello", "2025/DCS/DAY/2385", 70.0, 75.0));
        students.add(new ResearchStudent("David Ochen", "2025/DCS/DAY/2386", 85.0, 90.0));

        System.out.println("=================================");
        System.out.println("     STUDENT RESULTS SUMMARY     ");
        System.out.println("=================================\n");

        // Dynamic method dispatch at runtime:
        for (Student s : students) {
            s.displayDetails();
        }
    }
}
