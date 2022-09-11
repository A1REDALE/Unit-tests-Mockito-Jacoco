package com.example;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        List<String> actualEatMeatResult = (new Feline()).eatMeat();
        assertEquals(3, actualEatMeatResult.size());
        assertEquals("Животные", actualEatMeatResult.get(0));
        assertEquals("Птицы", actualEatMeatResult.get(1));
        assertEquals("Рыба", actualEatMeatResult.get(2));
    }


    @Test
    public void testGetKittens() {
        assertEquals(1, (new Feline()).getKittens());

    }

    @Test
    public void testGetKittens1() {
        assertEquals(3, (new Feline()).getKittens(3));
    }

    @Test
    public void testConstructor() {
        assertEquals("Кошачьи", (new Feline()).getFamily());
    }
}

