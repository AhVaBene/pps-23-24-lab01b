package e1;

public interface MovementLogics {

    public void setKnightPosition(Pair<Integer, Integer> knightPos);
    public Pair<Integer, Integer> getKnightPosition();
    public void setPawnPosition(Pair<Integer, Integer> pawnPos);
    public Pair<Integer, Integer> getPawnPosition();
    public void moveKnight(int row, int col);
    public boolean hasHit();
}
