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
import java.util.ArrayList;
import java.util.List;

@Component
public class GetMetadata implements Module {
    @Override
    public boolean validateFormat(String format) {
        return format.equals("png");
    }

    @Override
    public String functionDescription() {
        return "This function return metadata of your file";
    }

    @Override
    public String function(File file) {
        List<Tag> data = new ArrayList<>();
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    data.add(tag);
                }
            }
        }catch (ImageProcessingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Metadata of your file" + data;
    }
}
