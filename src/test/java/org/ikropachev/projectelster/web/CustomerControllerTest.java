package org.ikropachev.projectelster.web;

import org.ikropachev.projectelster.model.dwh.TestDimCustomer;
import org.ikropachev.projectelster.model.oltp.TestCustomer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustomerControllerTest extends AbstractControllerTest {
    private static final Logger log = getLogger(CustomerControllerTest.class);

    TestCustomer testCustomer1 = new TestCustomer("CUST-001", "Jonesy", "E 187th Street", "New York",
            "0000000001", YESTERDAY_STR);
    TestCustomer testCustomer2 = new TestCustomer("CUST-002", "Jones", "E 187th Street", "New York",
            "0000000002", YESTERDAY_STR);
    TestCustomer testCustomer3 = new TestCustomer("CUST-003", "Jones", "W 82nd Street", "New York",
            "0000000003", TODAY_STR);
    TestCustomer testCustomer4 = new TestCustomer("CUST-004", "Doe", "Poland St NW", "Atlanta",
            "0000000004", TODAY_STR);

    final List<TestCustomer> testCustomers = List.of(testCustomer1, testCustomer2, testCustomer3, testCustomer4);

    TestDimCustomer testDimCustomer1 = new TestDimCustomer(1L, "CUST-001", "Jonesy",
            "0000000001", YESTERDAY_STR);
    TestDimCustomer testDimCustomer2 = new TestDimCustomer(2L, "CUST-002", "Jones",
            "0000000002", YESTERDAY_STR);

    final List<TestDimCustomer> testDimCustomers = List.of(testDimCustomer1, testDimCustomer2);

    @Test
    public void getAllFromOltpTest() throws Exception {
        String expectedResponseContent = objectMapper.writeValueAsString(testCustomers);

        log.info("expectedResponseContent: " + expectedResponseContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/oltp"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));
    }

    @Test
    public void processDimensionsTest() throws Exception {
        String expectedResponseContent = objectMapper.writeValueAsString(testDimCustomers);

        log.info("expectedResponseContent: " + expectedResponseContent);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/customers"))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));
    }
}
