package org.ikropachev.projectelster.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.ikropachev.projectelster.model.TestSalesperson;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SalespersonControllerTest extends AbstractControllerTest {
    private static final Logger log = getLogger(SalespersonControllerTest.class);

    protected ObjectMapper objectMapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Test
    public void getAllSalespersonsTest() throws Exception {
        TestSalesperson salesperson1 = new TestSalesperson("SPERSON-001", "John Smith", LocalDate.now().toString());
        final List<TestSalesperson> salespersons = List.of(salesperson1);

        String expectedResponseContent = objectMapper.writeValueAsString(salespersons);

        log.info("expectedResponseContent: " + expectedResponseContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/salespersons"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));

    }
}
