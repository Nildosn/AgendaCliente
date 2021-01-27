package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Nildson Kleyton
 *
 */

public class JpaUtil {

	private static EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("AGENDA");
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }
}
