package stratego;

/**
 * // -------------------------------------------------------------------------
/**
 * This is the scout game piece, note that the move method allows movement in
 * for more than 1 square.
 *
 *  @author J
 *  @version Nov 11, 2012
 */
public class Scout
    extends Soldier
{

    public Scout(int x, int y, int rank)
    {
        super(x, y, rank);
    }

    @Override
    public int move(int newx, int newy) {
        if(newx != getX() && newy != getY()) {
            return -1;
        }
        else {
            setPosition(newx, newy);
            return 0;
        }
    }
}
