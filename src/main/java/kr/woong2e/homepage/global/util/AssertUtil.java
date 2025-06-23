package kr.woong2e.homepage.global.util;

import kr.woong2e.homepage.global.exception.CustomException;
import kr.woong2e.homepage.global.response.status.BaseStatus;

import java.util.Optional;

public class AssertUtil {

    private AssertUtil() {}

    public static void check(boolean condition, BaseStatus status) {
        if (!condition) {
            throw new CustomException(status);
        }
    }

    public static <T> T orElseThrow(Optional<T> optional, BaseStatus status) {
        return optional.orElseThrow(() -> new CustomException(status));
    }
}
