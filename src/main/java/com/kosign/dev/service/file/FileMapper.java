package com.kosign.dev.service.file;

import com.kosign.dev.payload.file.FileRequest;
import com.kosign.dev.payload.file.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileMapper {

//    public FileStorage mapToEntity(FileRequest payload){
//        return FileStorage.builder()
//                .fileName(payload.fileName())
//                .fileUrl(payload.fileUrl())
//                .size(payload.size())
//                .fileType(payload.fileType())
//                .build();
//    }
//
//    public FileResponse mapToResponse(FileStorage payload){
//        return FileResponse.builder()
//                .id(payload.getId())
//                .fileName(payload.getFileName())
//                .fileUrl(payload.getFileUrl())
//                .size(payload.getSize())
//                .fileType(payload.getFileType())
//                .build();
//    }
}
