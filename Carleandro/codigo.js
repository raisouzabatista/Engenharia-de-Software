function Cadastrar(){
var x = document.getElementById('Senha'); 
var valor1 = x.value; 
var y = document.getElementById('ConfSenha');
var valor2 = y.value; 

var u = document.getElementById('nome'); 
var nome = u.value; 


if (valor1 == valor2){

    localStorage.setItem("nome", nome);
    localStorage.setItem("senha", valor1);
alert('deu certo');

} else {
    alert('Senhas diferentes');
}


}
function Logar(){

var x = document.getElementById('nome2'); 
var nome = x.value; 
var y = document.getElementById('Senha2');
senha = y.value; 


    if(senha == localStorage.getItem('senha') && nome == localStorage.getItem('nome')){
    

        window.location.href = "caixa.html";


    } else{
        alert('Login incorreto')
    }


}
var itens = [];
var vendas = [];
var historico = [];

function adicionarItem() {
  var id = document.getElementById("item-id").value;
  var nome = document.getElementById("item-nome").value;
  var preco = parseFloat(document.getElementById("item-preco").value);
  
  var item = {
    id: id,
    nome: nome,
    preco: preco
  };
  
  itens.push(item);
  salvarItens();
  
  var table = document.getElementById("itens-table");
  var row = table.insertRow();
  row.innerHTML = "<td>" + id + "</td><td>" + nome + "</td><td>" + preco.toFixed(2) + "</td>";
  
  // Limpar campos de entrada
  document.getElementById("item-id").value = "";
  document.getElementById("item-nome").value = "";
  document.getElementById("item-preco").value = "";
}

function adicionarVenda() {
  var id = document.getElementById("venda-id").value;
  var quantidade = parseInt(document.getElementById("venda-quantidade").value);
  
  var item = itens.find(function(item) {
    return item.id === id;
  });
  
  if (item) {
    var total = item.preco * quantidade;
    
    var vendaItem = {
      id: item.id,
      nome: item.nome,
      preco: item.preco,
      quantidade: quantidade,
      total: total
    };
    
    vendas.push(vendaItem);
    
    var table = document.getElementById("venda-table");
    var row = table.insertRow();
    row.innerHTML = "<td>" + item.id + "</td><td>" + item.nome + "</td><td>" + item.preco.toFixed(2) + "</td><td>" + quantidade + "</td><td>" + total.toFixed(2) + "</td>";
    
    // Limpar campos de entrada
    document.getElementById("venda-id").value = "";
    document.getElementById("venda-quantidade").value = "";
    
    // Adicionar venda ao histórico
    historico.push(vendaItem);
    salvarHistorico();
    exibirHistorico(); // Adicionado aqui para atualizar o histórico
  } else {
    alert("Item não encontrado");
  }
}

function calcularTotal() {
    var total = 0;
    
    vendas.forEach(function(item) {
      total += item.total;
    });
    
    document.getElementById("total").innerHTML = "Total: R$ " + total.toFixed(2);
    exibirHistorico();
    salvarHistorico();
     // Atualizar histórico ao calcular o total
  }

  function salvarItens() {
    localStorage.setItem("itens", JSON.stringify(itens));
  }
  
  function carregarItens() {
    var itensData = localStorage.getItem("itens");
    if (itensData) {
      itens = JSON.parse(itensData);
      exibirItens();
    }

    
  }
  
  function salvarHistorico() {
    localStorage.setItem("historico", JSON.stringify(historico));
  }

function carregarHistorico() {
    var historicoData = localStorage.getItem("historico");
    if (historicoData) {
      historico = JSON.parse(historicoData);
      exibirHistorico();
    }
  }

function exibirItens() {
  var table = document.getElementById("itens-table");
  table.innerHTML = "<tr><th>ID</th><th>Nome</th><th>Preço</th></tr>";
  
  itens.forEach(function(item) {
    var row = table.insertRow();
    row.innerHTML = "<td>" + item.id + "</td><td>" + item.nome + "</td><td>" + item.preco.toFixed(2) + "</td>";
  });
}
function exibirHistorico() {
  var historicoTable = document.getElementById("historico-table");
  historicoTable.innerHTML = "<tr><th>ID</th><th>Nome</th><th>Preço</th><th>Quantidade</th><th>Total</th></tr>";
  
  historico.forEach(function(item) {
    var row = historicoTable.insertRow();
    row.innerHTML = "<td>" + item.id + "</td><td>" + item.nome + "</td><td>" + item.preco.toFixed(2) + "</td><td>" + item.quantidade + "</td><td>" + item.total.toFixed(2) + "</td>";
  });
}

  
  // Carregar itens e histórico ao carregar a página
  carregarItens();
  carregarHistorico();