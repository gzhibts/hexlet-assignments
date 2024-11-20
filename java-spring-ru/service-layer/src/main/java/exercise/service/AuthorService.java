package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    // BEGIN
    @Autowired
    private AuthorRepository repository;

    @Autowired
    private AuthorMapper mapper;

    public List<AuthorDTO> getAll() {
        var authors = repository.findAll();
        var result = authors.stream()
                .map(mapper::map)
                .toList();
        return result;
    }

    public AuthorDTO create(AuthorCreateDTO data) {
        var author = mapper.map(data);
        repository.save(author);
        var authorDTO = mapper.map(author);
        return authorDTO;
    }

    public AuthorDTO findById(Long id) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found: " + id));
        var authorDTO = mapper.map(author);
        return authorDTO;
    }

    public AuthorDTO update(AuthorUpdateDTO data, Long id) {
        var author = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        mapper.update(data, author);
        repository.save(author);
        var authorDTO = mapper.map(author);
        return authorDTO;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    // END
}
