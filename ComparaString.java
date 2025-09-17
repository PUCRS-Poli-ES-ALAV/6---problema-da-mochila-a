public class ComparaString {

    public static int distanciaEdicao(String s1, String s2){
        return distanciaEdicaoRec(s1, s2,s1.length()-1, s2.length()-1);
    }

    private static int distanciaEdicaoRec(String s1, String s2, int i, int j){
        if(i == 0) return j;
        if(j==0) return i;
        if(s1.charAt(i) == s2.charAt(j)){
            return 0 + distanciaEdicaoRec(s1, s2, i-1, j-1);
        }
        return 1 + Math.min(Math.min(distanciaEdicaoRec(s1,s2,i-1,j-1),distanciaEdicaoRec(s1,s2,i,j-1)),distanciaEdicaoRec(s1,s2,i-1,j));
    }
}
