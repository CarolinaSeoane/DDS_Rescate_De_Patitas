package ddsutn.Business.SchedulerRecomendaciones;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.newJob;

public class SchedulerRecomendaciones {

	public static void main(String[] args){

		Scheduler scheduler = null;

		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();

			scheduler.start();

			JobDetail jobDetail = newJob(RecomendacionesJob.class)
					.withIdentity("JobRecomendacionesSemanales")
					.build();

			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("TriggerSemanal")
					.startNow()
					.withSchedule(SimpleScheduleBuilder
							.simpleSchedule()
							.withIntervalInHours(168)
							.repeatForever())
					.build();

			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}
}

