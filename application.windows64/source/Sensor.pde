public class Sensor {
	private float _xAxis;
	private float _yAxis;
	private String _ID;

	public Sensor (String ID, float xAxis, float yAxis) {
		this._xAxis = xAxis;
		this._yAxis = yAxis;
		this._ID    = ID;
	}

	public void render () {
		rect (
			this._xAxis,
			this._yAxis,
			15,
			15
		);
	}
	public void renderText () {
		text (
			this._ID,
			this._xAxis + 2 + 15,
			this._yAxis - 2 + 15 - 2
		);
	}
}