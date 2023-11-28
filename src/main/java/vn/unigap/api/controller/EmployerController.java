package vn.unigap.api.controller;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.unigap.api.dto.in.*;
import vn.unigap.api.dto.out.EmployerDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.service.EmployerService;
import vn.unigap.common.Controller.AbstractResponseController;


@RestController
@RequestMapping(value = "/api/v1/employer")

public class EmployerController{

    private EmployerService employerService;
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createEmployer(@Valid @RequestBody EmployerDtoIn empDtoIn) {
        String result = employerService.createEmployer(empDtoIn);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateEmployer(@Valid @PathVariable Long id, @RequestBody UpdateEmployerDtoIn updateEmpDtoIn) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employerService.updateEmployer(id,updateEmpDtoIn));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployerById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(employerService.getEmployer(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteEmployer(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(employerService.deleteEmployer(id));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getListEmployer(@Valid PageEmployerDtoIn pageEmployerDtoIn) {
        return ResponseEntity.status(HttpStatus.FOUND).body(employerService.list(pageEmployerDtoIn));
    }
}
