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

public void buttonClick (GImageButton source, GEvent event) {
	println("source.tagNo: " + source.tagNo);
}
public void settingsGUI () {
	G4P.messagesEnabled      (false);
	G4P.setGlobalColorScheme (GCScheme.BLUE_SCHEME);
	G4P.setCursor            (ARROW);

	surface.setTitle         ("Temperaturew controler");

}
//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//

public void setup() {
	
	noFill     ();
	stroke     (255);
	background (20);
	frameRate  (60);

	settingsGUI ();

	complex = new Complex ((1.0f/4.0f) * width);
	complex.setCoors      ((complex.getWidth () / 2) + 10, (complex.getHeight () / 2) + 10);
	complex.createRooms   ();
	complex.createSensors ();

	dial = new Dial    (this, width / 2.0f, height / 2.0f);
	dial.createButtons ();

	// complex.render ();
}

public void draw() {
	// background(170);
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
				this._xAxis - this._operation (29.0f, 20.0f),
				this._yAxis - this._operation (1.0f, 4.0f),
				this._operation (2.0f, 5.0f), // Width
				this._operation (1.0f, 3.0f)  // Height
			)
		);
		rooms.add ( // Room 2
			new Room (
				"Room #2",
				this._xAxis - this._operation (21.0f, 20.0f),
				this._yAxis - this._operation (1.0f, 4.0f),
				this._operation (3.0f, 2.0f), // Width
				this._stdSize               // Height
			)
		);
		rooms.add ( // Room 3
			new Room (
				"Room #3",
				this._xAxis + this._operation (9.0f, 20.0f),
				this._yAxis - this._operation (1.0f, 4.0f),
				this._stdSize, // Width
				this._stdSize  // Height
			)
		);
		rooms.add ( // Room 4
			new Room (
				"Room #4",
				this._xAxis + this._operation (9.0f, 20.0f),
				this._yAxis - this._operation (3.0f, 4.0f),
				this._stdSize,
				this._operation (1.0f, 2.0f)
			)
		);
	}
	public void createSensors () {
		sensors.add ( // Sensor 1
			new Sensor (
				"S_1",
				this._xAxis - this._operation (21.0f, 20.0f),
				this._yAxis + this._operation (1.0f, 12.0f)
			)
		);
		sensors.add ( // Sensor 2
			new Sensor (
				"S_2",
				this._xAxis - this._operation (21.0f, 20.0f),
				this._yAxis + this._operation (5.0f, 12.0f)
			)
		);
		sensors.add ( // Sensor 3
			new Sensor (
				"S_3",
				this._xAxis + this._operation (9.0f, 20.0f),
				this._yAxis - this._operation (7.0f, 12.0f)
			)
		);
		sensors.add ( // Sensor 4
			new Sensor (
				"S_4",
				this._xAxis + this._operation (9.0f, 20.0f),
				this._yAxis - this._operation (5.0f, 12.0f)
			)
		);
		sensors.add ( // Sensor 5
			new Sensor (
				"S_5",
				this._xAxis + this._operation (9.0f, 20.0f),
				this._yAxis + this._operation (1.0f, 4.0f)
			)
		);
		sensors.add ( // Sensor 6
			new Sensor (
				"S_6",
				this._xAxis + this._operation (19.0f, 20.0f),
				this._yAxis + this._operation (3.0f, 4.0f) - 15
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
		return this._operation (29.0f, 10.0f);
	}
	public float getHeight () {
		return this._operation (3.0f, 2.0f);
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

	private GImageButton _temp;

	private ArrayList<GImageButton> _buttons = new ArrayList<GImageButton> ();

	private String [][] _buttonSprite = new String [][] {
		{"number 1.png", "number 1.png", "number 1 click.png"},
		{"number 2.png", "number 2.png", "number 2 click.png"},
		{"number 3.png", "number 3.png", "number 3 click.png"},
		{"number 4.png", "number 4.png", "number 4 click.png"},
		{"number 5.png", "number 5.png", "number 5 click.png"},
		{"number 6.png", "number 6.png", "number 6 click.png"},
		{"number 7.png", "number 7.png", "number 7 click.png"},
		{"number 8.png", "number 8.png", "number 8 click.png"},
		{"number 9.png", "number 9.png", "number 9 click.png"},
		{"back.png", "back.png", "back click.png"},
		{"number 0.png", "number 0.png", "number 0 click.png"},
		{"new.png", "new.png", "new click.png"},
	};

	public Dial (PApplet applet, float xAxis, float yAxis) {
		this._xAxis = xAxis;
		this._yAxis = yAxis;

		this._numberSize       = 64.0f;
		this._numberSeparation = 16.0f;
		this._rows             = 4.0f;
		this._colums           = 3.0f;

		this._dialWidth  = (
			(this._numberSize * this._colums) +
			(this._numberSeparation * (this._colums - 1))
		);
		this._dialHeight = (
			(this._numberSize * this._rows) +
			(this._numberSeparation * (this._rows - 1))
		);
		
		this._PApplet = applet;
	}

	public void createButtons () {
		for (float rowIndex = 0.0f; rowIndex < this._rows; ++rowIndex) {
			for (float columIndex = 0.0f; columIndex < this._colums; ++columIndex) {
				this._temp = new GImageButton (
					this._PApplet,
					PApplet.parseInt ( // xAxis
						this._xAxis -
						((1.0f/2.0f) * this._dialWidth) +
						(columIndex * this._numberSize) +
						(columIndex * this._numberSeparation)
					),
					PApplet.parseInt ( // yAxis
						this._yAxis -
						((1.0f/2.0f) * this._dialHeight) +
						(rowIndex * this._numberSize) +
						(rowIndex * this._numberSeparation)
					),
					this._buttonSprite [ // String []
						PApplet.parseInt (
							(rowIndex * this._colums) +
							columIndex
						)
					],
					"Dial alpha mask.png"
				);
				this._temp.tagNo = PApplet.parseInt (
					(rowIndex * this._colums) +
					columIndex
				);

				this._buttons.add (this._temp);
			}
		}
		for (GImageButton _button : this._buttons) {
			_button.addEventHandler (this._PApplet, "buttonClick");
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
