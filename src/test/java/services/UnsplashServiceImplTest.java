package services;

import com.interfaces.GetUnsplashService;
import com.interfaces.UnsplashService;
import com.model.ListCollection;
import com.service.UnsplashServiceImpl;
import com.service.odto.ListCollectionDataOdto;
import com.webservice_unsplash.webservice_unsplash_jn.WebserviceUnsplashJnApplication;
import factory.ListCollectionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = WebserviceUnsplashJnApplication.class)
class UnsplashServiceImplTest {
    public static final String FILTER_NULL = "";
    public static final String FILTER_NOT_NULL = "Halloween";
    public static final String TEST_ID = "1020971";

    @Mock
    private GetUnsplashService getUnsplashService;

    private UnsplashService unsplashService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        unsplashService = new UnsplashServiceImpl(getUnsplashService, new ListCollection(), new ListCollectionDataOdto());
    }

    @Test
    void getCollectionMovieTest_Filter_Null() {
        Mockito.when(getUnsplashService.getUnsplash()).thenReturn(ListCollectionFactory.factory());
        ListCollectionDataOdto listCollectionDataOdto = unsplashService.getCollectionMovie(FILTER_NULL);

        Assertions.assertNotNull(listCollectionDataOdto);
        Assertions.assertNotNull(listCollectionDataOdto.getCollectionDataOdtos());
        Assertions.assertEquals(listCollectionDataOdto.getCollectionDataOdtos().size(), 2);
        //Mockito.verify()
    }

    @Test
    void getCollectionMovieTest_Filter_Not_Null() {
        Mockito.when(getUnsplashService.getUnsplash()).thenReturn(ListCollectionFactory.factory());
        ListCollectionDataOdto listCollectionDataOdto = unsplashService.getCollectionMovie(FILTER_NOT_NULL);

        Assertions.assertNotNull(listCollectionDataOdto);
        Assertions.assertNotNull(listCollectionDataOdto.getCollectionDataOdtos());
        Assertions.assertEquals(listCollectionDataOdto.getCollectionDataOdtos().size(), 1);
        Assertions.assertEquals(listCollectionDataOdto.getCollectionDataOdtos().get(0).getId(), TEST_ID);
    }

}



