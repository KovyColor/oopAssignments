package assignment_3.OOP_part2.Task7all;

public class Programmer {
    private int salary = 1000;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int newSalary) {
        if (newSalary > salary) {
            salary = newSalary;
        }
    }
}
