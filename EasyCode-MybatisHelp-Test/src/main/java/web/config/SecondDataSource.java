package web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author : dafeng.guo
 * @date : 10:18 2020/12/17
 **/
@Configuration
@MapperScan(basePackages = "web.dao.testB", sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSource {

    /**
     * 指定mapper和dao位置进行数据隔离
     */
    private static final String PACKAGE="web.dao.testB";
    private static final String MAPPER_LOCATION="classpath:mapper/second/*.xml";

    @Value("${spring.datasource.testB.url}")
    private String url;
    @Value("${spring.datasource.testB.username}")
    private String username;
    @Value("${spring.datasource.testB.password}")
    private String password;
    @Value("${spring.datasource.testB.driverClassName}")
    private String driverClassName;

    @Bean(name = "secondDatasSource")
    public DataSource secondDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

    @Bean(name = "secondDataSourceTransaction")
    public DataSourceTransactionManager secondDataSourceTransactionManager(){
        return new DataSourceTransactionManager(secondDataSource());
    }


    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDatasSource") DataSource secondDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(secondDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondDataSource.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
