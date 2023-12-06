package tn.esprit.spring.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ContratDto {
    private Long reference;
    private Date dateDebut;
    private String typeContrat;
    private float salaire;

    public ContratDto() {
    }

    public ContratDto(Date dateDebut, String typeContrat, float salaire) {
        this.dateDebut = dateDebut;
        this.typeContrat = typeContrat;
        this.salaire = salaire;
    }

}
