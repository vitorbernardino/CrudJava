package br.com.agenda.aplicacao;
import br.com.agenda.dao.AgendaDAO;
import br.com.agenda.model.Contato;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Contato contato = new Contato();
        contato.setName("vitor");
        contato.setIdade(22);
        contato.setData(new Date());

        AgendaDAO agendaDAO = new AgendaDAO();
        agendaDAO.save(contato);
    }
}