package com.mycompany.funcionariomvc.DAO;

import com.mycompany.funcionariomvc.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rafaelamoreira
 */
public class FuncionarioDAOMySQL extends DAOAbstract implements FuncionarioDAO{
    private Map<Integer, Funcionario> funcionarios = new HashMap<>();
    //private static FuncionarioDAOMySQL instance = null;

    private FuncionarioDAOMySQL() {

    }

    public static DAOAbstract getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAOMySQL();
        }
        return instance;
    }
    public List<Funcionario> getFuncionarios() {
        Connection conn = DBConnection.getInstance().getConnection();
        List<Funcionario> obj = new ArrayList<>();
        try {
            String sql = Funcionario.SELECT;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet);
                Funcionario tmp = fromResultSet(resultSet);
                obj.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       
        //List<Funcionario> obj = new ArrayList<>();
        //funcionarios.values().forEach((f) -> {
        //    obj.add(f);
        //});
        return obj;
        
    }
    private void updateFuncionario(Funcionario f) {
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            String sql = Funcionario.UPDATE;
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, f.getNome());
            ps.setInt(2, f.getIdade());
            ps.setDouble(3, f.getSalario());
            ps.setInt(4, f.getId());
            

            ps.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println("erro:"+e.getMessage());
        }
        
    }

    private void insertFuncionario(Funcionario f) {
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            String sql = Funcionario.INSERT;
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, f.getNome());
            ps.setInt(2, f.getIdade());
            ps.setDouble(3, f.getSalario());
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            generatedKeys.next();
            int ai = generatedKeys.getInt(1);
            System.out.println("ID: " + ai);
            f.setId(ai);
            

        } catch (SQLException e) {
            System.out.println("erro:"+e.getMessage());
        }
        
    }

    public void salvarFuncionario(Funcionario f) {
        if (f.getId() == 0) {
            insertFuncionario(f);
        } else {
            updateFuncionario(f);
        }
        
    }

    public int buscaCodigo() {
         
        Connection conn = DBConnection.getInstance().getConnection();
        int id = 0;
        try {
            String sql = "select max(id) from funcionarios";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
        
       
    }

    @Override
    public Funcionario buscarFuncionario(int id) {
        Connection conn = DBConnection.getInstance().getConnection();
        Funcionario obj = null;
        try {
            String sql = Funcionario.SELECT+ " where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet);
                obj = fromResultSet(resultSet);
                
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        return obj;  
    }

    private Funcionario fromResultSet(ResultSet resultSet) throws SQLException {
        return new Funcionario(resultSet.getInt("id"), resultSet.getString("nome"),
                        resultSet.getInt("idade"), resultSet.getInt("salario"));
    }
}
