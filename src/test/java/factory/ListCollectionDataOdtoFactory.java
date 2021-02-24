package factory;

import com.service.odto.CollectionDataOdto;
import com.service.odto.ListCollectionDataOdto;
import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.List;

public class ListCollectionDataOdtoFactory {

    public static ListCollectionDataOdto factory() {
        ListCollectionDataOdto listCollectionDataOdto = new ListCollectionDataOdto();
        List<CollectionDataOdto> collectionDataOdtos = new ArrayList<>();

        collectionDataOdtos.add(CollectionDataOdto
                .builder().id("1020971").title("Halloween").description("Description").cover_photo(null).build());

        listCollectionDataOdto.setCollectionDataOdtos(collectionDataOdtos);

        return listCollectionDataOdto;
    }
}
