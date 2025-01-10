package com.fepa.lectorcodigobarras.codigoBarras;

import org.springframework.stereotype.Service;

@Service
public class CodigoBarrasService {
    public CodigoBarras getCodigoBarrasData(String codigo){
        if(codigo.length() == 12 || codigo.length() == 13 && codigo.endsWith("ACME")){
            String lote_extendido = codigo.substring(0, 6);
            String bulto = "";

            if(codigo.length() == 12) bulto = codigo.substring(6, 8);
            else if(codigo.length() == 13) bulto = codigo.substring(6, 9);

		    return new CodigoBarras(codigo,lote_extendido,bulto);
        }

        return new CodigoBarras(codigo,"","");
    }
}