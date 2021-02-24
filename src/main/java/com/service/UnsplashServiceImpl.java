package com.service;

import com.interfaces.GetUnsplashService;
import com.interfaces.UnsplashService;
import com.service.odto.CollectionDataOdto;
import com.service.odto.CoverPhotoOdto;
import com.service.odto.ListCollectionDataOdto;
import com.model.ListCollection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UnsplashServiceImpl implements UnsplashService {

    private final GetUnsplashService getUnsplashService;

    private ListCollection listCollection;

    private ListCollectionDataOdto listCollectionDataOdto;

    @Override
    public ListCollectionDataOdto getCollectionMovie(String filter) {

        listCollection = getUnsplashService.getUnsplash();

        listCollectionDataOdto = collectionToCollectionDataOdto(listCollection);

        if (Objects.nonNull(filter) && !filter.isBlank()) {
            listCollectionDataOdto = filterList(filter);
        }

        return listCollectionDataOdto;
    }

    public ListCollectionDataOdto collectionToCollectionDataOdto(ListCollection listCollection) {
        ListCollectionDataOdto listCollectionData = new ListCollectionDataOdto();

        listCollectionData.setCollectionDataOdtos(listCollection.getCollectionData().stream()
                .map(c -> new CollectionDataOdto(c.getId(), c.getTitle(), c.getDescription(),
                        c.getTags().stream().map(t -> new CoverPhotoOdto(t.getSource().getCover_photo().getId())).collect(Collectors.toList()))
                ).collect(Collectors.toList()));

        listCollectionData.getCollectionDataOdtos().stream()
                .forEach(c -> c.setCover_photo(c.getCover_photo().stream()
                        .filter(p -> p.getId() != null).map(cp -> new CoverPhotoOdto(cp.getId())).collect(Collectors.toList())));

        return listCollectionData;
    }

    private ListCollectionDataOdto filterList(String filter) {
        listCollectionDataOdto.setCollectionDataOdtos(listCollectionDataOdto.getCollectionDataOdtos().stream()
                .filter(c -> c.getId().contains(filter) || c.getTitle().contains(filter) || c.getDescription().contains(filter))
                .map(cl -> new CollectionDataOdto(cl.getId(), cl.getTitle(), cl.getDescription(), cl.getCover_photo()))
                .collect(Collectors.toList()));

        return listCollectionDataOdto;
    }
}
