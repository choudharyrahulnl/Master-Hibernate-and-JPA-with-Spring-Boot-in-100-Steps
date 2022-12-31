package com.digitalaicloud.hibernate.services;

import com.digitalaicloud.hibernate.entity.Passport;

public interface PassportService {

    Passport save(Passport passport);

    Passport findById(Long id);
}
