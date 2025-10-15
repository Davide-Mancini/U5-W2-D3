package davidemancini.U5_W2_D3.payloads;


import davidemancini.U5_W2_D3.entities.Autori;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class BlogsPayload {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private UUID author_id;
}
