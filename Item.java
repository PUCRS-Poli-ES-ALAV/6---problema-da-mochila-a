public class Item {
    public int peso;
    public int valor;
    public double razaoValor;

    public Item(int peso, int valor){
        this.peso = peso;
        this.valor = valor;
        razaoValor = valor / peso;
    }
}
