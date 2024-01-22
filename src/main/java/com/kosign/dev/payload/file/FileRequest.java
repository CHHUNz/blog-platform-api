package com.kosign.dev.payload.file;

public record FileRequest(String fileName,
                          String fileUrl,
                          String fileType,
                          Long size) {
}
