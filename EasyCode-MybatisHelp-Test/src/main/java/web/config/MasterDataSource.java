package web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author : dafeng.guo
 * @date : 10:18 2020/12/17
 **/
@Configuration
@MapperScan(basePackages = "web.dao.test", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSource {

    /**
     * 指定mapper和dao位置进行数据隔离
     */
    private static final String MAPPER_LOCATION="classpath:mapper/master/*.xml";

    @Value("${spring.datasource.test.url}")
    private String url;
    @Value("${spring.datasource.test.username}")
    private String username;
    @Value("${spring.datasource.test.password}")
    private String password;
    @Value("${spring.datasource.test.driverClassName}")
    private String driverClassName;

    @Bean(name = "masterDatasSource")
    @Primary
    public DataSource masterDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

    @Bean(name = "masterDataSourceTransaction")
    @Primary
    public DataSourceTransactionManager masterDataSourceTransactionManager(){
        return new DataSourceTransactionManager(masterDataSource());
    }


    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDatasSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterDataSource.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
