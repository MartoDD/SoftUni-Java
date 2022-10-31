import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum Utils {
    ;

    public static EntityManager createEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        return factory.createEntityManager();
    }
}
