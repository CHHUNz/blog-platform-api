package com.kosign.dev.payload.photo;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Builder
public class PhotoResponse {
    private UUID id;
    private String fileName;
}
