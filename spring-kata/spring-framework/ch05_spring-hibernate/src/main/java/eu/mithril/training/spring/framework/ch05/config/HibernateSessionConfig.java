package eu.mithril.training.spring.framework.ch05.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
public class HibernateSessionConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .build();

        return db;
    }

    /**
     * Initialize hibernate properties
     *
     * @return Properties
     */
    private Properties getHibernateProperties() {
        Properties properties = new Properties();

        // Configures the used database dialect. This allows Hibernate to create SQL that is
        // optimized for the used database.
        properties.put(
                AvailableSettings.DIALECT,
                env.getRequiredProperty("hibernate.dialect"));

        // If the value of this property is true, Hibernate writes all SQL statements to the
        // console.
        properties.put(
                AvailableSettings.SHOW_SQL, env.getRequiredProperty("hibernate.show_sql")
        );

        // If this value is set, it provides the maximum count for a batch operation.
        properties.put(
                AvailableSettings.STATEMENT_BATCH_SIZE, env.getRequiredProperty("hibernate.batch.size")
        );

        // Specifies the action that is invoked to the database when the Hibernate SessionFactory
        // is created or closed.
        properties.put(
                AvailableSettings.HBM2DDL_AUTO, env.getRequiredProperty("hibernate.hbm2ddl.auto")
        );

        // This property provides the implementation for the current session's context handling.
        properties.put(
                AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, env.getRequiredProperty("hibernate.current.session.context.class")
        );

        return properties;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan("eu.mithril.training.spring.framework.ch05.model");
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }


    /**
     * Initialize Transaction Manager
     *
     * @param sessionFactory
     * @return HibernateTransactionManager
     */
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }
}