package com.eduardo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eduardo.factory.Dao;
import com.eduardo.interfaces.DaoI;
import com.eduardo.model.Usuario;

public class UsuarioDao extends Dao implements DaoI<Usuario> {

	@Override
	public boolean cadastrar(Usuario obj) {

		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("insert into Usuario(nome,cnpj,ativo) values(?,?,1)");
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getCnpj());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean editar(Usuario obj) {

		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("update Usuario set nome = ?, cnpj = ? where id = ?");
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getCnpj());
			stmt.setInt(3, obj.getId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean excluir(Usuario obj) {

		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("update Usuario set ativo = 0  where id = ?");
			stmt.setInt(1, obj.getId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Usuario> listar() {

		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("select id,nome,cnpj from Usuario order by id");
			ResultSet result = stmt.executeQuery();
			List<Usuario> listUsuarios = new ArrayList<>();
			while (result.next()) {
				Usuario u = new Usuario();
				u.setId(result.getInt("id"));
				u.setNome(result.getString("nome"));
				u.setCnpj(result.getString("cnpj"));
				listUsuarios.add(u);
			}
			return listUsuarios;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean verifica(String nome, String cnpj) {
		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("SELECT id,nome,cnpj FROM usuario where nome = ? and cnpj=?");
			stmt.setString(1, nome);
			stmt.setString(2, cnpj);
			ResultSet result = stmt.executeQuery();
			List<Usuario> list = new ArrayList<>();
			if (result.next()) {
				Usuario l = new Usuario();
				l.setId(result.getInt("id"));
				l.setCnpj(result.getString("cnpj"));
				l.setNome(result.getString("nome"));
				list.add(l);
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	public Usuario verifica(String nome) {
		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("select id,nome,cnpj from Usuario where nome =?");
			stmt.setString(1, nome);
			ResultSet result = stmt.executeQuery();
			Usuario u = null;
			if (result.next()) {
				u = new Usuario();
				u.setId(result.getInt("id"));
				u.setNome(result.getString("nome"));
				u.setCnpj(result.getString("cnpj"));

			}
			return u;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
