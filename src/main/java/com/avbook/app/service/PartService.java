package com.avbook.app.service;

import com.avbook.app.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PartService {

    private final PartRepository partRepository;

    @Transactional
    public void incrementQuantity(UUID id) {
        partRepository.incrementQuantityById(id);
    }

    @Transactional
    public void decrementQuantity(UUID id) {
        partRepository.decrementQuantityById(id);
    }

    @Transactional
    public void incrementQuantity(UUID id, Integer number) {
        partRepository.incrementQuantityById(id, number);
    }

    @Transactional
    public void decrementQuantity(UUID id, Integer number) {
        partRepository.decrementQuantityById(id, number);
    }
}