package com.interview.algorithms.data.structures;

import com.interview.algorithms.data.structures.impls.FixedCapacityStack;
import com.interview.algorithms.data.structures.impls.LinkedListStack;
import com.interview.algorithms.data.structures.impls.ResizingArrayStack;
import com.interview.algorithms.princeton.CommonTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author: Vincent
 * @since:11:22 AM, 10/5/16
 */
public class Parentheses extends CommonTest {

    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static boolean isBalanced(Stack<Character> stack, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT_PAREN)   stack.push(LEFT_PAREN);
            if (s.charAt(i) == LEFT_BRACE)   stack.push(LEFT_BRACE);
            if (s.charAt(i) == LEFT_BRACKET) stack.push(LEFT_BRACKET);

            if (s.charAt(i) == RIGHT_PAREN) {
                if (stack.isEmpty())           return false;
                if (stack.pop() != LEFT_PAREN) return false;
            }

            else if (s.charAt(i) == RIGHT_BRACE) {
                if (stack.isEmpty())           return false;
                if (stack.pop() != LEFT_BRACE) return false;
            }

            else if (s.charAt(i) == RIGHT_BRACKET) {
                if (stack.isEmpty())             return false;
                if (stack.pop() != LEFT_BRACKET) return false;
            }
        }
        return stack.isEmpty();
    }

    @Test(dataProvider = "prepareInstance")
    public void testQueue(java.lang.String description, Stack<Character> stack, String testString, boolean isBanlance) throws Exception {
        logger.debug(description);

        Assert.assertTrue(stack.isEmpty());

        Assert.assertEquals(isBalanced(stack, testString), isBanlance);

    }

    @DataProvider
    @Override
    protected Object[][] prepareInstance() {
        return new Object[][]{
            {"LIFO Stack, Linked List stack implementation", new LinkedListStack<String>(), "[()]{}{[()()]()}", true},
            {"LIFO Stack, Linked List stack implementation", new LinkedListStack<String>(), "[(])", false},
            {"LIFO Stack, Fixed Capacity stack implementation", new FixedCapacityStack<String>(20), "[()]{}{[()()]()}", true},
            {"LIFO Stack, Fixed Capacity stack implementation", new FixedCapacityStack<String>(20), "[(])", false},
            {"LIFO Stack, Resizing Array stack implementation", new ResizingArrayStack<String>(), "[()]{}{[()()]()}", true},
            {"LIFO Stack, Resizing Array stack implementation", new ResizingArrayStack<String>(), "[(])", false}
        };
    }
}
