package org.jzou.service;

import org.jzou.client.MovieClient;
import org.jzou.dto.CustomerDto;
import org.jzou.dto.GenreUpdateRequest;
import org.jzou.exception.CustomerNotFoundException;
import org.jzou.mapper.EntityDtoMapper;
import org.jzou.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final MovieClient movieClient;
    private final CustomerRepository repository;

    public CustomerService(MovieClient movieClient, CustomerRepository repository) {
        this.movieClient = movieClient;
        this.repository = repository;
    }

    public CustomerDto getCustomer(Integer id) {
        var customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        var movies = this.movieClient.getMovies(customer.getFavoriteGenre());
        return EntityDtoMapper.toDto(customer, movies);
    }

    public void updateCustomerGenre(Integer id, GenreUpdateRequest request) {
        var customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        customer.setFavoriteGenre(request.favoriteGenre());
        this.repository.save(customer);
    }
}
