public class Student {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String course;
    private String email;
    private String phone;
    private String address;

    // Default Constructor
    public Student() {

    }

    // Parameterized Constructor
    public Student(int id, String name, int age, String gender,
                   String course, String email,
                   String phone, String address) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return "Student ID : " + id +
                "\nName      : " + name +
                "\nAge       : " + age +
                "\nGender    : " + gender +
                "\nCourse    : " + course +
                "\nEmail     : " + email +
                "\nPhone     : " + phone +
                "\nAddress   : " + address;
    }

}
