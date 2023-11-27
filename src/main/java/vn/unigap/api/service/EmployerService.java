package vn.unigap.api.service;


import org.springframework.http.ResponseEntity;
import vn.unigap.api.dto.in.EmployerDtoIn;
import vn.unigap.api.dto.in.PageEmployerDtoIn;
import vn.unigap.api.dto.in.UpdateEmployerDtoIn;
import vn.unigap.api.dto.out.EmployerDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.entity.jpa.Employer;

import java.util.List;

public interface EmployerService {
    String createEmployer(EmployerDtoIn emp);
    String updateEmployer(Long id, UpdateEmployerDtoIn updateEmployerDtoIn);
    EmployerDtoOut getEmployer(Long id);
    String deleteEmployer(Long id);
    PageDtoOut<EmployerDtoOut> list(PageEmployerDtoIn pageEmployerDtoIn);

}
