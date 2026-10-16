package design.strategy; // 2

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

// 전략 2 : URL 인코딩 (공백, 한글, 특수문자를 %xx 형태로 변환)
public class UrlStrategy implements EncodingStrategy{

    @Override
    public String encode(String text) {
        return URLEncoder.encode(text, StandardCharsets.UTF_8);
    }
}
