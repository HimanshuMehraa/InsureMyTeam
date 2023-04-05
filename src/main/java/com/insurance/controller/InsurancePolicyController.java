package com.insurance.controller;

import com.insurance.model.InsurancePolicy;
import com.insurance.service.InsurancePolicyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.*;
import java.util.List;


@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {

    @Autowired
    private InsurancePolicyService insurancePolicyService;

    @GetMapping
    public ResponseEntity<List<InsurancePolicy>> getAllPolicies() {
        List<InsurancePolicy> policies = insurancePolicyService.getAllPolicies();
        return ResponseEntity.ok(policies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable Long id) {
        InsurancePolicy policy = insurancePolicyService.getPolicyById(id);
        if (policy == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(policy);
    }

    @PostMapping
    public ResponseEntity<InsurancePolicy> createPolicy(@Valid @RequestBody InsurancePolicy policy, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(policy);
        }
        InsurancePolicy savedPolicy = insurancePolicyService.savePolicy(policy);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPolicy.getId()).toUri();
        return ResponseEntity.created(location).body(savedPolicy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updatePolicy(@PathVariable Long id, @Valid @RequestBody InsurancePolicy policy,
                                                        BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(policy);
        }
        policy.setId(id);
        InsurancePolicy savedPolicy = insurancePolicyService.savePolicy(policy);
        return ResponseEntity.ok(savedPolicy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        insurancePolicyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
