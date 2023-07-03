package hr.fer.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class InnovationCompetition {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(String firstName, String lastName, int proposedInnovations, int implementedInnovations) {
        employees.add(new Employee(firstName, lastName, proposedInnovations, implementedInnovations));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void removeEmployees(List<String> removalNames) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();

            if (removalNames.contains(employee.getLastName())) {
                iterator.remove();
            }

        }
    }

    private static final Comparator<Employee> COMPARATOR = Comparator.comparing(Employee::getImplementedInnovations).reversed().
            thenComparing(Comparator.comparing(Employee::getProposedInnovations).reversed()).
            thenComparing(Comparator.comparing(Employee::getLastName));

    public void rankEmployees() {
        Collections.sort(employees, COMPARATOR);
        //or like this: employees.sort(COMPARATOR);
    }

}
