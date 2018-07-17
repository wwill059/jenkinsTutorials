package com.revature.pojos;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="BEAR")
@NamedQueries({ @NamedQuery(name="@HQL_GET_ALL_BEARS", query="FROM Bear")})
@NamedNativeQueries({@NamedNativeQuery(name="@SQL_GET_ALL_THE_BEARS", query="SELECT * FROM BEAR")})


public class Bear {
	
	@Id
	@Column(name="BEAR_ID")
	@SequenceGenerator(name="BEARID_SEQ", sequenceName="BEAR_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEARID_SEQ")
	private int bearId;
	
	@Column(name="BEAR_COLOR")
	private String bearColor;
	
	@Column(name="BREED")
	private String breed;
	
	@Column(name="HEIGHT")
	private double height;
	
	@Column(name="WEIGHT")
	private double weight;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="honeypotId")
	@JoinColumn(name="HONEYPOT_ID")
	@Column(name="HONEYPOT_ID")
	private HoneyPot honeyPot;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PARENT_CUB", joinColumns=@JoinColumn(name="BEAR_ID"),
				inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	private Set<Bear> bearCub;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	@JoinColumn(name="bearHome")
	private Cave bearHome;
	
	
	
	public Bear() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bear(int bearId, String bearColor, String breed, double height, double weight, HoneyPot honeyPot,
			Cave bearHome) {
		super();
		this.bearId = bearId;
		this.bearColor = bearColor;
		this.breed = breed;
		this.height = height;
		this.weight = weight;
		this.honeyPot = honeyPot;
		this.bearHome = bearHome;
	}

	public int getBearId() {
		return bearId;
	}
	public void setBearId(int bearId) {
		this.bearId = bearId;
	}
	public String getBearColor() {
		return bearColor;
	}
	public void setBearColor(String bearColor) {
		this.bearColor = bearColor;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public HoneyPot getHoneyPot() {
		return honeyPot;
	}
	public void setHoneyPot(HoneyPot honeyPot) {
		this.honeyPot = honeyPot;
	}
	
	
	public Cave getBearHome() {
		return bearHome;
	}
	public void setBearHome(Cave bearHome) {
		this.bearHome = bearHome;
	}
	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", bearColor=" + bearColor + ", breed=" + breed + ", height=" + height
				+ ", weight=" + weight + ", honeyPot=" + honeyPot + ", bearHome=" + bearHome + "]";
	}
	
	
	

}
