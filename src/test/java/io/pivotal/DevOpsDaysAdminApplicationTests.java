package io.pivotal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import io.pivotal.devopsdays.DevOpsDaysAdminApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevOpsDaysAdminApplication.class)
@WebAppConfiguration
public class DevOpsDaysAdminApplicationTests {

	@Test
	public void contextLoads() {
	}

}
