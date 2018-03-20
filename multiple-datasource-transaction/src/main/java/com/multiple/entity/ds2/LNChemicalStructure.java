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
@NamedQueries({
	@NamedQuery(name = LNChemicalStructure.Q_SELECT_ID, query = "SELECT c.id FROM LNChemicalStructure c ORDER BY c.updatedAt ASC")
	,
	@NamedQuery(name = LNChemicalStructure.Q_SELECT_ID_UPDATED_AFTER, query = "SELECT c.id FROM LNChemicalStructure c WHERE c.updatedAt > :updatedAfter ORDER BY c.updatedAt ASC"),
	@NamedQuery(name = LNChemicalStructure.Q_SELECT_FOR_IDS, query = "SELECT c FROM LNChemicalStructure c WHERE c.id IN (:ids)")
})
public class LNChemicalStructure implements Serializable {

	public static final String Q_SELECT_ID = "c.selectAll";
	public static final String Q_SELECT_ID_UPDATED_AFTER = "c.selectAfterDate";
	public static final String Q_SELECT_FOR_IDS = "c.selectForIds";

	@Id
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt")
	private Date updatedAt;
	@Column(name = "unique_molecule_id")
	private Integer labnetworkId;
	private String smiles;

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getSmiles() {
		return smiles;
	}

	public void setSmiles(String smiles) {
		this.smiles = smiles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLabnetworkId() {
		return labnetworkId;
	}

	public void setLabnetworkId(Integer labnetworkId) {
		this.labnetworkId = labnetworkId;
	}
}
