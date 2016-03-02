package main;

public class DirectionTurner implements Turnable{
		
	public Direction Left(Direction direction)
	{
		return turn(direction, -1);
		
	}
	public Direction Right(Direction direction)
	{
		return turn(direction, 1);
		
	}
	private Direction turn(Direction direction, int index){
				
		int val= direction.get_directionIndex() + index;
		if (val<0)
		{
			val= direction.count() - 1;
		}
		else if (val== direction.count())
		{
			val= 0;
		}
		 return Direction.values()[val];		
	}
}
