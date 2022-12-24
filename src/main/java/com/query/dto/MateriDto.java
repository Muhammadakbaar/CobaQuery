package com.query.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
public class MateriDto {

    @NotBlank
    private Long id;

    @NotBlank
    private String namaMateri;

    @NotBlank
    private String kodeMateri;

    @NotBlank
    private String namaPengajar;

}