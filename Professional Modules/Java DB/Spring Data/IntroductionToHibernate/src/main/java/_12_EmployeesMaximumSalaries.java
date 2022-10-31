import javax.persistence.EntityManager;

public class _12_EmployeesMaximumSalaries {
    public static void main(String[] args) {

        final String GET_DEPARTMENT_AND_MAX_SALARY="SELECT e.department.name,MAX(e.salary) FROM Employee AS e GROUP BY e.department.name HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000";

        EntityManager em = Utils.createEntityManager();

        em.getTransaction().begin();

        em.createQuery(GET_DEPARTMENT_AND_MAX_SALARY, Object[].class).getResultList().forEach(e-> System.out.println(e[0] + " "+ e[1]));

        em.getTransaction().commit();
        em.close();
    }
}
