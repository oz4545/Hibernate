import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateGet {
    public static void main(String[] args) {
        // Crear una configuración desde el archivo hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Crear una fábrica de sesiones
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Abrir una sesión de Hibernate
        Session session = sessionFactory.openSession();

        try {
            // ID de la entidad que deseas recuperar
            int entityId = 1;

            // Utilizar el método get para recuperar la entidad por su ID
            Entidad entidad = session.get(Entidad.class, entityId);

            if (entidad != null) {
                System.out.println("Entidad recuperada: " + entidad.toString());
            } else {
                System.out.println("Entidad no encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la sesión y la fábrica de sesiones
            session.close();
            sessionFactory.close();
        }
    }
}
