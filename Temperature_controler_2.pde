// Imports
import g4p_controls.*;
import processing.core.PApplet;

// Classes
Complex complex;
Dial dial;


//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//

void setup() {
	size       (800, 480, JAVA2D);
	noFill     ();
	stroke     (255);
	background (20);
	frameRate  (60);

	complex = new Complex ((1.0/4.0) * width);
	complex.setCoors      ((complex.getWidth () / 2) + 10, (complex.getHeight () / 2) + 10);
	complex.createRooms   ();
	complex.createSensors ();

	dial = new Dial (width / 2.0, height / 2.0);
	dial.createButtons ();

	// complex.render ();
	// createGUI ();
}

void draw() {
	background(170);
	// complex.render ();
}

//- ## P R O C E S S I N G   S T A N D A R S ######################################################## -//
//- ################################################################################################# -//
