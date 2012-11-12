package stratego;

public class GamePiece
{

    private int x;
    private int y;

    public GamePiece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /***
     *Returns the x position.
     *@return x is the x position.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y position.
     * @return y is the y position.
     */
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * This is used by subclasses to move the piece.
     */
    protected void setPosition(int newx, int newy) {
        this.x = newx;
        this.y = newy;
    }

}
