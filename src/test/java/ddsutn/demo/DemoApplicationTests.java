package ddsutn.demo;

import ddsutn.Servicios.CaracteristicaSvc;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CaracteristicaSvc caracteristicaSvc;

	@Test
	void contextLoads() {
		//Assert.assertEquals("amigable",caracteristicaSvc.findAll().stream().findFirst().get().getCaracteristica());
	}

}
