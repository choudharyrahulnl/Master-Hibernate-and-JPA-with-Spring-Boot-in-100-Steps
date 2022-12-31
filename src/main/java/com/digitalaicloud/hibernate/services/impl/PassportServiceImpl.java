package com.digitalaicloud.hibernate.services.impl;

import com.digitalaicloud.hibernate.entity.Passport;
import com.digitalaicloud.hibernate.exceptions.NotFoundException;
import com.digitalaicloud.hibernate.repository.PassportRepository;
import com.digitalaicloud.hibernate.services.PassportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Passport findById(Long id) {
        Optional<Passport> byId = passportRepository.findById(id);
        if(!byId.isPresent()) {
            throw new NotFoundException("Passport not found with id " + id);
        }
        return byId.get();
    }
}
