package com.mycompany.funcionariomvc.DAO;

import com.mycompany.funcionariomvc.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelamoreira
 */
public class FuncionarioDAO {

    public static List<Funcionario> getFuncionarios() {
        Connection conn = DBConnection.getInstance().getConnection();
        List<Funcionario> obj = new ArrayList<>();
        try {
            String sql = "select * from funcionario";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Funcionario tmp = new Funcionario(resultSet.getInt("id"), resultSet.getString("nome"),
                        resultSet.getInt("idade"), resultSet.getInt("salario"));
                obj.add(tmp);
            }

        } catch (SQLException e) {
        }
        return obj;
    }

    public static void salvarFuncionario(Funcionario f) {
        Connection conn = DBConnection.getInstance().getConnection();
        try {
            String sql = "insert into funcionario (id, nome, idade, salario) values (?, ?, ?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, f.getId());
            ps.setString(2, f.getNome());
            ps.setInt(3, f.getIdade());
            ps.setDouble(4, f.getSalario());

            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public static int buscaCodigo() {
        Connection conn = DBConnection.getInstance().getConnection();
        int id = 0;
        try {
            String sql = "select max(id) from funcionario";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);

        } catch (SQLException e) {
        }
        return id;
    }
}
