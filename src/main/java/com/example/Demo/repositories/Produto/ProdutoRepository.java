package com.example.Demo.repositories.Produto;
import com.example.Demo.entities.Produto;
import com.example.Demo.repositories.RepositoryInterface;
import com.example.Demo.repositories.daos.DaoInterface;
import com.example.Demo.repositories.daos.Produto.ProdutoDao;
import com.example.Demo.repositories.daos.Produto.mapper.ProdutoModelToProduto;
import com.example.Demo.repositories.daos.Produto.mapper.ProdutoToProdutoModel;
import com.example.Demo.repositories.daos.Produto.model.ProdutoModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoRepository implements RepositoryInterface<Produto> {



    private DaoInterface<ProdutoModel> produtoDao;

    private ProdutoRepository(final DaoInterface<ProdutoModel> inDao) {
        this.produtoDao = inDao;
    }

    public static ProdutoRepository build(final ProdutoDao aDao) {
        return new ProdutoRepository(aDao);
    }

    @Override
    public Produto getById(final String id) {
        final var aModel = this.produtoDao.getById(id);
        final var anProduto = ProdutoModelToProduto.convert(aModel);
        return anProduto;
    }

    @Override
    public List<Produto> getAll() {

        final var aModelList = this.produtoDao.getAll();
        final var anProdutoList = aModelList.stream()
                .map(ProdutoModelToProduto::convert)
                .collect(Collectors.toList());
        return anProdutoList;
    }

    @Override
    public Produto create(final Produto anEntity) {
        final var aModel = ProdutoToProdutoModel.convert(anEntity);
        this.produtoDao.create(aModel);
        return anEntity;
    }

    @Override
    public Produto update(final Produto anEntity) {
        final var aModelToUpdate = this.produtoDao.getById(anEntity.getId()+"");
        if (aModelToUpdate != null) {
            final var aNewModel = ProdutoModel.with(anEntity.getId(), anEntity.getNome(), anEntity.getDescricao(),anEntity.getPreco(), anEntity.getQtdestoque(),  aModelToUpdate.createdAt());
            this.produtoDao.update(aNewModel);
            return anEntity;
        }
        throw new RuntimeException("Produto " + anEntity.getNome() + " not found to update");
    }

    @Override
    public void delete(final String id) {
        this.produtoDao.delete(id);
    }
}
