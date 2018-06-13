package co.edu.usbcali.backend.modelo;
// Generated 13/06/2018 04:59:00 PM by Hibernate Tools 5.1.7.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Avatar generated by hbm2java
 */
public class Avatar implements java.io.Serializable {

	private int idAvatar;
	private String nameAvatar;
	private String imgAvatar;
	private Set<Student> students = new HashSet<Student>(0);

	public Avatar() {
	}

	public Avatar(int idAvatar) {
		this.idAvatar = idAvatar;
	}

	public Avatar(int idAvatar, String nameAvatar, String imgAvatar, Set<Student> students) {
		this.idAvatar = idAvatar;
		this.nameAvatar = nameAvatar;
		this.imgAvatar = imgAvatar;
		this.students = students;
	}

	public int getIdAvatar() {
		return this.idAvatar;
	}

	public void setIdAvatar(int idAvatar) {
		this.idAvatar = idAvatar;
	}

	public String getNameAvatar() {
		return this.nameAvatar;
	}

	public void setNameAvatar(String nameAvatar) {
		this.nameAvatar = nameAvatar;
	}

	public String getImgAvatar() {
		return this.imgAvatar;
	}

	public void setImgAvatar(String imgAvatar) {
		this.imgAvatar = imgAvatar;
	}

	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}