package org.ikropachev.projectelster.web;

import java.time.LocalDate;

public abstract class AbstractController {
    protected final String YESTERDAY_STR = LocalDate.now().minusDays(1).toString();
}
