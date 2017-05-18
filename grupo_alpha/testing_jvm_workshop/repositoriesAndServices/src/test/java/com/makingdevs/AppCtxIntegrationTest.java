package com.makingdevs;

import com.makingdevs.config.PersistenceConfig;
import com.makingdevs.config.ServicesConfig;
import com.makingdevs.services.TaskService;
import com.makingdevs.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * Created by neodevelop on 17/05/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, ServicesConfig.class})
public class AppCtxIntegrationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testAppCtx(){
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        Assert.notNull(applicationContext);
        Assert.notNull(dataSource);
    }

    @Test
    public void testRepositories(){
        TaskService taskService = applicationContext.getBean(TaskService.class);
        Assert.notNull(taskService);
    }
}
