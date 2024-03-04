package e1;

import java.util.Random;

public class MovementLogicsImpl implements MovementLogics {

    private Pair<Integer, Integer> knightPosition;
    private Pair<Integer, Integer> pawnPosition;
    private final Random random = new Random();

    public MovementLogicsImpl(int size) {
        this.setPawnPosition(this.randomEmptyPosition(size));
        this.setKnightPosition(this.randomEmptyPosition(size));
    }

    public MovementLogicsImpl(Pair<Integer, Integer> knightPosition, Pair<Integer, Integer> pawnPosition) {
        this.knightPosition = knightPosition;
        this.pawnPosition = pawnPosition;
    }
    
    private final Pair<Integer,Integer> randomEmptyPosition(int size) {
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawnPosition!=null && this.pawnPosition.equals(pos) ? randomEmptyPosition(size) : pos;
    }

    @Override
    public void setKnightPosition(Pair<Integer, Integer> knightPosition) { this.knightPosition = knightPosition; }

    @Override
    public Pair<Integer, Integer> getKnightPosition() { return this.knightPosition; }

    @Override
    public void setPawnPosition(Pair<Integer, Integer> pawnPosition) { this.pawnPosition = pawnPosition; }

    @Override
    public Pair<Integer, Integer> getPawnPosition() { return this.pawnPosition; }

    @Override
    public void moveKnight(int row, int col) {
        int x = row-this.knightPosition.getX();
		int y = col-this.knightPosition.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.setKnightPosition(new Pair<>(row,col));
        }
    }

    @Override
    public boolean hasHit() { return this.knightPosition.equals(this.pawnPosition); }
}
