public class Caixa {
    
private String nome; 
private int id; 
private int senha;

public Caixa(){
    // só pra criar o obj de ajuda
}

public Caixa(String nome, int id, int senha) {
    this.nome = nome;
    this.id = id;
    this.senha = senha;
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
public int getSenha() {
    return senha;
}
public void setSenha(int senha) {
    this.senha = senha;
} 



}
