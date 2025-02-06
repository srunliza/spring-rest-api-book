package co.hrd.restapi.dto;


import lombok.Data;


public record CreateBookDto(String title, String author, String isbn) {
}
