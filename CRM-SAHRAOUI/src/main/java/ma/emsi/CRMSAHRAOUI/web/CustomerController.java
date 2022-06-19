package ma.emsi.CRMSAHRAOUI.web;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import ma.emsi.CRMSAHRAOUI.entities.Customer;
import ma.emsi.CRMSAHRAOUI.repositories.CustomerRepository;

@Controller
@AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository;
@GetMapping(path = "/index")
    public  String customers(Model model,
    		@RequestParam(name ="page", defaultValue="0")int page,
    		@RequestParam(name ="size", defaultValue="5")int size,
    		@RequestParam(name ="Keyword", defaultValue="")String Keyword

    		){
   Page<Customer> pageCustomer= customerRepository.findByfirstNameContains(Keyword,PageRequest.of(page, size));
model.addAttribute("listCustomers",pageCustomer.getContent());
model.addAttribute("pages",new int[pageCustomer.getTotalPages()]);
model.addAttribute("currentPage",page);
model.addAttribute("Keyword",Keyword);
    return "customers";
}
@GetMapping("/delete")
public String delete(Long id,String Keyword,int page) {
	
	customerRepository.deleteById(id);
return "redirect:/index?page=" +page+"&Keyword="+Keyword; 
}

@GetMapping("/")
public String home() {
	
return "redirect:/index"; 
}
@GetMapping("/formCustomers")
 public String formCustomers(Model model) {
	 model.addAttribute("customer", new Customer() );
	 return "formCustomers";
 }
@PostMapping(path="/save")
public String save(Model model, @Valid Customer customer,BindingResult bindingResult ,
		@RequestParam(defaultValue="0") int page,
		@RequestParam(defaultValue="") String Keyword) {
	if(bindingResult.hasErrors()) return "formCustomers";
	customerRepository.save(customer);
	return "redirect:/index?page="+page+"&Keyword="+Keyword;
	
	
}

@GetMapping("/editCustomer")
public String editCustomer(Model model,Long id,String Keyword,int page) {
	Customer customer=customerRepository.findById(id).orElse(null);
	if(customer==null)throw new RuntimeException("CUSTOMER INTROUVABLE");
	 model.addAttribute("customer", customer );
	 model.addAttribute("page", page);

	 model.addAttribute("Keyword", Keyword);
	 return "editCustomer";
}
}
