package dao;

import java.util.List;

import model.Pessoa;

public interface PessoaDao {
	public void save(Pessoa pessoa);
	public Pessoa getPessoa(Long id);
	public List<Pessoa> list(Pessoa pessoa);
	public void delete(Pessoa pessoa);
	public void update(Pessoa pessoa);
}
