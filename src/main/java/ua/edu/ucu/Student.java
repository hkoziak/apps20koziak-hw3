package ua.edu.ucu;


class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
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
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) {
            return false;
        }
        return Math.abs(this.GPA - ((Student) obj).getGPA()) < 0.00001
                    && this.year == ((Student) obj).getYear()
                    && this.name.equals(((Student) obj).getName())
                    && this.surname.equals(((Student) obj).getSurname());
        }
}
