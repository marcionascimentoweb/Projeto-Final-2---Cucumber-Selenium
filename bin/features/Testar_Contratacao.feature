#language: pt
#encoding: iso-8859-1

Funcionalidade: Inserir Notas do Aluno 
e saber a m�dia
e saber a situa��o

Esquema do Cen�rio: Inserir Notas e receber m�dia e situa��o com sucesso
Dado Acessar a p�gina do Cadastro de Funcionarios
E Selecionar o Funcion�rio <nome>   
E Selecionar o Tipo de Contrata��o <tipo>
Quando Solicitar a grava��o das altera��es
Ent�o Sistema informar� os dados alterados com sucesso

Exemplos: 
 | nome                   | tipo      |
 | "Ana Paula dos Santos" | "Estagio" |
 | "Eduardo Souza"        | "CLT"     |
  
 
Cen�rio: Validar os campos obrigat�rios 
Sistema dever� verificar os campos em brancos
Dado Acessar a p�gina do Cadastro de Funcionarios
Quando Solicitar a grava��o das altera��es
Ent�o Sistema informar� que precisam preencher todos os campos 