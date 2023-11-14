package pro.sky.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.algorithms.exceptions.InvalidIndexException;
import pro.sky.algorithms.exceptions.NullItemException;
import pro.sky.algorithms.exceptions.StorageIsFullException;
import pro.sky.algorithms.service.impl.StringListImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {
    StringListImpl out = new StringListImpl();


    @BeforeEach
    public void setUp() {
        out.add(0, "Rabotaet");


    }

    @Test
    void shouldAdd() {
        String expected[] = new String[]{"Rabotaet"};
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldAddByIndex() {
        out.add(1, "Rabotaet2");
        String expected[] = new String[]{"Rabotaet", "Rabotaet2"};
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldSet() {
        String expected[] = new String[]{"Renamed"};
        out.set(0, "Renamed");
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldReturnSizeAndClearArray() {
        out.clear();
        assertEquals(0, out.size());
    }

    @Test
    void shouldRemove() {
        String expected[] = new String[]{"Rabotaet"};
        out.add(1, "Item3");
        out.remove("Item3");
        assertArrayEquals(expected, out.toArray());
    }

    @Test
    void shouldStorageIsFullException() {
        out.add("Item1");
        out.add("Item66");

        assertThrows(StorageIsFullException.class, () -> out.add(2, "Item2"));
    }

    @Test
    void shouldInvalidIndexException() {
        assertThrows(InvalidIndexException.class, () -> out.add(-1, ""));
    }

    @Test
    void shouldNullItemException() {
        assertThrows(NullItemException.class, () -> out.add(1, null));
    }
}
