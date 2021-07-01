package home.holytiger.dynamicdatabase.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DatabaseConfig {

    private String baseJdbcUrl = "jdbc:mysql://localhost:3306/";
    private String baseJdbcUsername = "root";
    private String baseJdbcPassword = "holytiger";

    @Bean
    public DataSource RouterDataSource() {
        Map<Object, Object> targetSources = new HashMap<>();

        targetSources.put("master", getMasterDataSource());
        targetSources.put("slave", getSlaveDataSource());

        TestRoutingDataSource dataSource = new TestRoutingDataSource();
        dataSource.setTargetDataSources(targetSources);
        return dataSource;
    }

    private DataSource getMasterDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(baseJdbcUrl+"master");
        dataSource.setUsername(baseJdbcUsername);
        dataSource.setPassword(baseJdbcPassword);

        return dataSource;
    }

    private DataSource getSlaveDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(baseJdbcUrl+"slave");
        dataSource.setUsername(baseJdbcUsername);
        dataSource.setPassword(baseJdbcPassword);

        return dataSource;
    }
}
