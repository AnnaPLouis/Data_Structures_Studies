package Review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LetterCandles {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        // Read inputs here!

        System.out.println("Enter letter count: ");
        int letterCount = Integer.parseInt(reader.readLine());

        System.out.println("Enter number candles that can be removed : ");
        int m = Integer.parseInt(reader.readLine());

        System.out.println("Enter number candles that can be removed : ");
        String  letters = reader.readLine();

        System.out.println(letterCandlesCost(letterCount, m, letters));
    }
    public static int letterCandlesCost(int letterCount, int m,String str){


       /* List<Integer> frequencies = new ArrayList<>();
        List<String> chars = Arrays.asList(str.split(""));

        for (int i = 0; i < chars.size(); i++) {
                int frequency = Collections.frequency(chars,chars.get(i));
                frequencies.add(frequency);

            }
        int maxFrequency = Collections.max(frequencies);
        int minimize = Collections.max(frequencies)-m;
        frequencies.remove(maxFrequency);
        frequencies.add(minimize);

        int cost=0;

        for (int i = 0; i < frequencies.size(); i++) {
            cost+=i*i;
        }
        */

        int cost=0;

        Map <Character,Integer> map = new HashMap<>();
        int count;
        for (Character ch  : str.toCharArray()) {
            if (map.containsKey(ch)){
                count=map.get(ch);
                map.put(ch,count+1);
            } else map.put(ch, 1);

        }

        List<Integer> letterFreq = map.values().stream().sorted((o1,o2)->o2.compareTo(o1)).toList();

        int index=0;
        // minimize cost
        // O(n) n is not greater than 26 in fact it is constant
        while(m>0 && index<=letterFreq.size()-1){
            if (m>0 && letterFreq.size()==1) {
                letterFreq.set(0,letterFreq.get(0)-1);
                m--;
            }else if (letterFreq.get(index)>=letterFreq.get(index+1)) {
                letterFreq.set(index,letterFreq.get(index)-1);
                m--;
            } else if (index>0 && letterFreq.get(index)<letterFreq.get(index-1)) index--;
            else index++;
        } // O(m=26 at most) O(1)


        // calculate min cost
        // O(n) n is not > 26
        for (Integer num : letterFreq) {
            cost+=num*num;
        }
        // return result O(n)
        return cost;
    }

    }



