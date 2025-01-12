package com.fepa.lectorcodigobarras.codigoBarras;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/codigoBarras")
public class CodigoController {
    @Autowired
    private CodigoBarrasService codigoBarrasService;

	@GetMapping("/{codigo}")
	public ResponseEntity<Object> getCodigoBarras(@PathVariable(value = "codigo") String codigoEscaneado) {
        CodigoBarras codigoBarrasData = codigoBarrasService.getCodigoBarrasData(codigoEscaneado);

        if(codigoBarrasData == null){
            return new ResponseEntity("Código malformado.",HttpStatus.BAD_REQUEST);
        }
        else return ResponseEntity.ok().eTag("Código leído correctamente.").body(codigoBarrasData);
	}
}