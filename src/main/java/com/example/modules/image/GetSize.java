package com.example.modules.image;

import com.example.modules.Module;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class GetSize implements Module {
    @Override
    public boolean validateFormat(String format) {
        return format.equals("png") || format.equals("jpg") || format.equals("jpeg");
    }

    @Override
    public String functionDescription() {
        return "This function return size of your image";
    }

    @Override
    public String function(File file) {
        int width = 0;
        int height = 0;
        try {
            BufferedImage image = ImageIO.read(file);

            width = image.getWidth();
            height = image.getHeight();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Width: " + width + "\nHeight: " + height;
    }
}
