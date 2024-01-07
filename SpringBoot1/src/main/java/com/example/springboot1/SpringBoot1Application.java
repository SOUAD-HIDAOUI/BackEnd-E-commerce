package com.example.springboot1;


import com.example.springboot1.Repository.ClientRepository;
import com.example.springboot1.Service.AdminService;
import com.example.springboot1.Service.ClientService;
import com.example.springboot1.model.Admin;
import com.example.springboot1.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;


@SpringBootApplication
public class SpringBoot1Application {
    @Autowired
    private AdminService iservice;
    @Autowired
    private ClientService iservice1;

   /* public static void main(String[] args) {
        SpringApplication.run(SpringBoot1Application.class, args);
    }
    @Override
    public void run(String... args) {
       iservice.addClient(new Client("Souad", "El hidaoui", "souad@gmail.com"));
        iservice.addClient(new Client("Aya", "El hidaoui", "aya@gmail.com"));
    }*/
    public static void main(String[] args) {


        SpringApplication.run(SpringBoot1Application.class,args) ;   }
    @Bean
    CommandLineRunner init() {
        return args -> {
            iservice.addAdmin(new Admin( "root", "root"));
            iservice1.addClient(new Client("el hidaoui","souad","souad@gmail.com","root"));

        };
    }


    //   @Bean
//    CommandLineRunner init(ClientRepository userRepository) {
//        return args -> {
//            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
//                Client user = new Client(name, "EL HIDAOUI",name.toLowerCase() + "@domain.com");
//                userRepository.save(user);
//            });
//            userRepository.findAll().forEach(System.out::println);
//        };
    }





