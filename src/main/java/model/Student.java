package model;

public class Student {
    private int studentID;
    private String name;
    private int age;
    private boolean gender;

    // Constructors
    public Student() {
    }

    public Student(String name, int age, boolean gender) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
