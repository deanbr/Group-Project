package com.example.strategotesting;

import java.util.ArrayList;
import android.widget.Button;
import android.widget.Toast;
import android.view.MotionEvent;
import sofia.graphics.RectangleShape;
import sofia.graphics.Color;
import sofia.graphics.TextShape;
import sofia.app.ShapeScreen;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the GUI of our stratego project.
 * 0 is Blue team
 * 1 is Red team
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
    private ArrayList<GamePiece> piecesToCover;

    private int totalSetPieces = 0;
    private boolean hasBeenSet;
    private boolean redMove = true;
    private int pieceType = 1;
    private Button newGame;
    private GamePiece selectedPiece;
    private boolean selectedPieceIsSelected = false;
    private boolean newGameWasClickedOnce = false;


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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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

    /**
     * This method is used to set the red players pieces.
     */
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
                redMove = false;
                coverPieces();
                totalSetPieces = 0;
                pieceType = 1;
                isBlueSet();
            }
        }
    }

    /**
     * This method is used to set the blue players pieces.
     */
    public void isBlueSet() {
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
                redMove = true;
                coverPieces();
                unCoverPieces();
                hasBeenSet = true;
                totalSetPieces = 0;
            }
        }
    }

    /**
     * This method handles the user pressing the screen in the shape area.
     * @param me is the motion event.
     */
    public void onTouchDown(MotionEvent me) {
        if (newGameWasClickedOnce && !model.getIsGameOver()) {
            int x = (int) (me.getX() / cellSize);
            int y = (int) (me.getY() / cellSize);
            if (!hasBeenSet && redMove) {
                playerSetPiece(x, y);
            }
            else if (!hasBeenSet && !redMove) {
                playerSetPiece(x, y);
            }
            else if (hasBeenSet && redMove) {
                if (selectedPieceIsSelected) {
                    movePiece(x, y);
                }
                else if (model.getPiece(x, y) != null && model.getPiece(x, y).getTeam() == 1){
                    if (model.getPiece(x, y).getRank() != 11 && model.getPiece(x, y).getRank() != 12) {
                        selectedPiece =  model.getPiece(x, y);
                        selectedPieceIsSelected = true;
                    }
                }
            }
            else {
                if (selectedPieceIsSelected) {
                    movePiece(x, y);
                }
                else if (model.getPiece(x, y) != null && model.getPiece(x, y).getTeam() == 0){
                    if (model.getPiece(x, y).getRank() != 11 && model.getPiece(x, y).getRank() != 12) {
                        selectedPiece = model.getPiece(x, y);
                        selectedPieceIsSelected = true;
                    }
                }
            }
        }
    }

    /**
     * This method handles the red player setting his pieces in the beginning.
     * @param x is the x position.
     * @param y is the y position.
     */
    private void playerSetPiece(int x, int y) {
        if (!redMove && y >= 0 && y <= 3 && model.getPiece(x, y) == null) {
            model.setPiece(x, y, 0, pieceType);
            screenText[x][y].setText(model.getPiece(x, y).toStringShort());
            screenText[x][y].setColor(Color.blue);
            totalSetPieces++;
            isBlueSet();
        }
        else if (redMove && y <= 9 && y >= 6 && model.getPiece(x, y) == null) {
            model.setPiece(x, y, 1, pieceType);
            screenText[x][y].setText(model.getPiece(x, y).toStringShort());
            screenText[x][y].setColor(Color.red);
            totalSetPieces++;
            isRedSet();
        }

    }

    /**
     * This method handles the player action choices.
     */
    private void movePiece(int x, int y) {
        int res;
        int oldX = selectedPiece.getX();
        int oldY = selectedPiece.getY();
        Color textColor;
        if (redMove && selectedPiece.getTeam() == 1) {
             res = model.movement(selectedPiece, x, y);
             textColor = Color.red;
        }
        else if (!redMove && selectedPiece.getTeam() == 0) {
            res = model.movement(selectedPiece, x, y);
            textColor = Color.blue;
        }
        else {
            res = -1;
            textColor = Color.red;
        }
        switch (res) {
            case 0:
                screenText[oldX][oldY].setText("");
                screenText[x][y].setText(model.getPiece(x, y).toStringShort());
                screenText[x][y].setColor(textColor);
                if (model.getIsGameOver()) {
                    Toast.makeText(this, "Game Over!", Toast.LENGTH_LONG).show();
                    switchTurn();
                    unCoverPieces();
                }
                else {
                    switchTurn();
                    coverPieces();
                    unCoverPieces();
                }
            break;

            case 1:
                screenText[oldX][oldY].setText("");
                screenText[x][y].setText("");
                switchTurn();
                coverPieces();
                unCoverPieces();
            break;

            case -1:
                selectedPieceIsSelected = false;
            break;

            case -2:
                screenText[oldX][oldY].setText("");
                switchTurn();
                coverPieces();
                unCoverPieces();
            break;
        }
        selectedPieceIsSelected = false;

    }

    /**
     * This is a simple logic statement to swap turns.
     */
    public void switchTurn() {
        if (redMove) {
            redMove = false;
        }
        else {
            redMove = true;
        }
    }

    /**
     * This initializes a new game when clicked.
     */
    public void newGameClicked() {
        model = new GameboardModel();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                screenText[i][j].setText(" ");
            }
        }
        hasBeenSet = false;
        newGameWasClickedOnce = true;//this is a simple fix to prevent the game from breaking if the user selects the grid before instantiating the objects.
        Toast.makeText(this, "Red player set your pieces", Toast.LENGTH_SHORT).show();
        isRedSet();
    }

    /**
     * This method covers the pieces of the player whose turn it is not.
     */
    public void coverPieces() {
        String team;
        Color textColor;
        if (redMove) {
            piecesToCover = model.returnBluePieces();
            team = "Blu";
            textColor = Color.blue;
        }
        else {
            piecesToCover = model.returnRedPieces();
            team = "Red";
            textColor = Color.red;
        }
        for (int i = 0; i < piecesToCover.size(); i++) {
            screenText[piecesToCover.get(i).getX()][piecesToCover.get(i).getY()].setText(team);
            screenText[piecesToCover.get(i).getX()][piecesToCover.get(i).getY()].setColor(textColor);
        }
    }

    /**
     * This method uncovers the pieces of the player whose turn it is.
     */
    public void unCoverPieces() {
        if (redMove) {
            piecesToCover = model.returnRedPieces();
        }
        else {
            piecesToCover = model.returnBluePieces();
        }
        String piece;
        for (int i = 0; i < piecesToCover.size(); i++) {
            piece = piecesToCover.get(i).toStringShort();
            screenText[piecesToCover.get(i).getX()][piecesToCover.get(i).getY()].setText(piece);
        }
    }
}