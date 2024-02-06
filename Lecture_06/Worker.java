package Lecture_06;

public class Worker {
    int id;
    int salary;
    String firstName;
    String lastName;

    @Override
    public String toString() {
        return String.format("%d: %s %s %d", id, firstName, lastName, salary);
    }

    @Override
    public boolean equals(Object obj) {
        var t = (Worker) obj;
        return id == t.id && firstName == t.firstName;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
