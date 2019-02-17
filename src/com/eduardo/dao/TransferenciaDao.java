package com.eduardo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.ws.handler.MessageContext;

import com.eduardo.factory.Dao;
import com.eduardo.interfaces.DaoI;
import com.eduardo.model.Transferencia;
import com.eduardo.model.Usuario;

public class TransferenciaDao extends Dao implements DaoI<Transferencia> {

	@Override
	public boolean cadastrar(Transferencia obj) {

		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("insert into Transferencia"
					+ "(usuario_id,pagador_nome,pagador_banco,pagador_agencia,pagador_conta,beneficiario_nome,beneficiario_banco,beneficiario_agencia,beneficiario_conta,valor,tipo,status,ativo) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,1)");
			stmt.setInt(1, obj.getUsuario_id());
			stmt.setString(2, obj.getPagador_nome());
			stmt.setString(3, obj.getPagador_banco());
			stmt.setString(4, obj.getPagador_agencia());
			stmt.setString(5, obj.getPagador_conta());
			stmt.setString(6, obj.getBeneficiario_nome());
			stmt.setString(7, obj.getBeneficiario_banco());
			stmt.setString(8, obj.getBeneficiario_agencia());
			stmt.setString(9, obj.getBeneficiario_conta());
			stmt.setInt(10, obj.getValor());
			stmt.setString(11, obj.getTipo());
			stmt.setString(12, obj.getStatus());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Transferencia efetuada", "Info", JOptionPane.INFORMATION_MESSAGE);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean editar(Transferencia obj) {

		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("update Transferencia set usuario_id = ?" + ",set pagador_nome =?,"
					+ "set pagador_banco =?," + "set pagador_agencia = ?," + "set pagador_conta =?"
					+ ",set beneficiario_nome = ?," + "set beneficiario_banco=?," + "set beneficiario_agencia = ? ,"
					+ "set beneficiario_conta=?," + "set valor=?," + "set tipo=?," + "set status = ?  where id = ?");
			stmt.setInt(1, obj.getUsuario_id());
			stmt.setString(2, obj.getPagador_nome());
			stmt.setString(3, obj.getPagador_banco());
			stmt.setString(4, obj.getPagador_agencia());
			stmt.setString(5, obj.getPagador_conta());
			stmt.setString(6, obj.getBeneficiario_nome());
			stmt.setString(7, obj.getBeneficiario_banco());
			stmt.setString(8, obj.getBeneficiario_agencia());
			stmt.setString(9, obj.getBeneficiario_conta());
			stmt.setInt(10, obj.getValor());
			stmt.setString(11, obj.getTipo());
			stmt.setString(12, obj.getStatus());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean excluir(Transferencia obj) {

		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement("update Transferencia set ativo = 0  where id = ?");
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
	public List<Transferencia> listar() {

		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(
					"select t.id, t.usuario_id,t.pagador_nome,t.pagador_banco,t.pagador_agencia,t.pagador_conta,t.beneficiario_nome,t.beneficiario_banco,t.beneficiario_agencia,t.beneficiario_conta,t.valor,t.tipo,t.status\r\n"
							+ " from Transferencia as t  where ativo = 1;");
			ResultSet result = stmt.executeQuery();
			List<Transferencia> listTransfe = new ArrayList<>();
			while (result.next()) {
				Transferencia t = new Transferencia();
				t.setId(result.getInt("t.id"));
				t.setUsuario_id(result.getInt("t.usuario_id"));
				t.setPagador_nome(result.getString("t.pagador_nome"));
				t.setPagador_banco(result.getString("t.pagador_banco"));
				t.setPagador_agencia(result.getString("t.pagador_agencia"));
				t.setPagador_conta(result.getString("t.pagador_conta"));
				t.setBeneficiario_agencia(result.getString("t.beneficiario_agencia"));
				t.setBeneficiario_banco(result.getString("t.beneficiario_banco"));
				t.setBeneficiario_nome(result.getString("t.beneficiario_nome"));
				t.setBeneficiario_conta(result.getString("t.beneficiario_conta"));
				t.setValor(result.getInt("t.valor"));
				t.setTipo(result.getString("t.tipo"));
				t.setStatus(result.getString("t.status"));
				listTransfe.add(t);
			}
			return listTransfe;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Transferencia> listarp() {
		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(
					"select t.id, t.usuario_id,t.pagador_nome,t.pagador_banco,t.pagador_agencia,t.pagador_conta,t.beneficiario_nome,t.beneficiario_banco,t.beneficiario_agencia,t.beneficiario_conta,t.valor,t.tipo,t.status\r\n" + 
					"from Transferencia as t  where ativo = 1 order by t.pagador_nome ;");
			ResultSet result = stmt.executeQuery();
			List<Transferencia> listTransfe = new ArrayList<>();
			while (result.next()) {
				Transferencia t = new Transferencia();
				t.setId(result.getInt("t.id"));
				t.setUsuario_id(result.getInt("t.usuario_id"));
				t.setPagador_nome(result.getString("t.pagador_nome"));
				t.setPagador_banco(result.getString("t.pagador_banco"));
				t.setPagador_agencia(result.getString("t.pagador_agencia"));
				t.setPagador_conta(result.getString("t.pagador_conta"));
				t.setBeneficiario_agencia(result.getString("t.beneficiario_agencia"));
				t.setBeneficiario_banco(result.getString("t.beneficiario_banco"));
				t.setBeneficiario_nome(result.getString("t.beneficiario_nome"));
				t.setBeneficiario_conta(result.getString("t.beneficiario_conta"));
				t.setValor(result.getInt("t.valor"));
				t.setTipo(result.getString("t.tipo"));
				t.setStatus(result.getString("t.status"));
				listTransfe.add(t);
			}
			return listTransfe;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Transferencia> listarb() {
		try {
			PreparedStatement stmt;
			stmt = conexao.prepareStatement(
					"select t.id, t.usuario_id,t.pagador_nome,t.pagador_banco,t.pagador_agencia,t.pagador_conta,t.beneficiario_nome,t.beneficiario_banco,t.beneficiario_agencia,t.beneficiario_conta,t.valor,t.tipo,t.status\r\n" + 
					"from Transferencia as t  where ativo = 1 order by t.beneficiario_nome  ;");
			ResultSet result = stmt.executeQuery();
			List<Transferencia> listTransfe = new ArrayList<>();
			while (result.next()) {
				Transferencia t = new Transferencia();
				t.setId(result.getInt("t.id"));
				t.setUsuario_id(result.getInt("t.usuario_id"));
				t.setPagador_nome(result.getString("t.pagador_nome"));
				t.setPagador_banco(result.getString("t.pagador_banco"));
				t.setPagador_agencia(result.getString("t.pagador_agencia"));
				t.setPagador_conta(result.getString("t.pagador_conta"));
				t.setBeneficiario_agencia(result.getString("t.beneficiario_agencia"));
				t.setBeneficiario_banco(result.getString("t.beneficiario_banco"));
				t.setBeneficiario_nome(result.getString("t.beneficiario_nome"));
				t.setBeneficiario_conta(result.getString("t.beneficiario_conta"));
				t.setValor(result.getInt("t.valor"));
				t.setTipo(result.getString("t.tipo"));
				t.setStatus(result.getString("t.status"));
				listTransfe.add(t);
			}
			return listTransfe;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
