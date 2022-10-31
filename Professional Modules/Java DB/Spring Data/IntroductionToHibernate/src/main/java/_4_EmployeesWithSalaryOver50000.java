import javax.persistence.EntityManager;
import java.util.List;

public class _4_EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {

        final String GET_FIRST_NAME_OF_EMPLOYEES_WITH_SALARY_ABOVE_50000 = "SELECT e.firstName FROM Employee as e WHERE e.salary>50000";

        EntityManager em = Utils.createEntityManager();

        List<String> employees = em.createQuery(GET_FIRST_NAME_OF_EMPLOYEES_WITH_SALARY_ABOVE_50000, String.class).getResultList();

        for (String employee : employees) {
            System.out.println(employee);
        }


    }
}
