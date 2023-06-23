package com.lekarze.visit_api.controller;

import com.lekarze.visit_api.model.dto.DoctorDto;
import com.lekarze.visit_api.model.Doctor;
import com.lekarze.visit_api.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public List<DoctorDto> findAll() {
        return doctorService.findAll().stream()
                .map(DoctorDto::fromEntity)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorDto save(@RequestBody @Valid DoctorDto dto) {
        Doctor doctor = doctorService.save(dto.toEntity());
        return DoctorDto.fromEntity(doctor);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        doctorService.delete(id);
    }
}
