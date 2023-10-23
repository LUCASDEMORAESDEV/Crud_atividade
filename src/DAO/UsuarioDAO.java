
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    Connection conn;
    
    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDTO){
       conn = new ConexaoDao().conectaBD();
        
       try {
         String sql = "select * from UsuarioTeste where Nome_teste = ? and senha_usuario = ?";
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.setString(1, objUsuarioDTO.getNome_usuario());
           pstm.setString(2, objUsuarioDTO.getSenha_usuario());
      
       ResultSet rs = pstm.executeQuery();
       return rs;
       } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null,"UsuarioDAO" + erro);
            return null;
        
        }
    }
}
