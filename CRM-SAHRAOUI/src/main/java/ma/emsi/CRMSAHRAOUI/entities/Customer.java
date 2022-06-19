package ma.emsi.CRMSAHRAOUI.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name="customer")
public class Customer {
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotEmpty
        @Size(min=2,max=40)
        @Column
        private String firstName;
        @Column
        @NotEmpty
        @Size(min=2,max=40)
        private String lastName;
        @Column
        @NotEmpty
        @Size(min=2,max=40)
        private String email;
        @Column
        @NotEmpty
        @Size(min=2,max=40)
        private String adresse;
        @Column
        @NotEmpty
        @Size(min=2,max=40)
        private String ville;
        @Column
        @NotEmpty
        @Size(min=2,max=40)
        private String pays;
        @Column
        @NotEmpty
        @Size(min=4,max=40)
        private String telephone;
        // public getters and setters omitted for brevity

}
