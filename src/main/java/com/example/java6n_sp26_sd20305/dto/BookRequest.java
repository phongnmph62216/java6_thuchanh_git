package com.example.java6n_sp26_sd20305.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequest {


         private Long id;

         @NotBlank(message = "khong dc trong du lieu")
         private String title;

         @NotBlank(message = "khong dc trong du lieu")
        private String author;

         @NotNull(message = "khong dc trong du lieu")
        private Double price;


}
