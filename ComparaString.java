public class ComparaString {


    public int distanciaEdicao(String s1, String s2, int i, int j){
        if(s1.isBlank()) return s2.length();
        if(s2.isBlank()) return s1.length();
        if(s1.charAt(i) == s2.charAt(j)){
            return 0 + distanciaEdicao(s1, s2, i-1, j-1);
        }
        return Math.min();
    }
}
