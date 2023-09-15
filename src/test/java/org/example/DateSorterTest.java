package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateSorterTest {
    private static DateSorter dateSorter;

    @BeforeAll
    public static void initialize() {
        dateSorter = new DateSorter();
    }

    @Test
    public void sortDates_correctCase_ok() {
        List<LocalDate> localDates = List.of(
                LocalDate.of(2005, 7, 1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 5, 3)
        );
        List<LocalDate> expectedResult = List.of(
                LocalDate.of(2005, 1,1),
                LocalDate.of(2005, 1, 2),
                LocalDate.of(2005, 7, 1),
                LocalDate.of(2005, 5, 3)
        );
        assertEquals(expectedResult, dateSorter.sortDates(localDates));
    }

    @Test
    public void sortDates_emptyList_ok() {
        List<LocalDate> emptyList = new ArrayList<>();
        assertTrue(dateSorter.sortDates(emptyList).isEmpty());
    }

    @Test
    public void sortDates_nullList_notOk() {
        assertThrows(NullPointerException.class,
                () -> dateSorter.sortDates(null));
    }
}
