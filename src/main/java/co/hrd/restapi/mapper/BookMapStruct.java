package co.hrd.restapi.mapper;

import co.hrd.restapi.dto.CreateBookDto;
import co.hrd.restapi.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapStruct {

    Book  fromCreateBookDto(CreateBookDto createBookDto);
}
