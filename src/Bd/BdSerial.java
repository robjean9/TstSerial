/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import vo.Serial;

/**
 *
 * @author robson
 */
public class BdSerial extends Bd.bd {

    public BdSerial() {
        try{
           conexao();
           
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Erro: " +e.getMessage());
       }
    }
    
    public Serial verifica(String serial){
        String sql = "select * from Clientes where serial ='"+serial+"'";
        Serial registro = new Serial();
        try{
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                registro.setCodigo(rs.getInt("codigo"));
                registro.setCliente(rs.getInt("cliente"));
                registro.setSerial(rs.getString("serial"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                registro.setDatafim(data);
                registro.setAtivo(rs.getBoolean("ativo"));
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL:" +e.getMessage());
        }
        return registro;
    }
    
}
