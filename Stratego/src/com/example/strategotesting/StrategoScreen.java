package com.example.strategotesting;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.MotionEvent;
import sofia.graphics.RectangleShape;
import sofia.graphics.Color;
import sofia.graphics.TextShape;
import sofia.app.ShapeScreen;

public class StrategoScreen
    extends ShapeScreen
{

    private float cellSize;
    private int size = 10;
    private TextShape[][] screenText;
    private RectangleShape[][] screenMap;
    private GameboardModel model;
    private boolean redPlacement;
    private int redPieces;
    private final int invisible = 4;
    private final int visible = 0;

    private Spinner piecesOptions;
    private String[] opts = {"Marshal", "General", "Colonel" ,"Major" ,"Captain"
        ,"Lieutenant", "Sergeant", "Miner", "Scout", "Spy", "Bomb", "Flag" };

    public void initialize() {
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opts);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        piecesOptions.setAdapter(aa);
        piecesOptions.setVisibility(invisible);

        redPlacement = true;
        model = new GameboardModel();
        cellSize = Math.min(this.getWidth(), this.getHeight()) / size;
        screenText = new TextShape[size][size];
        screenMap = new RectangleShape[size][size];

        float x1 = 0;
        float y1 = 0;
        float x2 = cellSize;
        float y2 = cellSize;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextShape ts = new TextShape("", x1, y1);
                RectangleShape rs = new RectangleShape(x1, y1, x2, y2);
                rs.setColor(Color.black);
                y1 += cellSize;
                y2 += cellSize;
                screenText[i][j] = ts;
                screenMap[i][j] = rs;
                add(ts);
                add(rs);
            }
            x1 += cellSize;
            x2 += cellSize;
            y1 = 0;
            y2 = cellSize;
        }
    }

    public void onTouchDown(MotionEvent me) {
        if (redPlacement) {
            int x = (int) (me.getX() / cellSize);
            int y = (int) (me.getY() / cellSize);
            setPieces();
        }
    }

    public void setPieces() {
        System.out.println(piecesOptions.getSelectedItemPosition());
    }
}
