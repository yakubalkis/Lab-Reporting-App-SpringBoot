package com.report.service;

import com.report.entity.Laborant;
import com.report.repository.LaborantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaborantServiceImpl implements LaborantService{

    private LaborantRepository laborantRepository;
    @Autowired
    public LaborantServiceImpl(LaborantRepository laborantRepository) {
        this.laborantRepository = laborantRepository;
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
    public void save(Laborant laborant) {
        laborantRepository.save(laborant);
    }

    @Override
    public void deleteById(Integer id) {
        laborantRepository.deleteById(id);
    }
}
