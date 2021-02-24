package controller;

import com.interfaces.UnsplashService;
import com.webservice_unsplash.webservice_unsplash_jn.WebserviceUnsplashJnApplication;
import factory.ListCollectionDataOdtoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = WebserviceUnsplashJnApplication.class)
@AutoConfigureMockMvc
public class UnsplashConntrollerTest {
    public static final String FILTER_NULL = "";
    public static final String FILTER_NOT_NULL = "Halloweenn";

    @MockBean
    private UnsplashService unsplashService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("GET /collections Ok")
    void getCollectionUnsplashTest() throws Exception {
        Mockito.when(unsplashService.getCollectionMovie(FILTER_NULL)).thenReturn(ListCollectionDataOdtoFactory.factory());

        mockMvc.perform(get("/collections/all"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /collections/{filter} Ok")
    void getCollectionUnsplashFilterTest() throws Exception {
        Mockito.when(unsplashService.getCollectionMovie(FILTER_NULL)).thenReturn(ListCollectionDataOdtoFactory.factory());

        mockMvc.perform(get("/collections/{filter}", FILTER_NOT_NULL))
                .andExpect(status().isOk());
    }
}



