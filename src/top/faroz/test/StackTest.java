package top.faroz.test;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @ClassName StackTest
 * @Description TODO
 * @Author FARO_Z
 * @Date 2020/12/31 下午5:20
 * @Version 1.0
 **/
public class StackTest {
    @Test
    public void stackTest() {
        Stack<Integer> integers = new Stack<>();
        integers.push(20);
        integers.push(19);
        integers.push(18);
        while (!integers.isEmpty()) {
            System.out.println(integers.pop());
        }
    }
}
