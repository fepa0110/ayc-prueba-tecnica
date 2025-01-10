package com.fepa.lectorcodigobarras.codigoBarras;

public record CodigoBarras(
        String codigo_scanner, 
        String lote_extendido,
        String bulto
    ) { }