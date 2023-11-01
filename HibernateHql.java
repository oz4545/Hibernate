import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateHql {
    public static void main(String[] args) {
        // Crear una configuración desde el archivo hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Crear una fábrica de sesiones
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Abrir una sesión de Hibernate
        Session session = sessionFactory.openSession();

        try {
            // Ejemplo de consultas HQL
            Query query;

            // Consulta para seleccionar todas las entidades Usuario
            query = session.createQuery("from Usuario");
            List<Usuario> usuarios = query.list();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }

            // Consulta para seleccionar usuarios con nombre 'Raul'
            query = session.createQuery("from Usuario u where u.userName = 'Raul'");
            Usuario usuarioRaul = (Usuario) query.uniqueResult();
            if (usuarioRaul != null) {
                System.out.println("Usuario Raul: " + usuarioRaul);
            } else {
                System.out.println("Usuario Raul no encontrado.");
            }

            // Otras consultas HQL
            query = session.createQuery("from DomesticCat cat order by cat.name asc");
            List<DomesticCat> domesticCats = query.list();

            query = session.createQuery("from Cat as cat inner join cat.mate as mate");
            List<Cat> catsWithMate = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la sesión y la fábrica de sesiones
            session.close();
            sessionFactory.close();
        }
    }
}