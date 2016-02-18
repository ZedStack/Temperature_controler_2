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

	// private ArrayList<GImageButton> buttons = new ArrayList<GImageButton> ();
	private GImageButton [] _button;
	public  GImageButton testButton;

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

		this._numberSize       = 64.0;
		this._numberSeparation = 16.0;
		// this._rows             = 1.0;
		this._rows             = 4.0;
		// this._colums           = 1.0;
		this._colums           = 3.0;

		this._dialWidth  = (this._numberSize * this._colums) + (this._numberSeparation * (this._colums - 1));
		this._dialHeight = (this._numberSize * this._rows) + (this._numberSeparation * (this._rows - 1));

		this._button = new GImageButton [int (this._rows * this._colums)];
	}

	// public void buttonEvent (GImageButton source, GEvent event) {
	// 	println("testButton - GImageButton >> GEvent." + event + " @ " + millis());
	// }
	// public void createButtons () {
	// 	testButton = new GImageButton (
	// 		this._PApplet,
	// 		this._xAxis,
	// 		this._yAxis,
	// 		new String [] {"number 1.png", "number 1.png", "number 1.png"},
	// 		"Dial alpha mask.png"
	// 	);
	// 	testButton.addEventHandler (this._PApplet, "buttonEvent");
	// }

	public void createButtons () {
		for (float columIndex = 0.0; columIndex < this._colums; ++columIndex) {
			for (float rowIndex = 0.0; rowIndex < this._rows; ++rowIndex) {
				rect (
					this._xAxis - ((1.0/2.0) * this._dialWidth) + (columIndex * this._numberSize) + (columIndex * this._numberSeparation),
					this._yAxis - ((1.0/2.0) * this._dialHeight) + (rowIndex * this._numberSize) + (rowIndex * this._numberSeparation),
					this._numberSize,
					this._numberSize
				);
			}
		}
	}

	// public void createButtons () {
	// 	for (float rowIndex = 0.0; rowIndex < this._rows; ++rowIndex) {
	// 		for (float columIndex = 0.0; columIndex < this._colums; ++columIndex) {
	// 			buttons.add (
	// 				new GImageButton ( // Error: NullPointExeption
	// 					this._PApplet,
	// 					// this._xAxis,
	// 					// this._yAxis,
	// 					int (this._xAxis - ((1.0/2.0) * this._dialWidth) + (rowIndex * this._numberSize) + (rowIndex * this._numberSeparation)),
	// 					int (this._yAxis - ((1.0/2.0) * this._dialHeight) + (columIndex * this._numberSize) + (columIndex * this._numberSeparation)),
	// 					this._buttonSprite [int ((this._colums * columIndex) + rowIndex)],
	// 					"Dial alpha mask.png"
	// 				)
	// 			);
	// 		}
	// 	}
	// }
	
	// public void createButtons () {
	// 	for (float rowIndex = 0.0; rowIndex < this._rows; ++rowIndex) {
	// 		for (float columIndex = 0.0; columIndex < this._colums; ++columIndex) {
	// 			this._button [int ((this._colums * columIndex) + rowIndex)] = new GImageButton (
	// 				this._PApplet,
	// 				int (this._xAxis - ((1.0/2.0) * this._dialWidth) + (rowIndex * this._numberSize) + (rowIndex * this._numberSeparation)),
	// 				int (this._yAxis - ((1.0/2.0) * this._dialHeight) + (columIndex * this._numberSize) + (columIndex * this._numberSeparation)),
	// 				// this._buttonSprite [int ((this._colums * columIndex) + rowIndex)],
	// 				// this._buttonSprite [0],
	// 				new String [] {"number 1.png", "number 1.png", "number 1.png"},
	// 				"Dial alpha mask.png"
	// 			);
	// 		}
	// 	}
	// }
}