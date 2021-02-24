package com.service.odto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListCollectionDataOdto implements Serializable {
    private List<CollectionDataOdto> collectionDataOdtos;

    public List<CollectionDataOdto> getCollectionDataOdtos() {
        if (!Objects.nonNull(collectionDataOdtos)) {
            collectionDataOdtos = new ArrayList<>();
        }
        return collectionDataOdtos;
    }
}
