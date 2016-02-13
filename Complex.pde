public class Complex {
	private float _xAxis;
	private float _yAxis;
	private float _stdSize;

	private ArrayList<Room> rooms     = new ArrayList<Room> ();
	private ArrayList<Sensor> sensors = new ArrayList<Sensor> ();

	public Complex (float stdSize) {
		this._stdSize = stdSize;
	}

	public void createRooms () {
		// TODO: Simplify the algorithms for 'xAxis' and 'yAxis'.
		rooms.add ( // Room 1
			new Room (
				"Room #1",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize),
				// (this._stdSize * 2) / 5,
				(2.0/5.0) * this._stdSize,
				(1.0/3.0) * this._stdSize
			)
		);
		rooms.add ( // Room 2
			new Room (
				"Room #2",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((2.0/5.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize),
				(3.0/2.0) * this._stdSize,
				this._stdSize
			)
		);
		rooms.add ( // Room 3
			new Room (
				"Room #3",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((19.0/10.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize),
				this._stdSize,
				this._stdSize
			)
		);
		rooms.add ( // Room 4
			new Room (
				"Room #4",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((19.0/10.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize) - ((1.0/2.0) * this._stdSize),
				this._stdSize,
				(1.0/2.0) * this._stdSize
			)
		);
	}
	public void createSensors () {
		sensors.add ( // Sensor 1
			new Sensor (
				"S_1",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((2.0/5.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize) + ((1.0/3.0) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 2
			new Sensor (
				"S_2",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((2.0/5.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize) + ((2.0/3.0) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 3
			new Sensor (
				"S_3",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((19.0/10.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize) - ((1.0/2.0) * this._stdSize) + ((1.0/3.0) * ((1.0/2.0) * this._stdSize))
			)
		);
		sensors.add ( // Sensor 4
			new Sensor (
				"S_4",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((19.0/10.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize) - ((1.0/2.0) * this._stdSize) + ((2.0/3.0) * ((1.0/2.0) * this._stdSize))
			)
		);
		sensors.add ( // Sensor 5
			new Sensor (
				"S_5",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((19.0/10.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize) + ((1.0/2.0) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 6
			new Sensor (
				"S_6",
				this._xAxis - (((29.0/10.0) * this._stdSize) / 2) + ((19.0/10.0) * this._stdSize) + ((1.0/2.0) * this._stdSize),
				this._yAxis - (((3.0/2.0) * this._stdSize) / 2) + ((1.0/2.0) * this._stdSize) + this._stdSize - 15
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
		return (29.0/10.0) * this._stdSize;
	}
	public float getHeight () {
		return (3.0/2.0) * this._stdSize;
	}
}