package common;

/**
 * Author : mahdi ,  Date : 9/4/2021
 */
public class WordCounter {
    public static int countWords1(String sentence){
        while(sentence.contains("  ")){
            sentence = sentence.replaceAll("  "," ");
        }
        String[] strings  =sentence.split(" ");
        return strings.length;
    }

    public static int countWords2(String sentence){
        int count = 0 ;
        while(sentence.length()>0) {
            int index = sentence.indexOf(" ");

            if (index != 0){
                count++;
                sentence = sentence.substring(index);
            }
            else{
                sentence = sentence.substring(index+1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String sentence= "salam     mahdi     yaghoobi   maman";
        System.out.println( countWords1(sentence));
        System.out.println( countWords2(sentence));
    }
}
