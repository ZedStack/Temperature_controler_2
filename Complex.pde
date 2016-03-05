public class Complex {
	private float _xAxis;
	private float _yAxis;
	private float _stdSize;

	private ArrayList<Room> rooms     = new ArrayList<Room> ();
	private ArrayList<Sensor> sensors = new ArrayList<Sensor> ();

	private float _operation (float num1, float num2) {
		return (num1 / num2) * this._stdSize;
	}

	public Complex (float stdSize) {
		this._stdSize = stdSize;
	}

	public void createRooms () {
		rooms.add ( // Room 1
			new Room (
				"Room #1",
				this._xAxis - this._operation (29.0, 20.0),
				this._yAxis - this._operation (1.0, 4.0),
				this._operation (2.0, 5.0), // Width
				this._operation (1.0, 3.0)  // Height
			)
		);
		rooms.add ( // Room 2
			new Room (
				"Room #2",
				this._xAxis - this._operation (21.0, 20.0),
				this._yAxis - this._operation (1.0, 4.0),
				this._operation (3.0, 2.0), // Width
				this._stdSize               // Height
			)
		);
		rooms.add ( // Room 3
			new Room (
				"Room #3",
				this._xAxis + this._operation (9.0, 20.0),
				this._yAxis - this._operation (1.0, 4.0),
				this._stdSize, // Width
				this._stdSize  // Height
			)
		);
		rooms.add ( // Room 4
			new Room (
				"Room #4",
				this._xAxis + this._operation (9.0, 20.0),
				this._yAxis - this._operation (3.0, 4.0),
				this._stdSize,
				this._operation (1.0, 2.0)
			)
		);
	}
	public void createSensors () {
		sensors.add ( // Sensor 1
			new Sensor (
				"S_1",
				this._xAxis - this._operation (21.0, 20.0),
				this._yAxis + this._operation (1.0, 12.0)
			)
		);
		sensors.add ( // Sensor 2
			new Sensor (
				"S_2",
				this._xAxis - this._operation (21.0, 20.0),
				this._yAxis + this._operation (5.0, 12.0)
			)
		);
		sensors.add ( // Sensor 3
			new Sensor (
				"S_3",
				this._xAxis + this._operation (9.0, 20.0),
				this._yAxis - this._operation (7.0, 12.0)
			)
		);
		sensors.add ( // Sensor 4
			new Sensor (
				"S_4",
				this._xAxis + this._operation (9.0, 20.0),
				this._yAxis - this._operation (5.0, 12.0)
			)
		);
		sensors.add ( // Sensor 5
			new Sensor (
				"S_5",
				this._xAxis + this._operation (9.0, 20.0),
				this._yAxis + this._operation (1.0, 4.0)
			)
		);
		sensors.add ( // Sensor 6
			new Sensor (
				"S_6",
				this._xAxis + this._operation (19.0, 20.0),
				this._yAxis + this._operation (3.0, 4.0) - 15
			)
		);
	}
	public void setCoors (float xAxis, float yAxis) {
		this._xAxis = xAxis;
		this._yAxis = yAxis;
	}
	public void render () {
		for (Room _room : rooms) {
			_room.render ();
			_room.renderText ();
		}
		for (Sensor _sensor : sensors) {
			_sensor.render ();
			_sensor.renderText ();
		}
	}

	public float getWidth () {
		return this._operation (29.0, 10.0);
	}
	public float getHeight () {
		return this._operation (3.0, 2.0);
	}
}