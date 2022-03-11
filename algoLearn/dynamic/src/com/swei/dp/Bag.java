package com.swei.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: SweiPC
 * Date: 2022-03-11
 * Time: 17:54
 */
public class Bag {
    /*处理过程中需要的二维数组的元素定义*/
    private static class ArrayElement {
        /*计算后数组元素*/
        private int value;
        /*哪些物品的值组成了当前数组元素*/
        private Set<Element> elements;

        public ArrayElement(int value, Element element) {
            this.value = value;
            this.elements = new HashSet<>();
            this.elements.add(element);
        }

        public ArrayElement(int value, Set<Element> element) {
            this.value = value;
            this.elements = element;
        }

        @Override
        public String toString() {
            return "ArrayElement{" +
                    "value=" + value +
                    ", elements=" + elements +
                    '}';
        }
    }

    private static class Element {
        private final String name;
        private final int vlaue;
        private final int cost;
    }

}
