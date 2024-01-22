package com.kosign.dev.service.file;


import com.kosign.dev.domain.file.FileEntity;
import com.kosign.dev.domain.file.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;
//    private final Path root= Paths.get("src/main/resources/Datauplaod");
    private final Path root= Paths.get("/home/hrd123/easycartImage/");

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }
    @Override
    public FileEntity InsertFile(FileEntity fileEntity) {
        return fileRepository.save(fileEntity);
    }

    @Override
    public String Uplaodfile(MultipartFile file) throws IOException {
        try{
            String fileName=file.getOriginalFilename();
            if(fileName!=null) {
                fileName=  UUID.randomUUID()+"."+ StringUtils.getFilenameExtension(fileName);
                if(!Files.exists(root)){
                    Files.createDirectories(root);
                }
                Files.copy(file.getInputStream(),root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
                return fileName;
            }
            else {
                return "File Not Found!";
            }
        }catch (IOException ex){
            throw new IOException("File not found!");
        }
    }

    @Override
    public Resource getFile(String fileName) throws IOException {
        FileEntity files = fileRepository.findByFileName(fileName);
//        Path path=Paths.get("src/main/resources/Datauplaod/"+files.getFileName());
        Path path=Paths.get("/home/hrd123/easycartImage/"+files.getFileName());
        Resource file=new ByteArrayResource(Files.readAllBytes(path));
        return file;
    }
}
