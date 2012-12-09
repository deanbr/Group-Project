package com.example.strategotesting;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.graphics.RectF;
import android.widget.ImageView;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import java.io.InputStream;
import sofia.graphics.Image;
import sofia.graphics.ImageShape;
import android.widget.TextView;
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
 * Credit to http://www.edcollins.com/stratego/stratego-rules-later.htm
 * for the images for all of the pieces.
 *
 *  @author J
 *  @version Dec 1, 2012
 */
public class StrategoScreen
    extends ShapeScreen
{

    private float cellSize;
    private int size = 10;
    //private TextShape[][] screenText;
    private GameboardModel model;
    //private TextShape ts;
    private ArrayList<GamePiece> piecesToCover;

    private int totalSetPieces = 0;
    private boolean hasBeenSet;
    private boolean redMove = true;
    private int pieceType = 1;
    //private Button newGame;
    //private Button endGame;
    private GamePiece selectedPiece;
    private boolean selectedPieceIsSelected = false;
    private boolean newGameWasClickedOnce = false;

    private TextView playerMessage;
    private TextView teamMessage;
    private ImageShape[][] screenImages;
    private ImageShape screenImage;
    private RectangleShape rs;
    private RectangleShape[][] boardCells;


    /**
     * This method is run initially. It does very little other than some base
     * startup.
     */
    public void initialize() {
        playerMessage = (TextView)findViewById(R.id.playerMessage);
        playerMessage.setText("");
        teamMessage = (TextView)findViewById(R.id.teamMessage);
        teamMessage.setText("");

        cellSize = Math.min(this.getWidth(), this.getHeight()) / size;
        screenImages = new ImageShape[size][size];
        boardCells = new RectangleShape[size][size];

        float x1 = 0;
        float y1 = 0;
        float x2 = cellSize;
        float y2 = cellSize;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //This centers the text in the middle of the cell
                //ts = new TextShape("", (x1 + 20f), (y1 + 20f));

                screenImage = new ImageShape("blank", new RectF(x1, y1, x2, y2));

                rs = new RectangleShape(x1, y1, x2, y2);
                rs.setColor(Color.black);
                y1 += cellSize;
                y2 += cellSize;
                screenImages[i][j] = screenImage;
                boardCells[i][j] = rs;

                add(rs);
                add(screenImage);

                //add(ts);

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
                playerMessage.setText("Set your Marshal \n(#1, 1 piece)");
            }
            else if (totalSetPieces < 2) {
                pieceType = 2;
                playerMessage.setText("Set your General \n(#2, 1 pieces)");
            }
            else if (totalSetPieces < 4) {
                pieceType = 3;
                playerMessage.setText("Set your Colonel \n(#3, 2 pieces)");
            }
            else if (totalSetPieces < 7) {
                pieceType = 4;
                playerMessage.setText("Set your Major \n(#4, 3 pieces)");
            }
            else if (totalSetPieces < 11) {
                pieceType = 5;
                playerMessage.setText("Set your Captain \n(#5, 4 pieces)");
            }
            else if (totalSetPieces < 15) {
                pieceType = 6;
                playerMessage.setText("Set your Liutenant \n(#6, 4 pieces)");
            }
            else if (totalSetPieces < 19) {
                pieceType = 7;
                playerMessage.setText("Set your Sergeant \n(#7, 4 pieces)");
            }
            else if (totalSetPieces < 24) {
                pieceType = 8;
                playerMessage.setText("Set your Miner \n(#8, 5 pieces)");
            }
            else if (totalSetPieces < 32) {
                pieceType = 9;
                playerMessage.setText("Set your Scout \n(#9, 8 pieces)");
            }
            else if (totalSetPieces < 33) {
                pieceType = 10;
                playerMessage.setText("Set your Spy \n(#10, 1 piece)");
            }
            else if (totalSetPieces < 39) {
                pieceType = 11;
                playerMessage.setText("Set your Bombs \n(6 pieces)");
            }
            else if (totalSetPieces < 40) {
                pieceType = 12;
                playerMessage.setText("Set your Flag");
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
        teamMessage.setText("Blue Player set your pieces");
        if (!hasBeenSet) {
            if (totalSetPieces < 1) {
                pieceType = 1;
                playerMessage.setText("Set your Marshal \n(#1, 1 piece)");
            }
            else if (totalSetPieces < 2) {
                pieceType = 2;
                playerMessage.setText("Set your General \n(#2, 1 piece)");
            }
            else if (totalSetPieces < 4) {
                pieceType = 3;
                playerMessage.setText("Set your Colonel \n(#3, 2 pieces)");
            }
            else if (totalSetPieces < 7) {
                pieceType = 4;
                playerMessage.setText("Set your Major \n(#4, 3 pieces)");
            }
            else if (totalSetPieces < 11) {
                pieceType = 5;
                playerMessage.setText("Set your Captain \n(#5, 4 pieces)");
            }
            else if (totalSetPieces < 15) {
                pieceType = 6;
                playerMessage.setText("Set your Lieutenant \n(#6, 4 pieces)");
            }
            else if (totalSetPieces < 19) {
                pieceType = 7;
                playerMessage.setText("Set your Sergeant \n(#7, 4 pieces)");
            }
            else if (totalSetPieces < 24) {
                pieceType = 8;
                playerMessage.setText("Set your Miner \n(#8, 5 pieces)");
            }
            else if (totalSetPieces < 32) {
                pieceType = 9;
                playerMessage.setText("Set your Scout \n(#9, 8 pieces)");
            }
            else if (totalSetPieces < 33) {
                pieceType = 10;
                playerMessage.setText("Set your Spy \n(1 piece)");
            }
            else if (totalSetPieces < 39) {
                pieceType = 11;
                playerMessage.setText("Set your Bombs \n(6 bombs)");
            }
            else if (totalSetPieces < 40) {
                pieceType = 12;
                playerMessage.setText("Set your Flag");
            }
            else {
                redMove = true;
                teamMessage.setText("Red's Turn");
                playerMessage.setText("");
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
                        //screenText[x][y].setColor(Color.yellow);
                        screenImages[x][y].setColor(Color.yellow);
                        selectedPieceIsSelected = true;
                    }
                }
            }
            else { // if hasBeenSet && !redMove
                if (selectedPieceIsSelected) {
                    movePiece(x, y);
                }
                else if (model.getPiece(x, y) != null && model.getPiece(x, y).getTeam() == 0){
                    if (model.getPiece(x, y).getRank() != 11 && model.getPiece(x, y).getRank() != 12) {
                        selectedPiece = model.getPiece(x, y);
                        //screenText[x][y].setColor(Color.yellow);
                        screenImages[x][y].setColor(Color.yellow);
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

            screenImages[x][y].setImage(model.getPiece(x, y).toString().toLowerCase());
            screenImages[x][y].setColor(Color.lightBlue);
            boardCells[x][y].setFilled(true);
            boardCells[x][y].setFillColor(Color.lightBlue);


            totalSetPieces++;
            isBlueSet();
        }
        else if (redMove && y <= 9 && y >= 6 && model.getPiece(x, y) == null) {
            model.setPiece(x, y, 1, pieceType);

            screenImages[x][y].setImage(model.getPiece(x, y).toString().toLowerCase());
            screenImages[x][y].setColor(Color.red);
            boardCells[x][y].setFilled(true);
            boardCells[x][y].setFillColor(Color.red);

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
                screenImages[oldX][oldY].setImage("blank");
                screenImages[x][y].setImage(model.getPiece(x, y).toString().toLowerCase());
                screenImages[x][y].setColor(textColor);

                boardCells[oldX][oldY].setFilled(false);
                boardCells[x][y].setFilled(true);
                if(textColor.equals(Color.blue)) {
                    boardCells[x][y].setFillColor(Color.lightBlue);
                }
                else {
                    boardCells[x][y].setFillColor(Color.red);
                }

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
                screenImages[oldX][oldY].setImage("blank");
                screenImages[x][y].setImage("blank");
                boardCells[oldX][oldY].setFilled(false);
                boardCells[x][y].setFilled(false);
                switchTurn();
                coverPieces();
                unCoverPieces();
            break;

            case -1:
                selectedPieceIsSelected = false;
                if (redMove)
                {
                    screenImages[oldX][oldY].setColor(Color.red);
                    boardCells[oldX][oldY].setFilled(true);
                    boardCells[oldX][oldY].setFillColor(Color.red);
                }
                else
                {
                    screenImages[oldX][oldY].setColor(Color.lightBlue);
                    boardCells[oldX][oldY].setFilled(true);
                    boardCells[oldX][oldY].setFillColor(Color.lightBlue);
                }
            break;

            case -2:
                screenImages[oldX][oldY].setImage("blank");
                boardCells[oldX][oldY].setFilled(false);
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
            teamMessage.setText("Blue's Turn");
        }
        else {
            redMove = true;
            teamMessage.setText("Red's Turn");
        }
    }

    /**
     * This initializes a new game when clicked.
     */
    public void newGameClicked() {
        model = new GameboardModel();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                screenImages[i][j].setImage("blank");
                boardCells[i][j].setFilled(false);
            }
        }
            //screenText = new TextShape[10][10];
        hasBeenSet = false;
        newGameWasClickedOnce = true;
        totalSetPieces = 0;
        redMove = true;
        /*this is a simple fix to prevent the game from breaking if the
         * user selects the grid before instantiating the objects.
        */
        teamMessage.setText("Red player set your pieces");
        isRedSet();
    }

    /**
     * Ends the current game and resets the application.
     */
    public void endGameClicked()
    {
        model = new GameboardModel();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                screenImages[i][j].setImage("blank");
                boardCells[i][j].setFilled(false);
            }
        }
        playerMessage.setText("");
        teamMessage.setText("");
    }

    /**
     * Calls the StatisticsPopUp class to display a pop up window with
     * game statistics.
     */
    /*public void statisticsPopUpClicked() {
        System.out.println("IMMA ROLL OVER YOU BEEEEAAATCH!");
    }*/

    /**
     * This method covers the pieces of the player whose isn't playing that turn.
     */
    public void coverPieces() {
        String team;
        Color textColor;
        if (redMove) {
            piecesToCover = model.returnBluePieces();
            team = "backblue";
            textColor = Color.lightBlue;
        }
        else {
            piecesToCover = model.returnRedPieces();
            team = "backred";
            textColor = Color.red;
        }
        for (int i = 0; i < piecesToCover.size(); i++) {
            screenImages[piecesToCover.get(i).getX()][piecesToCover.get(i).getY()].setImage(team);
            screenImages[piecesToCover.get(i).getX()][piecesToCover.get(i).getY()].setColor(textColor);
            boardCells[piecesToCover.get(i).getX()][piecesToCover.get(i).getY()].setFilled(true);
            boardCells[piecesToCover.get(i).getX()][piecesToCover.get(i).getY()].setFillColor(textColor);
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
            screenImages[piecesToCover.get(i).getX()][piecesToCover.get(i).getY()].setImage(piecesToCover.get(i).toString().toLowerCase());
        }
    }

    /**
     * Allows access to the model.
     * @return The gameboard model
     */
    public GameboardModel getModel()
    {
        return model;
    }

    private PopupWindow pw;
    private TextView blueStats;
    private TextView redStats;
    private Button cancelPopUp;
    // ----------------------------------------------------------
    /**
     * When clicked, it launches pop up window above the board using the
     * layout in statisticspopup.xml
     */
    public void statisticsPopUpClicked() {
        try {
            LayoutInflater inflater = (LayoutInflater) StrategoScreen.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View layout = inflater.inflate(R.layout.statisticspopup,
                    (ViewGroup) findViewById(R.id.statisticspopup));
            // sets dimensions of window
            pw = new PopupWindow(layout, 300, 470, true);
            // centers window
            pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
            // set values of fields within window
            redStats = (TextView) layout.findViewById(R.id.redStats);
            blueStats = (TextView) layout.findViewById(R.id.blueStats);
            cancelPopUp = (Button) layout.findViewById(R.id.closeStats);
            cancelPopUp.setOnClickListener(closePopUp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private OnClickListener closePopUp = new OnClickListener() {
        public void onClick(View v) {
            pw.dismiss();
        }
    };

}