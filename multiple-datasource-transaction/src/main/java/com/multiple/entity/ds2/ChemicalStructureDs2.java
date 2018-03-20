package com.multiple.entity.ds2;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author nick
 */
@Entity
@Table(name = "chemical_structures")
public class ChemicalStructureDs2 implements Serializable {

	@Id
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt")
	private Date updatedAt;
	@Column(name = "unique_molecule_id")
	private Integer labnetworkId;
	private String smiles;



	public ChemicalStructureDs2() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getLabnetworkId() {
		return labnetworkId;
	}

	public void setLabnetworkId(Integer labnetworkId) {
		this.labnetworkId = labnetworkId;
	}

	public String getSmiles() {
		return smiles;
	}

	public void setSmiles(String smiles) {
		this.smiles = smiles;
	}
}
