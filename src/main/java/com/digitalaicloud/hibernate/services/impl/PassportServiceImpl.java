package com.digitalaicloud.hibernate.services.impl;

import com.digitalaicloud.hibernate.entity.Passport;
import com.digitalaicloud.hibernate.repository.PassportRepository;
import com.digitalaicloud.hibernate.services.PassportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
