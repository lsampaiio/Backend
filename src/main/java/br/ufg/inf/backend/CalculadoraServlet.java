package br.ufg.inf.backend;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//try {
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			String operacao = req.getParameter("operacao");

			double numero1 = Double.parseDouble(num1);
			double numero2 = Double.parseDouble(num2);

			double resultado = 0.0;

			if (operacao.equals("soma")) {
				resultado = numero1 + numero2;

			} else if (operacao.equals("subtracao")) {
				resultado = numero1 - numero2;

			} else if (operacao.equals("divisao")) {
				resultado = numero1 / numero2;

			} else if (operacao.equals("multiplicacao")) {
				resultado = numero1 * numero2;

			} else {
				throw new RuntimeException(
						"Operação não encontrada! As operações aceitas são: soma,subtracao,divisao,multiplicacao");
			}

//			resp.getWriter().append(String.format("%.2f", resultado));
//		} catch (NumberFormatException | NullPointerException d) {
//			resp.getWriter().append("Os número informado é inválido");
//		} catch (RuntimeException e) {
//			resp.getWriter().append(e.getMessage());
//		} catch (Exception e) {
//			resp.getWriter().append("ERRRO");
//		}

	}

}
