package com.insurance.service;

import com.insurance.model.InsurancePolicy;
import com.insurance.repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class InsurancePolicyService {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    public List<InsurancePolicy> getAllPolicies() {
        return insurancePolicyRepository.findAll();
    }

    public InsurancePolicy getPolicyById(Long id) {
        return insurancePolicyRepository.findById(id).orElse(null);
    }

    public InsurancePolicy savePolicy(InsurancePolicy policy) {
        return insurancePolicyRepository.save(policy);
    }

    public void deletePolicy(Long id) {
        insurancePolicyRepository.deleteById(id);
    }
}
