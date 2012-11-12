package stratego;

import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;

public class StrategoScreen
    extends ShapeScreen
{
    private float width;
    private float height;
    private GameboardModel model;
    private int size = 10;
    private RectangleShape[][] screen;

    public StrategoScreen()
    {
        // TODO Auto-generated constructor stub
    }


    public void initialize() {
        this.width = this.getWidth();
        this.height = this.getHeight();
        screen = new RectangleShape[size][size];
        float x1 = 0;
        float x2 = width;
        float y1 = 0;
        float y2 = height;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                RectangleShape rect = new RectangleShape(x1, y1, x2, y2);
                add(rect);
                y1 += height;
                y2 += height;
            }
            x1 += width;
            x2 += width;
            y1 = 0;
            y2 = height;
        }
        restartGame();
    }

    public void restartGame() {
        model = new GameboardModel();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                screen[i][j].setColor(Color.black);
            }
        }
    }

}
