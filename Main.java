import main.Commands;
import main.Direction;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {	

        System.out.println("-----Toy Robot Simulator-----");
        System.out.println("Enter a command, valid commands are:");
        System.out.println("PLACE X,Y,NORTH|SOUTH|EAST|WEST     (ex: PLACE 2,3,NORTH)");
        System.out.println("MOVE");
        System.out.println("LEFT");
        System.out.println("RIGHT");
        System.out.println("REPORT");
        System.out.println("EXIT");
        System.out.print("Enter :");

		RobotSimulator _simulator = new RobotSimulator();
        Scanner scanner= new Scanner(System.in);
        String inputString = scanner.nextLine();
        boolean continueFlag = true;
        while (continueFlag)
        {
        	if ("EXIT".equals(inputString))
        	{
        		continueFlag= false;
        	}
        	else
        	{
        		evaluateCommands(inputString, _simulator);
        		System.out.print(" Enter a command for the Toy Robot Simulator : ");
            	inputString = scanner.nextLine();
        	}        	
        }
        System.out.println("You have chosen to exit the program.");
    }
		
	public static void evaluateCommands(String commandString, RobotSimulator simulator)
	{
		try{
			String[] args = commandString.split(" ");
			Commands command = Commands.valueOf(args[0]);
			if (command != null){						
				
				String[] parameters;
				int x = 0;
				int y = 0;
				Direction direction = null;
				if (command == Commands.PLACE) {
					if(command == Commands.PLACE && args.length != 2)
					{
						System.out.println("Invalid PLACE command. ex: PLACE 0,0,NORTH");				
					}
					else
					{
						parameters = args[1].split(",");
			            try {
			                x = Integer.parseInt(parameters[0]);
			                y = Integer.parseInt(parameters[1]);
			                direction = Direction.valueOf(parameters[2]);
			            } catch (Exception e) {
			                System.out.println("Invalid commands in PLACE. ex: PLACE 0,0,NORTH");
			            }
					}
		        }
				String reportOutput;
				switch (command)
				{
				case PLACE:
					simulator.place(x, y, direction);
					break;
				case MOVE:
					simulator.move();
					break;
				case LEFT:
					simulator.turnLeft();
					break;
				case RIGHT:
					simulator.turnRight();
					break;
				case REPORT:
					reportOutput = simulator.report();
					if (reportOutput !=null){
					System.out.println(reportOutput);
					}
					break;
				default: 
					System.out.println("You have entered an invalid command!");
				}				
			}
			else
			{
				System.out.println("You have entered an invalid command!");
			}
		}
		catch (Exception e)
		{
			System.out.println("You have entered an invalid command!");
			
		}
		
		
	}
		
	}

