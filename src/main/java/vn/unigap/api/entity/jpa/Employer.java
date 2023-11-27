package vn.unigap.api.entity.jpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employer")
public class Employer implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email", unique = true,  length = 225)
    private String email;

    @Column(name = "name", columnDefinition = "text")
    private String name;

    @Column(name = "province")
    private Integer province;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Builder.Default
    @Column(name = "CREATED_DATE")
    private Date created_at = new Date();

    @Builder.Default
    @Column(name = "UPDATED_DATE")
    private Date updated_at= new Date();


}
