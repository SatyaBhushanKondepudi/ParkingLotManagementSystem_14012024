package com.SatyaBhushan.Repository;

import com.SatyaBhushan.models.Gate;

import java.util.Optional;

public interface IGateRepository {
    Optional<Gate> findGateById(Long gateId);
}
