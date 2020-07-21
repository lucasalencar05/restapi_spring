package com.lucasalencar.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lucasalencar.cursomc.domain.enums.TypeClient;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private  String email;
    private String cpfOrCnpj;
    private Integer typeClient;

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "phone")
    private Set<String> phone = new HashSet<>();

    private List<Order> orders = new ArrayList<>();

    public Client(){}

    public Client(Integer id, String name, String email, String cpfOrCnpj, TypeClient typeClient) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOrCnpj = cpfOrCnpj;
        this.typeClient = typeClient.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public TypeClient getTypeClient() {
        return TypeClient.toEnum(typeClient);
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient.getCod();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getPhone() {
        return phone;
    }

    public void setPhone(Set<String> phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
