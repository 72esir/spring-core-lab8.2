package com.example.modules.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.example.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class GetMIMEType implements Module {
    @Override
    public boolean validateFormat(File file) {
        try {
            return file.getName().split("\\.")[1].equals("png") || file.getName().split("\\.")[1].equals("jpg") || file.getName().split("\\.")[1].equals("jpeg");
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public String functionDescription() {
        return "This function return MIME type of your image";
    }

    @Override
    public String function(File file) {
        String mimeType = "";
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    if (tag.toString().startsWith("[File Type] Detected MIME Type")){
                        mimeType = tag.toString().split("-")[1].strip();
                    }
                }
            }
        }catch (ImageProcessingException | IOException e) {
            e.printStackTrace();
        }
        return "MIME type of your image: " + mimeType;
    }
}
