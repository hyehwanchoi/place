package com.hot.place.study.unit;

import com.hot.place.AcceptanceTest;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest extends AcceptanceTest {

    @Test
    void test() {
        List<Map<String, Integer>> list1 = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("1", 2);
        list1.add(map);

        List<List<Map<String, Integer>>> list = new ArrayList<>();
        list.add(list1);

        for (List<Map<String, Integer>> b: list) {
        }
    }
}
