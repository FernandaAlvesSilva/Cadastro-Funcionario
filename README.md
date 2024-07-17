# Projeto de Sistema de Funcionários

Este projeto consiste em um sistema de gerenciamento de funcionários utilizando Java e MySQL. O sistema permite a conexão a um banco de dados, e possibilita a inserção de dados de funcionários na tabela correspondente. O projeto inclui classes para representar os dados dos funcionários e a lógica de acesso ao banco de dados.

## Estrutura do Projeto

O projeto é dividido em duas partes principais:

1. **Classe `funcionario`**:
    - Representa os dados de um funcionário.
    - Possui atributos privados para armazenar o registro, nome, cargo e salário.
    - Inclui métodos getter e setter para acessar e modificar esses atributos.

2. **Classe `funcionarioDAO`**:
    - Responsável por gerenciar a conexão com o banco de dados e realizar operações SQL.
    - Inclui métodos para conectar ao banco de dados, salvar dados de funcionários e desconectar do banco de dados.

## Classes

### `funcionario`

```java
package dao;

public class funcionario {
    private String registro;
    private String nome;
    private String cargo;
    private double salario;
    
    public funcionario() {  
    }
    
    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
```

### `funcionarioDAO`

```java
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class funcionarioDAO {
    Connection conn;
    Statement st;
    
    public boolean conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdFunc", "root", "");
            st = conn.createStatement();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    public boolean salvar(funcionario funcionarioX) {
        String inserir = "INSERT INTO tbfuncionario VALUES ('" + funcionarioX.getRegistro() + "', '" + funcionarioX.getNome() + "','" + funcionarioX.getCargo() + "'," + funcionarioX.getSalario() + ")";
        
        try {
            st.executeUpdate(inserir);
            return true;
        } catch (SQLException ex){
            return false;
        }
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }
}
```

## Configuração do Banco de Dados

1. **Criar Banco de Dados**:
   ```sql
   CREATE DATABASE bdFunc;
   ```

2. **Criar Tabela**:
   ```sql
   CREATE TABLE tbfuncionario (
       registro VARCHAR(50) PRIMARY KEY,
       nome VARCHAR(100),
       cargo VARCHAR(50),
       salario DOUBLE
   );
   ```

## Como Executar

1. **Configurar Banco de Dados**:
   - Certifique-se de que o MySQL está instalado e em execução.
   - Crie o banco de dados e a tabela conforme as instruções acima.

2. **Compilar e Executar**:
   - Compile as classes `funcionario` e `funcionarioDAO`.
   - Utilize a classe `funcionarioDAO` para conectar ao banco de dados e inserir dados de funcionários.

3. **Exemplo de Uso**:
   ```java
   public class Main {
       public static void main(String[] args) {
           funcionarioDAO dao = new funcionarioDAO();
           
           if (dao.conectar()) {
               funcionario func = new funcionario();
               func.setRegistro("123");
               func.setNome("João da Silva");
               func.setCargo("Desenvolvedor");
               func.setSalario(5000.00);
               
               if (dao.salvar(func)) {
                   System.out.println("Funcionário salvo com sucesso!");
               } else {
                   System.out.println("Erro ao salvar funcionário.");
               }
               
               dao.desconectar();
           } else {
               System.out.println("Erro ao conectar ao banco de dados.");
           }
       }
   }
   ```

## Observações

- Certifique-se de que o driver JDBC para MySQL está incluído no classpath do projeto.
- Ajuste as credenciais de conexão (`root`, `""`) conforme necessário.

Este é um exemplo básico de como gerenciar dados de funcionários usando Java e MySQL. O projeto pode ser expandido para incluir mais funcionalidades conforme necessário.
