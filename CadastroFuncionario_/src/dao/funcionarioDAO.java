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
