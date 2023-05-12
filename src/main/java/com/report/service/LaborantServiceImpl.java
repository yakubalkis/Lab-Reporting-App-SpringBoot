package com.report.service;

import com.report.entity.Laborant;
import com.report.entity.Role;
import com.report.repository.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaborantServiceImpl implements LaborantService{

    private LaborantRepository laborantRepository;
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public LaborantServiceImpl(LaborantRepository laborantRepository, @Lazy BCryptPasswordEncoder passwordEncoder) {
        this.laborantRepository = laborantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Laborant> findAll() {
        return laborantRepository.findAll();
    }

    @Override
    public Laborant findById(Integer id) {

        Optional<Laborant> result = laborantRepository.findById(id);

        Laborant laborant = null;

        if(result.isPresent()){
            laborant = result.get();
        }
        else{
            throw new RuntimeException("Did not found laborant with id: "+ id);
        }

        return laborant;
    }

    @Override
    public Laborant save(Laborant laborant) {
       String password = laborant.getPassword();
       String encodedPassword = passwordEncoder.encode(password);
       laborant.setPassword(encodedPassword);

        return laborantRepository.save(laborant);
    }

    @Override
    public void deleteById(Integer id) {
        laborantRepository.deleteById(id);
    }

    @Override
    public Laborant findLaborantByIdNo(String idNo) {
        return laborantRepository.findLaborantByIdNo(idNo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Laborant laborant = laborantRepository.findByIdNo(username);
        if(laborant==null){
            throw new UsernameNotFoundException("Invalid username or password!");
        }

        return new org.springframework.security.core.userdetails.User(laborant.getIdNo(), laborant.getPassword(), mapRolesToAuthorities(laborant.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){

        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
