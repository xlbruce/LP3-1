/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import java.util.List;

/**
 *
 * @author Raquel
 */
public interface GenericDAO<T> {
    public void insert(T e);
    public List<T> readList();
    public T read(T e);
    public void update(T e, int id);
    public void delete (T e);
}
