package br.ufg.inf.backend.spring.controller;


import java.util.List;
import java.util.Optional;

import br.ufg.inf.backend.spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufg.inf.backend.spring.model.Produto;

@Controller
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/produtos")
	public String listarProdutos(Model model, @RequestParam(required = false) String sucesso) {
		model.addAttribute("produtos", produtoService.listAll());
		model.addAttribute("sucesso", sucesso);
		return "produtos";
	}

	@GetMapping("/produtos/adicionar")
	public String mostrarFormularioAdicionarProduto() {
		return "adicionar-produto";
	}

	@PostMapping("/produtos")
	public String adicionarProduto(@RequestParam String nome, @RequestParam Double preco,
			RedirectAttributes redirectAttributes) {

		try {
			produtoService.add(nome, preco);
			redirectAttributes.addFlashAttribute("sucesso", "Produto adicionado com sucesso!");

		} catch (Exception e) {

			redirectAttributes.addFlashAttribute("erro", "Erro ao adicionar o produto: " + e.getMessage());

		}

		return "redirect:/produtos";

	}

	@GetMapping("/produtos/editar") 
    public String mostrarFormularioEditarProduto(@RequestParam("id") Long id, Model model)
    
    {
        Optional<Produto> produto = produtoService.findById(id);
        model.addAttribute("produto", produto.get()); 
        return "editar-produto";
    }

	@PostMapping("/produtos/editar")
	public String alterarProduto(@RequestParam Long id, @RequestParam String nome, @RequestParam double preco,
			RedirectAttributes redirectAttributes) {
		try {
			Produto produto = new Produto(id, nome, preco);
			produtoService.update(id, nome, preco);
			redirectAttributes.addAttribute("sucesso", "Produto alterado com sucesso!");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", "Erro ao alterar o produto: " + e.getMessage());

		}
		return "redirect:/produtos";
	}

	@PostMapping("/produtos/deletar")
	public String deletarProduto(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
		try {
			produtoService.delete(id);
			redirectAttributes.addFlashAttribute("sucesso", "Produto deletado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("erro", "Erro ao remover produto: " + e.getMessage());
		}
		return "redirect:/produtos";
	}
}

//   
