package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class FileUploadExceptionAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(MaxUploadSizeExceededException exc, ModelMap modelMap) {
        modelMap.addAttribute("error", "O tamanho do arquivo não pode exceder 2 MB.");
        return "/inserirProduto";
    }
}
