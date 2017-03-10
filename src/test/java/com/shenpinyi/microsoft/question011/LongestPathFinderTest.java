package com.shenpinyi.microsoft.question011;

import com.shenpinyi.utils.tree.BinaryTree;
import com.shenpinyi.utils.tree.Entry;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by jack on 10/03/2017.
 */
public class LongestPathFinderTest {

    @Test
    public void testFindMaxLengthPath() throws Exception {
        new LongestPathFinder(
            new BinaryTree<String, EntryValue>(
                Arrays.asList(
                    new Entry<String, EntryValue>("A", new EntryValue(), null),
                    new Entry<String, EntryValue>("B", new EntryValue(), null),
                    new Entry<String, EntryValue>("D", new EntryValue(), null),
                    new Entry<String, EntryValue>("H", new EntryValue(), null),
                    new Entry<String, EntryValue>("I", new EntryValue(), null),
                    new Entry<String, EntryValue>("J", new EntryValue(), null),
                    null,
                    null,
                    null,
                    null,
                    null,
                    new Entry<String, EntryValue>("E", new EntryValue(), null),
                    new Entry<String, EntryValue>("G", new EntryValue(), null),
                    null,
                    null,
                    null,
                    new Entry<String, EntryValue>("C", new EntryValue(), null),
                    new Entry<String, EntryValue>("K", new EntryValue(), null),
                    new Entry<String, EntryValue>("L", new EntryValue(), null),
                    new Entry<String, EntryValue>("M", new EntryValue(), null),
                    new Entry<String, EntryValue>("N", new EntryValue(), null),
                    null,
                    null,
                    null,
                    null,
                    null,
                    new Entry<String, EntryValue>("O", new EntryValue(), null),
                    new Entry<String, EntryValue>("P", new EntryValue(), null),
                    null,
                    null,
                    null
                )
            )
        ).findMaxLengthPath();
    }
}