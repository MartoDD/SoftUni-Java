import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_IncreaseSalaries {
    public static void main(String[] args) {

        final String SELECT_EMPLOYEES_AFFECTED_BY_UPDATE = "SELECT e FROM Employee AS e WHERE e.department.name IN (:departments)";
        final String PRINT_EMPLOYEE_INFORMATION="%s %s ($%.2f)%n";

        EntityManager em = Utils.createEntityManager();

        em.getTransaction().begin();

        List<String> departments = new ArrayList<>(Arrays.asList("Engineering","Tool Design","Marketing","Information Services"));

        em.createQuery(SELECT_EMPLOYEES_AFFECTED_BY_UPDATE, Employee.class).setParameter("departments",departments).getResultList().forEach(employee -> {
            employee.setSalary(employee.getSalary().multiply(BigDecimal.valueOf(1.12)));
            em.persist(employee);
        });


        em.createQuery(SELECT_EMPLOYEES_AFFECTED_BY_UPDATE, Employee.class).setParameter("departments", departments).getResultList().
                forEach(e->System.out.printf(PRINT_EMPLOYEE_INFORMATION,e.getFirstName(),e.getLastName(),e.getSalary()));

        em.getTransaction().commit();
        em.close();

    }
}
