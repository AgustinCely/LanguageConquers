package co.edu.usbcali.backend.modelo;
// Generated 13/06/2018 04:59:00 PM by Hibernate Tools 5.1.7.Final

/**
 * StudentProgrammingLevel generated by hbm2java
 */
public class StudentProgrammingLevel implements java.io.Serializable {

	private int idStudentProgrammingLevel;
	private ProgrammingLevel programmingLevel;
	private Student student;

	public StudentProgrammingLevel() {
	}

	public StudentProgrammingLevel(int idStudentProgrammingLevel) {
		this.idStudentProgrammingLevel = idStudentProgrammingLevel;
	}

	public StudentProgrammingLevel(int idStudentProgrammingLevel, ProgrammingLevel programmingLevel, Student student) {
		this.idStudentProgrammingLevel = idStudentProgrammingLevel;
		this.programmingLevel = programmingLevel;
		this.student = student;
	}

	public int getIdStudentProgrammingLevel() {
		return this.idStudentProgrammingLevel;
	}

	public void setIdStudentProgrammingLevel(int idStudentProgrammingLevel) {
		this.idStudentProgrammingLevel = idStudentProgrammingLevel;
	}

	public ProgrammingLevel getProgrammingLevel() {
		return this.programmingLevel;
	}

	public void setProgrammingLevel(ProgrammingLevel programmingLevel) {
		this.programmingLevel = programmingLevel;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}