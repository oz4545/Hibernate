import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUpdate {
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
            // Ejemplo de consulta de actualización (UPDATE)
            String hqlUpdate = "update Usuario set userName = :newName where id = :userId";
            int updatedEntities = session.createQuery(hqlUpdate)
                    .setString("newName", "NuevoNombre")
                    .setLong("userId", 1)
                    .executeUpdate();

            System.out.println("Filas actualizadas: " + updatedEntities);

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
