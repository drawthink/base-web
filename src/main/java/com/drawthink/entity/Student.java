package com.drawthink.entity;

import java.io.Serializable;

public class Student implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.stu_id
     *
     * @mbggenerated
     */
    private String stuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.stu_name
     *
     * @mbggenerated
     */
    private String stuName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.stu_sex
     *
     * @mbggenerated
     */
    private String stuSex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.stu_address
     *
     * @mbggenerated
     */
    private String stuAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.stu_school_id
     *
     * @mbggenerated
     */
    private String stuSchoolId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.stu_class_id
     *
     * @mbggenerated
     */
    private String stuClassId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table student
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.stu_id
     *
     * @return the value of student.stu_id
     *
     * @mbggenerated
     */
    public String getStuId() {
        return stuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.stu_id
     *
     * @param stuId the value for student.stu_id
     *
     * @mbggenerated
     */
    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.stu_name
     *
     * @return the value of student.stu_name
     *
     * @mbggenerated
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.stu_name
     *
     * @param stuName the value for student.stu_name
     *
     * @mbggenerated
     */
    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.stu_sex
     *
     * @return the value of student.stu_sex
     *
     * @mbggenerated
     */
    public String getStuSex() {
        return stuSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.stu_sex
     *
     * @param stuSex the value for student.stu_sex
     *
     * @mbggenerated
     */
    public void setStuSex(String stuSex) {
        this.stuSex = stuSex == null ? null : stuSex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.stu_address
     *
     * @return the value of student.stu_address
     *
     * @mbggenerated
     */
    public String getStuAddress() {
        return stuAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.stu_address
     *
     * @param stuAddress the value for student.stu_address
     *
     * @mbggenerated
     */
    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.stu_school_id
     *
     * @return the value of student.stu_school_id
     *
     * @mbggenerated
     */
    public String getStuSchoolId() {
        return stuSchoolId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.stu_school_id
     *
     * @param stuSchoolId the value for student.stu_school_id
     *
     * @mbggenerated
     */
    public void setStuSchoolId(String stuSchoolId) {
        this.stuSchoolId = stuSchoolId == null ? null : stuSchoolId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.stu_class_id
     *
     * @return the value of student.stu_class_id
     *
     * @mbggenerated
     */
    public String getStuClassId() {
        return stuClassId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.stu_class_id
     *
     * @param stuClassId the value for student.stu_class_id
     *
     * @mbggenerated
     */
    public void setStuClassId(String stuClassId) {
        this.stuClassId = stuClassId == null ? null : stuClassId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getStuId() == null ? other.getStuId() == null : this.getStuId().equals(other.getStuId()))
            && (this.getStuName() == null ? other.getStuName() == null : this.getStuName().equals(other.getStuName()))
            && (this.getStuSex() == null ? other.getStuSex() == null : this.getStuSex().equals(other.getStuSex()))
            && (this.getStuAddress() == null ? other.getStuAddress() == null : this.getStuAddress().equals(other.getStuAddress()))
            && (this.getStuSchoolId() == null ? other.getStuSchoolId() == null : this.getStuSchoolId().equals(other.getStuSchoolId()))
            && (this.getStuClassId() == null ? other.getStuClassId() == null : this.getStuClassId().equals(other.getStuClassId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuId() == null) ? 0 : getStuId().hashCode());
        result = prime * result + ((getStuName() == null) ? 0 : getStuName().hashCode());
        result = prime * result + ((getStuSex() == null) ? 0 : getStuSex().hashCode());
        result = prime * result + ((getStuAddress() == null) ? 0 : getStuAddress().hashCode());
        result = prime * result + ((getStuSchoolId() == null) ? 0 : getStuSchoolId().hashCode());
        result = prime * result + ((getStuClassId() == null) ? 0 : getStuClassId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuId=").append(stuId);
        sb.append(", stuName=").append(stuName);
        sb.append(", stuSex=").append(stuSex);
        sb.append(", stuAddress=").append(stuAddress);
        sb.append(", stuSchoolId=").append(stuSchoolId);
        sb.append(", stuClassId=").append(stuClassId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}