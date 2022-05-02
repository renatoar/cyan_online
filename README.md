# cyan_online

Cyan Online é um projeto com objetivo de levar o compilador Cyan para Web e ser usado por qualquer um na comunidade. 
O projeto é composto por uma interface web simples construída em PHP que disponibiliza um editor e campo para input de argumentos para seu código Cyan, sendo possível compilar e verificar o resultado diretamente nesta interface. 
O compilador Cyan que acompanha o projeto é usado para efetuar a compilação em tempo real e o PHP cuida de levar o código para ser compilado e trazer o resultado para a interface.

Para maiores informações sobre a linguagem Cyan, consulte: http://cyan-lang.org/.

## Ambientes

Linux

## Requisitos:

Java 8 ou superior
PHP 8 ou superior
Apache Web Server

### Diretório destino na instância (server):
/var/www/html

## Como configurar:

- Instale todos os componentes listados em requisitos na máquina que será usada como servidor. 

- Coloque todo o conteúdo deste repositório no diretório "/var/www/html" do servidor.

- Inicie o Apache Web Server

## Atualizar compilador Cyan

Tanto as bibliotecas como o próprio compilador de Cyan estão localizados no diretório "Cyan/". Para atualizá-lo basta substituir qualquer arquivo deste diretório e copiar novamente para o diretório "/var/www/html" do servidor.