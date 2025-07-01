# language: pt

Funcionalidade: Comprar telefone
  Cenário: Realizar a compra de um telefone
    Dado que eu esteja no site
    Quando eu selecionar a categoria "Phones"
    E adicionar o telefone "Samsung galaxy s6" no carrinho
    E acessar o carrinho
    E finalizar a compra preenchendo todos os campos obrigatórios
    Então apresentará a mensagem de compra com sucesso