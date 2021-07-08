#language: pt
#encoding: iso-8859-1

Funcionalidade: Inserir Notas do Aluno 
e saber a média
e saber a situação

Esquema do Cenário: Inserir Notas e receber média e situação com sucesso
Dado Acessar a página do Cadastro de Funcionarios
E Selecionar o Funcionário <nome>   
E Selecionar o Tipo de Contratação <tipo>
Quando Solicitar a gravação das alterações
Então Sistema informará os dados alterados com sucesso

Exemplos: 
 | nome                   | tipo      |
 | "Ana Paula dos Santos" | "Estagio" |
 | "Eduardo Souza"        | "CLT"     |
  
 
Cenário: Validar os campos obrigatórios 
Sistema deverá verificar os campos em brancos
Dado Acessar a página do Cadastro de Funcionarios
Quando Solicitar a gravação das alterações
Então Sistema informará que precisam preencher todos os campos 