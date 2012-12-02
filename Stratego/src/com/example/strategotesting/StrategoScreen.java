package com.example.strategotesting;

import android.widget.Button;
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
    private GameboardModel model;
    private TextShape ts;

    private boolean hasBeenSet;
    private boolean redMove = true;
    private int pieceType = 1;
    private Button newGame;

    /**
     * This method is run initially. It does very little other than some base
     * startup.
     */
    public void initialize() {
        cellSize = Math.min(this.getWidth(), this.getHeight()) / size;
        screenText = new TextShape[size][size];

        float x1 = 0;
        float y1 = 0;
        float x2 = cellSize;
        float y2 = cellSize;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //This centers the text in the middle of the squre. Do not
                //mess with it!
                ts = new TextShape("", (x1 + 20f), (y1 + 20f));
                RectangleShape rs = new RectangleShape(x1, y1, x2, y2);
                rs.setColor(Color.black);
                y1 += cellSize;
                y2 += cellSize;
                screenText[i][j] = ts;
                add(ts);
                add(rs);
            }
            x1 += cellSize;
            x2 += cellSize;
            y1 = 0;
            y2 = cellSize;
        }
    }

    public void setRedPieces() {
        pieceType = 1;
        //for (int i = 0; i < 1; i++) {
            Toast.makeText(this, "Place Your Marshal", Toast.LENGTH_SHORT).show();
          //  while (!hasBeenSet) {
                //Has to be empty
            //}
       // }
        /**
        pieceType = 2;
        hasBeenSet = false;
        for (int i = 0; i < 1; i++) {
            Toast.makeText(this, "Place Your General", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 3;
        hasBeenSet = false;
        for (int i = 0; i < 2; i++) {
            Toast.makeText(this, "Place Your Colonel", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 4;
        hasBeenSet = false;
        for (int i = 0; i < 3; i++) {
            Toast.makeText(this, "Place Your Major", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 5;
        hasBeenSet = false;
        for (int i = 0; i < 4; i++) {
            Toast.makeText(this, "Place Your Captain", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 6;
        hasBeenSet = false;
        for (int i = 0; i < 4; i++) {
            Toast.makeText(this, "Place Your Lieutenant", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 7;
        hasBeenSet = false;
        for (int i = 0; i < 4; i++) {
            Toast.makeText(this, "Place Your Sergeant", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 8;
        hasBeenSet = false;
        for (int i = 0; i < 5; i++) {
            Toast.makeText(this, "Place Your Miner", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 9;
        hasBeenSet = false;
        for (int i = 0; i < 8; i++) {
            Toast.makeText(this, "Place Your Scout", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 10;
        hasBeenSet = false;
        for (int i = 0; i < 8; i++) {
            Toast.makeText(this, "Place Your Spy", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 11;
        hasBeenSet = false;
        for (int i = 0; i < 8; i++) {
            Toast.makeText(this, "Place Your Bombs", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }

        pieceType = 12;
        hasBeenSet = false;
        for (int i = 0; i < 8; i++) {
            Toast.makeText(this, "Place Your Flag", Toast.LENGTH_SHORT).show();
            while (!hasBeenSet) {
                //Has to be empty
            }
        }
        redMove = false;
        hasBeenSet = false;**/
    }

    /**
     * This method handles the user pressing the screen in the shape area.
     * @param me is the motion event.
     */
    public void onTouchDown(MotionEvent me) {
        int x = (int) (me.getX() / cellSize);
        int y = (int) (me.getY() / cellSize);
        if (!hasBeenSet && redMove) {
            playerSetPiece(x, y);
        }
        else if (!hasBeenSet && !redMove) {
            playerSetPiece(x, y);
         }
        else if (hasBeenSet && redMove) {
            //Red's normal move
        }
        else {
            //Blue's normal move
        }
        System.out.println("X: " + x + " Y: " + y);
    }

    /**
     * This method handles the red player setting his pieces in the beginnning.
     * @param x is the x position.
     * @param y is the y position.
     */
    private void playerSetPiece(int x, int y) {
        Color textcolor = Color.red;
        if (!redMove) {
            textcolor = Color.blue;
        }
        if (y <= 9 && y >= 6 && model.getPiece(x, y) == null) {
            model.setPiece(x, y, 0, pieceType);
            screenText[x][y].setText(model.getPiece(x, y).toStringShort());
            screenText[x][y].setColor(textcolor);
            hasBeenSet = true;
        }
    }

    /**
     * This initializes a new game when clicked.
     */
    public void newGameClicked() {
        model = new GameboardModel();
        hasBeenSet = false;
        setRedPieces();
    }
}
