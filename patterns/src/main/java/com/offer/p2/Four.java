package com.offer.p2;

public class Four {
    public static void main(String[] args) {
        char[] chars;
//        String str = "we are   happy.";
        String str = "  ";
        chars = str.toCharArray();
        char[] chars1 = ReplaceBlank(chars, chars.length);
        for (char aChar : chars1) {
            System.out.print(aChar);
        }
    }

    public static char[]  ReplaceBlank(char[] chars, int length) {
        if (chars == null || length < 0) {
            return null;
        }
        // 遍历一遍，先找到空格数量
        int blankNum = 0;
        for (char c : chars) {
            if (c == ' ') {
                blankNum++;
            }
        }
        // 把空格换成 %20 后的长度
        int newLength = length + 2 * blankNum;
        int indexOfOriginal = length -1;
        int indexOfNew = newLength -1;
        char[] newChars = new char[newLength];
        System.arraycopy(chars, 0, newChars, 0, chars.length);

        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if (newChars[indexOfOriginal] == ' ') {
                newChars[indexOfNew--] = '0';
                newChars[indexOfNew--] = '2';
                newChars[indexOfNew--] = '%';
            } else {
                newChars[indexOfNew--] = newChars[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        return newChars;
    }
}
