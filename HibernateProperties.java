import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateProperties{
    public static void main(String[] args) {
        // Crear la configuración
        Configuration config = new Configuration();

        // Establecer las propiedades de Hibernate
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mi_basedatos");
        config.setProperty("hibernate.connection.username", "mi_usuario");
        config.setProperty("hibernate.connection.password", "mi_contraseña");
        config.setProperty("hibernate.c3p0.min_size", "5");
        config.setProperty("hibernate.c3p0.max_size", "20");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.current_session_context_class", "thread");

        // Crear la fábrica de sesiones
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Abrir una sesión
        Session session = sessionFactory.openSession();

        // Realizar operaciones con la sesión

        // Cerrar la sesión y la fábrica de sesiones
        session.close();
        sessionFactory.close();
    }
}
