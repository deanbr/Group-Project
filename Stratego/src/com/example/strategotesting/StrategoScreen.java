package com.example.strategotesting;

import android.widget.Toast;
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
    private int redPieces;

    public void initialize() {
        model = new GameboardModel();
        cellSize = Math.min(this.getWidth(), this.getHeight()) / 7;
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

    public void setPieces() {
        Toast.makeText(this, "Red Player Place Your Pieces", Toast.LENGTH_LONG).show();

    }
}
