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
public class GetTitle implements Module {
    @Override
    public boolean validateFormat(String format) {
        return format.equals("mp3");
    }

    @Override
    public String functionDescription() {
        return "This function return title of your mp3";
    }

    @Override
    public String function(File file) {
        return file.getName();
    }
}
