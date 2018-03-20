package com.readWriteSplit;

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

}
