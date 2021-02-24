package com.interfaces;

import com.service.odto.ListCollectionDataOdto;

public interface UnsplashService {
    ListCollectionDataOdto getCollectionMovie(String filter);
}
