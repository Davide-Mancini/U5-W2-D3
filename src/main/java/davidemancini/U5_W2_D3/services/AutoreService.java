package davidemancini.U5_W2_D3.services;


import davidemancini.U5_W2_D3.entities.Autori;
import davidemancini.U5_W2_D3.exceptions.NotFoundExceptions;
import davidemancini.U5_W2_D3.payloads.AutoriPayload;
import davidemancini.U5_W2_D3.repositories.AutoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AutoreService {
    @Autowired
    AutoriRepository autoriRepository;


    public List<Autori> findAll (){

        return autoriRepository.findAll();
    }

    public Autori saveAutore(AutoriPayload body){
        Autori newAutore = new Autori(body.getNome(), body.getCognome(), body.getEmail(), body.getDataDiNascita());
        autoriRepository.save(newAutore);
        return newAutore;
    }

    public Autori findAutoreById (UUID autoreId){
        return autoriRepository.findById(autoreId).orElseThrow(()->new NotFoundExceptions(autoreId));
    }

    public Autori findByIdAndUpdate (UUID autoreId, AutoriPayload body){
        Autori trovato = findAutoreById(autoreId);
        trovato.setNome(body.getNome());
        trovato.setCognome(body.getCognome());
        trovato.setDataDiNascita(body.getDataDiNascita());
        trovato.setEmail(body.getEmail());
        Autori autoreModificato = autoriRepository.save(trovato);
        return autoreModificato;
    }

    public void deleteAutoreById(UUID autoreId){
        Autori trovato= findAutoreById(autoreId);
        autoriRepository.delete(trovato);

    }
}
