import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class _5_EmployeesFromDepartment {
    public static void main(String[] args) {

        final String PRINT_EMPLOYEE_INFORMATION="%s %s from Research and Development - $%.2f%n";
        final String DEPARTMENT_NAME="Research and Development";
        final String SELECT_EMPLOYEES_FROM_DEPARTMENT = "SELECT e FROM Employee AS e  WHERE e.department.name =: dn order by e.salary,e.id";

        EntityManager em = Utils.createEntityManager();
        em.getTransaction().begin();

        List<Employee> employees = em.createQuery(SELECT_EMPLOYEES_FROM_DEPARTMENT, Employee.class).setParameter("dn",DEPARTMENT_NAME).getResultList();

        employees.forEach(employee -> System.out.printf(PRINT_EMPLOYEE_INFORMATION,employee.getFirstName(),employee.getLastName(),employee.getSalary()));

        em.getTransaction().commit();
        em.close();
    }
}
