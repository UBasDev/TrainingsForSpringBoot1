package org.group1.relational1.Core.Application.Helpers;

import org.springframework.stereotype.Component;

@Component
public class ArrayHelpers {
    public static String[] addItemAndReturnNewArray(String[] arr, String x) {
        short arrayLength = (short) arr.length;
        String[] newArray = new String[arrayLength + 1];
        for (short i = 0; i < arrayLength; i++)
            newArray[i] = arr[i];
        newArray[arrayLength] = x;
        return newArray;
    }
}
