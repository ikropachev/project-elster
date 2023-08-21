package org.ikropachev.projectelster.web;

import org.ikropachev.projectelster.model.dwh.TestDimProduct;
import org.ikropachev.projectelster.model.oltp.TestProduct;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest extends AbstractControllerTest {
    private static final Logger log = getLogger(ProductControllerTest.class);

    TestProduct testProduct1 = new TestProduct(1L, "Vacuum cleaner", YESTERDAY_STR);
    TestProduct testProduct2 = new TestProduct(2L, "Cleaner bags", YESTERDAY_STR);
    TestProduct testProduct3 = new TestProduct(3L, "Oven mittens", TODAY_STR);

    final List<TestProduct> testProducts = List.of(testProduct1, testProduct2, testProduct3);

    TestDimProduct testDimProduct1 = new TestDimProduct(1L, 1L, "Vacuum cleaner", YESTERDAY_STR);
    TestDimProduct testDimProduct2 = new TestDimProduct(2L, 2L, "Cleaner bags", YESTERDAY_STR);

    final List<TestDimProduct> testDimProducts = List.of(testDimProduct1, testDimProduct2);

    @Test
    public void getAllFromOltpTest() throws Exception {
        String expectedResponseContent = objectMapper.writeValueAsString(testProducts);

        log.info("expectedResponseContent: " + expectedResponseContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products/oltp"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));
    }

    @Test
    public void processDimensionsTest() throws Exception {
        String expectedResponseContent = objectMapper.writeValueAsString(testDimProducts);

        log.info("expectedResponseContent: " + expectedResponseContent);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/products"))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedResponseContent));
    }
}
