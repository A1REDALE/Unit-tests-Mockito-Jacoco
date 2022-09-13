package com.example;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    public void createLionWithManePositiveResult() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.hasMane);
    }

    @Test
    public void createLionWithoutManePositiveResult() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.hasMane);
    }

    @Test
    public void getFoodShouldReturnPredatorFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }

    @Test
    public void doesHaveManeShouldReturnTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeShouldReturnFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }
}


