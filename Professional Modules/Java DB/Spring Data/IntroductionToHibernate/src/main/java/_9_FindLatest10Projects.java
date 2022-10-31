import entities.Project;

import javax.persistence.EntityManager;
import java.util.Comparator;

public class _9_FindLatest10Projects {
    public static void main(String[] args) {

        final String GET_LAST_10_PROJECTS="SELECT p FROM Project AS p ORDER BY p.startDate DESC";

        EntityManager em = Utils.createEntityManager();

        em.getTransaction().begin();

        em.createQuery(GET_LAST_10_PROJECTS, Project.class).setMaxResults(10).getResultList().stream().sorted(Comparator.comparing(Project::getName)).forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}
