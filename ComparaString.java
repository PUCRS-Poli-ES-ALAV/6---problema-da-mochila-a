public class ComparaString {

    private static int iteracoes = 0;

    public static int distanciaEdicaoPD(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] matriz = new int[m][n];
        matriz[0][0] = 0;

        for (int i = 0; i < m; i++){
            matriz[i][0] = (i == 0) ? 0 : matriz[i-1][0] + 1;
        }

        for (int j = 0; j < n; j++){
            matriz[0][j] = (j == 0) ? 0 : matriz[0][j-1] + 1;
        }

        int custoExtra = 0;
        int iteracoesPD = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                iteracoesPD++;
                if(s1.charAt(i) == s2.charAt(j)){
                    custoExtra = 0;
                }
                else{
                    custoExtra = 1;
                }
                matriz[i][j] = Math.min(
                    Math.min(matriz[i-1][j] + 1, matriz[i][j-1] + 1),
                    matriz[i-1][j-1] + custoExtra
                );
            }
        }

        System.out.println("Iterações PD: " + iteracoesPD);
        return matriz[m-1][n-1];
    }


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
