package com.example;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Test
    public void eatMeatShouldReturnPredatorFood() throws Exception {

        Feline felineSpy = Mockito.spy(new Feline());
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(expected);
        List<String> actual = felineSpy.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() {
        assertEquals(1, (new Feline()).getKittens());
    }

    @Test
    public void getKittensTestWithSpecifiedAmount() {
        assertEquals(3, (new Feline()).getKittens(3));
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", (new Feline()).getFamily());
    }
}

