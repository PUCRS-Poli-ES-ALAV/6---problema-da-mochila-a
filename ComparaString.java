public class ComparaString {

    private static int iteracoes = 0;

    public static int distanciaEdicaoForcaBruta(String s1, String s2){
        iteracoes = 0;
        int resultado = distanciaEdicaoForcaBrutaRec(s1, s2, s1.length()-1, s2.length()-1);
        System.out.println("Iterações: " + iteracoes);
        return resultado;
    }

    private static int distanciaEdicaoForcaBrutaRec(String s1, String s2, int i, int j){
        iteracoes++;
        if(i == 0) return j;
        if(j == 0) return i;
        if(s1.charAt(i) == s2.charAt(j)){
            return distanciaEdicaoForcaBrutaRec(s1, s2, i-1, j-1);
        }
        return 1 + Math.min(
            Math.min(
                distanciaEdicaoForcaBrutaRec(s1, s2, i-1, j-1),
                distanciaEdicaoForcaBrutaRec(s1, s2, i, j-1)
            ),
            distanciaEdicaoForcaBrutaRec(s1, s2, i-1, j)
        );
    }
}
