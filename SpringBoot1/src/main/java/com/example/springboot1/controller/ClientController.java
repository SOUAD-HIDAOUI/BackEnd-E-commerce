        package com.example.springboot1.controller;


        import com.example.springboot1.Service.AdminService;
        import com.example.springboot1.model.Admin;
        import com.example.springboot1.model.Client;
        import com.example.springboot1.Service.ClientService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import java.util.List;
        @CrossOrigin(origins="http://localhost:4200")
        @RestController
        @RequestMapping("/clients")
        public class ClientController {
            @Autowired
            private AdminService adminService;
            @Autowired
            private ClientService clientService;
            @GetMapping(value = "/", produces = "application/json")
            public @ResponseBody List<Client> getAllClients() {
                return clientService.getAllClients();
            }
            @PostMapping("/addClient")
            public Client createClient(@RequestBody Client client) throws Exception {
                String tempEmail=client.getEmail();
                if(tempEmail!=null &&!"".equals(tempEmail)){
                   Client client1= clientService.fetchClientByEmail(tempEmail);
                   if(client1!=null  ){
                       throw new Exception("user with "+tempEmail+" is already exist");
                   }
                }
                return clientService.addClient(client);
            }
            @DeleteMapping(value="delete/{clientId}")
            public void deleteClient(@PathVariable Long clientId) {
                clientService.remove(clientId);
            }
            @GetMapping(value="/{clientId}")
            public Client getClientById(@PathVariable Long clientId) {
                return clientService.getClientById(clientId);
            }
            @PostMapping("/login")
            public Client LoginUser(@RequestBody Client client) throws Exception {
                String tempEmail=client.getEmail();
                String tempPasswod=client.getPassword();
                Client clientObj=null;
                if(tempEmail!=null && tempPasswod!=null){
                   clientObj=clientService.fetchClientByEmailAndPassword(tempEmail,tempPasswod);
                }
                if(clientObj==null){
                    throw new Exception("Bad credentials");
                }
                return clientObj;
            }
            /*@PostMapping("/update/{clientId}")
            public void updateClient(@PathVariable Long clientId, @RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String password) throws Exception {
                Client existingClient = clientService.getClientById(clientId);
                if (existingClient == null) {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }

                // Vérifiez si l'e-mail mis à jour est différent de celui existant
                if (!existingClient.getEmail().equals(email)) {
                    // Vérifiez si le nouvel e-mail existe déjà dans le système
                    Client clientWithNewEmail = clientService.fetchClientByEmail(email);
                    if (clientWithNewEmail != null) {
                        throw new Exception("Email " + email + " is already in use by another client.");
                    }
                }

                existingClient.setNom(updatedClient.getNom());
                existingClient.setPrenom(updatedClient.getPrenom());
                existingClient.setEmail(updatedClient.getEmail());
                existingClient.setPassword(updatedClient.getPassword());

                clientService.update(existingClient);

                return new ResponseEntity<>(existingClient, HttpStatus.OK);
            }*/
            @PostMapping(value="/update/{clientId}")
            public ResponseEntity<Client> updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) {
                Client existingClient = clientService.getClientById(clientId);

                if (existingClient != null) {
                    existingClient.setNom(updatedClient.getNom());
                    existingClient.setPrenom(updatedClient.getPrenom());
                    existingClient.setEmail(updatedClient.getEmail());
                    existingClient.setPassword(updatedClient.getPassword());

                    clientService.update(existingClient);

                    return new ResponseEntity<>(existingClient, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            @PostMapping("/addAdmin")
            public Admin createAdmin(@RequestBody Admin admin) throws Exception {

                return adminService.addAdmin(admin);
            }
            @GetMapping(value = "/fetchByEmail/{email}", produces = "application/json")
            public ResponseEntity<Client> fetchClientByEmail(@PathVariable String email) {
                Client client = clientService.fetchClientByEmail(email);

                if (client != null) {
                    return new ResponseEntity<>(client, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
        }
