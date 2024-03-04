package e1;

public class LogicsImpl implements Logics {

	private final int size;
	private final MovementLogics movementLogics;
	 
    public LogicsImpl(int size) {
    	this.size = size;
		this.movementLogics = new MovementLogicsImpl(size);	
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPos, Pair<Integer, Integer> knightPos) {
		this.size = size;
		this.movementLogics = new MovementLogicsImpl(knightPos, pawnPos);	
	}
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		this.movementLogics.moveKnight(row, col);
		return movementLogics.hasHit();
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return new Pair<>(row,col).equals(this.movementLogics.getKnightPosition());
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return new Pair<>(row,col).equals(this.movementLogics.getPawnPosition());
	}
}
