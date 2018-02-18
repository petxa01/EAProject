import EA.Read;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Do you want to work with:");
        System.out.println("\t\t [0] JDBC");
        System.out.println("\t\t [1] Hibernate");
        int i = Read.Int("");

        if (i == 0) {
            EA.Main.main(args);
        } else {
            EAHibernate.Main.main(args);
        }
    }
}
