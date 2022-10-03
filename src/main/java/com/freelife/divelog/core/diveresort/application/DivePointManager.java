package com.freelife.divelog.core.diveresort.application;

import com.freelife.divelog.core.diveresort.application.dto.DivePointDto;
import com.freelife.divelog.core.diveresort.application.dto.DivePointRegisterCommand;
import com.freelife.divelog.core.diveresort.application.dto.DivePointUpdateCommand;
import com.freelife.divelog.core.diveresort.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DivePointManager implements DivePointEditor, DivePointFinder {
    private final DiveResortRepository diveResortRepository;
    private final DivePointRepository divePointRepository;

    public DivePointManager(DiveResortRepository diveResortRepository, DivePointRepository divePointRepository) {
        this.diveResortRepository = diveResortRepository;
        this.divePointRepository = divePointRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<DivePointDto> findAll() {
        return divePointRepository.findAll().stream().map(DivePointDto::ofEntity)
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<DivePointDto> findByDiveResortId(Long diveResortId) {
        DiveResort diveResort = diveResortRepository.findById(diveResortId)
                .orElseThrow(() -> new DiveResortNotFoundException(diveResortId));
        
        return divePointRepository.findByDiveResort(diveResort).stream()
                .map(DivePointDto::ofEntity)
                .collect(Collectors.toUnmodifiableList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<DivePointDto> findByDivePointId(Long divePointId) {
        return divePointRepository.findById(divePointId)
                .map(DivePointDto::ofEntity);
    }

    @Transactional
    @Override
    public DivePointDto save(DivePointRegisterCommand registerCommand) {
        DiveResort diveResort = diveResortRepository.findById(registerCommand.getDiveResortId())
                .orElseThrow(() -> new DiveResortNotFoundException(registerCommand.getDiveResortId()));
        
        return DivePointDto.ofEntity(divePointRepository.save(registerCommand.convertToEntity(diveResort)));
    }

    @Transactional
    @Override
    public DivePointDto update(Long divePointId, DivePointUpdateCommand updateCommand) {
        DivePoint divePoint = divePointRepository.findById(divePointId)
                .orElseThrow(() -> new DivePointNotFoundException(divePointId));
        
        return DivePointDto.ofEntity(divePointRepository.save(updateCommand.update(divePoint)));
    }

    @Transactional
    @Override
    public void delete(Long divePointId) {
        DivePoint divePoint = divePointRepository.findById(divePointId)
                .orElseThrow(() -> new DivePointNotFoundException(divePointId));
        
        divePointRepository.delete(divePoint);
    }

}
