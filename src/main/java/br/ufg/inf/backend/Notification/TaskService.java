package br.ufg.inf.backend.Notification;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
	protected List<String> tarefas = new ArrayList<>();

	public List<String> listar() {
		return tarefas;
	}

	public String add(String task) {

		if (task == null || task.isBlank()) {
			throw new RuntimeException("Não pode estar em branco a task!!!!");
		}

		tarefas.add(task);
		return task;
	}

	public String update(int index, String task) {
		if (task == null || task.isBlank()) {
			throw new RuntimeException("Não pode estar em branco a task!!!!");
		}
		tarefas.set(index, task);
		return task;
	}

	public int remove(int index) {

		throw new RuntimeException("O serviço de exclusão de tarefas foi requisitado.");

	}

}
