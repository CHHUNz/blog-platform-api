package com.kosign.dev.domain.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface FileRepository extends JpaRepository<FileEntity,Long> {
FileEntity findByFileName(String filename);
}
