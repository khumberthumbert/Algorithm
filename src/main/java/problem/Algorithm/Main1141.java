package problem.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//접두사
public class Main1141 {

    static int N;

    public static boolean isPrefix(String word1, String word2) {
        return word2.startsWith(word1);
    }

    public static int findMaxPrefixSet(List<String> words){
        Set<String> wordSet = new HashSet<>(words);
        List<String> uniqueWords = new ArrayList<>(wordSet);

        int n = uniqueWords.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isPrefixFound = false;
            for (int j = 0; j < n; j ++) {
                //i == j 인 경우 -> 자기자신이므로 비교 할 필요 x
                if(i !=j && isPrefix(uniqueWords.get(i), uniqueWords.get(j))){
                    isPrefixFound = true;
                    break;
                }
            }
            if (!isPrefixFound) {
                count += 1;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //String[] words = new String[N];
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        System.out.println(findMaxPrefixSet(words));

    }

}
