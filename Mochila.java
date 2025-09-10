import java.util.ArrayList;

public class Mochila {
    private int capacidade;
    private int ocupado;
    private ArrayList<Item> itens;

    public Mochila(int capacidade){
        this.capacidade = capacidade;
        ocupado = 0;
        itens = new ArrayList<Item>();
    }

    public void adicionar(Item item){
        if (item == null) return;
        ocupado =+ item.peso;
        itens.add(item);
    }

    //BRUTE FORCE
    //TODO: Terminar
    public void otimizaMochila(Item[] itens){
        Item melhor = null;
        for(int i = 0; i < itens.length; i++){
            for (int j = 0; j < itens.length; j++) {
                if(melhor == null && itens[j].peso <= (capacidade - ocupado)){
                    melhor = itens[j];
                }
                if(itens[j].razaoValor >= melhor.razaoValor && itens[j].peso <= (capacidade - ocupado)){
                    
                }
            }
            adicionar(melhor);
        }
    }

    //Programacao dinamica
    public int knapcksack(int numItens, int capMoc, Item[] itens){
        int[][] maxTab = new int[numItens+1][capMoc+1];
        for (int i = 1; i <= numItens; i++) {
            for (int j = 0; j < capMoc; j++) {
                if (itens[i].peso <= j){
                    maxTab[i][j] = Math.max(maxTab[i-1][j], itens[i].valor + maxTab[i-1][j - itens[i].peso]);
                }
            }
        }

        return maxTab[numItens][capMoc];
    }
}
