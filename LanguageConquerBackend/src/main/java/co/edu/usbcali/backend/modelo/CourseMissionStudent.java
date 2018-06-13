package co.edu.usbcali.backend.modelo;
// Generated 13/06/2018 04:59:00 PM by Hibernate Tools 5.1.7.Final

/**
 * CourseMissionStudent generated by hbm2java
 */
public class CourseMissionStudent implements java.io.Serializable {

	private int idCourseMissionStudent;
	private CourseMission courseMission;
	private MissionState missionState;
	private Student student;
	private Integer scoreStudent;

	public CourseMissionStudent() {
	}

	public CourseMissionStudent(int idCourseMissionStudent) {
		this.idCourseMissionStudent = idCourseMissionStudent;
	}

	public CourseMissionStudent(int idCourseMissionStudent, CourseMission courseMission, MissionState missionState,
			Student student, Integer scoreStudent) {
		this.idCourseMissionStudent = idCourseMissionStudent;
		this.courseMission = courseMission;
		this.missionState = missionState;
		this.student = student;
		this.scoreStudent = scoreStudent;
	}

	public int getIdCourseMissionStudent() {
		return this.idCourseMissionStudent;
	}

	public void setIdCourseMissionStudent(int idCourseMissionStudent) {
		this.idCourseMissionStudent = idCourseMissionStudent;
	}

	public CourseMission getCourseMission() {
		return this.courseMission;
	}

	public void setCourseMission(CourseMission courseMission) {
		this.courseMission = courseMission;
	}

	public MissionState getMissionState() {
		return this.missionState;
	}

	public void setMissionState(MissionState missionState) {
		this.missionState = missionState;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getScoreStudent() {
		return this.scoreStudent;
	}

	public void setScoreStudent(Integer scoreStudent) {
		this.scoreStudent = scoreStudent;
	}

}
