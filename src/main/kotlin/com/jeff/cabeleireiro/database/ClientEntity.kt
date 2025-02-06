package com.jeff.cabeleireiro.database

import jakarta.persistence.*

@Entity
@Table(name = "clients")
data class ClientEntity(
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column(name = "name_complete", nullable = false, length = 150)
    var nameComplete: String?,

    @Column(name = "email", nullable = false, length = 300)
    var email: String?,

    @Column(name = "number_telephone", nullable = false, length = 30)
    var numberTelephone: String?,

    @Column(name = "gender", nullable = false, length = 70)
    var gender: String?

)