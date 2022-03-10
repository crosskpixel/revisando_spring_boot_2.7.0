package com.application.web.model;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Revizia Gestao e Analise de documentos
 */

@Entity
@Table(
    schema = "public",
    name = "usuario",
    uniqueConstraints = @UniqueConstraint(name = "UNQ_USUARIO", columnNames = { "email" })
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "primeiro_login", columnDefinition = "boolean default false")
    @Builder.Default
    private boolean primeiroLogin = false;

    @Column(name = "ativo", columnDefinition = "boolean default true")
    @Builder.Default
    private boolean ativo = true;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreatedBy
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Usuario createdBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private Usuario updatedBy;

}
