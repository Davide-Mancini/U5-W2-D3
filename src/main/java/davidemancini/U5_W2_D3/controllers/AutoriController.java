package davidemancini.U5_W2_D3.controllers;


import davidemancini.U5_W2_D3.entities.Autori;
import davidemancini.U5_W2_D3.payloads.AutoriPayload;
import davidemancini.U5_W2_D3.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AutoriController {
    @Autowired
    private AutoreService autoreService;

    @GetMapping
    public Page<Autori> getAutori(@RequestParam (defaultValue = "0") int page,
                                  @RequestParam (defaultValue = "10") int size,
                                  @RequestParam (defaultValue = "nome") String sortBy){
        return autoreService.findAll(page,size,sortBy);
    }
    @GetMapping("/{authorId}")
    public Autori authorById(@PathVariable UUID authorId){
        return autoreService.findAutoreById(authorId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Autori createAuthor (@RequestBody AutoriPayload body){
    return autoreService.saveAutore(body);
    }
    @PutMapping("/{authorId}")
    public Autori findAuthorByIdAndUpdate(@PathVariable UUID authorId, @RequestBody AutoriPayload body){
        return autoreService.findByIdAndUpdate(authorId,body);
    }
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById (@PathVariable UUID authorId){
        autoreService.deleteAutoreById(authorId);
    }
}
