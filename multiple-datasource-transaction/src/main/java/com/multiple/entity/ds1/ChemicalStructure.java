package com.multiple.entity.ds1;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author nick
 */
@Entity
@Table(name = "chemical_structures")
@NamedQueries({
	@NamedQuery(name = ChemicalStructure.Q_SELECT_ID, query = "SELECT c.id FROM ChemicalStructure c ORDER BY c.updatedAt ASC")
	,
	@NamedQuery(name = ChemicalStructure.Q_SELECT_ID_UPDATED_AFTER, query = "SELECT c.id FROM ChemicalStructure c WHERE c.updatedAt > :updatedAfter ORDER BY c.updatedAt ASC"),
	@NamedQuery(name = ChemicalStructure.Q_SELECT_FOR_IDS, query = "SELECT c FROM ChemicalStructure c WHERE c.id IN (:ids)")
})
public class ChemicalStructure implements Serializable {

	public static final String Q_SELECT_ID = "ChemicalStructure.selectAll";
	public static final String Q_SELECT_ID_UPDATED_AFTER = "ChemicalStructure.selectAfterDate";
	public static final String Q_SELECT_FOR_IDS = "ChemicalStructure.selectForIds";

	@Id
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt")
	private Date updatedAt;
	@Column(name = "unique_molecule_id")
	private Integer labnetworkId;
	private String smiles;

	//pains
	@Column(name = "number_violations_pains")
	private Integer numberViolationsPains;
	//compount type
	//rule 3 5
	private Integer ruleOfFive;
	private Integer ruleOfThree;

	//6filter
	private Double molecularWeight;
	private Double logP;
	private Integer HBondDonorCount;
	private Integer rotBondCount;
	private Integer HBondAcceptorCount;
	@Column(name = "polar_surface_area")
	private Double polarSurfaceArea;


	public ChemicalStructure() {
	}

	public Integer getId() {
		return id;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Integer getLabnetworkId() {
		return labnetworkId;
	}

	public String getSmiles() {
		return smiles;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLabnetworkId(Integer labnetworkId) {
		this.labnetworkId = labnetworkId;
	}

	public Integer getNumberViolationsPains() {
		return numberViolationsPains;
	}

	public void setNumberViolationsPains(Integer numberViolationsPains) {
		this.numberViolationsPains = numberViolationsPains;
	}

	public Double getMolecularWeight() {
		return molecularWeight;
	}

	public void setMolecularWeight(Double molecularWeight) {
		this.molecularWeight = molecularWeight;
	}

	public Double getLogP() {
		return logP;
	}

	public void setLogP(Double logP) {
		this.logP = logP;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setSmiles(String smiles) {
		this.smiles = smiles;
	}

	public Integer getRuleOfFive() {
		return ruleOfFive;
	}

	public void setRuleOfFive(Integer ruleOfFive) {
		this.ruleOfFive = ruleOfFive;
	}

	public Integer getRuleOfThree() {
		return ruleOfThree;
	}

	public void setRuleOfThree(Integer ruleOfThree) {
		this.ruleOfThree = ruleOfThree;
	}

	public Integer getRotBondCount() {
		return rotBondCount;
	}

	public void setRotBondCount(Integer rotBondCount) {
		this.rotBondCount = rotBondCount;
	}

	public Integer getHBondDonorCount() {
		return HBondDonorCount;
	}

	public void setHBondDonorCount(Integer HBondDonorCount) {
		this.HBondDonorCount = HBondDonorCount;
	}

	public Integer getHBondAcceptorCount() {
		return HBondAcceptorCount;
	}

	public void setHBondAcceptorCount(Integer HBondAcceptorCount) {
		this.HBondAcceptorCount = HBondAcceptorCount;
	}

	public Double getPolarSurfaceArea() {
		return polarSurfaceArea;
	}

	public void setPolarSurfaceArea(Double polarSurfaceArea) {
		this.polarSurfaceArea = polarSurfaceArea;
	}
}
