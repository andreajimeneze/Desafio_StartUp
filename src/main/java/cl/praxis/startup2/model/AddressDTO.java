package cl.praxis.startup2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private int id;
    private String name;
    private String number;
    private int user_id;

    public AddressDTO(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
}