package e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovementLogicsTest {

    private MovementLogics logics;
    private int knightPosx = 1;
    private int knightPosy = 1;
    private int pawnPosx = 2;
    private int pawnPosy = 3;
    private Pair<Integer,Integer> knightPos = new Pair<>(knightPosx, knightPosy);
    private Pair<Integer,Integer> pawnPos = new Pair<>(pawnPosx, pawnPosy);

    @BeforeEach
    void BeforeEach() {
        this.logics = new MovementLogicsImpl(5);
        this.logics.setKnightPosition(this.knightPos);    
        this.logics.setPawnPosition(this.pawnPos);
    }

    @Test
    void testSetKnightPosition() {
        assertEquals(this.logics.getKnightPosition(), this.knightPos);
    }

    @Test
    void testSetPawnPosition() {
        assertEquals(this.logics.getPawnPosition(), this.pawnPos);
    }

    @Test
    void testMoveKnight() {
        this.logics.moveKnight(this.pawnPosx, this.pawnPosy);
        assertTrue(this.logics.hasHit());
    }
}
