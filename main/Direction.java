package main;

public enum Direction
{
  WEST(0),
  NORTH(1),
  EAST(2),
  SOUTH(3);
  
  private final int direction;

  Direction(int dir)
  {
    direction = dir;
  }   
}
