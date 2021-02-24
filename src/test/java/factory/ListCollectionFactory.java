package factory;

import com.model.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ListCollectionFactory {

    public static ListCollection factory() {
        ListCollection listCollection = new ListCollection();
        CollectionData collectionData = new CollectionData();

        collectionData.setId("1020971");
        collectionData.setTitle("Halloween");
        collectionData.setDescription("Description");
        collectionData.setTags(Arrays.asList(UnsplashTag.builder()
                .source(UnsplashSource.builder()
                        .cover_photo(UnsplashCoverPhoto.builder().id("T43tMZ5jyzs").build())
                        .build()).build()));

        listCollection.setCollectionData(new ArrayList<>());
        listCollection.getCollectionData().add(collectionData);

        collectionData = new CollectionData();

        collectionData.setId("9454911");
        collectionData.setTitle("––BASKETBALL");
        collectionData.setDescription(null);
        collectionData.setTags(Arrays.asList(UnsplashTag.builder()
                .source(UnsplashSource.builder()
                        .cover_photo(UnsplashCoverPhoto.builder().id("57rD2oDZquc").build())
                        .build()).build()));

        listCollection.getCollectionData().add(collectionData);

        return listCollection;
    }
}
