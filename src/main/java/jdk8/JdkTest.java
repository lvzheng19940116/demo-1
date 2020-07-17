package jdk8;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LvZheng
 * 创建时间：2020/7/6 5:36 下午
 */
@Slf4j
public class JdkTest {

    public static void main(String[] args) {
        ArrayList<String> strings = Lists.newArrayList("1", "6", "4");
        List<Integer> collect = strings.stream().map(Integer::parseInt).collect(Collectors.toList());

        List<BigDecimal> collect1 = strings.stream().map(BigDecimal::new).collect(Collectors.toList());

        System.out.println(collect);
        System.out.println(collect1);


    }
}
