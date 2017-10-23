package Arrays_and_strings;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework_1_2 {


    public static String addTags(String text, String tag) {
        String result = "<" + tag + ">" + text + "<" + tag + "/>";
        return result;
    }

    public static String firstTwoChars (String input_string) {
        String result;
        if (input_string.length() <= 2)
            result = input_string;
        else
            result = input_string.substring(0, 2);
        return result;
    }

    public static String combStr (String first_str, String second_str) {
        if (first_str.length() == 0)
            return second_str;
        else if (second_str.length() == 0)
            return first_str;

        if (first_str.length() > second_str.length())
            return second_str + first_str + second_str;
        else
            return first_str + second_str + first_str;
    }

    public static char charAt(String str, int index) {
        if (str.length() == 0)
            return 0;
        index %= str.length();
        if (index < 0)
            index += str.length();
        return str.charAt(index);
    }

    public static boolean commonEnd(int[] a, int[] b)
    {
        if(a[0]==b[0] || a[a.length - 1] == b[b.length - 1])
            return true;
        return false;
    }
    public static int[] reverseArr(int [] arr) {
        int[] reverse = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            reverse[i] = arr[arr.length - 1 - i];
        return reverse;
    }

    public static int countEven(int[] arr)
    {
        int counter = 0;
        for(int a: arr)
            if(a%2 == 0)
                counter++;
        return counter;
    }

    public static int[] paritySort(int[] arr)
    {
        int []result = new int[arr.length];
        int left = 0, right = arr.length - 1;
        for(int a:arr)
        {
            if(a%2 == 0)
            {
                result[left] = a;
                left++;
            }
            else
            {
                result[right] = a;
                right--;
            }
        }
        return result;
    }

    public static String[] extractData(String str)
    {
       String result[] = new String[3];
       Pattern p = Pattern.compile("^[a-zA-Z]+:/|^[a-zA-Z]+//");
       Matcher m = p.matcher(str);

        if(m.find())
            result[0] = m.group().substring(0, m.group().length()-2);
        else
            result[0] ="";

        StringBuffer tmp;
        if(result[0].length() == 0)
            p=Pattern.compile("^[a-zA-Z0-9._-]+[/:]?");//|^[a-zA-Z0-9._-]+");
        else
            p=Pattern.compile("/[a-zA-Z0-9._-]+[/:]|/[a-zA-Z0-9._-]+");
        m = p.matcher(str);
        if(m.find()) {
            tmp = new StringBuffer(m.group());//.substring(0, m.group().length()-1);
            p=Pattern.compile("[a-zA-Z0-9._-]+");
            m = p.matcher(tmp.toString());
            m.find();
            result[1] = m.group();
        }
        else
            result[1] ="";

        p=Pattern.compile(":[0-9]+$");
        m = p.matcher(str);
        if(m.find()) {
            result[2] = m.group().substring(1, m.group().length());
        }
        else
            result[2] ="";
        return result;
    }
    public static String deleteSpaces(String str)   {
        String res;
        int left, right = str.length() - 1;
        for(left = 0; left<str.length() && Character.isWhitespace(str.charAt(left));left++);
        if(str.length() == 0 || left == str.length()) {
            res = "";
            return res;
        }
        for(right = str.length()-1; Character.isWhitespace(str.charAt(right));right--);
        res = str.substring(left, right+1);
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println("Task №1 \n" + addTags("Привет", "123"));
        System.out.println("\nTask №2 \n" +firstTwoChars("Привет"));
        System.out.println("\nTask №3 \n" +combStr("1234","567"));
        System.out.println("\nTask №4 \n" +charAt("Hello",528)+charAt("Hello",-146));
        int[] mas1 = {1,2,3,4,5,6,3};
        int[] mas2 = {1,4,8,7,5};
        int[] mas3 = {2,5,9,8};
        System.out.println("\nTask №5 \n" + commonEnd(mas1, mas2)+'\n'+commonEnd(mas1,mas3));
        System.out.println("\nTask №6");
        int []reverse_mas = reverseArr(mas2);
        for (int x:mas2) {
            System.out.print(x + ' ');
        }
        System.out.println();
        for (int x:reverse_mas) {
            System.out.print(x + ' ');
        }
        System.out.println("\n\nTask №7 \n" + countEven(mas2));
        System.out.println("\nTask №8");
        int []sorted = paritySort(mas1);
        for (int x:mas1) {
            System.out.print(x + ' ');
        }
        System.out.println();
        for (int x:sorted) {
            System.out.print(x + ' ');
        }
        System.out.println("\n\nTask №9");
        String result[] = new String[3];
        result = extractData("http://www.tratata.com/posts");
        System.out.println(result[0]+'\n'+result[1]+'\n'+result[2]);

        result = extractData("ftp//example.com:20");
        System.out.println(result[0]+'\n'+result[1]+'\n'+result[2]);

        System.out.println("\nTask №10");
        System.out.println(deleteSpaces("              "));
        System.out.println(deleteSpaces("  hfejhf hguh ghhughg uehur            "));
        System.out.println(deleteSpaces("e tet ellthejthejthe jthe jklth eth"));


    }
}
