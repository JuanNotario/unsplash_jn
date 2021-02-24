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
public class CollectionDataOdto implements Serializable {
    private String id;
    private String title;
    private String description;
    private List<CoverPhotoOdto> cover_photo;

    public String getId() {
        if (!Objects.nonNull(id)) {
            id = new String();
        }
        return id;
    }

    public String getTitle() {
        if (!Objects.nonNull(title)) {
            title = new String();
        }
        return title;
    }

    public String getDescription() {
        if (!Objects.nonNull(description)) {
            description = new String();
        }
        return description;
    }

    public List<CoverPhotoOdto> getCover_photo() {
        if (!Objects.nonNull(cover_photo)) {
            cover_photo = new ArrayList<>();
        }
        return cover_photo;
    }
}
