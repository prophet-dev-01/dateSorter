package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DateSorter {
    private static final String SPECIFIC_MONTH_SYMBOL = "r";

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> localDatesWithoutR = unsortedDates.stream()
                .filter(localDate -> localDate.getMonth().name().toLowerCase().contains(SPECIFIC_MONTH_SYMBOL))
                .sorted().collect(Collectors.toList());
        localDatesWithoutR.addAll(unsortedDates.stream()
                .filter(localDate -> !localDate.getMonth().name().toLowerCase().contains(SPECIFIC_MONTH_SYMBOL))
                .sorted(Comparator.reverseOrder())
                .toList());
        return localDatesWithoutR;
    }
}
