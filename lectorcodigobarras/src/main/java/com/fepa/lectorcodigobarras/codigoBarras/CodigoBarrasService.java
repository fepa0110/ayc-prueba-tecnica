package com.fepa.lectorcodigobarras.codigoBarras;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CodigoBarrasService {
    private final static String PALABRA_FINAL_CODIGO = "ACME";
    private final static String FORMATO_CODIGO = "\\d{4}.\\d\\d{2,3}"+PALABRA_FINAL_CODIGO;
    private Pattern patternFormatoCodigo = Pattern.compile(FORMATO_CODIGO);

    public CodigoBarras getCodigoBarrasData(String codigo){
        codigo = codigo.trim().toUpperCase();

        boolean formatoCorrecto = patternFormatoCodigo.matcher(codigo).matches();

        if(formatoCorrecto){   
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