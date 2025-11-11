package com.pttk.cinema.controller;

import com.pttk.cinema.dao.MovieDao;
import com.pttk.cinema.model.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/movie")
public class MovieServlet extends HttpServlet {
    private MovieDao movieDao;

    @Override
    public void init() throws ServletException {
        movieDao = new MovieDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        // Kiểm tra quyền truy cập
        if (role == null || !"manager".equals(role)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Hiển thị form thêm phim
            request.getRequestDispatcher("/WEB-INF/views/AddMovieView.jsp").forward(request, response);
        } else {
            // Hiển thị danh sách phim
            request.setAttribute("movies", movieDao.getAllMovies());
            request.getRequestDispatcher("/WEB-INF/views/ManageMovieView.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if (role == null || !"manager".equals(role)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String movieName = request.getParameter("movieName");
            String category = request.getParameter("category");
            String durationStr = request.getParameter("duration");
            String description = request.getParameter("description");
            String ageRatingStr = request.getParameter("ageRating");

            if (movieName != null && !movieName.trim().isEmpty() && 
                category != null && !category.trim().isEmpty() &&
                durationStr != null && ageRatingStr != null) {
                
                try {
                    Movie movie = new Movie();
                    movie.setName(movieName);
                    movie.setCategory(category);
                    movie.setDescription(description != null ? description : "");
                    movie.setDuration(Integer.parseInt(durationStr));
                    movie.setAgeRating(Integer.parseInt(ageRatingStr));

                    Movie addedMovie = movieDao.addMovie(movie);
                    if (addedMovie != null) {
                        request.setAttribute("success", "Thêm phim thành công!");
                    } else {
                        request.setAttribute("error", "Có lỗi xảy ra khi thêm phim");
                    }
                } catch (NumberFormatException e) {
                    request.setAttribute("error", "Thời lượng và độ tuổi phải là số");
                }
            } else {
                request.setAttribute("error", "Vui lòng điền đầy đủ thông tin");
            }

            // Sau khi thêm, quay lại danh sách
            request.setAttribute("movies", movieDao.getAllMovies());
            request.getRequestDispatcher("/WEB-INF/views/ManageMovieView.jsp").forward(request, response);
        }
    }
}
