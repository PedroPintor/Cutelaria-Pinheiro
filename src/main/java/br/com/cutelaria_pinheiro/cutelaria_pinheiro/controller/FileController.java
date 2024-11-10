package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cutelaria_pinheiro.cutelaria_pinheiro.service.FileService;

@Controller
@RequestMapping("/arquivos")
public class FileController {

    @Autowired
    private FileService fileService;

    // inserir Foto do Produtod
    @GetMapping("/adicionar")
    public String inserir() {

        return "/inserirProduto";
    }

    // Método para fazer o upload do arquivo
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            fileService.uploadFile(file);
            redirectAttributes.addFlashAttribute("message", "Upload realizado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Falha no upload do arquivo.");
        }
        return "redirect:/administrador/produtos/listar";
    }

    // Método para download do arquivo
    // @GetMapping("/download/{id}")
    // public ResponseEntity<byte[]> downloadFile(@PathVariable UUID id) {
    //     File fileEntity = fileService.getFile(id);
    //     if (fileEntity != null) { 
    //         return ResponseEntity.ok()
    //                         ->ERRO .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
    //                 fileEntity.getName() + "\"")
    // .body(fileEntity.getData());
    // }
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    // }

}
