package main;

public enum Direction
{
  WEST(0),
  NORTH(1),
  EAST(2),
  SOUTH(3);
  
  private final int directionIndex;

  Direction(int dir)
  {
	  directionIndex = dir;
  }
  public Direction turn_Left()
  {
	  int val= this.directionIndex -1;	  
	  return Direction.values()[val];
  }
}
