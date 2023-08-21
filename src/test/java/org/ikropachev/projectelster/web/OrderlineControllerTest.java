package org.ikropachev.projectelster.web;

import org.ikropachev.projectelster.model.oltp.TestOrderline;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderlineControllerTest extends AbstractControllerTest {
    private static final Logger log = getLogger(OrderlineControllerTest.class);

    TestOrderline testOrderline1 = new TestOrderline(1L, 1, 1, 3.0, 49.99, YESTERDAY_STR);
    TestOrderline testOrderline2 = new TestOrderline(2L, 1, 2, 1.0, 24.99, YESTERDAY_STR);
    TestOrderline testOrderline3 = new TestOrderline(3L, 2, 2, 1.0, 24.99, YESTERDAY_STR);
    TestOrderline testOrderline4 = new TestOrderline(4L, 2, 3, 2.0, 19.99, YESTERDAY_STR);
    TestOrderline testOrderline5 = new TestOrderline(5L, 3, 1, 1.0, 49.99, YESTERDAY_STR);
    TestOrderline testOrderline6 = new TestOrderline(6L, 4, 1, 3.0, 47.99, TODAY_STR);
    TestOrderline testOrderline7 = new TestOrderline(7L, 4, 3, 2.0, 24.50, TODAY_STR);
    TestOrderline testOrderline8 = new TestOrderline(8L, 5, 1, 1.0, 49.99, TODAY_STR);
    TestOrderline testOrderline9 = new TestOrderline(9L, 5, 2, 3.0, 24.99, TODAY_STR);
    TestOrderline testOrderline10 = new TestOrderline(10L, 6, 1, 1.0, 48.99, TODAY_STR);

    final List<TestOrderline> testOrderlines = List.of(testOrderline1, testOrderline2, testOrderline3, testOrderline4,
            testOrderline5, testOrderline6, testOrderline7, testOrderline8, testOrderline9, testOrderline10);

    @Test
    public void getAllOrderlinesTest() throws Exception {
        String expectedResponseContent = objectMapper.writeValueAsString(testOrderlines);

        log.info("expectedResponseContent: " + expectedResponseContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/orderlines/oltp"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));
    }
}
