package com.cg.ovs.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public interface MapValidationErrorService {
	public ResponseEntity<?> mapValidationError(BindingResult result);

}
