import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateSession {
    public static void main(String[] args) {
        // Crear una configuración desde el archivo hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Crear una fábrica de sesiones
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Abrir una sesión de Hibernate
        Session session = sessionFactory.openSession();

        // Comenzar una transacción
        Transaction transaction = session.beginTransaction();

        try {
            // Crear una entidad y guardarla en la base de datos
            Entidad entidad = new Entidad();
            entidad.setNombre("Ejemplo");
            session.save(entidad);

            // Realizar consultas o más operaciones aquí

            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            // En caso de error, realizar un rollback de la transacción
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar la sesión y la fábrica de sesiones
            session.close();
            sessionFactory.close();
        }
    }
}