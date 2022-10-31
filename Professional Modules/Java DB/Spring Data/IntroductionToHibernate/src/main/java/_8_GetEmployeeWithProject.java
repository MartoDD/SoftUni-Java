import entities.Employee;

import javax.persistence.EntityManager;
import java.util.Scanner;


public class _8_GetEmployeeWithProject {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EntityManager em = Utils.createEntityManager();

        final String GET_EMPLOYEE_INFORMATION="SELECT e FROM Employee as e WHERE e.id=:id";

        em.getTransaction().begin();

        int id= scanner.nextInt();

        em.createQuery(GET_EMPLOYEE_INFORMATION, Employee.class).setParameter("id",id).getResultList().forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}
