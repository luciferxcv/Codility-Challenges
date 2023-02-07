package lessons.lesson5;

import java.util.HashMap;
import java.util.Map;

public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q){
        int len = S.length();
        Map<Character, Integer> nucleotideMap = new HashMap<>();
        nucleotideMap.put('A', 0);
        nucleotideMap.put('C', 1);
        nucleotideMap.put('G', 2);
        nucleotideMap.put('T', 3);
        int[][] prefixSum = new int[len][4];
        prefixSum[0][nucleotideMap.get(S.charAt(0))] = 1;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < 4; j++){
                prefixSum[i][j] = prefixSum[i-1][j];
            }
            prefixSum[i][nucleotideMap.get(S.charAt(i))]++;
        }
        int queryLen = P.length;
        int[] queryResults = new int[queryLen];
        for(int i = 0; i < queryLen; i++){
            int[] segmentSum = new int[4];
            if(P[i] == 0){
                segmentSum = prefixSum[Q[i]];
            }else{
                for(int j = 0; j < 4; j++){
                    segmentSum[j] = prefixSum[Q[i]][j] - prefixSum[P[i]-1][j];
                }
            }
            if(segmentSum[0] > 0){
                queryResults[i] = 1;
            }else if(segmentSum[1] > 0){
                queryResults[i] = 2;
            }else if(segmentSum[2] > 0){
                queryResults[i] = 3;
            }else{
                queryResults[i] =4;
            }
        }
        return queryResults;
    }

    public static void main(String[] args) {
        GenomicRangeQuery query = new GenomicRangeQuery();
        for(int i : query.solution("CAGCCTA", new int[]{2,5,0}, new int[]{4,5,6})){
            System.out.println(i);
        }
    }
}
