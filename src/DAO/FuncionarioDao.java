package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class FuncionarioDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();

    public void cadastrarFunicionario(FuncionarioDTO objfuncionariodto) {
        String sql = "insert into Estoque (nome,descricao,quantidade,preco) values (?,?,?,?)";
            
        conn = new ConexaoDao().conectaBD();

        try {
         
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome());
            pstm.setString(2, objfuncionariodto.getDescricao());
            pstm.setString(3, String.valueOf(objfuncionariodto.getPreco()));
            pstm.setString(4, String.valueOf(objfuncionariodto.getQuantidade()));

            pstm.execute();
            pstm.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO" + erro);
        }
    }

    public ArrayList<FuncionarioDTO> PesquisarFuncionario() {
        String sql = "select * from Estoque";
         conn = new ConexaoDao().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();
                objFuncionarioDTO.setId(rs.getInt("id"));
                objFuncionarioDTO.setNome(rs.getString("nome"));
                objFuncionarioDTO.setDescricao(rs.getString("descricao"));
                objFuncionarioDTO.setPreco(Float.valueOf(rs.getString("preco")));
                objFuncionarioDTO.setQuantidade(Integer.valueOf(rs.getString("quantidade")));    
                

                lista.add(objFuncionarioDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionsrioDAO Pesquisar" + erro);

        }
        return lista;
    }

    public void alterarFuncionario(FuncionarioDTO objfuncionariodto) {
        String sql = "update Estoque set nome = ?, descricao = ?  quantidade = ?,preco = ?,where id = ?";

        conn = new ConexaoDao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome());
            pstm.setString(2, objfuncionariodto.getDescricao());
            pstm.setInt(3, objfuncionariodto.getId());
            pstm.setString(3, String.valueOf(objfuncionariodto.getPreco()));
            pstm.setString(4, String.valueOf(objfuncionariodto.getQuantidade()));

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO alterar" + erro);
        }
    
    
    }
     
    public void Excluir(FuncionarioDTO objfuncionariodto){
        String sql = "delete from Estoque where id = ?";
       
        conn = new ConexaoDao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            
           
            pstm.setInt(1, objfuncionariodto.getId());

            pstm.execute();
            pstm.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO excluir" + erro);
        }
    
    }
    ArrayList<Integer> id_cargo = new ArrayList<>();
    public ResultSet listarCargo(){
    
       String sql = "SELECT * Cargo  ORDEY BY descricao_cargo = ?";
       conn = new ConexaoDao().conectaBD();
       
        
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
           

            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO cargo" + erro.getMessage());
            return null;
        }
     
   }
}
