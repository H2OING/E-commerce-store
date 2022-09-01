package com.example.demo.Service;

import com.example.demo.Model.Role;
import com.example.demo.Model.Web_User;
import com.example.demo.Repository.Web_User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
<<<<<<< HEAD
import java.util.Collection;
=======
import javax.validation.constraints.NotNull;

>>>>>>> ba9cec44773fbe2e560dac14d6324deabaf54aa4
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Web_User_Service implements UserDetailsService {
    @Autowired
    Web_User_Repository webUserRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    private static boolean isLoggedIn = false;

    
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

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
        webUser.setRole(Role.CUSTOMER);
        webUser.setPassword(passwordEncoder.encode(webUser.getPassword()));
        return webUserRepository.save(webUser);
    }

    public Web_User updateWebUser(Long id, Web_User webUser){
        Optional<Web_User> optionalWebUser = webUserRepository.findById(id);
        if(optionalWebUser.isPresent()){
            Web_User existingWebUser = optionalWebUser.get();
            existingWebUser.setEmail(webUser.getEmail());
            existingWebUser.setPassword(webUser.getPassword());
            existingWebUser.setRole(webUser.getRole());
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

<<<<<<< HEAD
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Web_User webUser = webUserRepository.findByEmail(username);
        if(webUser == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(webUser.getEmail(), webUser.getPassword(), mapRolesToAuthorities(List.of(webUser.getRole())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
    }
=======
    public boolean getWebUserByEmailAndPassword(@NotNull String email, @NotNull String password) {
        if(webUserRepository.existsByEmail(email)){
            Web_User wUser = webUserRepository.findByEmail(email);
            if(wUser.checkPassword(password)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
   
>>>>>>> ba9cec44773fbe2e560dac14d6324deabaf54aa4
}
