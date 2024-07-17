
package dao;

public class funcionario {
    private String registro;
    private String nome;
    private String cargo;
    private double salario;
    
            
    public funcionario(){  
}
    
public String getRegistro(){
    return registro;
}

public void setRegistro(String registro){
    this.registro = registro;
}

public String getNome(){
    return nome;
}

public void setNome(String registro){
    this.nome = registro;
}


public String getCargo() {
    return cargo;
}

public void setCargo(String cargo){
    this.cargo = cargo;
}

public double getSalario(){
    return salario;
   
}

public void setSalario(double salario){
    this.salario = salario;
}
}