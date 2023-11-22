package com.example.figureCollection.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="users")
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;

    private String avatar;

    private String banner;

    @NotNull
    @Column(columnDefinition = "boolean default true")
	private Boolean enabled;
    
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="user_role",
			joinColumns=
            	@JoinColumn(name="user_id", referencedColumnName="id"),
            inverseJoinColumns=
            	@JoinColumn(name="role_id", referencedColumnName="id"))
    private List<Role> listRoles;

    @OneToMany(mappedBy = "user")
    private List<FigureUserOwned> listFigureOwned;

    @ManyToMany(mappedBy = "listFigureLiked")
    private List<Figure> listFiguresLiked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<Role> getListRoles() {
        return listRoles;
    }

    public void setListRoles(List<Role> listRoles) {
        this.listRoles = listRoles;
    }

    public List<FigureUserOwned> getListFigureOwned() {
        return listFigureOwned;
    }

    public void setListFigureOwned(List<FigureUserOwned> listFigureOwned) {
        this.listFigureOwned = listFigureOwned;
    }

    public List<Figure> getListFiguresLiked() {
        return listFiguresLiked;
    }

    public void setListFiguresLiked(List<Figure> listFiguresLiked) {
        this.listFiguresLiked = listFiguresLiked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
