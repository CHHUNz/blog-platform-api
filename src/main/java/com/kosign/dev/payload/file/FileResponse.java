package com.kosign.dev.payload.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponse<T> {
    private  String message;
    private  int status;
    private  T payload;
}
