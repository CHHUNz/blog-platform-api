package com.kosign.dev.service.file;


import com.kosign.dev.domain.file.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileService {
    FileEntity InsertFile(FileEntity fileEntity);
    String Uplaodfile(MultipartFile file) throws IOException;
    Resource getFile(String fileName) throws IOException;
}
