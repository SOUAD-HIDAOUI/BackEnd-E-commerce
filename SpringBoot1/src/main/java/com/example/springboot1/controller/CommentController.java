package com.example.springboot1.controller;

import com.example.springboot1.Service.CommentService;
import com.example.springboot1.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/", produces = "application/json")
    public @ResponseBody List<Comment> getAllComments() {
        return commentService.getAllComments();
    }
    @PostMapping("/addComment/{clientId}")
    public void createComment(@PathVariable Long clientId, @RequestBody String body) {
        commentService.addCommentForClient(clientId, body);
    }
    @DeleteMapping(value="/delete/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.remove(commentId);
    }
    @GetMapping(value="/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }
    @PostMapping(value="/update/{commentId}")
    public ResponseEntity<Comment> updateClient(@PathVariable Long commentId, @RequestBody Comment updatedComment) {
            Comment existingComment = commentService.getCommentById(commentId);
            existingComment.setBody(updatedComment.getBody());
            commentService.update(existingComment);
            return new ResponseEntity<>(existingComment, HttpStatus.OK);
    }
}
