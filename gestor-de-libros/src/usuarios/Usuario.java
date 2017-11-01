package usuarios;

import entidades.Libro;

class Usuario {
	private String usuario;
	private String contrasenia;
	
	@Override
	public boolean equals(Object obj) {
		return this == obj || (obj instanceof Usuario && 
				(usuario.equals(((Usuario) obj).usuario)) && (contrasenia.equals(((Usuario) obj).contrasenia)));
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Usuario(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
}