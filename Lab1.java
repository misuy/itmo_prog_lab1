import java.util.ArrayList;

public class Lab1
{
    public static int[] fillA1(int start, int end)
    {
        int[] m = new int[(int) (end - start) / 2 + 1];
        int pos = 0;
        for (int i = start; i <= end; i += 2)
        {
            m[pos] = i;
            pos++;
        }
        return m;
    }

    public static float[] fillX(float min, float max, int len)
    {
        float[] m = new float[len];
        for (int i = 0; i < len; i++)
        {
            m[i] = min + (float) Math.random() * (max - min);
        }
        return m;
    }


    public static boolean isInArray(int el, int[] m)
    {
        boolean b = false;
        for (int i=0; i<m.length; i++)
        {
            if (el == m[i])
            {
                b = true;
                break;
            }
        }
        return b;
    }


    public static float calcCase1(float x)
    {
        return (float) Math.pow(Math.pow((Math.tan(x) / 3) / 4, Math.pow(3 * (x - 1), 2)), Math.log(Math.pow(Math.tan(x), 2)) / 2);
    }


    public static float calcCase2(float x)
    {
        return (float) Math.pow(Math.pow(Math.asin((x - 3.5) / 21) / 2, 3), Math.pow(x, Math.pow(x, Math.pow(0.25 / x, 3) * (Math.atan((x - 3.5) / 21) - 1))) / 2);
    }

    public static float calcCase3(float x)
    {
        return (float) Math.atan(0.1 * Math.pow(Math.E, -Math.pow(Math.abs(x)/(Math.abs(x) + 1), (float) 1/3))); //тк java почему то не извлекает корень 3 степени из отрицательного числа, возьмем его по модулю, а потом искусственно добавим "-" (Math.abs(x)/(Math.abs(x) + 1) - всегда >= 0)
    }


    public static float[][] fillA2(int case1, int[] case2, int height, int weight, int[] a, float[] x)
    {
        float[][] m = new float[height][weight];
        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < weight; j++)
            {
                if (a[i] == case1) m[i][j] = calcCase1(x[j]);
                else if (isInArray(a[i], case2)) m[i][j] = calcCase2(x[j]);
                else m[i][j] = calcCase3(x[j]);
            }
        }
        return m;
    }

    public static String modToString(float n, int maxLen, int longDigitsCounter)
    {
        String s = String.format("%.3f", n);
        int len = s.length();
        if (maxLen > len)
        {
            for (int i = 0; i < (maxLen - len); i++)
            {
                s += " ";
            }
        }
        else s = "(" + Integer.toString(longDigitsCounter + 1) + ")       ";
        return s;
    }

    public static String isLongDigit(float n, int maxLen, int longDigitsCounter)
    {
        String s = String.format("%.3f", n);
        if (maxLen <= s.length())
        {
            return "(" + Integer.toString(longDigitsCounter + 1) + ") - " + s + "\n";
        }
        else return "";
    }


    public static void printArray(float[][] m)
    {
        int maxLen = 10;
        String ss = "";
        String line = "";
        String longDigitsLine = "";
        int longDigitsCounter = 0;
        for (int i = 0; i < m.length; i++)
        {
            line = "";
            for (int j = 0; j < m[i].length; j++)
            {
                line += modToString(m[i][j], maxLen, longDigitsCounter);
                ss = isLongDigit(m[i][j], maxLen, longDigitsCounter);
                longDigitsLine += ss;
                if (ss != "") longDigitsCounter++;
            }
            System.out.println(line);
        }
        System.out.println(longDigitsLine);
    }

    public static void main(String[] args)
    {
        final int STARTA1 = 4;
        final int ENDA1 = 24;
        final int LENX = 18;
        final int HEIGHTA2 = 11;
        final int WEIGHTA2 = 18;
        final float MINX = (float) -14.0;
        final float MAXX = (float) 7.0;
        final int CASE1 = 18;
        final int[] CASE2 = {8, 14, 16, 20, 24};
        int[] a1 = fillA1(STARTA1, ENDA1);
        float[] x = fillX(MINX, MAXX, LENX);
        float[][] a2 = fillA2(CASE1, CASE2, HEIGHTA2, WEIGHTA2, a1, x);
        printArray(a2);
    }
}