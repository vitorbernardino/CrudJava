package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class AgendaDAO {

    public void save(Contato contato){
        String sql = "insert into contatos (nome, idade, dataCadastro ) values (?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.getConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, contato.getName());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getData().getTime()));

            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(pstm != null){
                   pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
