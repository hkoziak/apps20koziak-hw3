package ua.edu.ucu;


class Student {

    private double gpa;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double gpaNum, int year) {
        this.gpa = gpaNum;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return gpa;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname
                + ", " + "GPA=" + gpa + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        final double MAXDIFF = 0.00001;
        return Math.abs(this.gpa - ((Student) obj).getGPA()) < MAXDIFF &&
                this.year == ((Student) obj).getYear() &&
                this.name.equals(((Student) obj).getName()) &&
                this.surname.equals(((Student) obj).getSurname());
        }
}
