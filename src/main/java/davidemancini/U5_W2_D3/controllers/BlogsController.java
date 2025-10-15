package davidemancini.U5_W2_D3.controllers;




import davidemancini.U5_W2_D3.entities.Blog;
import davidemancini.U5_W2_D3.payloads.BlogsPayload;
import davidemancini.U5_W2_D3.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
@Autowired
    private BlogsService blogsService;


//RITORNA LA LISTA DI TUTTI I BLOG
    @GetMapping
    public List<Blog> getBlogs (){
        return blogsService.findAll();
    }

//SALVO UN NUOVO BLOG
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Blog createBlog (@RequestBody BlogsPayload body){
        return blogsService.saveBlog(body);
}
//RITORNA UN SINGOLO BLOG
    @GetMapping("/{blogId}")
public Blog blogById(@PathVariable UUID blogId){
        return blogsService.findById(blogId);
    }
//MODIFICA UNO SPECIFICO BLOG
    @PutMapping("/{blogId}")
    public Blog getBlogByIdAndUpdate(@PathVariable UUID blogId, @RequestBody BlogsPayload body){
    return blogsService.findByIdAndUpdate(blogId,body);
    }
//ELIMINA SPECIFICO BLOG
@DeleteMapping("/{blogId}")
@ResponseStatus(HttpStatus.NO_CONTENT)public void deleteBlogById(@PathVariable UUID blogId){
        blogsService.deleteBlogById(blogId);
}
}
