public class Item {
    private String nome; 
    private int id; 
    private Double preco;

    public Item() {
        // só pra objs de ajuda
    }
    public Item(String nome, int id, Double preco) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    } 


    
}
