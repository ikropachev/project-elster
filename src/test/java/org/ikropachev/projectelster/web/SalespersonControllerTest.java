package org.ikropachev.projectelster.web;

import org.ikropachev.projectelster.model.TestSalesperson;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SalespersonControllerTest extends AbstractControllerTest {
    private static final Logger log = getLogger(SalespersonControllerTest.class);

    @Test
    public void getAllSalespersonsTest() throws Exception {
        TestSalesperson testSalesperson1 = new TestSalesperson("SPERSON-001", "John Smith", TODAY_STR);
        TestSalesperson testSalesperson2 = new TestSalesperson("SPERSON-002", "Jack London", TODAY_STR);
        final List<TestSalesperson> testSalespersons = List.of(testSalesperson1, testSalesperson2);

        String expectedResponseContent = objectMapper.writeValueAsString(testSalespersons);

        log.info("expectedResponseContent: " + expectedResponseContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/salespersons"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));

    }
}
