package challenge.jurassiccode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public int solution(int[] X, int[] Y, String colors) {
        // write your code in Java SE 8
        int result = 0;
        char[] colorArray = colors.toCharArray();
        RadiusInfo radiusInfo = new RadiusInfo();
        for(int i = 0; i < X.length; i++){
            int radius = X[i]*X[i] + Y[i]*Y[i];
            radiusInfo.add(radius, colorArray[i]);
        }
        if(radiusInfo.red == radiusInfo.green)
            result = radiusInfo.red + radiusInfo.green;
        else{
            List<Integer> list = new ArrayList<>(radiusInfo.radiusMap.keySet());
            list.sort((a, b) -> b - a);
            for(int radius : list){
                int[] colorInfo = radiusInfo.radiusMap.get(radius);
                radiusInfo.red -= colorInfo[0];
                radiusInfo.green -= colorInfo[1];
                if(radiusInfo.red == radiusInfo.green){
                    result = radiusInfo.red += radiusInfo.green;
                    break;
                }
            }
        }
        return result;
    }
    class RadiusInfo{
        int red;
        int green;
        Map<Integer, int[]> radiusMap;
        public RadiusInfo(){
            red = 0;
            green = 0;
            radiusMap = new HashMap<>();
        }
        public void add(int radius, char color){
            int[] colorInfo;
            if(radiusMap.containsKey(radius)){
                colorInfo = radiusMap.get(radius);
                if(color == 'R'){
                    colorInfo[0]++;
                    red++;
                } else{
                    colorInfo[1]++;
                    green++;
                }
            }else{
                colorInfo = new int[2];
                if(color == 'R') {
                    colorInfo[0]++;
                    red++;
                } else {
                    colorInfo[1]++;
                    green++;
                }
                radiusMap.put(radius, colorInfo);
            }
        }
    }
}
