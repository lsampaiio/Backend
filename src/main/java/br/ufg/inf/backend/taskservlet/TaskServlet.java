package br.ufg.inf.backend.taskservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tarefa")

public class TaskServlet extends HttpServlet {

	protected List<String> tarefas = new ArrayList<>();

	// Listagem de tarefas

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (tarefas.size() == 0) {
			resp.getWriter().append("Não existe tarefa cadastradas");

		} else {

			for (String task : tarefas) {
				resp.getWriter().append(String.format("%d - %s\n", tarefas.indexOf(task) + 1, task));

			}
		}
	}

	// Inserir tarefa a lista
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String task = req.getParameter("task");

		if (task == null || task.isBlank()) {
			resp.getWriter().append("Não pode estar em branco a task!!!!");
		} else {
			tarefas.add(task);

			resp.getWriter().append("Adicionado com sucesso!!");
		}

	}

	// Atualizar a tarefa a partir do index
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String task = req.getParameter("task");
			if (task == null || task.isBlank()) {
				resp.getWriter().append("Não pode estar em branco a task!!!!");
			} else {
				int index = Integer.parseInt(req.getParameter("index"));
				tarefas.set(index - 1, task);

				resp.getWriter().append("Atualizado com sucesso!!");
			}
		} catch (NullPointerException e) {
			resp.getWriter().append("Necessário informar o index");
		} catch (NumberFormatException e) {
			resp.getWriter().append(" O Index informado não valido informe um inteiro");

		} catch (IndexOutOfBoundsException e) {
			resp.getWriter().append(" O Index informado não existe na lista de tarefas");

		}
	}

	// deleta a tarefa
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int index = Integer.parseInt(req.getParameter("index"));
			tarefas.remove(index);

			resp.getWriter().append("Tarefa removida com sucesso!!");

		} catch (NullPointerException e) {
			resp.getWriter().append("Necessário informar o index");
		} catch (NumberFormatException e) {
			resp.getWriter().append(" O Index informado não valido informe um inteiro");

		} catch (IndexOutOfBoundsException e) {
			resp.getWriter().append(" O Index informado não existe na lista de tarefas");

		}

	}

}
