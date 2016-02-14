import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import g4p_controls.*; 
import processing.core.PApplet; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Temperature_controler_2 extends PApplet {

// Imports



// Classes
Complex complex;
Dial dial;


//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//

public void setup() {
	
	noFill     ();
	stroke     (255);
	background (20);
	frameRate  (60);

	complex = new Complex ((1.0f/4.0f) * width);
	complex.setCoors      ((complex.getWidth () / 2) + 10, (complex.getHeight () / 2) + 10);
	complex.createRooms   ();
	complex.createSensors ();

	dial = new Dial (width / 2.0f, height / 2.0f);
	dial.createButtons ();

	// complex.render ();
	// createGUI ();
}

public void draw() {
	background(170);
	// complex.render ();
}

//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//
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
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize),
				// (this._stdSize * 2) / 5,
				(2.0f/5.0f) * this._stdSize,
				(1.0f/3.0f) * this._stdSize
			)
		);
		rooms.add ( // Room 2
			new Room (
				"Room #2",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((2.0f/5.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize),
				(3.0f/2.0f) * this._stdSize,
				this._stdSize
			)
		);
		rooms.add ( // Room 3
			new Room (
				"Room #3",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize),
				this._stdSize,
				this._stdSize
			)
		);
		rooms.add ( // Room 4
			new Room (
				"Room #4",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) - ((1.0f/2.0f) * this._stdSize),
				this._stdSize,
				(1.0f/2.0f) * this._stdSize
			)
		);
	}
	public void createSensors () {
		sensors.add ( // Sensor 1
			new Sensor (
				"S_1",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((2.0f/5.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) + ((1.0f/3.0f) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 2
			new Sensor (
				"S_2",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((2.0f/5.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) + ((2.0f/3.0f) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 3
			new Sensor (
				"S_3",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) - ((1.0f/2.0f) * this._stdSize) + ((1.0f/3.0f) * ((1.0f/2.0f) * this._stdSize))
			)
		);
		sensors.add ( // Sensor 4
			new Sensor (
				"S_4",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) - ((1.0f/2.0f) * this._stdSize) + ((2.0f/3.0f) * ((1.0f/2.0f) * this._stdSize))
			)
		);
		sensors.add ( // Sensor 5
			new Sensor (
				"S_5",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) + ((1.0f/2.0f) * this._stdSize)
			)
		);
		sensors.add ( // Sensor 6
			new Sensor (
				"S_6",
				this._xAxis - (((29.0f/10.0f) * this._stdSize) / 2) + ((19.0f/10.0f) * this._stdSize) + ((1.0f/2.0f) * this._stdSize),
				this._yAxis - (((3.0f/2.0f) * this._stdSize) / 2) + ((1.0f/2.0f) * this._stdSize) + this._stdSize - 15
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
		return (29.0f/10.0f) * this._stdSize;
	}
	public float getHeight () {
		return (3.0f/2.0f) * this._stdSize;
	}
}
public class Dial {
	private float _xAxis;
	private float _yAxis;
	private float _numberSize;
	private float _numberSeparation;
	private float _dialWidth;
	private float _dialHeight;
	private float _rows;
	private float _colums;

	private PApplet _PApplet;

	private ArrayList<GImageButton> buttons = new ArrayList<GImageButton> ();

	private String [][] _buttonSprite = new String [][] {
		{"number 1.png", "number 1.png", "number 1.png"},
		{"number 2.png", "number 2.png", "number 2.png"},
		{"number 3.png", "number 3.png", "number 3.png"},
		{"number 4.png", "number 4.png", "number 4.png"},
		{"number 5.png", "number 5.png", "number 5.png"},
		{"number 6.png", "number 6.png", "number 6.png"},
		{"number 7.png", "number 7.png", "number 7.png"},
		{"number 8.png", "number 8.png", "number 8.png"},
		{"number 9.png", "number 9.png", "number 9.png"},
		{"back.png", "back.png", "back.png"},
		{"back.png", "back.png", "back.png"},
		{"number 0.png", "number 0.png", "number 0.png"},
	};

	public Dial (float xAxis, float yAxis) {
		this._xAxis = xAxis;
		this._yAxis = yAxis;

		this._numberSize       = 64.0f;
		this._numberSeparation = 16.0f;
		// this._rows             = 1.0;
		this._rows             = 4.0f;
		// this._colums           = 1.0;
		this._colums           = 3.0f;

		this._dialWidth  = (this._numberSize * this._colums) + (this._numberSeparation * (this._colums - 1));
		this._dialHeight = (this._numberSize * this._rows) + (this._numberSeparation * (this._rows - 1));
	}

	public void createButtons () {
		for (float rowIndex = 0.0f; rowIndex < this._rows; ++rowIndex) {
			for (float columIndex = 0.0f; columIndex < this._colums; ++columIndex) {
				buttons.add (
					new GImageButton (
						this._PApplet,
						// this._xAxis,
						// this._yAxis,
						PApplet.parseInt (this._xAxis - ((1.0f/2.0f) * this._dialWidth) + (rowIndex * this._numberSize) + (rowIndex * this._numberSeparation)),
						PApplet.parseInt (this._yAxis - ((1.0f/2.0f) * this._dialHeight) + (columIndex * this._numberSize) + (columIndex * this._numberSeparation)),
						this._buttonSprite [PApplet.parseInt ((this._colums * columIndex) + rowIndex)],
						"Dial alpha mask.png"
					)
				);
			}
		}
	}
}
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
  public void settings() { 	size       (800, 480, JAVA2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Temperature_controler_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
