package com.isa.usersengine.cdi;

import com.isa.usersengine.exceptions.UserImageNotFound;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public interface FileUploadProcessor {

    String getUploadImageFilesPath() throws IOException;
    File uploadImageFile(Part filePart) throws IOException, UserImageNotFound;
}
