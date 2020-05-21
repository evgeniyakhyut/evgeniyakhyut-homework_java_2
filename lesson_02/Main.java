package ru.gb.jtwo.blesson.online;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String matrixString = "10 3 1 2\n2 3 2 2\n5 6 7 l\n300 3 1 0";
        String[][] array = new String[4][4];

        try {
            array = stringToArray(matrixString);

            System.out.println("stringToArray");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("We failed: " + e.getMessage());
        }

        int[][] arrayInt = new int[4][4];

        try {
            arrayInt = arrayToInt(array);

            System.out.println("arrayToInt");
            for (int i = 0; i < arrayInt.length; i++) {
                for (int j = 0; j < arrayInt[i].length; j++) {
                    System.out.print(arrayInt[i][j] + " ");
                }
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.out.println("We failed arrayToInt: " + e.getMessage());
        }

        System.out.println(sumAndDivide(arrayInt));
    }

    private static String[][] stringToArray (String matrixString) throws IOException {
            String symbolAcc = "";
            String[][] arr = new String[4][4];
            int lineNumber = 0;
            int columnNumber = 0;

            for (int i = 0; i < matrixString.length(); i++) {
                if (matrixString.charAt(i) == ' ') {
                    arr[lineNumber][columnNumber] = symbolAcc;
                    symbolAcc = "";
                    columnNumber++;
                } else if (matrixString.charAt(i) == '\n') {
                    if (columnNumber != 3) {
                        throw new IOException("Line has wrong size");
                    }
                    arr[lineNumber][columnNumber] = symbolAcc;
                    symbolAcc = "";
                    columnNumber = 0;
                    lineNumber++;
                } else if (i == matrixString.length() - 1) {
                    if (columnNumber != 3) {
                        throw new IOException("Line has wrong size");
                    }
                    symbolAcc += matrixString.charAt(i);
                    arr[lineNumber][columnNumber] = symbolAcc;
                    break;
                } else {
                    symbolAcc += matrixString.charAt(i);
                }
            }

            if (lineNumber != 3) {
                throw new IOException("Matrix has wrong size");
            }

            return arr;
    }

    private static int[][] arrayToInt(String[][] arrayOfString) throws NumberFormatException {
        int lengthOfArray = 4;
        int heightOfArray = 4;
        int[][] integerArray = new int[lengthOfArray][heightOfArray];

        for (int i = 0; i < lengthOfArray; i++) {
            for (int j = 0; j < heightOfArray; j++) {
                if (!isNumber(arrayOfString[i][j])) {
                    throw new NumberFormatException("A matrix element is not a number");
                }

                integerArray[i][j] = Integer.parseInt(arrayOfString[i][j]);
            }
        }

        return integerArray;
    }

    private static Boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static float sumAndDivide(int[][] arrayOfInt) {
        float sum = 0;
        float result;

        for (int i = 0; i < arrayOfInt.length; i++) {
            for (int j = 0; j < arrayOfInt[i].length; j++) {
                sum += (float) arrayOfInt[i][j];
            }
        }
        result = sum / 2;
        return result;
    }
}
