package UtilTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jms.core.JmsTemplate;

import com.qa.TrainerAPI.persistence.domain.Trainer;
import com.qa.TrainerAPI.util.Constants;
import com.qa.TrainerAPI.util.TrainerProducer;

public class TrainerProducerTest {
	private TrainerProducer producer;
	private Trainer trainer;
	@Mock
	private JmsTemplate jmsTemplate;
	
	@Test
	public void produceTrainerTest(Trainer trainer) {
		Trainer trainer1= new Trainer();
		Mockito.doReturn(Constants.REQUEST_QUEUED_MESSAGE)
		.when(jmsTemplate).convertAndSend(Constants.INCOMING_TRAINER_QUEUE_NAME, trainer1);
		assertEquals(Constants.REQUEST_QUEUED_MESSAGE, producer.produce(trainer1));
	}
	
	
	
	
}
