package com.javateam.service;

import com.javateam.model.Post;
import com.javateam.model.Subreddit;
import com.javateam.model.User;
import com.javateam.model.Vote;
import com.javateam.repository.PostRepository;
import com.javateam.repository.SubredditRepository;
import com.javateam.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    private PostRepository postRepository;
    private SubredditRepository subredditRepository;
    private VoteRepository voteRepository;

    public PostService(PostRepository postRepository, SubredditRepository subredditRepository, VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
        this.postRepository = postRepository;
        this.subredditRepository = subredditRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAllByOrderByVoteCountDesc();
    }

    public void save(Post post){
        postRepository.save(post);
    }
    public Post findById(Integer postId) {
        return postRepository.findById(postId).get();
    }

    public void save(Subreddit subreddit) {
        subredditRepository.save(subreddit);
    }

    public List<Subreddit> findAllSubreddit() {
        return subredditRepository.findAll();
    }

    public void deleteById(Integer postId) {
        postRepository.deleteById(postId);
    }

    public void createVote(Vote vote) {
        voteRepository.save(vote);
    }
    public Vote findVoteByUserAndPost(User user, Post post) {
        return voteRepository.findByUserAndPost(user, post);
    }
    public void updateVote(Vote vote) {
        voteRepository.save(vote);
    }




}
