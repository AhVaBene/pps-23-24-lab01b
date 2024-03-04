package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  private Logics logics;
  private int knightPosx = 1;
  private int knightPosy = 1;
  private int pawnPosx = 2;
  private int pawnPosy = 3;
  private Pair<Integer,Integer> knightPos = new Pair<>(knightPosx, knightPosy);
  private Pair<Integer,Integer> pawnPos = new Pair<>(pawnPosx, pawnPosy);
  private final static int SIZE = 5;

  @BeforeEach
  void BeforeEach() {
      this.logics = new LogicsImpl(SIZE, this.pawnPos, this.knightPos);
  }

  @Test
  public void testKnightPos() {
      assertTrue(this.logics.hasKnight(this.knightPosx, this.knightPosy));
  }

  @Test
  public void testPawnPos() {
    assertTrue(this.logics.hasPawn(this.pawnPosx, this.pawnPosy));
  }

  @Test
  public void testHasHit() {
    assertTrue(this.logics.hit(this.pawnPosx, this.pawnPosy));
  }
}
