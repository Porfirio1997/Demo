package com.example.Demo.repositories.daos.Produto;

import com.example.Demo.repositories.daos.DaoInterface;
import com.example.Demo.repositories.daos.Produto.model.ProdutoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProdutoDao implements DaoInterface<ProdutoModel> {

    private HashMap<String, ProdutoModel> produtos;
    private ProdutoDao() {
        this.produtos = new HashMap<String, ProdutoModel>();
    }
    public static ProdutoDao build() {
        return new ProdutoDao();
    }
    @Override
    public ProdutoModel getById(String id) {
        // Select * from TABLE where id=id
        return this.produtos.get(id);
    }
    @Override
    public List<ProdutoModel> getAll() {
        // Select * from TABLE
        final List<ProdutoModel> aList = new ArrayList<>(this.produtos.values());
        return aList;
    }

    @Override
    public ProdutoModel create(ProdutoModel anEntity) {
        // INSERT INTO TABLE ...
        if (this.produtos.get(String.valueOf(anEntity.id())) == null) {
            this.produtos.put(String.valueOf(anEntity.id()), anEntity);
            return anEntity;
        }

        return null;
    }
    @Override
    public ProdutoModel update(ProdutoModel anEntity) {
        // UPDATE TABLE SET ...
        if (this.produtos.get(String.valueOf(anEntity.id())) != null) {
            this.produtos.put(String.valueOf(anEntity.id()), anEntity);
            return anEntity;
        }
        return null;
    }
    @Override
    public void delete(String id) {
        // DELETE FROM TABLE WHERE ID = id ...
        this.produtos.remove(id);
    }
}
