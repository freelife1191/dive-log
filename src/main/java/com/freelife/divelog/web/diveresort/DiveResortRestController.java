package com.freelife.divelog.web.diveresort;

import com.freelife.divelog.core.diveresort.application.DiveResortEditor;
import com.freelife.divelog.core.diveresort.application.DiveResortFinder;
import com.freelife.divelog.core.diveresort.application.dto.DiveResortDto;
import com.freelife.divelog.web.diveresort.dto.DiveResortRegisterRequest;
import com.freelife.divelog.web.diveresort.dto.DiveResortUpdateRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class DiveResortRestController {
    private final DiveResortFinder finder;
    private final DiveResortEditor editor;

    public DiveResortRestController(DiveResortFinder finder, DiveResortEditor editor) {
        this.finder = finder;
        this.editor = editor;
    }

    @GetMapping("/dive-resorts")
    public ResponseEntity<List<DiveResortDto>> getDiveResorts() {
        
        return ResponseEntity.ok(finder.findAll());
    }

    @PostMapping("/dive-resorts")
    public ResponseEntity<?> create(HttpServletRequest servletRequest,@RequestBody @Validated DiveResortRegisterRequest request,
            BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()) {
            Map<String, String> errorMaps = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return ResponseEntity.badRequest().body(errorMaps);
        }
        
        DiveResortDto result = editor.save(request.convertToRegisterCommand());
        //@see https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-servleturicomponentsbuilder
        String location = ServletUriComponentsBuilder.fromContextPath(servletRequest)
                .path("/dive-resorts/{id}")
                .buildAndExpand(result.getId()).toString();
        
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, location)
                .body(result);
    }

    @GetMapping("/dive-resorts/{diveResortId}")
    public ResponseEntity<DiveResortDto> findById(@PathVariable("diveResortId") Long diveResortId) {
        
        return ResponseEntity.of(finder.findByDiveResortId(diveResortId));
    }

    @PutMapping("/dive-resorts/{diveResortId}")
    public ResponseEntity<?> update(@PathVariable("diveResortId") Long diveResortId,
            @RequestBody @Validated DiveResortUpdateRequest request, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()) {
            Map<String, String> errorMaps = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return ResponseEntity.badRequest().body(errorMaps);
        }
        
        return ResponseEntity.ok(editor.update(diveResortId, request.convertToUpdateCommand()));
    }
    
    @DeleteMapping("/dive-resorts/{diveResortId}")
    public ResponseEntity<Void> delete(@PathVariable("diveResortId") Long diveResortId) {
        editor.delete(diveResortId);
        
        return ResponseEntity.noContent().build();
    }
    
}
