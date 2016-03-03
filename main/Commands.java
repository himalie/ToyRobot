package main;

public enum Commands {
	PLACE(0),
	MOVE(1),
	LEFT(2),
	RIGHT(3),
	REPORT(4);
	
	private final int commandIndex;

	Commands(int dir)
	{
		commandIndex = dir;
	}	
}
