import java.util.Scanner; 
import java.util.ArrayList; 

public class Principal {
    
    static int idCaixa = 0; 
    static int idItem = 0; 
    static int idPedido = 0; 
    public static void main(String[] args) {


        Scanner ler = new Scanner(System.in);
        Item objItem = new Item();
        ArrayList <Caixa> listaCaixa = new ArrayList<Caixa>(); 
        Caixa objCaixa = new Caixa();
        ArrayList <Item> listaItens = new ArrayList<Item>();


        int opc = 0;
        do{

System.out.println("1 - Logar");
System.out.println("2 - Cadastrar");
System.out.println("3 - Sair");

opc = ler.nextInt(); 
     

switch(opc){
    case 1:
// logar
System.out.println("Digite seu id de caixa");
int idVerificar = ler.nextInt();
int verificarId = listaCaixa.get(idVerificar).getId();
if( verificarId == idVerificar){

    // criar mecanismo que busca e trás um valor boolean para para de dar erro

    System.out.println("Digite sua senha");
    int senhaVerificar =ler.nextInt(); 
    int verificarSenha = listaCaixa.get(idVerificar).getSenha();
    if( verificarSenha == senhaVerificar){

int opcCaixa = 0; 
do{
System.out.println("1 - Fazer venda");
System.out.println("2 - Histórico de vendas");
System.out.println("3 - Adicionar itens");
System.out.println("4 - Voltar");
opcCaixa = ler.nextInt(); 
switch(opcCaixa){
    case 1: 
    // fazer venda
System.out.println("Itens disponiveis no catálogo: ");
for (Item item : listaItens) {
    System.out.println("Item: "+item.getNome()+"\nPreço: "+item.getPreco()+"\nId: "+item.getId()+"\n");


    break;
    case 2: 
    // ver histórico
    break; 
    case 3: 
    //adicionar itens

System.out.println("Digite o nome do item: ");
ler.nextLine();
String nomeItem = ler.nextLine();
System.out.println("Digite o preço do item: ");
Double precoItem = ler.nextDouble(); 
System.out.println("Item a ser adicionado: "+ "\nnome: "+ nomeItem+"\npreço: "+precoItem+ "\nid: "+idItem);
System.out.println("para confirmar digite (1) para adicionar o item ou  digite outro número para voltar ");
int opcItem = ler.nextInt(); 
if(opcItem == 1){
    System.out.println("item adicionado com sucesso");
Item itens = new Item(nomeItem, idItem, precoItem); 
listaItens.add(itens); 
idItem++;

} else{
    opcCaixa = 3; 

}

    break; 
    case 4: 

    break; 
    default:
    System.out.println("opção não encontrada");
    break; 
}
}while(opcCaixa != 4);

    } else {
        System.out.println("Senha incorreta");
        opc = 0; 
    }

} else{
    System.out.println("Id não encontrado");
    opc = 0; 
}

    break; 
    case 2: 
// cadastrar
System.out.println("Digite o nome do caixa: ");
ler.nextLine();
String nome = ler.nextLine();
System.out.println("Digite a senha do caixa(Max 8 números): ");
int senha = ler.nextInt();
System.out.println("id do caixa:" + idCaixa);

Caixa pessoa = new Caixa (nome, idCaixa, senha);
listaCaixa.add(pessoa);

idCaixa++;

    break; 
    case 3: 
    System.out.println("Codigo fechado");
    break; 
    default: 
    System.out.println("Opção inválida");
    break; 
}
        }while(opc !=3); 




    }
}
