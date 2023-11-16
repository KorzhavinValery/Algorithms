package pro.sky.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.algorithms.exceptions.ItemNotFoundException;
import pro.sky.algorithms.service.impl.IntegerListImpl;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListImplTest {
    IntegerListImpl out = new IntegerListImpl(1);

    @BeforeEach
    public void setUp() {
        out.add(1);


    }

    @Test
    void shouldAdd() {
        Integer[] expected = {1};
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldAddByIndex() {
        out.add(0, 2);
        out.add(1, 7);
        Integer[] expected = {2,7,1};
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldSet() {
        Integer[] expected = {777};
        out.set(0, 777);
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldReturnSizeAndClearArray() {
        out.clear();
        assertEquals(0, out.size());
    }

    @Test
    void shouldRemove() {
        Integer[] expected = {1};
        out.add(23);
        out.remove(23);
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldItemNotFoundException() {
        assertThrows(ItemNotFoundException.class, ()->out.remove(1645456));
    }

}
