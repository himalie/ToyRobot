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
  public Direction turn(int index)
  {
	  int val= this.directionIndex + index;	  
	  return Direction.values()[val];
  }
}
