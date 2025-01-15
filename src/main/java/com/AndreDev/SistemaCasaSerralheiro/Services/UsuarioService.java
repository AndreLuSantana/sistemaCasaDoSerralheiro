package com.AndreDev.SistemaCasaSerralheiro.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.AndreDev.SistemaCasaSerralheiro.domain.Usuario;
import com.AndreDev.SistemaCasaSerralheiro.repositories.UsuarioRepository;
import com.AndreDev.SistemaCasaSerralheiro.Services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado! Id: " + id));
    }

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Usuario insert(Usuario obj) {
        if (repository.existsByLogin(obj.getLogin())) {
            throw new IllegalArgumentException("Já existe um usuário com este login!");
        }
        return repository.save(obj);
    }

    @Transactional
    public Usuario update(Long id, Usuario obj) {
        Usuario entity = findById(id);
        if (!entity.getLogin().equals(obj.getLogin()) && repository.existsByLogin(obj.getLogin())) {
            throw new IllegalArgumentException("Já existe um usuário com este login!");
        }
        updateData(entity, obj);
        return repository.save(entity);
    }

    @Transactional
    public void delete(Long id) {
        findById(id); // Verifica se existe
        repository.deleteById(id);
    }

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setLogin(obj.getLogin());
        entity.setSenha(obj.getSenha());
        entity.setFuncao(obj.getFuncao());
    }
}