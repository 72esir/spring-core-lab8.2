package com.example.modules.mp3;

import com.example.modules.Module;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class GetDuration implements Module {
    @Override
    public boolean validateFormat(String format) {
        return format.equals("mp3");
    }

    @Override
    public String functionDescription() {
        return "This function return duration of your mp3";
    }

    @Override
    public String function(File file) {
        String duration = "";
        try (InputStream input = new FileInputStream(file)) {
            Parser parser = new Mp3Parser();

            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            ParseContext parseCtx = new ParseContext();
            parser.getSupportedTypes(parseCtx);

            parser.parse(input, handler, metadata, parseCtx);
            duration = metadata.get("xmpDM:duration");
        } catch (IOException | SAXException | TikaException e) {
            System.out.println(e.getMessage());
        }
        return "Duration in seconds: " +  duration;
    }
}
