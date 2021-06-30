package com.desenvolvimento.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvimento.dsvendas.dto.SaleDTO;
import com.desenvolvimento.dsvendas.dto.SaleSumDTO;
import com.desenvolvimento.dsvendas.dto.SalesSuccessDTO;
import com.desenvolvimento.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	@GetMapping(value ="/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	@GetMapping(value ="/success-by-seller")
	public ResponseEntity<List<SalesSuccessDTO>> successGroupedBySeller(){
		List<SalesSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}

}
