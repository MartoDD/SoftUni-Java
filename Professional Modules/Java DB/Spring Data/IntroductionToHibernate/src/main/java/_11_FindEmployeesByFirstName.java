import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class _11_FindEmployeesByFirstName {
    public static void main(String[] args) {

        final String GET_EMPLOYEES_BY_PATTERN="SELECT e FROM Employee AS e WHERE e.firstName LIKE :pattern";
        final String PRINT_EMPLOYEE_INFO="%s %s - %s - ($%.2f)%n";


        Scanner scanner = new Scanner(System.in);

        EntityManager em = Utils.createEntityManager();

        em.getTransaction().begin();

        String pattern=scanner.nextLine().concat("%");

        List<Employee> employees = em.createQuery(GET_EMPLOYEES_BY_PATTERN, Employee.class).setParameter("pattern", pattern).getResultList();

        employees.forEach(e-> System.out.printf(PRINT_EMPLOYEE_INFO,e.getFirstName(),e.getLastName(),e.getJobTitle(),e.getSalary()));

        em.getTransaction().commit();
        em.close();

    }
}
