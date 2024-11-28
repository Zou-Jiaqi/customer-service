package org.jzou.mapper;

import org.jzou.dto.CustomerDto;
import org.jzou.dto.MovieDto;
import org.jzou.entity.Customer;

import java.util.List;

public class EntityDtoMapper {

    public static CustomerDto toDto(Customer customer, List<MovieDto> movies){
        return new CustomerDto(
                customer.getId(),
                customer.getName().toUpperCase(),
                customer.getFavoriteGenre(),
                movies
        );
    }
}
