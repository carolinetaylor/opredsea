package com.amazon;

import java.util.*;

/**
 * Created by Tian on 2017/4/8.
 */
public class SolutionMovieNetwork {

    Comparator<Movie> queueComp = new Comparator<Movie>() {
        public int compare(Movie a, Movie b) {
            return (a.rating - b.rating > 0 ? 1 : -1);
        }
    };

    public List<Movie> getNearest(Movie movie, int k) {
        /*
            A priorityQueue to keep minHeap of top k rating
            Use DFS level order traverse all nodes
         */
        PriorityQueue<Movie> pq = new PriorityQueue<Movie>(k, queueComp);
        Queue<Movie> queue = new LinkedList<Movie>();
        HashSet<Movie> hash = new HashSet<Movie>();

        for (Movie indegree : movie.similarMovies) {
            if (!hash.contains(indegree)) {
                queue.offer(indegree);
                hash.add(indegree);
            }
        }

//        queue.offer(movie);
//        hash.add(movie);
        while (!queue.isEmpty()) {
            Movie oneMovie = queue.poll();
            if (pq.size() < k) {
                pq.add(oneMovie);
            } else {
                if (pq.peek().rating < oneMovie.rating) {
                    pq.poll();
                    pq.offer(oneMovie);
                }
            }
            for (Movie similar : oneMovie.similarMovies) {
                if (!hash.contains(similar)) {
                    pq.offer(similar);
                    hash.add(similar);
                }
            }
        }

        List<Movie> res = new ArrayList<Movie>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        return res;
    }

    public static class Movie
    {
        int movieId;
        float rating;
        List<Movie> similarMovies;
    }
}
