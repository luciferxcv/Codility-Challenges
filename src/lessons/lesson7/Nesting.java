package lessons.lesson7;

public class Nesting {
    public int solution(String S){
        int i = -1;
        char[] brackets = S.toCharArray();
        for(int j = 0; j < brackets.length; j++){
            if(brackets[j] == '(') brackets[++i] = brackets[j];
            else if(i == -1) return 0;
            else i--;
        }
        return i == -1 ? 1 : 0;
    }
}
