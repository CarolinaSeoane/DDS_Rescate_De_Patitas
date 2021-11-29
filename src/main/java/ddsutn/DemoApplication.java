package ddsutn;

import ddsutn.Business.SchedulerRecomendaciones.JavaJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class DemoApplication implements ApplicationListener {

	@Autowired
	private JavaJob javaJob;

	@Bean
	public JavaJob javaJob() {
		return new JavaJob();
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationStartedEvent) {
			ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
			scheduler.scheduleWithFixedDelay(javaJob::jobWithDelay, 0, 7, TimeUnit.DAYS);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
