package com.example.springboot1.Service;

import com.example.springboot1.Repository.ClientRepository;
import com.example.springboot1.Repository.CommentRepository;
import com.example.springboot1.model.Client;
import com.example.springboot1.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    ClientRepository clientRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
    public void remove(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    public Comment getCommentById(Long id) {
        return commentRepository.getCommentById(id);
    }


    public void update(Comment existingComment) {
        commentRepository.saveAndFlush(existingComment);
    }
    public void addCommentForClient(Long clientId, String body) {
        Client client = clientRepository.getClientById(clientId);
        if (client != null) {
            Comment newComment = new Comment();
            newComment.setBody(body);
            client.addComment(newComment);
            commentRepository.save(newComment);
        }

    }
    public List<Comment> getAllCommentsWithClient() {
        List<Comment> comments = commentRepository.findAll();
        for (Comment comment : comments) {
            comment.getClient().getId();
        }
        return comments;
    }
}
