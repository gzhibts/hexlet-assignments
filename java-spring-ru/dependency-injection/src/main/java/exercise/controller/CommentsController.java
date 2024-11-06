package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Comment show(@PathVariable long id) {
        return commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
    }

    @PostMapping(path = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment create(@RequestBody Comment data) {
        return commentRepository.save(data);
    }

    @PutMapping(path = "/{id}")
    public Comment update(@PathVariable long id, @RequestBody Comment data){
        var comment =  commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));

        comment.setBody(data.getBody());

        return commentRepository.save(comment);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        commentRepository.deleteById(id);
    }
}
// END
