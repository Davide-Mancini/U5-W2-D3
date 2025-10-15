package davidemancini.U5_W2_D3.services;


import davidemancini.U5_W2_D3.entities.Autori;
import davidemancini.U5_W2_D3.entities.Blog;
import davidemancini.U5_W2_D3.exceptions.NotFoundExceptions;
import davidemancini.U5_W2_D3.payloads.BlogsPayload;
import davidemancini.U5_W2_D3.repositories.AutoriRepository;
import davidemancini.U5_W2_D3.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BlogsService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AutoriRepository autoriRepository;
    public List<Blog> findAll (){
        return blogRepository.findAll();
    }
    public Blog saveBlog (BlogsPayload body){
        Autori autoreTrovato = autoriRepository.findById(body.getAuthor_id()).orElseThrow(()-> new NotFoundExceptions(body.getAuthor_id()));
        Blog newBlog = new Blog(body.getCategoria(), body.getTitolo(), body.getContenuto(),body.getTempoDiLettura(),autoreTrovato);
        blogRepository.save(newBlog);
        return newBlog;
    }
    public Blog findById (UUID blogId) {
       return blogRepository.findById(blogId).orElseThrow(()-> new NotFoundExceptions(blogId));
    }

    //RICERCA TRAMITE ID E UPDATE
    public Blog findByIdAndUpdate(UUID blogId, BlogsPayload body){
        Autori autoreTrovato = autoriRepository.findById(body.getAuthor_id()).orElseThrow(()-> new NotFoundExceptions(body.getAuthor_id()));
        Blog found = findById(blogId);
                found.setCategoria(body.getCategoria());
                found.setTitolo(body.getTitolo());
                found.setContenuto(body.getContenuto());
                found.setTempoDiLettura(body.getTempoDiLettura());
                found.setAuthor_id(autoreTrovato);
            Blog blogModificato= found;
            blogRepository.save(blogModificato);
            return blogModificato;
        }


    //ELIMINA BLOG SPECIFICO
    public void deleteBlogById(UUID blogId){
        Blog found = findById(blogId) ;
        blogRepository.delete(found);

    }
}
