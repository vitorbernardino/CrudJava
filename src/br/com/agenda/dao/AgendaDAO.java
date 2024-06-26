package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {

    public void save(Contato contato){
        String sql = "INSERT INTO contatos (nome, idade, dataCadastro ) values (?,?,?)";

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
            System.out.println("erro");
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

    public List<Contato> getContatos(){
        List<Contato> contatos = new ArrayList<Contato>();
        String sql = "select * from contatos";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try{
            conn = ConnectionFactory.getConnection();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()){
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setName(rs.getString("name"));
                contato.setIdade(rs.getInt("idade"));
                contato.setData(rs.getDate("dataCadastro"));
                contatos.add(contato);
            }
        }catch(Exception e){
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

        return contatos;
    }
}
