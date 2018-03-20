package com.readWriteSplit;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wanli zhou
 * @created 2017-12-17 10:19 PM.
 */
@Entity
@Table(name = "users")
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	@Version
	private Integer version;
	@Column(name = "dingding_id")
	private String dingDingId;

	public String getDingDingId() {
		return dingDingId;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setDingDingId(String dingDingId) {
		this.dingDingId = dingDingId;
	}
}
