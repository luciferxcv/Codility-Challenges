package lessons.lesson7;

public class Brackets {
    public int solution(String S){
        char[] brackets = S.toCharArray();
        int len = brackets.length;
        int i = -1;
        for(int j = 0; j < len; j++){
            char bracket = brackets[j];
            if(bracket == '(' || bracket == '[' || bracket == '{'){
                brackets[++i] = bracket;
            }else if(i == -1 || Math.abs(brackets[j] - brackets[i]) > 2){
                return 0;
            }else{
                i--;
            }
        }
        return i == -1 ? 1 : 0;
    }

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        System.out.println(brackets.solution("{[()()]}"));
        System.out.println(brackets.solution("([)()]"));
        System.out.println(brackets.solution("("));
        System.out.println(brackets.solution(""));
        System.out.println(brackets.solution("{())"));
    }
}
