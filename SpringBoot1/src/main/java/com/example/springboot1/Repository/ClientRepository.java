package com.example.springboot1.Repository;

import com.example.springboot1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Transactional(readOnly=true)
@Repository
public interface  ClientRepository extends JpaRepository<Client,Long> {
   Client findClientByEmail(String email);
   Client findClientByEmailAndAndPassword(String email,String password
   );
    @Override
    List<Client> findAll();



   void deleteById(Long id);

    Client getClientById(Long id);




}
