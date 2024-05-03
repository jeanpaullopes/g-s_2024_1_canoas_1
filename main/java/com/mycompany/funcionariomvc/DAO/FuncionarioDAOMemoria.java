package com.mycompany.funcionariomvc.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.funcionariomvc.model.Funcionario;

public class FuncionarioDAOMemoria extends DAOAbstract implements FuncionarioDAO {
    
private Map<Integer, Funcionario> funcionarios;
private static FuncionarioDAOMemoria instance = null;

public static DAOAbstract getInstance() {
    if (instance == null) {
        instance = new FuncionarioDAOMemoria();
    }
    return instance;
}

private FuncionarioDAOMemoria() {
    super();
    this.funcionarios = new HashMap();
}
@Override
public List<Funcionario> getFuncionarios() {
    List<Funcionario> obj = new ArrayList<>();
    funcionarios.values().forEach((f) -> {
        obj.add(f);
    });
    return obj;
}

@Override
public void salvarFuncionario(Funcionario f) {
    if (f.getId() == 0) {
        f.setId(this.funcionarios.size()+1);
    }
    this.funcionarios.put(f.getId(), f);
    
}

@Override
public Funcionario buscarFuncionario(int id) {
    return this.funcionarios.get(id);
}

@Override
public int buscaCodigo() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'buscaCodigo'");
}
}
