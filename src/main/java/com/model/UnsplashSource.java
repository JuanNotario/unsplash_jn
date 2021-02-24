package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsplashSource implements Serializable {
    private UnsplashCoverPhoto cover_photo;

    public UnsplashCoverPhoto getCover_photo() {
        if (!Objects.nonNull(cover_photo)) {
            cover_photo = new UnsplashCoverPhoto();
        }
        return cover_photo;
    }
}
