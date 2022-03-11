package com.application.web.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(
    schema = "public",
    name = "acesso",
    uniqueConstraints = {
            @UniqueConstraint(name = "UNQ_ACCESS_TOKEN", columnNames = { "access_token" }),
            @UniqueConstraint(name = "UNQ_REFRESH_TOKEN", columnNames = { "refresh_token" })
    }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Acesso implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GEN_ACESSO")
    @SequenceGenerator(name="SQ_GEN_ACESSO", sequenceName = "SQ_ACESSO", allocationSize = 1)
    private Long id;

    @Column(name = "ip")
    @Size(min = 8, max = 15)
    private String ip;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @JoinColumn(name = "usuario_id", nullable = false)
    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Usuario usuario;

}
