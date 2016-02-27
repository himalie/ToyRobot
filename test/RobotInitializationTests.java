package test;

import main.Position;
import main.ToyRobot;
import main.Direction;
import main.Validatable;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class RobotInitializationTests {	

	@Test
	public void ShouldValidatePositionOnInitialization() {			
		Validatable positionValidator = mock(Validatable.class);				
		ToyRobot robot = new ToyRobot(positionValidator);
		Position position = new Position(1,2);
		
		robot.place(position, Direction.NORTH);
		verify(positionValidator, atLeastOnce()).validate(position);		
	}	
}
