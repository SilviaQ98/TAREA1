package com.distribuida.services;

import com.distribuida.db.authors;

import javax.ws.rs.core.Response;
import java.util.List;

public interface authorsService {
    public List<authors> get();
    public authors findById(Integer id);
    public authors update(Integer id, authors authors);
    public void delete (Integer id);
    public Response create(authors authors);
}
