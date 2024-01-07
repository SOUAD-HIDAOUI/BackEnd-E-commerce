    package com.example.springboot1.Repository;


    import com.example.springboot1.model.Client;
    import com.example.springboot1.model.Comment;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.List;

    public interface CommentRepository extends JpaRepository<Comment,Long> {
        List<Comment> findAll();
        void deleteById(Long id);
        Comment getCommentById(Long id);

    }
