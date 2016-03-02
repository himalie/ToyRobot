package main;

public class Board {
	private final int _width;
	private final int _height;
	
	public Board(int width, int height) {
		this._width = width;
		this._height = height;
	}

	public int get_width() {
		return _width;
	}

	public int get_height() {
		return _height;
	}

}
