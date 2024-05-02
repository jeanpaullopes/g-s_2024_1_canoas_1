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
public interface FuncionarioDAO {
    
    public List<Funcionario> getFuncionarios();
    
    public void salvarFuncionario(Funcionario f);
    public int buscaCodigo();
    
    
}
