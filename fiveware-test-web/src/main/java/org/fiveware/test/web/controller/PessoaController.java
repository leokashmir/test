package org.fiveware.test.web.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.fiveware.test.entidades.Pessoa;
import org.fiveware.test.service.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PessoaController {
	
	
	@Autowired
	@Qualifier("pessoaServiceImpl")
	private PessoaServiceImpl pessoaService;
	
	
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(Model model) {
    	carregarDadosPagina(model);
    	model.addAttribute("pessoa", new Pessoa());
    	return "index";
    }

    @RequestMapping(value = "/addPessoa", method = RequestMethod.GET)
    public ResponseEntity<String> addPessoa(Model model,Pessoa pessoa) {
    		
    	try{	
    		pessoaService.atualizarOuSalvar(pessoa);
    		showIndex(model);
    		return new ResponseEntity<String>(HttpStatus.OK);
    	
    	}catch(Exception e){
    		return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
    	}
    	
    }
    
    @RequestMapping(value = "/deletar", method = RequestMethod.GET)
    public ResponseEntity<String> deletar(Model model,@RequestParam("id") String id) {
    		
    	try{	
    		Pessoa p = new Pessoa(); 
    		
    		p.setIdPessoa(new Integer(id));
    		
    		pessoaService.delete(p);
    		showIndex(model);
    		return new ResponseEntity<String>(HttpStatus.OK);
    	
    	}catch(Exception e){
    		return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
    	}
    	
    }
    
   
   
    
    
    /*
     * Metodo para carregar Combobox, Checkbox, e Radio
     * */
    
    private void carregarDadosPagina(Model model){
  
    	Map<String,String> sexo = new LinkedHashMap<String,String>();
    	sexo.put("M","Masculino");
    	sexo.put("F","Feminino");
    	model.addAttribute("sexo", sexo);
    		
    	Map<String,String> graduacao = new LinkedHashMap<String,String>();
    	
    	graduacao.put("Pos Graducao","Pos Graduacao");
    	graduacao.put("Mestrado","Mestrado");
    	graduacao.put("Dontorado","Dontorado");
    	model.addAttribute("graduacao", graduacao);
    	
    	boolean formado = true;
    	
    	List lstPessoas = pessoaService.listarTodos();
    	model.addAttribute("lstPessoas", lstPessoas);
    	
    }
    
    
}
