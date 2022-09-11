package com.example;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Test
    public void testConstructor() {
        assertEquals("Мяу", (new Cat(new Feline()).getSound()));
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actualFood = (new Cat(new Feline())).getFood();
        assertEquals(3, actualFood.size());
        assertEquals("Животные", actualFood.get(0));
        assertEquals("Птицы", actualFood.get(1));
        assertEquals("Рыба", actualFood.get(2));
    }
    @Test
    public void testCatMethodGetFoodException() throws Exception{

        try {
            Cat cat = new Cat(new Feline());
            Mockito.when(new Feline().getFood("Барсик")).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            cat.getFood();
        }
        catch (Exception e) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

}

