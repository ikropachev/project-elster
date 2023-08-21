package org.ikropachev.projectelster.web;

import java.time.LocalDate;

public abstract class AbstractController {
    protected LocalDate getYesterdayDate() {
        LocalDate yesterdayDate = LocalDate.now().minusDays(1);
        return yesterdayDate;
    }
}
