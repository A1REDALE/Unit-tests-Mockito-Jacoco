package com.example;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {


    @Mock
    Feline feline;


    @Test
    public void invalidLionSexShouldThrowException() throws Exception {
        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Невиданная зверушка", feline);
        });
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual = e.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actualFood = (new Lion("Самец", new Feline())).getFood();
        assertEquals(3, actualFood.size());
        assertEquals("Животные", actualFood.get(0));
        assertEquals("Птицы", actualFood.get(1));
        assertEquals("Рыба", actualFood.get(2));
    }

    @Test

    public void testGetFood2() throws Exception {
        (new Lion("Самец",feline)).getFood();
    }

    @Test
    public void createMaleLion() throws Exception {
        Lion Lion = new Lion("Самец", feline);
        assertTrue(Lion.hasMane);
    }

    @Test
    public void createFemaleLion() throws Exception {
        Lion Lion = new Lion("Самка", feline);
        assertFalse(Lion.hasMane);
    }
}

