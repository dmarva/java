package integration.com.dani.examples.rest.api.config;

import javax.sql.DataSource;

import org.dbunit.ext.h2.H2DataTypeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;

@Configuration
public class TestConfiguration {

    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {
	DatabaseConfigBean dbConfig = new com.github.springtestdbunit.bean.DatabaseConfigBean();
	dbConfig.setDatatypeFactory(new H2DataTypeFactory());
	return dbConfig;
    }

    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(DataSource dataSource) {
	DatabaseDataSourceConnectionFactoryBean dbConnection = new com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean(
		dataSource);
	dbConnection.setDatabaseConfig(dbUnitDatabaseConfig());
	return dbConnection;
    }

}
