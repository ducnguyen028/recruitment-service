package vn.unigap.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.unigap.api.dto.in.EmployerDtoIn;
import vn.unigap.api.dto.in.PageEmployerDtoIn;
import vn.unigap.api.dto.in.UpdateEmployerDtoIn;
import vn.unigap.api.dto.out.EmployerDtoOut;
import vn.unigap.api.dto.out.PageDtoOut;
import vn.unigap.api.entity.jpa.Employer;
import vn.unigap.api.repository.jpa.Employer.EmployerRepository;
import vn.unigap.common.errorCode.ErrorCode;
import vn.unigap.common.exception.ApiException;

import java.util.Date;
import java.util.List;

@Service
public class EmployerServiceImp implements EmployerService{

    private final EmployerRepository employerRepository;

    public EmployerServiceImp(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public String createEmployer(EmployerDtoIn emp) {
        Date currentDate = new Date();
        Employer newEmp = Employer.builder()
                .name(emp.getName())
                .email(emp.getEmail())
                .province(emp.getProvinceId())
                .description(emp.getDescription())
                .created_at(currentDate)
                .updated_at(currentDate)
                .build();

        Employer saveEmp = employerRepository.save(newEmp);
        return "New Employer:"+saveEmp.getId()+"is created";
    }

    @Override
    public String updateEmployer(Long id, UpdateEmployerDtoIn updateEmployerDtoIn) {
        Employer updateEmployer = employerRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Employer ID: " + id + "NO FOUND!"));
        updateEmployer.setName(updateEmployerDtoIn.getName());
        updateEmployer.setProvince(updateEmployer.getProvince());
        updateEmployer.setDescription(updateEmployerDtoIn.getDescription());
        employerRepository.save(updateEmployer);

        return "Employer:"+updateEmployer.getId()+"is updated";
    }

    @Override
    public EmployerDtoOut getEmployer(Long id) {
        /*Employer emp = employerRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Employer ID: " + id + "NO FOUND!"));*/
        return null;
    }

    @Override
    public String deleteEmployer(Long id) {
        Employer emp = employerRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Employer ID: " + id + "NO FOUND!"));
        employerRepository.deleteById(id);

        return "Employer:"+id+" is deleted";    }

    @Override
    public PageDtoOut<EmployerDtoOut> list(PageEmployerDtoIn pageEmployerDtoIn) {
        Page<Employer> emp = this.employerRepository.findAll(PageRequest.of(pageEmployerDtoIn.getPage() - 1, pageEmployerDtoIn.getPageSize(),
                Sort.by("name").ascending()));
        return PageDtoOut.from(pageEmployerDtoIn.getPage(),
                pageEmployerDtoIn.getPageSize(),
                emp.getTotalElements(),
                emp.stream().map(EmployerDtoOut::from).toList());
    }


}
