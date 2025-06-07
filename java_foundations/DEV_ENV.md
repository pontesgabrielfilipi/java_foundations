# Ambiente de Desenvolvimento Moderno com WSL2

## Tutorial de instalação do WSL2

[Clique no link](https://learn.microsoft.com/pt-br/windows/wsl/install)

## Requisitos mínimos

- **Windows 10 Home ou Professional**

  - Versão 2004 ou superior (Build 19041 ou superior).
  - Versões mais antigas requerem a instalação manual do WSL 2. Ver tutorial [https://learn.microsoft.com/en-us/windows/wsl/install-manual](https://learn.microsoft.com/en-us/windows/wsl/install-manual).

- **Windows 11 Home ou Professional**

  - Versão 22000 ou superior (qualquer Windows 11).

- Uma máquina compatível com virtualização (verifique a disponibilidade de acordo com a marca do seu processador. Se sua máquina for mais antiga pode ser necessária habilita-la na BIOS).

- Pelo menos 4GB de memória RAM (Recomendado 8GB).

### Atualizar o WSL

Com a versão 2004 do Windows 10 ou Windows 11, o WSL já estará presente em sua máquina, execute o comando para pegar a versão mais recente do WSL:

```bash
wsl --update
```

### Distribuições

Após a instalação do WSL2 é necessário instalar uma distribuição Linux.

### Integração com VSCode

[Clique no link](https://learn.microsoft.com/pt-br/windows/wsl/tutorials/wsl-vscode)

## Z-Shell (Zsh) um poderoso shell de linha de comandos

O Shell é uma camada que faz intermediação de comandos/serviços entre o sistema operacional e o usuário. São divididos em dois grupos:

- shells CLIs (Command Line Interface): interface baseada em texto, também conhecida como linha de comando
- shells GUIs (Graphical User Interface): interface gráfica para que os comandos não precisem ser digitados, sendo executados por interação com elementos gráficos como ícones, atalhos, botões, etc.

Geralmente quando se trata de shell nos referimos aos shells CLIs, ou terminal. Há alguns interpretadores de comandos diferentes, como:

### Bash

- Mais popular entre os interpretadores, sendo o padrão na maioria das distribuições.

### Szh

- Zsh é um shell projetado para uso interativo, embora também seja uma linguagem de script poderosa. Para sua instalação se usa o framework Oh My Zsh, que facilita a digitação de comandos.

### Instalação do Oh My Zsh

Exemplo de instalação para o apt (gerenciador de pacotes das distribuições Ubuntu e Debian)

#### Instalação do Oh My Zsh

```
sudo apt-get install zsh
```

#### Definir o Zsh como o seu shell padrão

```
chsh -s $(which zsh)
```

#### Verificar a instalação

```
zsh --version
```

#### Verificar a instalação do Client URL (CURL)

Para prosseguir com a instalação do framework OhMyZsh, precisaremos do gerenciados de pacotes curl instalado. Caso não o tenha, faça a instalação através do comando abaixo:

```
sudo apt install curl
```

Além disso, verifique a instalação do git, em sua máquina: git --version. Caso não tenha uma resposta positiva, instale com o seguinte comando:

```
sudo apt install git
```

#### Instalação do Oh My Zsh

```
sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
```

#### Personalizando o Ambiente

Instale via Terminal

```
sudo apt-get install fonts-powerline
```

Ou instale as fontes diratamente no Windows

- [MesloLGS NF Regular.ttf](https://github.com/romkatv/powerlevel10k-media/raw/master/MesloLGS%20NF%20Regular.ttf)
- [MesloLGS NF Bold.ttf](https://github.com/romkatv/powerlevel10k-media/raw/master/MesloLGS%20NF%20Bold.ttf)
- [MesloLGS NF Italic.ttf](https://github.com/romkatv/powerlevel10k-media/raw/master/MesloLGS%20NF%20Italic.ttf)
- [MesloLGS NF Bold Italic.ttf](https://github.com/romkatv/powerlevel10k-media/raw/master/MesloLGS%20NF%20Bold%20Italic.ttf)

E depois abra o terminal para que ele carregue as fontes.

Na configuração do tipo de fonte, altere para a fonte MesloLGS NF.

#### Plugins que Transformam a Experiência

Obervação: entre na pasta raíz do usuário

```
 cd ~
```

##### Zsh-syntax-highlighting

Este plugin realça comandos corretos em verde e erros em vermelho. Sua instalação é feita com o comando:

```
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting

git clone https://github.com/zdharma-continuum/fast-syntax-highlighting.git ${ZSH_CUSTOM:-$HOME/.oh-my-zsh/custom}/plugins/fast-syntax-highlighting
```

##### Zsh-autosuggestions

Para sugestões de comandos baseadas no histórico, o plugin Zsh-autosuggestions é essencial:

```
git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting
```

##### Zsh-autocomplete

```
git clone --depth 1 -- https://github.com/marlonrichert/zsh-autocomplete.git $ZSH_CUSTOM/plugins/zsh-autocomplete
```

##### Habilitar Plugins e adicioná-los ao .zshrc

- Use o editor de texto de sua preferência

```
nano ~/.zshrc
```

- Encontre a linha que diz plugins=(git)
- Substitua essa linha por plugins=(git zsh-autosuggestions zsh-syntax-highlighting fast-syntax-highlighting zsh-autocomplete)

# Configurações GIT

- git init
- git add .
- git commit -m "first commit"
- git branch -M main
- git remote add origin https://github.com/seu-usuario-do-github/java_foundations.git
- git push -u origin main

# Instalação do JDK 24 (Java Development Kit)

- Acesse o site:
  [JDK Download](https://www.oracle.com/java/technologies/downloads/)

- Acessar o WSL 2
  - Use wget para baixar o arquivo. Exemplo:

```
wget https://download.oracle.com/java/24/latest/jdk-24_linux-x64_bin.tar.gz
sudo mkdir -p /opt/jdk
sudo tar -xvzf jdk-24_linux-x64_bin.tar.gz -C /opt/jdk
```

- Configurar as variáveis de ambiente

```
nano ~/.zshrc
```

- Adicione ao final:

```
export JAVA_HOME=/opt/jdk/jdk-24.0.1
export PATH=$JAVA_HOME/bin:$PATH
```

- Salve e recarregue o shell:

```
source ~/.zshrc
```

- Verificar instalação

```
java -version
```

- Você deve ver algo como:

```
java version "24.0.1" 2025-04-15
Java(TM) SE Runtime Environment (build 24.0.1+9-30)
Java HotSpot(TM) 64-Bit Server VM (build 24.0.1+9-30, mixed mode, sharing)
```
