package com.example.springboot1.controller;


import com.example.springboot1.Service.AdminService;
import com.example.springboot1.model.Admin;
import com.example.springboot1.model.Client;
import com.example.springboot1.Repository.ClientRepository;
import com.example.springboot1.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class WebController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Optional<Admin> admin = adminService.findByUsernameAndpassword(username, password);

        if (admin.isPresent()) {
            return "redirect:/clients";
        } else {
            // Handle invalid login, e.g., show an error message
            return "login";
        }
    }
    @GetMapping(value = "/clients")
    public String index(Model model, Principal principal) {
        model.addAttribute("List",clientRepository.findAll());
        return "index";
//        if (principal != null) {
//            model.addAttribute("List", clientRepository.findAll());
//            return "index";
//        } else {
//            // Redirect to the login page if not authenticated
//            return "redirect:/login";
//        }
    }
//    @RequestMapping(value = "/addClient", method = {RequestMethod.GET, RequestMethod.POST})
//    public String saveClient(@ModelAttribute Client client) {
//            clientService.addClient(client);   ;
//            return "addClient";
//    }
@RequestMapping(value = "/addClient", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveClient(Model model) {
          Client client=new Client();
          model.addAttribute("client",client);
            return "addClient";
    }
    @PostMapping("/clients")
    public String addClient(@ModelAttribute("client") Client client){
        clientService.addClient(client);
        return "redirect:/clients";
    }

    @RequestMapping (value="/deleteClient/{clientId}",method = {RequestMethod.GET, RequestMethod.DELETE})
    public String deleteClient(@PathVariable Long clientId) {
        clientService.remove(clientId);
        return "redirect:/clients";
    }


    @GetMapping( value="/edit/{id}")
    public String editClient(@PathVariable Long id,Model model){
        model.addAttribute("client",clientService.getClientById(id));
        return "editclient";

    }
    @PostMapping(value="/clients/{id}")
    public String updateClient(@PathVariable Long id,@ModelAttribute("client") Client client,Model model ){
        Client existingClient= (Client) clientService.getClientById(id);
        existingClient.setNom(client.getNom());
        existingClient.setPrenom(client.getPrenom());
        existingClient.setEmail(client.getEmail());
        clientService.update(existingClient);
        return "redirect:/clients";
    }

}