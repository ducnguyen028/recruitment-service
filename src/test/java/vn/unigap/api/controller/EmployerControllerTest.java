package vn.unigap.api.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import vn.unigap.api.service.EmployerService;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
@SpringBootTest
@AutoConfigureMockMvc
public class EmployerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployerService employerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetListEmployer() {
        int page = 2;
        int size = 5;

        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/v1/employer")
                            .param("page", String.valueOf(page))
                            .param("size", String.valueOf(size))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(size));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetEmployerById() {
        int sampleId = 3094094;
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .get("/api/v1/employer/{id}", sampleId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateEmployer() {
        try {
            when(employerService.createEmployer(any())).thenReturn("New employer created successfully with id ");

            mockMvc.perform(MockMvcRequestBuilders
                            .post("/api/v1/employer")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateEmployer() {
        int testId = 52;
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .put("/api/v1/employer/{id}", testId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("Employer with ID: " + testId + " updated successfully."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteEmployer() {
        try {
            mockMvc.perform(MockMvcRequestBuilders
                            .delete("/api/v1/employer/{id}", 1)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
