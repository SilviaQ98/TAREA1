package com.distribuida.services;

import com.distribuida.db.authors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class authorsServiceImpl implements authorsService {

    public List<authors> get(){
        List<authors> listAll = authors.findAll().list();
        return listAll.stream().collect(Collectors.toList());
    }

    public authors findById(Integer id){
        return authors.findById(id);
    }

    @Transactional
    public authors update (Integer id, authors authors){
        authors entity = authors.findById(id);
        if(entity == null){
            throw new NotFoundException();
        }
        entity.setFirst_name(authors.getFirst_name());
        entity.setLast_name(authors.getLast_name());

        return entity;
    }
    @Transactional
    public void delete(Integer id){
        authors entity = authors.findById(id);
        if(entity == null){
            throw new NotFoundException();
        }
        entity.delete();
    }

    @Transactional
    public Response create(authors authors){
       authors.persist();
       return Response.created(URI.create("/authors"+authors.getId())).build();
    }
}
