package com.example.strategotesting;

import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.MotionEvent;
import sofia.graphics.RectangleShape;
import sofia.graphics.Color;
import sofia.graphics.TextShape;
import sofia.app.ShapeScreen;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the GUI of our stratego project.
 * 0 is Red team
 * 1 is Blue team
 *
 *  @author J
 *  @version Dec 1, 2012
 */
public class StrategoScreen
    extends ShapeScreen
{

    private float cellSize;
    private int size = 10;
    private TextShape[][] screenText;
    private RectangleShape[][] screenMap;
    private GameboardModel model;

    private final int invisible = 4;
    private final int visible = 0;
    private boolean hasBeenSet = false;
    private boolean redMove = true;
    private int pieceType = 1;

    private Spinner piecesOptions;
    //private String[] opts = {"Marshal", "General", "Colonel" ,"Major" ,"Captain"
       // ,"Lieutenant", "Sergeant", "Miner", "Scout", "Spy", "Bomb", "Flag" };

    public void initialize() {
       /** ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, opts);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        piecesOptions.setAdapter(aa);
        piecesOptions.setVisibility(invisible);**/

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
        setRedPieces();
    }

    public void setRedPieces() {
        pieceType = 1;
        for (int i = 0; i < 1; i++) {
            Toast.makeText(this, "Place Your Marshal", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 2;
        hasBeenSet = false;
        for (int i = 0; i < 1; i++) {
            Toast.makeText(this, "Place Your General", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 3;
        hasBeenSet = false;
        for (int i = 0; i < 2; i++) {
            Toast.makeText(this, "Place Your Colonel", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 4;
        hasBeenSet = false;
        for (int i = 0; i < 3; i++) {
            Toast.makeText(this, "Place Your Major", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 5;
        hasBeenSet = false;
        for (int i = 0; i < 4; i++) {
            Toast.makeText(this, "Place Your Captain", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 6;
        hasBeenSet = false;
        for (int i = 0; i < 4; i++) {
            Toast.makeText(this, "Place Your Lieutenant", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 7;
        hasBeenSet = false;
        for (int i = 0; i < 4; i++) {
            Toast.makeText(this, "Place Your Sergeant", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 8;
        hasBeenSet = false;
        for (int i = 0; i < 5; i++) {
            Toast.makeText(this, "Place Your Miner", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 9;
        hasBeenSet = false;
        for (int i = 0; i < 8; i++) {
            Toast.makeText(this, "Place Your Scout", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 10;
        hasBeenSet = false;
        for (int i = 0; i < 8; i++) {
            Toast.makeText(this, "Place Your Spy", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 11;
        hasBeenSet = false;
        for (int i = 0; i < 8; i++) {
            Toast.makeText(this, "Place Your Bombs", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 12;
        hasBeenSet = false;
        for (int i = 0; i < 8; i++) {
            Toast.makeText(this, "Place Your Flag", Toast.LENGTH_SHORT).show();
            while (hasBeenSet) {
                //Has to be empty
            }
        }
        redMove = false;
    }

    public void onTouchDown(MotionEvent me) {
        int x = (int) (me.getX() / cellSize);
        int y = (int) (me.getY() / cellSize);
        if (!hasBeenSet && redMove) {
           if (y <= 9 && y >= 6 && model.getPiece(x, y) == null) {
               model.setPiece(x, y, 0, pieceType);
               hasBeenSet = true;
           }
        }
    }

}
