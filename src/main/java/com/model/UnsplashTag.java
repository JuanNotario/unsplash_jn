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
public class UnsplashTag implements Serializable {
    private UnsplashSource source;

    public UnsplashSource getSource() {
        if (!Objects.nonNull(source)) {
            source = new UnsplashSource();
        }
        return source;
    }
}
