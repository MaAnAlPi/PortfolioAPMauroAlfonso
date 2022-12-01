package com.portfolio.MAAP.Security.Entity;

import java.util.Collection;
import java.util.List;

public class UsuarioPrincipal implements UserDetails {

    private String nombre;
    private String nombreusuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombre, String nombreusuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.nombreusuario = nombreusuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre())).collect(collectors.toList())
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getpassword(), autorities);
                
    }

}
