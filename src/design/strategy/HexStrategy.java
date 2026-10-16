package design.strategy;

import java.nio.charset.StandardCharsets;
import java.util.HexFormat;

// 전략 1 : Base64 인코딩
public class HexStrategy implements EncodingStrategy{
    @Override
    public String encode(String text) {
        return HexFormat.of().formatHex(text.getBytes(StandardCharsets.UTF_8));
    }
}
