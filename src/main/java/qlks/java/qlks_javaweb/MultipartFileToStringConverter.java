package qlks.java.qlks_javaweb;

import org.springframework.core.convert.converter.Converter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Component;

@Component
public class MultipartFileToStringConverter implements Converter<MultipartFile, String> {
    @Override
    public String convert(MultipartFile multipartFile) {
        return multipartFile != null ? multipartFile.getOriginalFilename() : null;
    }
}
