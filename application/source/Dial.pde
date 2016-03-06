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

		this._numberSize       = 64.0;
		this._numberSeparation = 16.0;
		this._rows             = 4.0;
		this._colums           = 3.0;

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
		for (float rowIndex = 0.0; rowIndex < this._rows; ++rowIndex) {
			for (float columIndex = 0.0; columIndex < this._colums; ++columIndex) {
				this._temp = new GImageButton (
					this._PApplet,
					int ( // xAxis
						this._xAxis -
						((1.0/2.0) * this._dialWidth) +
						(columIndex * this._numberSize) +
						(columIndex * this._numberSeparation)
					),
					int ( // yAxis
						this._yAxis -
						((1.0/2.0) * this._dialHeight) +
						(rowIndex * this._numberSize) +
						(rowIndex * this._numberSeparation)
					),
					this._buttonSprite [ // String []
						int (
							(rowIndex * this._colums) +
							columIndex
						)
					],
					"Dial alpha mask.png"
				);
				this._temp.tagNo = int (
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