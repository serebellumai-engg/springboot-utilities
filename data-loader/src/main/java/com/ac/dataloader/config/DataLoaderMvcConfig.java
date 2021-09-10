package com.ac.dataloader.config;

import com.ac.dataloader.dao.JobRepository;
import com.ac.dataloader.dao.OrderDetailsRepository;
import com.ac.dataloader.dao.OrdersRepository;
import com.ac.dataloader.entity.orm.Job;
import com.ac.dataloader.entity.orm.Order;
import com.ac.dataloader.entity.orm.OrderDetails;
import com.ac.dataloader.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Properties;

@Configuration
@ComponentScan(value = "com.ac.dataloader.dao")
public class DataLoaderMvcConfig {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private Properties properties;

    @Bean
    public void objectHandlerMapping() {
        properties.put("jobs", getPair(Job.class, jobRepository));
        properties.put("orders", getPair(Order.class, ordersRepository));
        properties.put("orderdetails", getPair(OrderDetails.class, orderDetailsRepository));
    }

    private Pair getPair(Class object, CrudRepository value) {
        return new Pair<Class, CrudRepository>(object, value);
    }

    /*@Bsean(value = "datasource")
    @ConfigurationProperties("datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }*/

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
        t.setCorePoolSize(10);
        t.setMaxPoolSize(100);
        t.setQueueCapacity(50);
        t.setAllowCoreThreadTimeOut(true);
        t.setKeepAliveSeconds(120);
        return t;
    }
}
