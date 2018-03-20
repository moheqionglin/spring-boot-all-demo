package com.transaction.spring.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transaction.spring.domain.City;
import com.transaction.spring.domain.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UseSpringBootTests {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	public void contextLoads() {
		List<City> citis = new ArrayList<>();
		City c = new City();
		c.setCode("c-tc");
		c.setName("test-city");

		citis.add(c);

		Province newP = new Province();
		newP.setName("test-name");
		newP.setCode("p-tc");
		newP.setCities(citis);
		c.setProvince(newP);
		em.persist(newP);
		em.flush();
		List<Province> ps = em.createQuery("select p from Province p where p.name like :name", Province.class)
				.setParameter("name", "%test%")
				.getResultList();
		ObjectMapper objectMapper = new ObjectMapper();
		StringWriter stringEmp = new StringWriter();
		try {
			objectMapper.writeValue(stringEmp, ps);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Employee JSON is\n"+stringEmp);
		System.out.println("==");
	}


	@Test
	public void asyncTest(){
		ExecutorService executor = Executors.newCachedThreadPool();


		log.info("ASYNC ||| Get Ignite data from redis by per page : {}", Thread.currentThread().getId());
		Callable<Boolean> asyncTask = new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				System.out.println("===START RUN ==");
				Thread.sleep(2000L);
				System.out.println("===START RUN ==");
				return true;
			}
		};
		Future<Boolean> result = executor.submit(asyncTask);
		executor.shutdown();

		log.info("Leaving  controller");

	}

}
