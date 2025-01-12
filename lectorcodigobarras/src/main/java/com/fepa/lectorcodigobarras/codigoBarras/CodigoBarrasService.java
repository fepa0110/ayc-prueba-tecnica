package com.fepa.lectorcodigobarras.codigoBarras;

import org.springframework.stereotype.Service;

@Service
public class CodigoBarrasService {
    private final String PALABRA_FINAL = "ACME";

    public CodigoBarras getCodigoBarrasData(String codigo){
        codigo = codigo.toUpperCase();

        if((codigo.length() == 12 || codigo.length() == 13) 
            && codigo.endsWith(PALABRA_FINAL)){
                
            String lote_extendido = codigo.substring(0, 6);
            
            String bulto = 
                codigo.length() == 12 ? 
                codigo.substring(6, 8) : 
                codigo.substring(6, 9);

		    return new CodigoBarras(codigo,lote_extendido,bulto);
        }
        else return null;
    }
}