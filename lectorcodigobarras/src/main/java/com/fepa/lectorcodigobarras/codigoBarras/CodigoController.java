package com.fepa.lectorcodigobarras.codigoBarras;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/codigoBarras")
public class CodigoController {
    @Autowired
    private CodigoBarrasService codigoBarrasService;

	@GetMapping("/{codigo}")
	public CodigoBarras getCodigoBarras(@PathVariable(value = "codigo") String codigoEscaneado) {
        return codigoBarrasService.getCodigoBarrasData(codigoEscaneado);
	}
}