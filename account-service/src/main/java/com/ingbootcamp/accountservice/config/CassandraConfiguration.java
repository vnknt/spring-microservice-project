package com.ingbootcamp.accountservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;

import java.util.List;
@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${sp.cassandra.contact-point}")
    private String contactPoint;
    @Value("${sp.cassandra.uname}")
    private String username;
    @Value("${sp.cassandra.passw}")
    private String password;

    @Value("${sp.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${sp.cassandra.datacenter}")
    private String localDatacenter;

    @Value("${sp.cassandra.port}")
    private int port;



    @Override
    protected String getKeyspaceName() {
        return this.keyspaceName;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages(){
        return new String[] {"com.ingbootcamp.accountservice"};
    }


    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cqlSessionFactoryBean =  new CqlSessionFactoryBean();
        cqlSessionFactoryBean.setContactPoints(contactPoint);
        cqlSessionFactoryBean.setPort(port);
        cqlSessionFactoryBean.setUsername(username);
        cqlSessionFactoryBean.setPassword(password);

        cqlSessionFactoryBean.setLocalDatacenter(localDatacenter);
        cqlSessionFactoryBean.setKeyspaceName(keyspaceName);

        return cqlSessionFactoryBean;
    }
}
