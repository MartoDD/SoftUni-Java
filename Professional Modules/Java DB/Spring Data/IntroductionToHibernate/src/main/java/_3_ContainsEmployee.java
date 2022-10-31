import javax.persistence.EntityManager;
import java.util.Scanner;

public class _3_ContainsEmployee {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EntityManager em = Utils.createEntityManager();

        em.getTransaction().begin();

        String []nameToCheck=scanner.nextLine().split(" ");
        String firstName=nameToCheck[0];
        String lastName=nameToCheck[1];

        Long count = em.createQuery("SELECT COUNT(e) FROM Employee AS e WHERE e.firstName =: fn AND e.lastName=:ln", Long.class).
                setParameter("fn", firstName).
                setParameter("ln", lastName).getSingleResult();

        if (count==0){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }

        em.close();

    }
}
