package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.Web_User;
import com.example.demo.Repository.Product_Repository;
import com.example.demo.Repository.Web_User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class Web_User_Service {
    @Autowired
    Web_User_Repository webUserRepository;

    public List<Web_User> getAllWebUsers(){
        return webUserRepository.findAll();
    }

    public Web_User getWebUserById(long id){
        Optional<Web_User> webUser = webUserRepository.findById(id);
        if(webUser.isPresent()){
            return webUser.get();
        } else{
            throw new EntityNotFoundException();
        }
    }

    public Web_User createWebUser(Web_User webUser){
        return webUserRepository.save(webUser);
    }

    public Web_User updateWebUser(Long id, Web_User webUser){
        Optional<Web_User> optionalWebUser = webUserRepository.findById(id);
        if(optionalWebUser.isPresent()){
            Web_User existingWebUser = optionalWebUser.get();
            existingWebUser.setEmail(webUser.getEmail());
            existingWebUser.setPassword(webUser.getPassword());
            existingWebUser.setRole(webUser.getRole());
            existingWebUser.setCustomer(webUser.getCustomer());
            return webUserRepository.save(existingWebUser);
        } else{
            throw new EntityNotFoundException();
        }
    }

    public void deleteWebUser(Long id){
        Optional<Web_User> optionalWebUser= webUserRepository.findById(id);
        if(optionalWebUser.isPresent()){
            webUserRepository.deleteById(id);
        } else{
            throw new EntityNotFoundException();
        }
    }
}
