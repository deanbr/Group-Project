package com.example.strategotesting;

import android.widget.EditText;
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

    private int totalSetPieces = 0;
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

    public void isRedSet() {
        if (!hasBeenSet) {
            if (totalSetPieces < 1) {
                pieceType = 1;
                Toast.makeText(this, "Set your Marshal", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 2) {
                pieceType = 2;
                Toast.makeText(this, "Set your General", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 4) {
                pieceType = 3;
                Toast.makeText(this, "Set your Colonel", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 7) {
                pieceType = 4;
                Toast.makeText(this, "Set your Major", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 11) {
                pieceType = 5;
                Toast.makeText(this, "Set your Captain", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 15) {
                pieceType = 6;
                Toast.makeText(this, "Set your Lieutenant", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 19) {
                pieceType = 7;
                Toast.makeText(this, "Set your Sergeant", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 24) {
                pieceType = 8;
                Toast.makeText(this, "Set your Miner", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 32) {
                pieceType = 9;
                Toast.makeText(this, "Set your Scout", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 33) {
                pieceType = 10;
                Toast.makeText(this, "Set your Spy", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 39) {
                pieceType = 11;
                Toast.makeText(this, "Set your Bomb", Toast.LENGTH_SHORT).show();
            }
            else if (totalSetPieces < 40) {
                pieceType = 12;
                Toast.makeText(this, "Set your Flag", Toast.LENGTH_SHORT).show();
            }
            else {

            }
        }
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
    }

    /**
     * This method handles the red player setting his pieces in the beginnning.
     * @param x is the x position.
     * @param y is the y position.
     */
    private void playerSetPiece(int x, int y) {
        if (!redMove && y >= 0 && y <= 3) {
            model.setPiece(x, y, 1, pieceType);
            screenText[x][y].setText(model.getPiece(x, y).toStringShort());
            screenText[x][y].setColor(Color.blue);
            totalSetPieces++;
        }
        else if (y <= 9 && y >= 6 && model.getPiece(x, y) == null) {
            model.setPiece(x, y, 0, pieceType);
            screenText[x][y].setText(model.getPiece(x, y).toStringShort());
            screenText[x][y].setColor(Color.red);
            totalSetPieces++;
            isRedSet();
            //hasBeenSet = true;
        }

    }

    /**
     * This initializes a new game when clicked.
     */
    public void newGameClicked() {
        model = new GameboardModel();
        hasBeenSet = false;
        isRedSet();
    }
}
