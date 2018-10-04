package com.thecc.theccbackend.controller;

import com.thecc.theccbackend.exception.ResourceNotFoundException;
import com.thecc.theccbackend.model.Email;
import com.thecc.theccbackend.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    EmailRepository emailRepository;

    @GetMapping("/emails")
    public List<Email> getAllEmail() {
        return emailRepository.findAll();
    }

    @PostMapping("/emails")
    public Email createEmail(@Valid @RequestBody Email email) {
        return emailRepository.save(email);
    }

    @GetMapping("/emails/{id}")
    public Email getEmailById(@PathVariable(value = "id") Long emailId) {
        return emailRepository.findById(emailId)
                .orElseThrow(() -> new ResourceNotFoundException("Email", "id", emailId));
    }

    @PutMapping("/emails/{id}")
    public Email updateEmail(@PathVariable(value = "id") Long emailId, @Valid @RequestBody Email emailDetails) {

        Email email = emailRepository.findById(emailId)
                .orElseThrow(() -> new ResourceNotFoundException("Email", "id", emailId));

        email.setEmail(emailDetails.getEmail());

        Email updatedEmail = emailRepository.save(email);
        return updatedEmail;
    }

    @DeleteMapping("/emails/{id}")
    public ResponseEntity<?> deleteEmail(@PathVariable(value = "id") Long emailId) {
        Email email = emailRepository.findById(emailId)
                .orElseThrow(() -> new ResourceNotFoundException("Email", "id", emailId));

        emailRepository.delete(email);

        return ResponseEntity.ok().build();
    }
}