package com.insurance.controller;

import com.insurance.model.Claim;
import com.insurance.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.*;
import java.util.*;


@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> claims = claimService.getAllClaims();
        return ResponseEntity.ok(claims);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Claim claim = claimService.getClaimById(id);
        if (claim == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(claim);
    }

    @PostMapping
    public ResponseEntity<Claim> createClaim(@Valid @RequestBody Claim claim, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(claim);
        }
        Claim savedClaim = claimService.saveClaim(claim);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedClaim.getId()).toUri();
        return ResponseEntity.created(location).body(savedClaim);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @Valid @RequestBody Claim claim,
                                             BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(claim);
        }
        claim.setId(id);
        Claim savedClaim = claimService.saveClaim(claim);
        return ResponseEntity.ok(savedClaim);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
        return ResponseEntity.noContent().build();
    }
}

