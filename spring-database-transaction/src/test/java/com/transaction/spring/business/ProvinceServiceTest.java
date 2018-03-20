package com.transaction.spring.business;

import com.transaction.spring.domain.City;
import com.transaction.spring.domain.Province;
import com.transaction.spring.message.CityInfo;
import com.transaction.spring.message.ProvinceInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@EnableTransactionManagement
@SpringBootTest
public class ProvinceServiceTest {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	public void saveProvince(){
		ProvinceInfo pi = new ProvinceInfo();
		pi.setName("PROVINCE-1");
		pi.setCode("CODE-2");

		CityInfo cityInfo = new CityInfo();
		cityInfo.setCode("CODE-2");
		cityInfo.setName("CITY-2");
		ProvinceInfo pi1 = new ProvinceInfo();
		pi1.setId(1);
		cityInfo.setProvince(pi1);
		saveProvinceForPropagation(pi);
		saveProvinceForPropagation(cityInfo);
		Province province = new Province();
		province.setName("==");
		province.setCode("=");
		em.persist(province);
//		throw new RuntimeException("-======-");

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void saveProvinceForPropagation(CityInfo cityInfo){
		City city = new City();
		city.setCode(cityInfo.getCode());
		city.setName(cityInfo.getName());
		city.setProvince(em.find(Province.class, cityInfo.getProvince().getId()));
		em.persist(city);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void saveProvinceForPropagation(ProvinceInfo provinceInfo){
		Province province = new Province();
		province.setName(provinceInfo.getName());
		province.setCode(provinceInfo.getCode());
		em.persist(province);
	}



}
