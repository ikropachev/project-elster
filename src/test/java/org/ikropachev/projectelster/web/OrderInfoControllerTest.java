package org.ikropachev.projectelster.web;

import org.ikropachev.projectelster.model.oltp.TestOrderInfo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderInfoControllerTest extends AbstractControllerTest {
    private static final Logger log = getLogger(OrderInfoControllerTest.class);

    @Test
    public void getAllOrdersInfoTest() throws Exception {
        TestOrderInfo testOrderInfo1 = new TestOrderInfo(1L, "CUST-004", "SPERSON-001", YESTERDAY_STR);
        TestOrderInfo testOrderInfo2 = new TestOrderInfo(2L, "CUST-001", "SPERSON-001", YESTERDAY_STR);
        TestOrderInfo testOrderInfo3 = new TestOrderInfo(3L, "CUST-002", "SPERSON-001", YESTERDAY_STR);
        TestOrderInfo testOrderInfo4 = new TestOrderInfo(4L, "CUST-003", "SPERSON-002", TODAY_STR);
        TestOrderInfo testOrderInfo5 = new TestOrderInfo(5L, "CUST-001", "SPERSON-002", TODAY_STR);
        TestOrderInfo testOrderInfo6 = new TestOrderInfo(6L, "CUST-001", "SPERSON-002", TODAY_STR);
        final List<TestOrderInfo> testOrdersInfo = List.of(testOrderInfo1, testOrderInfo2, testOrderInfo3, testOrderInfo4,
                testOrderInfo5, testOrderInfo6);

        String expectedResponseContent = objectMapper.writeValueAsString(testOrdersInfo);

        log.info("expectedResponseContent: " + expectedResponseContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ordersinfo"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));

    }
}
