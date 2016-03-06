public class Room {
	private float _xAxis;
	private float _yAxis;
	private float _roomWidth;
	private float _roomHeight;
	private String _name;

	public Room (String name, float xAxis, float yAxis, float roomWidth, float roomheight) {
		this._name       = name;
		this._xAxis      = xAxis;
		this._yAxis      = yAxis;
		this._roomWidth  = roomWidth;
		this._roomHeight = roomheight;
	}

	public void render () {
		rect (
			this._xAxis,
			this._yAxis,
			this._roomWidth,
			this._roomHeight
		);
	}
	public void renderText () {
		text (
			this._name,
			this._xAxis + 2,
			this._yAxis + this._roomHeight - 2
		);
	}
}