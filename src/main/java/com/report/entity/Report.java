package com.report.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id; 
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "tc_no")
    private String tcNo;
    @Column(name = "diagnosis_title")
    private String diagnosisTitle;
    @Column(name = "diagnosis_detail")
    private String diagnosisDetail;
    @Column(name = "date")
    private String date;
    @Column(name = "image_name")
    private String imageName;

    public Report() {
    }

    public Report(String firstName, String lastName, String tcNo, String diagnosisTitle, String diagnosisDetail, String date, String imageName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNo = tcNo;
        this.diagnosisTitle = diagnosisTitle;
        this.diagnosisDetail = diagnosisDetail;
        this.date = date;
        this.imageName = imageName;
    }
}
