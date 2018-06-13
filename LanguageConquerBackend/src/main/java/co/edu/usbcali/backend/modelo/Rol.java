package co.edu.usbcali.backend.modelo;
// Generated 13/06/2018 04:59:00 PM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Rol generated by hbm2java
 */
public class Rol implements java.io.Serializable {

	private int idRol;
	private String nameRol;
	private String imgRol;
	private Set<CourseMissionRol> courseMissionRols = new HashSet<CourseMissionRol>(0);
	private Set<RolStudent> rolStudents = new HashSet<RolStudent>(0);

	public Rol() {
	}

	public Rol(int idRol) {
		this.idRol = idRol;
	}

	public Rol(int idRol, String nameRol, String imgRol, Set<CourseMissionRol> courseMissionRols,
			Set<RolStudent> rolStudents) {
		this.idRol = idRol;
		this.nameRol = nameRol;
		this.imgRol = imgRol;
		this.courseMissionRols = courseMissionRols;
		this.rolStudents = rolStudents;
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNameRol() {
		return this.nameRol;
	}

	public void setNameRol(String nameRol) {
		this.nameRol = nameRol;
	}

	public String getImgRol() {
		return this.imgRol;
	}

	public void setImgRol(String imgRol) {
		this.imgRol = imgRol;
	}

	public Set<CourseMissionRol> getCourseMissionRols() {
		return this.courseMissionRols;
	}

	public void setCourseMissionRols(Set<CourseMissionRol> courseMissionRols) {
		this.courseMissionRols = courseMissionRols;
	}

	public Set<RolStudent> getRolStudents() {
		return this.rolStudents;
	}

	public void setRolStudents(Set<RolStudent> rolStudents) {
		this.rolStudents = rolStudents;
	}

}
