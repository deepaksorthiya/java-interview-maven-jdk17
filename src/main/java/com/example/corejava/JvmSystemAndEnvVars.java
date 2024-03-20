package com.example.corejava;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class JvmSystemAndEnvVars {

    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        Map<String, String> envs = System.getenv();
        envs.forEach((k, v) -> map.put(k, v));


        Properties props = System.getProperties();
        props.forEach((k, v) -> map.put(k.toString(), v.toString()));

        map.forEach((k, v) -> System.out.println(k + "=====>" + v));

        System.out.println(Arrays.toString(args));

    }
}
