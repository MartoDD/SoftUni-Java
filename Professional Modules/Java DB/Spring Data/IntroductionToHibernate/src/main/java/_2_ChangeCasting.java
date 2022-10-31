

import javax.persistence.EntityManager;



public class _2_ChangeCasting {
    public static void main(String[] args) {

        final String UPDATE_TOWNS_WITH_NAME_SHORTER_THAN_FIVE="UPDATE Town t SET t.name=UPPER(t.name) WHERE LENGTH(t.name)<=5";

        EntityManager em = Utils.createEntityManager();

        em.getTransaction().begin();

        em.createQuery(UPDATE_TOWNS_WITH_NAME_SHORTER_THAN_FIVE).executeUpdate();



        em.getTransaction().commit();
        em.close();
    }
}
