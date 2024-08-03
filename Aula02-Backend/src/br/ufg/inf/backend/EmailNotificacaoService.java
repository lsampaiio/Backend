package br.ufg.inf.backend;

import br.ufg.inf.backend.NotificaoService.NotificacaoService;

public class EmailNotificacaoService implements NotificacaoService {

    public void enviarNotificacao() {
        System.out.println("Notificação de e-mail enviada!");
    }
}