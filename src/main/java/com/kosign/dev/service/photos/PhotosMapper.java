package com.kosign.dev.service.photos;

import com.kosign.dev.domain.photos.PhotoEntity;
import com.kosign.dev.payload.photo.PhotoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PhotosMapper {
    public PhotoResponse mapToResponse (PhotoEntity photo){
        return PhotoResponse.builder()
                .id(photo.getId())
                .fileName(photo.getPhoto())
                .build();
    }
}
